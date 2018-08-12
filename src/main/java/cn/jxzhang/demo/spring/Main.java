package cn.jxzhang.demo.spring;

import cn.jxzhang.demo.spring.domain.Student;
import cn.jxzhang.demo.spring.service.StudentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Main
 *
 * @author zhangjiaxing
 * @version 1.0
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-aop.xml");
//        TeacherService bean = context.getBean(TeacherService.class);
//        bean.getTeacherById(1);
        StudentService bean1 = context.getBean(StudentService.class);
        bean1.addStudent(new Student());
    }
}
