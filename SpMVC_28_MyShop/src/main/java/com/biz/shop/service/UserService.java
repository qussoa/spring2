package com.biz.shop.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.biz.shop.domain.AuthorityVO;
import com.biz.shop.domain.UserDetailsVO;
import com.biz.shop.persistance.AuthoritiesDao;
import com.biz.shop.persistance.UserDao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserService {

	private final PasswordEncoder passwordEncoder;
	private final UserDao uDao;
	private final AuthoritiesDao aDao;

	@Autowired
	public UserService(PasswordEncoder passwordEncoder, UserDao uDao, AuthoritiesDao aDao) {
		// TODO Auto-generated constructor stub
		this.passwordEncoder = passwordEncoder;
		this.uDao = uDao;
		this.aDao = aDao;

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

	@Transactional
	public int insert(String username, String password) {
		String encPassword = passwordEncoder.encode(password);
		UserDetailsVO userVO = UserDetailsVO.builder().username(username).password(encPassword).build();

		int ret = uDao.insert(userVO);
		List<AuthorityVO> authList = new ArrayList<>();
		authList.add(AuthorityVO.builder()
				.username(userVO.getUsername())
				.authority("ROLE_USER").build());
		authList.add(AuthorityVO.builder()
				.username(userVO.getUsername())
				.authority("USER").build());
		aDao.insert(authList);
		return ret;
	}

	@Transactional
	public int insert(UserDetailsVO userVO) {
		userVO.setEnabled(false);
		userVO.setAuthorities(null);
		String encPassword = passwordEncoder.encode(userVO.getPassword());
		userVO.setPassword(encPassword);

		int ret = uDao.insert(userVO);
		return ret;
	}

	@Transactional
	public boolean isExistsUserName(String username) {
		UserDetailsVO userVO = uDao.findByUserName(username);
		if (userVO != null && userVO.getUsername().equalsIgnoreCase(username)) {
			return true;
		}
		return false;
	}

	
	public UserDetailsVO findById(long id) {
		UserDetailsVO userVO = uDao.findById(id);
		return userVO;
	}

	public boolean check_password(String password) {
		UserDetailsVO userVO = (UserDetailsVO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return passwordEncoder.matches(password, userVO.getPassword());
	}

	@Transactional
	public int update(UserDetailsVO userVO, String[] authList) {
		int ret = uDao.update(userVO);
		if (ret > 0) {
			List<AuthorityVO> authCollection = new ArrayList<>();
			for (String auth : authList) {
				if (!auth.isEmpty()) {
					AuthorityVO authVO = AuthorityVO.builder().username(userVO.getUsername()).authority(auth).build();
					authCollection.add(authVO);
				}
			}
			aDao.delete(userVO.getUsername());
			aDao.insert(authCollection);
		}
		return ret;
	}

	@Transactional
	public int update(UserDetailsVO userVO) {
		Authentication oldAuth = SecurityContextHolder.getContext().getAuthentication();
		UserDetailsVO oldUserVO = (UserDetailsVO) oldAuth.getPrincipal();

		oldUserVO.setEmail(userVO.getEmail());
		oldUserVO.setPhone(userVO.getPhone());
		oldUserVO.setAddress(userVO.getAddress());

		int ret = uDao.update(userVO);
		if (ret > 0) {
			Authentication newAuth = new UsernamePasswordAuthenticationToken(oldUserVO, oldAuth.getCredentials(),
					oldAuth.getAuthorities());
			SecurityContextHolder.getContext().setAuthentication(newAuth);

		}
		return ret;
	}

	@Transactional
	private Collection<GrantedAuthority> getAuthorities(String[] authList) {
		List<GrantedAuthority> authorities = new ArrayList<>();

		for (String auth : authList) {
			if (!auth.isEmpty()) {
				SimpleGrantedAuthority sAuth = new SimpleGrantedAuthority(auth);
				authorities.add(sAuth);
			}
		}
		return authorities;
	}

	@Transactional
	public List<UserDetailsVO> selectAll() {
		return uDao.selectAll();
	}

	@Transactional
	public UserDetailsVO findByUserName(String username) {
		return uDao.findByUserName(username);
	}

}
