package edu.poly.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.hibernate.Session;

import edu.poly.entity.Share;
import edu.poly.entity.User;
import edu.poly.entity.Video;
import edu.poly.utils.HibernateUtils;

public class ShareDao extends AbstractEntityDao<Share>{

	public ShareDao() {
		super(Share.class);
	
	}
	public List<Share> findAll(){
		Session session=HibernateUtils.getSession();
		String hql="FROM Share";
		TypedQuery<Share> query=session.createQuery(hql,Share.class);
		
		return query.getResultList();
		
	}
	
}
