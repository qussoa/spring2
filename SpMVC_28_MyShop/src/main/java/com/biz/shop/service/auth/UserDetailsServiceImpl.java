package com.biz.shop.service.auth;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.biz.shop.domain.AuthorityVO;
import com.biz.shop.domain.UserDetailsVO;
import com.biz.shop.persistance.AuthoritiesDao;
import com.biz.shop.persistance.UserDao;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService{

	private final AuthoritiesDao aDao;
	private final UserDao uDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) {
		UserDetailsVO userVO = uDao.findByUserName(username);
		if(userVO == null) {
			throw new UsernameNotFoundException("USERNAME 없음");
		}
		
		userVO.setAccountNonExpired(true);
		userVO.setAccountNonLocked(true);
		userVO.setCredentialsNonExpired(true);
		
		userVO.setAuthorities(this.getAuthorities(username));
		
		return userVO;
	}
	
	private Collection<GrantedAuthority> getAuthorities(String username){
		
		List<AuthorityVO> authList = aDao.findByUserName(username);
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		
		for(AuthorityVO vo : authList) {
			SimpleGrantedAuthority sAuth 
			= new SimpleGrantedAuthority(vo.getAuthority());
			authorities.add(sAuth);
		}
		return authorities;
	}
}
