package com.biz.shop.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.biz.shop.domain.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, String>{

	
	
}
