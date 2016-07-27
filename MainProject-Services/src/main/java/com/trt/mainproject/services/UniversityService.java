/*
 * 
 */

package com.trt.mainproject.services;

import com.trt.mainproject.entity.University;
import java.util.List;

/**
 *
 * @author nilay
 */
public interface UniversityService {
    public Long create(University university);
    public University retriveById(Long id);
    public University update(University university);
    public Boolean delete(Long id);
    public List<University> retriveAll();
}
