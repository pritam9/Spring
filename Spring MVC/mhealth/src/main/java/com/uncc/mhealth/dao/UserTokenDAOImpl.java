package com.uncc.mhealth.dao;

import java.util.List;
import java.util.UUID;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.uncc.mhealth.model.User;
import com.uncc.mhealth.model.UserToken;

public class UserTokenDAOImpl implements UserTokenDAO{

	private SessionFactory sessionFactory;
	 
    public UserTokenDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
 
    @Transactional
    public List<UserToken> list() {
        @SuppressWarnings("unchecked")
        List<UserToken> listUser = (List<UserToken>) sessionFactory.getCurrentSession()
                .createCriteria(UserTokenDAO.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
 
        return listUser;
    }
 
    @Transactional
    public void saveOrUpdate(UserToken user) {
        sessionFactory.getCurrentSession().saveOrUpdate(user);
    }
    
    @Transactional
    public void update(UserToken user) {
        sessionFactory.getCurrentSession().saveOrUpdate(user);
    }
 
    @Transactional
    public void delete(int id, String token) {
    	UserToken userToDelete = new UserToken();
        userToDelete.setUser_id(id);
        userToDelete.setToken(token);
        sessionFactory.getCurrentSession().delete(userToDelete);
    }
 
    @Transactional
    public List<UserToken> get(int id) {
        String hql = "from UserToken where user_id=" + id;
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
         
        @SuppressWarnings("unchecked")
        List<UserToken> listUser = (List<UserToken>) query.list();
         
        return listUser;
    }
    
    @Transactional
    public UserToken getUserTokenFromToken(String token) {
        String hql = "from UserToken where session_token='" + token+"'";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        
        System.out.println("@@Query: "+query.getQueryString());
         
        @SuppressWarnings("unchecked")
        List<UserToken> listUser = (List<UserToken>) query.list();
         
        if (listUser != null && !listUser.isEmpty()) {
            return listUser.get(0);
        }
         
        return null;
    }
    
    @Transactional
    public UserToken getUserToken(int user_id, String device_token) {
        String hql = "from UserToken where user_id=" + user_id+" and token='"+device_token+"'";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        
        System.out.println("@@Query: "+query.getQueryString());
         
        @SuppressWarnings("unchecked")
        List<UserToken> listUser = (List<UserToken>) query.list();
         
        if (listUser != null && !listUser.isEmpty()) {
            return listUser.get(0);
        }
         
        return null;
    }

}
