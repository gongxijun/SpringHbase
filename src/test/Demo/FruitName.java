package Demo;

/**
 * author: 龚细军
 * class-aim:
 */

import java.lang.annotation.*;

/**
 * 水果名称注解
 */

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitName {
    String value() default "";
}
