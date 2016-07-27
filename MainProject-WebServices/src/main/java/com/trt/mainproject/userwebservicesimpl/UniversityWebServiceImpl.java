/*
 * 
 */
package com.trt.mainproject.userwebservicesimpl;

import com.trt.mainproject.entity.University;
import com.trt.mainproject.services.UniversityService;
import com.trt.mainproject.userwebservices.UniversityWebService;
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
public class UniversityWebServiceImpl implements UniversityWebService {

    @Autowired
    private UniversityService universityService;

    @Override
    public List<University> getAllUniversity() {
        List<University> universitys = null;
        universitys = universityService.retriveAll();

        return universitys;
    }

    @Override
    public University getUniversityById(@PathVariable Long id) {
        University university;
        university = universityService.retriveById(id);
        return university;
    }

    @Override
    public Long addUniversity(@RequestBody University university) {
        Long id = universityService.create(university);
        return id;
    }

    @Override
    public University updateUniversity(@RequestBody University university) {
        university = universityService.update(university);
        return university;
    }

    @Override
    public Boolean deleteUniversity(@PathVariable Long id) {
        Boolean flag = false;
        flag = universityService.delete(id);
        return flag;
    }
}
