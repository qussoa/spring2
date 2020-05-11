package com.biz.shop.service.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.biz.shop.domain.UserDetailsVO;

public class AuthProviderImpl implements AuthenticationProvider{
	
	@Autowired
	@Qualifier("userDetailsService")
	private UserDetailsServiceImpl udService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public Authentication authenticate(Authentication authenticateion) {
		String username = (String) authenticateion.getPrincipal();
		String password = (String) authenticateion.getCredentials();
		
		UserDetailsVO userVO = (UserDetailsVO) udService.loadUserByUsername(username);
		
		if(!passwordEncoder.matches(password.trim(), userVO.getPassword().trim())) {
			throw new BadCredentialsException("비밀번호 오류");
		}
		
		if(!userVO.isEnabled()) {
			throw new BadCredentialsException(username + " : 접근 권한 없음");
		}
		
		return new UsernamePasswordAuthenticationToken(userVO, null,userVO.getAuthorities());
		
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
