/*
 * 
 */
package com.trt.mainproject.userwebservicesimpl;

import com.trt.mainproject.entity.Teacher;
import com.trt.mainproject.services.TeacherService;
import com.trt.mainproject.userwebservices.UserWebService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author nilay
 */
@RestController
public class UserWebServiceImpl implements UserWebService {

    @Autowired
    private TeacherService teacherService;

    public Boolean ping() {
        return true;
    }

    @Override
    public List<Teacher> getAllTeachers() {
        List<Teacher> teachers = null;
        teachers = teacherService.retriveAll();
        return teachers;
    }

    @Override
    public Teacher getTeacherById(@PathVariable Long id) {
        Teacher teacher;
        teacher = teacherService.retriveById(id);
        return teacher;
    }

    @Override
    public Long addTeacher(@RequestBody Teacher teacher) {
        Long id = teacherService.create(teacher);
        return id;
    }

    @Override
    public Teacher updateTeacher(@RequestBody Teacher teacher) {
        teacher = teacherService.update(teacher);
        return teacher;
    }

    @Override
    public Boolean deleteTeacher(@PathVariable Long id) {
        Boolean flag = false;
        flag = teacherService.delete(id);
        return flag;
    }
}
