package com.kuebiko.dao;

import java.util.List;

import com.kuebiko.entity.SignupEntity;

public interface SignupDao {

	SignupEntity authUser(String username, String password);
	void signup(SignupEntity signupEntity);
	SignupEntity findById(int sid);
	void deleteById(int sid);
	List<SignupEntity> findAll();
	void updateSignup(SignupEntity signupEntity);


}
