/*
 * 
 */
package com.trt.mainproject.userwebservices;

import com.trt.mainproject.entity.Admin;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author nilay
 */
public interface AdminWebService {
    @RequestMapping(value = "/admin", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<Admin> getAllAdmin();

    @RequestMapping(value = "/admin/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public Admin getAdminById(@PathVariable Long id);

    @RequestMapping(value = "/admin", method = RequestMethod.POST, headers = "Accept=application/json")
    public Long addAdmin(@RequestBody Admin admin);

    @RequestMapping(value = "/admin", method = RequestMethod.PUT, headers = "Accept=application/json")
    public Admin updateAdmin(@RequestBody Admin admin);

    @RequestMapping(value = "/admin/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
    public Boolean deleteAdmin(@PathVariable Long id);
}
