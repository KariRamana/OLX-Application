package com.zensar.olxlogin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zensar.olxlogin.entity.User;

public interface LoginRepository extends JpaRepository<User, Long>{

}
