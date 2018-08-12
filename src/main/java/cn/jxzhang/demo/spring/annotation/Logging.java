package cn.jxzhang.demo.spring.annotation;

import cn.jxzhang.demo.spring.enumeration.LoggingType;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;

/**
 * Logging
 *
 * @author zhangjiaxing
 * @version 1.0
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(value={CONSTRUCTOR, FIELD, LOCAL_VARIABLE, METHOD, PACKAGE, PARAMETER, TYPE})
public @interface Logging {

    String value() default "";

    LoggingType type() default LoggingType.INFO ;
}
