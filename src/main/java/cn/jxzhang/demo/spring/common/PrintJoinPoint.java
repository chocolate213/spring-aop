package cn.jxzhang.demo.spring.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;

import java.util.Arrays;

/**
 * PrintJoinPoint
 *
 * @author zhangjiaxing
 * @version 1.0
 */
public class PrintJoinPoint {
    public static void printJoinPoint(JoinPoint joinPoint, String method, String className) {
        System.out.println("==========START: " + className + " : " + method + "==========");

        Object[] args = joinPoint.getArgs();
        String kind = joinPoint.getKind();
        Object target = joinPoint.getTarget();
        Object aThis = joinPoint.getThis();

        Signature signature = joinPoint.getSignature();
        String name = signature.getName(); //获取类名
        Class declaringType = signature.getDeclaringType(); //获取类Class对象
        String declaringTypeName = signature.getDeclaringTypeName(); //获取Class对象名
        int modifiers = signature.getModifiers(); //获取类的访问权限

        System.out.println("name: " + name);
        System.out.println("declaringType: " + declaringType);
        System.out.println("declaringTypeName: " + declaringTypeName);
        System.out.println("modifiers: " + modifiers);

        System.out.println("args: " + Arrays.toString(args));    //获取请求参数
        System.out.println("kind: " + kind);                     //获取执行类型
        System.out.println("target: " + target);                 //获取执行目标
        System.out.println("aThis: " + aThis);                   //获取当前对象

        System.out.println("==========END: " + method + "==========\n");
    }
}
