package com.fieb.tcc.academicologin.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.fieb.tcc.academicologin.model.Role;
import com.fieb.tcc.academicologin.model.User;
import com.fieb.tcc.academicologin.web.dto.UserDto;



public interface UserService extends UserDetailsService {
	
	User save(UserDto userDto);
	User saveAdmin(UserDto userDto);
	User findByEmail(UserDto userDto);
	User update(UserDto userDto);
	User getAuthenticatedUser();
	Role saveRole(Role role);
	void addRoleToUser(String username, String roleName);
	//void excluirUser(Long id);
	
}
