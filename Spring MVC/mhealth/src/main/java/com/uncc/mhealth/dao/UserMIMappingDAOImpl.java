package com.uncc.mhealth.dao;

import java.util.List;
import java.util.UUID;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import com.uncc.mhealth.model.MI;
import com.uncc.mhealth.model.User;
import com.uncc.mhealth.model.UserMIMapping;
import com.uncc.mhealth.model.UserMIMappingFuture;

public class UserMIMappingDAOImpl implements UserMIMappingDAO{

	private SessionFactory sessionFactory;
	 
    public UserMIMappingDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
 
    @Transactional
    public List<UserMIMapping> list() {
        @SuppressWarnings("unchecked")
        List<UserMIMapping> listUser = (List<UserMIMapping>) sessionFactory.getCurrentSession()
                .createCriteria(UserMIMapping.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
 
        return listUser;
    }
 
    @Transactional
    public void saveOrUpdate(UserMIMapping user) {
        sessionFactory.getCurrentSession().saveOrUpdate(user);
    }
 
    @Transactional
    public void delete(int id) {
    	UserMIMapping userToDelete = new UserMIMapping();
        userToDelete.setId(id);
        sessionFactory.getCurrentSession().delete(userToDelete);
    }
 
    @Transactional
    public UserMIMapping get(int id) {
        String hql = "from UserMIMapping where id=" + id;
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
         
        @SuppressWarnings("unchecked")
        List<UserMIMapping> listUser = (List<UserMIMapping>) query.list();
         
        if (listUser != null && !listUser.isEmpty()) {
            return listUser.get(0);
        }
         
        return null;
    }
    
    @Transactional
    public List<UserMIMapping> fetchFromMIAndUser(int mi_id, int userId) {
        String hql = "from UserMIMapping where mi_id=" + mi_id+" and user_id = "+userId;
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
         
        @SuppressWarnings("unchecked")
        List<UserMIMapping> listUser = (List<UserMIMapping>) query.list();
        return listUser;
    }

	@Transactional
	public List<UserMIMapping> list(int user_id, int sent) {
		String hql = "from UserMIMapping where user_id=" + user_id +" and sent = "+sent;
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
         
        @SuppressWarnings("unchecked")
        List<UserMIMapping> listUser = (List<UserMIMapping>) query.list();
		return listUser;
	}
	
	
	@Transactional
	public List<UserMIMapping> getAllMapping(int sent) {
		String hql = "from UserMIMapping where sent = "+sent;
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
         
        @SuppressWarnings("unchecked")
        List<UserMIMapping> listUser = (List<UserMIMapping>) query.list();
		return listUser;
	}
	
	@Transactional
    public void saveOrUpdate(UserMIMappingFuture userMIFuture) {
        sessionFactory.getCurrentSession().saveOrUpdate(userMIFuture);
    }
	
	@Transactional
    public List<UserMIMappingFuture> futurelist() {
        String sql = "select * from user_mi_mapping_future where pendingStatus='Y' and STR_TO_DATE(future_time, '%Y-%m-%d %H:%i') < STR_TO_DATE(now(),'%Y-%m-%d %H:%i')";
        SQLQuery query = sessionFactory.getCurrentSession().createSQLQuery(sql);
        query.addEntity(UserMIMappingFuture.class);
        @SuppressWarnings("unchecked")
		List<UserMIMappingFuture> results = (List<UserMIMappingFuture>)query.list();
        //System.out.println("Results ::"+results.size());
        return results;
    }

	@Transactional
	public MI getMIObj(int mi_id) {
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(MI.class);
		Criterion  ct=Restrictions.eq("id",mi_id);
		cr.add( ct );
		@SuppressWarnings("unchecked")
		List<MI> listMI = (List<MI>) cr.list();
		MI mi = null;
		if (listMI.size() > 0)
			mi = listMI.get(0);
		return mi;
	}
	@Transactional
    public boolean isLastSentMsg(int userId,int miMappingId) {
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(UserMIMapping.class);
		Criterion ct=Restrictions.eq("user_id",userId);
		cr.add( ct ).setProjection(Projections.max("id"));
		Integer maxMImappingId=(Integer)cr.uniqueResult();
		if(maxMImappingId!=null && maxMImappingId==miMappingId)
			return true; 
	    return false;
	}
}
