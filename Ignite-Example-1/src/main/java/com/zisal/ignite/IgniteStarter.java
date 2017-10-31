package com.zisal.ignite;

import org.apache.ignite.Ignition;

/**
 * Created on 4/22/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class IgniteStarter {

    public static void main(String [] args){
        for (int a=0; a<1; a++){
            Ignition.start("/home/fauzi/Bin/apache-ignite-1.9.0/examples/config/example-cache.xml");
        }
    }
}
