package com.biz.shop.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.biz.shop.persistance.UserDao;


@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	private final UserDao uDao;

	public UserDetailsServiceImpl(UserDao uDao) {
		// TODO Auto-generated constructor stub
		this.uDao = uDao;
		
		String create_user_table
		= " CREATE TABLE IF NOT EXISTS tbl_users( "
		+ " id bigint PRIMARY KEY AUTO_INCREMENT, "
		+ " user_name varchar(50) UNIQUE, " 
		+" user_pass varchar(125), "
		+ " enabled boolean default true, "
		+ " email varchar(50), " 
		+ " phone varchar(20), "
		+ " address varchar(125) "
		+ " ) ";

		String create_auth_table 
		= " CREATE TABLE IF NOT EXISTS authorities ( "
				+ " id bigint PRIMARY KEY AUTO_INCREMENT, " 
				+ " username varchar(50), " 
				+ " authority varchar(50) "
				+ " ) ";
		
		uDao.create_table(create_user_table);
		uDao.create_table(create_auth_table);
		
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	
}
