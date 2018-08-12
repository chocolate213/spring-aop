package cn.jxzhang.demo.spring.aspect;

import cn.jxzhang.demo.spring.common.PrintJoinPoint;
import cn.jxzhang.demo.spring.common.ResponseMessage;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * LoggingTargetAspect
 *
 * <code>@target</code>: @target表示使用目标注解装饰的类中的所有方法匹配切面
 *
 * @author zhangjiaxing
 * @version 1.0
 */
@Component
@Aspect
public class LoggingTargetAnnotationAspect {
    /**
     * 前置通知：在目标方法开始执行前执行
     *
     * 1. 如果目标方法没有执行，则该方法不会执行（@Around标签所注解的方法没有执行目标方法，该方法就不会执行）
     *
     * @param joinPoint join point
     */
    @Before("@target(cn.jxzhang.demo.spring.annotation.LoggingOnClass)")
    public void before(JoinPoint joinPoint) {
        PrintJoinPoint.printJoinPoint(joinPoint, "before", getClass().getName());
    }

    /**
     * 后置通知：在目标方法执行后(无论是否发生异常,也就是说如果发生异常该方法还是会执行)，执行的通知称之为后置通知
     *
     * 1. 无论目标方法是否执行，该方法都会执行
     *
     * @param joinPoint join point
     */
    @After("@target(cn.jxzhang.demo.spring.annotation.LoggingOnClass)")
    public void after(JoinPoint joinPoint) {
        PrintJoinPoint.printJoinPoint(joinPoint, "after", getClass().getName());
    }

    /**
     * 返回通知：在方法正常结束后执行的叫返回通知，返回通知可以访问到方法的返回值
     *
     * 1. 方法执行抛出异常，该方法不会执行
     * 2. 方法执行抛出异常，但是异常被@Around处理掉，该方法还是会正常执行
     *
     * @param joinPoint join point
     * @param result    返回结果
     */
    @AfterReturning(value = "@target(cn.jxzhang.demo.spring.annotation.LoggingOnClass)", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        PrintJoinPoint.printJoinPoint(joinPoint, "AfterReturning", getClass().getName());
        if (result instanceof ResponseMessage) {
            ResponseMessage responseMessage = (ResponseMessage) result;
            System.out.println("response message: " + responseMessage);
        } else {
            System.out.println("response result: " + result);
        }
    }

    /**
     * 异常通知：在目标方法出现异常时会执行的代码
     * 可以访问到异常对象，且可以指定要捕捉的异常，如果出现的异常不是给定异常或给定异常的子类，那么该方法就不会执行
     *
     * 1. 抛出异常时该方法会执行
     * 2. 抛出异常，但是被@Around方法处理掉，该方法不会执行
     *
     * @param point     join point
     * @param exception exception
     */
    @AfterThrowing(value = "@target(cn.jxzhang.demo.spring.annotation.LoggingOnClass)", throwing = "exception")
    public void afterThrowing(JoinPoint point, Exception exception) {
        PrintJoinPoint.printJoinPoint(point, "AfterThrowing", getClass().getName());
        System.out.println("exception: " + exception);
    }
}
