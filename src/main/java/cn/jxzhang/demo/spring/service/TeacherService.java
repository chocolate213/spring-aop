package cn.jxzhang.demo.spring.service;

import cn.jxzhang.demo.spring.common.ResponseMessage;
import cn.jxzhang.demo.spring.domain.Teacher;

import java.util.List;

/**
 * TeacherService
 *
 * @author zhangjiaxing
 * @version 1.0
 */
public interface TeacherService {
    ResponseMessage<List<Teacher>> list();

    ResponseMessage<Teacher> getTeacherById(Integer id);
}
