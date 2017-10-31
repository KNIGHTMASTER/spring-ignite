package com.zisal.ignite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


/**
 * Created on 4/22/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Controller
public class ControllerIgniteDB {

    @Autowired
    IServiceEmployee serviceEmployee;


    @RequestMapping("/employee/cache")
    public ModelAndView displayAllEmployee(){
        DTOReloadData dtoReloadData = serviceEmployee.reloadEmployee();
        return new ModelAndView("employee", "data", dtoReloadData);
    }
    
    @RequestMapping("/employee/nocache")
    public ModelAndView displayAllEmployeeNoCache(){
        DTOReloadData dtoReloadData = serviceEmployee.reloadEmployeeNoCache();
        return new ModelAndView("employee", "data", dtoReloadData);
    }
}
