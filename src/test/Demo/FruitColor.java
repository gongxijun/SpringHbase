package Demo;

import java.lang.annotation.*;

/**
 * author: 龚细军
 * class-aim:
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitColor {
    /*颜色枚举*/
    public enum Color {
        BULE, RED, GREEN
    }

    /*颜色属性*/
    Color fruitColor() default Color.GREEN;
}
