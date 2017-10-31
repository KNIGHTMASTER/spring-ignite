package com.zisal.igniteexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created on 4/22/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
public class ServiceEmployeeImpl implements IServiceEmployee {

    @Autowired
    IRepoEmployee repoEmployee;

    @Override
    public List<Employee> selectAllEmployee() {
        return repoEmployee.findAll();
    }
}
