package team.redrock.rain.reflection;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * team.redrock.rain.reflection.null.java
 * lesson4
 *
 * @author 寒雨
 * @since 2022/11/11 下午10:14
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AutoWired {
    String value() default "";
}
