package com.nr.project2.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.nr.project2.dao.UserRepository;
import com.nr.project2.domain.Role;
import com.nr.project2.domain.User;
import com.nr.project2.helper.AppHelper;
import com.nr.project2.model.UserDto;
import com.nr.project2.service.UserService;

public class UserServiceImpl implements UserService, UserDetailsService {
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private UserRepository userRepository;

	@Override
	public void add(UserDto userDto) throws Exception {
		if (userRepository.findByLoginId(userDto.getLoginId()) != null) {
			throw new Exception();
		}
		userDto.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
		userRepository.save(AppHelper.getEntityFromDto(userDto));
	}

	@Override
	public List<UserDto> getAllUsers() {
		return userRepository.findAll().stream().map(user -> AppHelper.getDtoFromEntity(user))
				.collect(Collectors.toList());
	}

	@Override
	public UserDto getUserByLoginId(String userId) {
		return AppHelper.getDtoFromEntity(userRepository.findByLoginId(userId));
	}

	@Override
	public UserDto updateUser(UserDto userDto) {
		return AppHelper.getDtoFromEntity(userRepository.save(AppHelper.getEntityFromDto(userDto)));
	}

	@Override
	public String deleteUser(String userId) {
		userRepository.findByLoginId(userId).setDeleted(true);
		return userId;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = Optional.ofNullable(userRepository.findByLoginId(username))
				.orElseThrow(() -> new UsernameNotFoundException("No user found with username: " + username));

		boolean enabled = true;
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;

		return new org.springframework.security.core.userdetails.User(user.getLoginId(), user.getPassword(), enabled,
				accountNonExpired, credentialsNonExpired, accountNonLocked, getAuthorities(user.getRoles()));
	}

	private static List<GrantedAuthority> getAuthorities(Set<Role> roles) {
		List<GrantedAuthority> authorities = new ArrayList<>();
		for (Role role : roles) {
			authorities.add(new SimpleGrantedAuthority(role.getRole()));
		}
		return authorities;
	}
}
