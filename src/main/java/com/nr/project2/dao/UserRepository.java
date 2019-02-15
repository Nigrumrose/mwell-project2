package com.nr.project2.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nr.project2.domain.User;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long> {
	User findByLoginId(String loginId);
}
