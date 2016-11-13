package org.siva.ravipati;

import java.io.*;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class IbatisMain {
	public static void main(String a[]) throws Exception {
		//Initialize dao
		UserDAOIbatis manager = new UserDAOIbatis();
 
        //Create the SQLMapClient
        Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
        SqlMapClient sqlmapClient = SqlMapClientBuilder.buildSqlMapClient (reader);
 
        Integer id = (Integer)sqlmapClient.queryForObject("user.getMaxId");
        System.out.println(id);
        //Create a new user to persist
//        UserTEO user = new UserTEO();
//        user.setId(1);
//        user.setName("Demo User");
//        user.setPassword("password");
//        user.setEmail("demo-user@howtodoinjava.com");
//        user.setStatus(1);
// 
        //Add the user
        //manager.addUser(user,sqlmapClient);
 
        //Fetch the user detail
        UserTEO createdUser = manager.getUserById(1, sqlmapClient);
        System.out.println(createdUser.getEmail());
 
        
        //Lets delete the user
        //manager.deleteUserById(1, sqlmapClient);

	}
}
