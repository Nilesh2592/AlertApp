/*
 * 
 */
package com.trt.mainproject.userwebservices;

import com.trt.mainproject.entity.University;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author nilay
 */
public interface UniversityWebService {

    @RequestMapping(value = "/uni", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<University> getAllUniversity();

    @RequestMapping(value = "/uni/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public University getUniversityById(@PathVariable Long id);

    @RequestMapping(value = "/uni", method = RequestMethod.POST, headers = "Accept=application/json")
    public Long addUniversity(@RequestBody University university);

    @RequestMapping(value = "/uni", method = RequestMethod.PUT, headers = "Accept=application/json")
    public University updateUniversity(@RequestBody University university);

    @RequestMapping(value = "/uni/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
    public Boolean deleteUniversity(@PathVariable Long id);
}
