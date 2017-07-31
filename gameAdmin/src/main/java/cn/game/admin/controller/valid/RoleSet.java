package cn.game.admin.controller.valid;


import javax.validation.Constraint;
import javax.validation.Payload;


import java.lang.annotation.*;


@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy=RoleSetValidator.class)
@Documented
public @interface RoleSet {

  String message() default "{cn.gaiasys.retail.constraints.RoleSet.message}";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
