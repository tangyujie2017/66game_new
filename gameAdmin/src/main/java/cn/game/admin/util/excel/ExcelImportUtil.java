package cn.game.admin.util.excel;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:Excel文件解析工具类
 *
 * @author liuyan
 * @date 2017/10/23 23:18
 * @version V1.0
 * Copyright (c) 2017, ISoftStone All Right reserved.
 */
public class ExcelImportUtil {

    public final static String DATE_OUTPUT_PATTERNS = "yyyy-MM-dd HH:mm:ss.SSSZ";
    public final static SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_OUTPUT_PATTERNS);

    /**
     * @param clazz Class的对象
     * @param path 文件路径
     * @return List
     * @throws Exception 
     */
    @SuppressWarnings("resource")
    public static List<?> readExcle(Class<?> clazz, String path) throws Exception {
    	//获取指定路径的excle中数据转化为指定的Class的对象
    	
    	
    	//存放临时数据的容器
        List<Object> list = new ArrayList<>();
        //检查文件类型
        String fileType = CheckFileTypeUtil.getFileType(path);
       
        if(fileType.endsWith("xlsx")){
            InputStream is = null;

            is = new FileInputStream(path);
            XSSFWorkbook hssfWorkbook = new XSSFWorkbook(is);
           //根据Class的对象获取所有属性
           
            Map<String,ObjectForSheet> objToSheet=new HashMap<>();
           for(Field field :clazz.getDeclaredFields()) {
        	   //静态字段和常量不忽略
        	   if (Modifier.isStatic(field.getModifiers()) || Modifier.isFinal(field.getModifiers())) {
                   continue;
               }
        	   //把要插入的字段放入容器用于判断
        	   ExcelAnnotation aa= field.getAnnotation(ExcelAnnotation.class);
        	   if(aa==null) {
        		   continue;
        	   }
        	   int index=aa.index();
        	   int indexSheet=aa.sheetIndex();
        	   Class<?> valueType=aa.valueType();
        	   ObjectForSheet sheet=new ObjectForSheet();
        	   sheet.setHssfSheet(hssfWorkbook.getSheetAt(indexSheet));
        	   sheet.setValueType(valueType);
        	   sheet.setIndex(index);
        	   sheet.setIndexSheet(indexSheet);
        	   objToSheet.put(field.getName(), sheet);
           }
           //基本判断
          
           int temp=0;
           for(String name:objToSheet.keySet()) {
        	   if(temp==0) {
        		   temp= objToSheet.get(name).getHssfSheet().getLastRowNum();
        	   }else {
        		   if(temp==objToSheet.get(name).getHssfSheet().getLastRowNum()) {
        			   
        		   }else {
        			   throw new Exception("不同表单的数据不一样，请检查后在上传");
        		   }
        		   
        	   }
        	 
        	   
           }
           //开始组装数据
           for(int rowNum = 1; rowNum <= temp; rowNum++) {
        	   Object  instance = clazz.newInstance();
        	   Field[] fields=clazz.getDeclaredFields();
        	   //每一行
              
        	   for(Field f:fields) {
        		   
        		   if(objToSheet.get(f.getName())!=null) {
        			   
        			   String methodName = "set"+f.getName().substring(0, 1).toUpperCase()+f.getName().substring(1);
        			   XSSFRow hssfRow = objToSheet.get(f.getName()).getHssfSheet().getRow(rowNum);
        			   
        			   XSSFCell cell=hssfRow.getCell(objToSheet.get(f.getName()).getIndex());
        			     if(cell==null) {
        			    	 throw new Exception("导入的Excel文件在第:("+(objToSheet.get(f.getName()).getIndex()+1)+")列处值未填写，请检查后在导入");
        			     }
        			   
        			  
        			  
        			   Method method = instance.getClass().getMethod(methodName,f.getType());
        			   //在excel中获取的值都是String,所以要根据属性的类型进行值的转换,多類型在此
                       if(f.getType().toString().equals("class java.lang.String")){
                           //调用实例对象obj的set方法进行对属性的数值
                    	   cell .setCellType(Cell.CELL_TYPE_STRING); 
       				        String value= cell.getStringCellValue();
                           method.invoke(instance, value);
                       }else if(f.getType().toString().equals("int")||f.getType().toString().equals("Integer")) {
                    	   cell .setCellType(Cell.CELL_TYPE_STRING); 
      				        String value= cell.getStringCellValue();
                           method.invoke(instance, Integer.valueOf(value));
                       } else if(f.getType().toString().equals("long")||f.getType().toString().equals("class java.lang.Long")){
                    	   cell .setCellType(Cell.CELL_TYPE_STRING); 
      				        String value= cell.getStringCellValue();
                           method.invoke(instance, Long.parseLong(value));
                       } else if (f.getType().toString().equals("byte")||f.getType().toString().equals("class java.lang.Byte")) {
                    	   cell .setCellType(Cell.CELL_TYPE_STRING); 
      				        String value= cell.getStringCellValue();
                           method.invoke(instance, Byte.parseByte(value));
                       } else if (f.getType().toString().equals("class java.util.Date")) {
                    	   if(HSSFDateUtil.isCellDateFormatted(cell)) {
                    		   Date d = cell.getDateCellValue();
                    		  
                    		   String date = simpleDateFormat.format(d);
                    		   method.invoke(instance, simpleDateFormat.parse(date));
                    	   }else {
                    		   DecimalFormat df = new DecimalFormat("########");
                    		   String date= df.format(cell.getNumericCellValue());
                    		   method.invoke(instance, simpleDateFormat.parse(date));
                    	   }
                           
                       }
        			   
        			   
        			  
        		   }
        	   }
        	  
        	   list.add(instance);
        	   
           }
          
            is.close();
        
        }
        return list;
    }

   public static void main(String[] args) throws Exception {
	  List list= readExcle(SpmsTeacherCertificate.class, "E:\\test2.xlsx");
	  System.out.println("获得数据。。。。"+list.size());
}
}
