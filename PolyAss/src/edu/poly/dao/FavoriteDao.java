package edu.poly.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.hibernate.Session;

import edu.poly.domain.FavoriteListVideoReport;
import edu.poly.domain.FavoriteUserReport;
import edu.poly.entity.Favorite;
import edu.poly.entity.User;
import edu.poly.entity.Video;
import edu.poly.utils.HibernateUtils;

public class FavoriteDao extends AbstractEntityDao<Favorite>{

	public FavoriteDao() {
		super(Favorite.class);
	}
	public List<FavoriteUserReport> reportFavoriteUser(String videoId){
		String hql="select new edu.poly.domain.FavoriteUserReport"
				+ "(f.user.userId,f.user.fullname,f.user.email,f.likeDate) "
				+ "from Favorite f where f.video.videoId =:videoId";
		Session session=HibernateUtils.getSession();
	
			TypedQuery<FavoriteUserReport> query=session.createQuery(hql,FavoriteUserReport.class);
			query.setParameter("videoId", videoId);
		return  query.getResultList();
	}	
	public List<FavoriteListVideoReport> reportFavoriteListVideo(){
		Session session=HibernateUtils.getSession();
		String jpql="select new edu.poly.domain.FavoriteListVideoReport( f.video.title,count(f) ,min(f.likeDate),max(f.likeDate)) "
				+ "from Favorite f group by f.video.title ";
			TypedQuery<FavoriteListVideoReport> query=session.createQuery(jpql, FavoriteListVideoReport.class);
		
		return query.getResultList();
	}
	public List<Favorite> findAll(){
		Session session=HibernateUtils.getSession();
		String hql="FROM Favorite";
		TypedQuery<Favorite> query=session.createQuery(hql,Favorite.class);
		
		return query.getResultList();
		
	}
	public List<Favorite> findAllLike(String id,int offset,int limit){
		Session session=HibernateUtils.getSession();
		try {
			String hql="FROM Favorite f WHERE f.user.userId=:userId";
			TypedQuery<Favorite> query=session.createQuery(hql,Favorite.class);
			query.setParameter("userId", id);
			query.setFirstResult(offset);
			query.setMaxResults(limit);
			return query.getResultList();
			
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			throw e;
		}
		
		
	}
}
