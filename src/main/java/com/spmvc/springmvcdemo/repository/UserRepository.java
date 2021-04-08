package com.spmvc.springmvcdemo.repository;

import com.spmvc.springmvcdemo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {

     List<User> findByEmailId(String emailId);
     User findByEmailIdAndPassword(String emailId,String password);

}
