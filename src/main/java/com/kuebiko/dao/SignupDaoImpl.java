package com.kuebiko.dao;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kuebiko.entity.SignupEntity;
import com.kuebiko.query.SQLQuery;

@Repository
public class SignupDaoImpl implements SignupDao {
	
	@Autowired
	@Qualifier("pkdataSource")
	private DataSource dataSource;
	
   private	JdbcTemplate jdbcTemplate;
   
   public SignupDaoImpl() {
   }
	
	@PostConstruct
	public void init() {
		jdbcTemplate=new JdbcTemplate(dataSource);
	}
	
	@Override
	public void signup(SignupEntity signupEntity) {
		//insert into signup_tbl(username,password,email,name,salutation,datecreated) values(?,?,?,?,?,?)
		Timestamp timestamp=new Timestamp(new Date().getTime());
		Object[] data= {signupEntity.getUsername(),signupEntity.getPassword(),signupEntity.getEmail(),signupEntity.getName(),signupEntity.getSalutation(),timestamp};
		jdbcTemplate.update(SQLQuery.INSERT_SIGNUP,data);
	}
	
	@Override
	public void updateSignup(SignupEntity signupEntity) {
		Object[] data= {signupEntity.getUsername(),signupEntity.getPassword(),signupEntity.getEmail(),signupEntity.getName(),signupEntity.getSalutation(),signupEntity.getSid()};
		jdbcTemplate.update(SQLQuery.UPDATE_SIGNUP_BY_SID,data);
	}
	
	@Override
	public void deleteById(int  sid) {
		jdbcTemplate.update(SQLQuery.DELETE_SIGNUP,new Object[] {sid});
	}
	
	@Override
	public SignupEntity findById(int sid) {
		SignupEntity signupEntity=(SignupEntity)jdbcTemplate.queryForObject(SQLQuery.SELECT_SIGNUPS_SID, new Object[] {sid},new BeanPropertyRowMapper<>(SignupEntity.class));
		return signupEntity;
	}


	@Override
	public SignupEntity authUser(String username, String password) {
		 List<SignupEntity> signupList=jdbcTemplate.query(SQLQuery.SELECT_SIGNUP_USERNAME_PASSWORD, new Object[] {username,password},new BeanPropertyRowMapper<>(SignupEntity.class));
		 return signupList.size()==0 ?null : signupList.get(0);
	}
	
	@Override
	public List<SignupEntity> findAll(){ 
		 List<SignupEntity> signupList=jdbcTemplate.query(SQLQuery.SELECT_SIGNUPS, new BeanPropertyRowMapper<>(SignupEntity.class));
		return signupList;
	}
	
	
	@Override
    public List<SignupEntity> getSignups(int pageid,int total) {
		//1-5
		//0 ,5
		//5,5
		//10,5
        String sql = "select sid,username,password,email,name,salutation,datecreated from signup_tbl order by sid desc limit "+(pageid-1)+","+total;
        List<SignupEntity> signupList=jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(SignupEntity.class));
        return signupList;
    }
	
	
	@Override
    public int findTotalSignup() {
        String sql = "select count(*) from signup_tbl";
        Integer count=jdbcTemplate.queryForObject(sql, Integer.class);
        return count;
    }

}
