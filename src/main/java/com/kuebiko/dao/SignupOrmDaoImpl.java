package com.kuebiko.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.kuebiko.entity.SignupEntity;

@Repository("SignupOrmDaoImpl")
public class SignupOrmDaoImpl implements SignupDao {
	
    @Autowired
    private SessionFactory sessionFactory;
    
    private Session getSession(){
             return sessionFactory.getCurrentSession();
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
		boolean babab=org.springframework.transaction.support.TransactionSynchronizationManager.isActualTransactionActive();
		   Session session = sessionFactory.getCurrentSession();
		   SignupEntity signupEntity = session.byId(SignupEntity.class).load(sid);
	       session.delete(signupEntity);
	}

	@Override
	public List<SignupEntity> findAll() {
		List<SignupEntity> signupEntities=getSession().createQuery("from SignupEntity").getResultList();
		return signupEntities;
	}

	@Override
	public void updateSignup(SignupEntity signupEntity) {
		getSession().merge(signupEntity);
	}

	@Override
	public List<SignupEntity> getSignups(int pageid, int total) {
		Query query=getSession().createQuery("from SignupEntity");
        query.setFirstResult(pageid-1);
        query.setMaxResults(total);
        List<SignupEntity> entities = query.list();
		return entities;
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
