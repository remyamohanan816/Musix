package com.ust.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ust.Model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>{

}