package com.prueba.auth;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;





@Component
public class InfoAdicionalToken implements TokenEnhancer, UserDetailsService {
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		
		
		Map<String, Object> info = new HashMap<>();
		info.put("Info_token", "Hola que hace dice el token");
		info.put("nombre_usuario", ":  API-Front-APP");
		((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);
		
		return accessToken;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		
		var roles = new ArrayList<GrantedAuthority>();
        
        
        roles.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        
        String hash = passwordEncoder.encode("1234");
        
        return new User("appFront", hash,  roles);
	}

}
