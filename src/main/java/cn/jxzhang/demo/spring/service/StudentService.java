package cn.jxzhang.demo.spring.service;

import cn.jxzhang.demo.spring.common.ResponseMessage;
import cn.jxzhang.demo.spring.domain.Student;

import java.util.List;

/**
 * StudentService
 *
 * @author zhangjiaxing
 * @version 1.0
 */
public interface StudentService {

    ResponseMessage<List<Student>> list();

    ResponseMessage<Student> getStudentById(Integer id);

    ResponseMessage addStudent(Student student);
}
