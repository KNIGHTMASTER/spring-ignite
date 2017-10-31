/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zisal.ignite;

import org.apache.ignite.springdata.repository.IgniteRepository;
import org.apache.ignite.springdata.repository.config.RepositoryConfig;

/**
 *
 * @author fauzi
 */
@RepositoryConfig(cacheName = "EmployeeCache")
public interface IRepoIgnite extends IgniteRepository<Employee, Integer>{
    
}
