package com.kuebiko.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kuebiko.controller.dto.SignupDTO;
import com.kuebiko.dao.SignupDao;
import com.kuebiko.entity.SignupEntity;
import com.kuebiko.utils.Utils;

@Service
@Transactional
public class SignupServiceImpl implements SignupService {
	
	 @Autowired
	 @Qualifier("SignupOrmDaoImpl")
	 private SignupDao signupDao;

	@Override
	public SignupDTO authUser(String username, String password) {
		SignupEntity signupEntity= signupDao.authUser(username, password);
		SignupDTO signupDTO=null;
		if(signupEntity!=null) {
			 signupDTO=new SignupDTO();
			BeanUtils.copyProperties(signupEntity, signupDTO);	
		}
		return signupDTO;
	}

	@Override
	public void persist(SignupDTO signupDTO) {
		SignupEntity signupEntity=new SignupEntity();
		BeanUtils.copyProperties(signupDTO, signupEntity);
		signupDao.signup(signupEntity);
	}
	
	

	@Override
	public byte[] findImageById(int sid) {
		return signupDao.findImageById(sid);
	}

	@Override
	public SignupDTO findById(int sid) {
		SignupEntity signupEntity=signupDao.findById(sid);
		SignupDTO signupDTO=new SignupDTO();
		BeanUtils.copyProperties(signupEntity, signupDTO);
		return signupDTO;
	}

	@Override
	public void deleteById(int sid) {
		signupDao.deleteById(sid);
	}

	@Override
	public List<SignupDTO> findAll() {
		List<SignupEntity> list=signupDao.findAll();
		List<SignupDTO> signupDTOs=new ArrayList<>();
		for(SignupEntity entity:list) {
			SignupDTO signupDTO=new SignupDTO();
			BeanUtils.copyProperties(entity, signupDTO);
			signupDTOs.add(signupDTO);
		}
		return signupDTOs;
	}
	
	
	@Override
	public List<SignupDTO> getSignups(int pageid, int total){
		List<SignupEntity> list=signupDao.getSignups(pageid,total);
		List<SignupDTO> signupDTOs=new ArrayList<>();
		for(SignupEntity entity:list) {
			SignupDTO signupDTO=new SignupDTO();
			BeanUtils.copyProperties(entity, signupDTO);
			signupDTOs.add(signupDTO);
		}
		return signupDTOs;
	}

	@Override
	public void updateSignup(SignupDTO signupDTO) {
		SignupDTO dbsignupDTO=findById(signupDTO.getSid());
		Utils.copyNonNullProperties(signupDTO, dbsignupDTO);
		SignupEntity signupEntity=new SignupEntity();
		BeanUtils.copyProperties(dbsignupDTO, signupEntity);
		signupDao.updateSignup(signupEntity);
	}
	
	@Override
	public int findTotalSignup() {
		return signupDao.findTotalSignup();
	}

}
