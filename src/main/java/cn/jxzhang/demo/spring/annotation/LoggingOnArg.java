package cn.jxzhang.demo.spring.annotation;

import cn.jxzhang.demo.spring.enumeration.LoggingType;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

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
public @interface LoggingOnArg {

    String value() default "";

    LoggingType type() default LoggingType.INFO ;
}
