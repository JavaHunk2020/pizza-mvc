package com.kuebiko.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kuebiko.entity.SignupEntity;

@Repository("SignupOrmDaoImpl")
@Transactional
public class SignupOrmDaoImpl implements SignupDao {
	
    @Autowired
    private SessionFactory sessionFactory;
    
    private Session getSession(){
             return sessionFactory.openSession();
    }


	@Override
	public SignupEntity authUser(String username, String password) {
		 TypedQuery<SignupEntity> query=getSession().createQuery("from SignupEntity t where t.username=:pusername and t.password=:ppassword"); //HQL
		 query.setParameter("pusername", username);
		 query.setParameter("ppassword", password);
		 SignupEntity  loginHistoryEntity=null;
		 try {
		      loginHistoryEntity=query.getSingleResult();
		 }catch (Exception e) {
			 e.printStackTrace();
		}
		return loginHistoryEntity;
	}

	@Override
	public void signup(SignupEntity signupEntity) {
		getSession().save(signupEntity);
	}

	@Override
	public SignupEntity findById(int sid) {
		SignupEntity entity=getSession().get(SignupEntity.class, sid);
		return entity;
	}

	@Override
	public void deleteById(int sid) {
		Session session=getSession();
		SignupEntity entity=session.get(SignupEntity.class, sid);
		session.delete(entity);
	}

	@Override
	public List<SignupEntity> findAll() {
		List<SignupEntity> signupEntities=getSession().createQuery("from SignupEntity").getResultList();
		return signupEntities;
	}

	@Override
	public void updateSignup(SignupEntity signupEntity) {
		getSession().update(signupEntity);
	}

	@Override
	public List<SignupEntity> getSignups(int pageid, int total) {
		return null;
	}

	@Override
	public int findTotalSignup() {
		Query query = getSession().createQuery("select count(*) from SignupEntity");
		Long count = (Long)query.uniqueResult();
		return count.intValue();
	}

	@Override
	public byte[] findImageById(int sid) {
		SignupEntity entity=getSession().get(SignupEntity.class, sid);
		return entity.getBphoto();
	}

}
