package cn.game.admin.util.excel;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Description:用于Excel导入字段注解
 *
 * @author liuyan
 * @date 2017/10/24 20:37
 * @version V1.0
 * Copyright (c) 2017, ISoftStone All Right reserved.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ExcelAnnotation {

    //用于标注对象映射Excel表格列
    int index() default 0;
    //用于标注读取Excel的表单
    int sheetIndex() default 0;
    //用于标注取值转化为Java什么类型
    Class valueType() ;
}
