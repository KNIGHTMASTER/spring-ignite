package com.zisal.ignite;

import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.Ignition;
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

    List<Employee> result;

    @Override
    public DTOReloadData reloadEmployee() {
        DTOReloadData dtoReloadData = new DTOReloadData();
        try (
            //Ignite ignite = Ignition.start("/home/fauzi/Bin/apache-ignite-1.9.0/examples/config/example-default.xml")) {
            Ignite ignite = Ignition.getOrStart(ApacheIgniteConfiguration.loadConfiguration())) {
            // Put values in cache.            
            IgniteCache<Integer, List<Employee>> cache = ignite.getOrCreateCache("myCache");

            long startTime = System.currentTimeMillis();

            List<Employee> data = cache.get(1);
            if (data == null) {
                System.out.println("Cache empty");
                data = repoEmployee.findAll();
                cache.put(1, data);
                System.out.println("CACHE HAS BEEN PUT");
                data = cache.get(1);                
            }

                long estimatedTime = System.currentTimeMillis() - startTime;
                System.out.println("Elapsed Time : " + estimatedTime);
                dtoReloadData.setEmployees(data);
                dtoReloadData.setElapsedTime("Elapsed Time : " + estimatedTime + " ms");
            //});
        }
        return dtoReloadData;
    }

    @Override
    public DTOReloadData reloadEmployeeNoCache() {
        DTOReloadData dtoReloadData = new DTOReloadData();
        
        long startTime = System.currentTimeMillis();

        List<Employee> employees = repoEmployee.findAll();
        result = employees;

        long estimatedTime = System.currentTimeMillis() - startTime;
        
        System.out.println("Elapsed Time : " + estimatedTime);
        dtoReloadData.setEmployees(result);
        dtoReloadData.setElapsedTime("Elapsed Time : " + estimatedTime + " ms");
        return dtoReloadData;
    }

}
