package cn.game.admin.controller.valid;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;




public class MobileValidator implements ConstraintValidator<Mobile, String> {

  @Override
  public void initialize(Mobile constraintAnnotation) {
    // 不需要执行初始化操作
  }

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    return false;
  }
}
