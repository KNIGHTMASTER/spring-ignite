package com.zisal.igniteexample;

import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.Ignition;
import org.apache.ignite.lang.IgniteRunnable;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 *
 * @author fauzi
 */
public class HelloWorld {

    public static void main(String[] args) {
        //exampleHelloWorld();
        exampleDataBase();
    }

    static void exampleDataBase(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        IServiceEmployee serviceEmployee = (IServiceEmployee) applicationContext.getBean("serviceEmployee");
        List<Employee> employees = serviceEmployee.selectAllEmployee();
        for (Employee employee : employees){
            System.out.println(employee.toString());
        }
    }

    static void exampleHelloWorld(){
        try (Ignite ignite = Ignition.start("/home/fauzi/Bin/apache-ignite-1.9.0/examples/config/example-cache.xml")) {
            // Put values in cache.
            final IgniteCache<Integer, String> cache = ignite.getOrCreateCache("myCache");
            cache.put(1, "Hello");
            cache.put(2, "World!");
            // Get values from cache
            // Broadcast 'Hello World' on all the nodes in the cluster.
            ignite.compute().broadcast(new IgniteRunnable() {
                @Override
                public void run() {
                    long startTime = System.currentTimeMillis();
                    for (int a=0; a<10; a++){
                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(cache.get(1) + " " + cache.get(2));
                    }
                    long estimatedTime = System.currentTimeMillis() - startTime;
                    System.out.println("Elapsed Time 1 : "+estimatedTime);

                    long startTime2 = System.currentTimeMillis();
                    for (int a=0; a<10; a++){
                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(cache.get(1) + " " + cache.get(2));
                    }
                    long estimatedTime2 = System.currentTimeMillis() - startTime;
                    System.out.println("Elapsed Time 2 : "+estimatedTime);
                }
            });
        }
    }
}
