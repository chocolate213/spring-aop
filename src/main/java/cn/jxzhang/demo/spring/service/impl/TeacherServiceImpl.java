package cn.jxzhang.demo.spring.service.impl;

import cn.jxzhang.demo.spring.annotation.Logging;
import cn.jxzhang.demo.spring.annotation.LoggingOnClass;
import cn.jxzhang.demo.spring.common.ResponseMessage;
import cn.jxzhang.demo.spring.domain.Teacher;
import cn.jxzhang.demo.spring.service.TeacherService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TeacherServiceImpl
 *
 * @author zhangjiaxing
 * @version 1.0
 */
@Service
@LoggingOnClass
public class TeacherServiceImpl implements TeacherService {
    private static final Map<Integer, Teacher> teachers = new HashMap<>();

    static {
        teachers.put(1, new Teacher(1, "TeacherA", 22));
        teachers.put(2, new Teacher(1, "TeacherB", 23));
    }

    @Override
    @Logging
    public ResponseMessage<List<Teacher>> list() {
        return ResponseMessage.SUCCESS(new ArrayList<>(teachers.values()));
    }

    @Override
    @Logging
    public ResponseMessage<Teacher> getTeacherById(Integer id) {
        return ResponseMessage.SUCCESS(teachers.get(id));
    }

}
