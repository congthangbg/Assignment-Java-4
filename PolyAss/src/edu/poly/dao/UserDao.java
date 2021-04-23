package edu.poly.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.hibernate.Session;

import edu.poly.entity.User;
import edu.poly.utils.HibernateUtils;

public class UserDao extends AbstractEntityDao<User>{

	public UserDao() {
		super(User.class);
	
	}
	public List<User> findAll(int offset,int limit){
		Session session=HibernateUtils.getSession();
		String hql="FROM User";
		Query query=session.createQuery(hql);
		query.setFirstResult(offset);
		query.setMaxResults(limit );
		
		List<User> list=query.getResultList();
		return list;
	}
	public List<User> findAll2(){
		Session session=HibernateUtils.getSession();
		String hql="FROM User";
		TypedQuery<User> query=session.createQuery(hql,User.class);
		
		return query.getResultList();
		
	}
	public void changePassword(String userId,String oldPass,String newPass) throws Exception {
		Session session=HibernateUtils.getSession();
		try {
			String hql="select u from User u where u.userId =:userId and u.password=:password";
			session.clear();
			session.beginTransaction();
			TypedQuery<User> query=session.createQuery(hql,User.class);
			query.setParameter("userId", userId);
			query.setParameter("password", oldPass);
			
			User user=query.getSingleResult();
			
			if(user == null ) {
				throw new Exception("UserId or password are incorrect");
			}
			user.setPassword(newPass);
			
			session.update(user);
			
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			throw e;
		}
	}
	public User findByUserIdAndEmail(String userId,String email) {
		Session session=HibernateUtils.getSession();
		
		String hql="SELECT u FROM User u WHERE u.userId=:userId AND u.email=:email";
			TypedQuery<User> query=session.createQuery(hql,User.class);
			query.setParameter("userId", userId);
			query.setParameter("email", email);
			
		
		return query.getSingleResult();
	}
}
