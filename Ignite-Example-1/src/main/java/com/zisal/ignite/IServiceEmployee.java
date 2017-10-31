package com.zisal.ignite;

/**
 * Created on 4/22/17.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface IServiceEmployee {

    DTOReloadData reloadEmployee();
    
    DTOReloadData reloadEmployeeNoCache();
}
