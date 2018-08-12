package cn.jxzhang.demo.spring.service.impl;

import cn.jxzhang.demo.spring.annotation.Logging;
import cn.jxzhang.demo.spring.annotation.LoggingOnClass;
import cn.jxzhang.demo.spring.common.ResponseMessage;
import cn.jxzhang.demo.spring.domain.Student;
import cn.jxzhang.demo.spring.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * StudentServiceImpl
 *
 * @author zhangjiaxing
 * @version 1.0
 */
@Service
@LoggingOnClass
public class StudentServiceImpl implements StudentService {

    private static final Map<Integer, Student> students = new HashMap<>();

    static {
        students.put(1, new Student(1, "TeacherA", 22));
        students.put(2, new Student(1, "TeacherB", 23));
    }

    @Override
    public ResponseMessage<List<Student>> list() {
        return ResponseMessage.SUCCESS(new ArrayList<>(students.values()));
    }

    @Override
    public ResponseMessage<Student> getStudentById(Integer id) {
        System.out.println("get student by id running....");
        return ResponseMessage.SUCCESS(students.get(id));
    }

    @Override
    @Logging
    public ResponseMessage addStudent(Student student) {
        students.put(student.getId(), student);
        return ResponseMessage.SUCCESS();
    }
}
