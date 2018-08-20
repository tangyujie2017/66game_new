package cn.game.admin.util.excel;

import org.apache.poi.xssf.usermodel.XSSFSheet;

public class ObjectForSheet {
	private int index;
	
	private int indexSheet;
	
	private Class<?> valueType;
	
	private  XSSFSheet hssfSheet;

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getIndexSheet() {
		return indexSheet;
	}

	public void setIndexSheet(int indexSheet) {
		this.indexSheet = indexSheet;
	}

	

	public Class<?> getValueType() {
		return valueType;
	}

	public void setValueType(Class<?> valueType) {
		this.valueType = valueType;
	}

	public XSSFSheet getHssfSheet() {
		return hssfSheet;
	}

	public void setHssfSheet(XSSFSheet hssfSheet) {
		this.hssfSheet = hssfSheet;
	}
	
	
	

}
