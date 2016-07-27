/*
 * 
 */
package com.trt.mainproject.userwebservices;

import com.trt.mainproject.entity.Teacher;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author nilay
 */
public interface UserWebService {

    @RequestMapping(value = "/ping", method = RequestMethod.GET)
    public Boolean ping();

    @RequestMapping(value = "/user", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<Teacher> getAllTeachers();

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public Teacher getTeacherById(@PathVariable Long id);

    @RequestMapping(value = "/user", method = RequestMethod.POST, headers = "Accept=application/json")
    public Long addTeacher(@RequestBody Teacher teacher);

    @RequestMapping(value = "/user", method = RequestMethod.PUT, headers = "Accept=application/json")
    public Teacher updateTeacher(@RequestBody Teacher teacher);

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
    public Boolean deleteTeacher(@PathVariable Long id);
}
