package com.uncc.mhealth.dao;

import java.util.List;
import java.util.UUID;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.uncc.mhealth.model.User;
import com.uncc.mhealth.model.UserToken;

public class UserDAOImpl implements UserDAO{

	@Autowired
    private UserTokenDAO userTokenDao;
    
	private SessionFactory sessionFactory;
	 
    public UserDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
 
    @Transactional
    public List<User> list() {
        @SuppressWarnings("unchecked")
        List<User> listUser = (List<User>) sessionFactory.getCurrentSession()
                .createCriteria(User.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
 
        return listUser;
    }
 
    @Transactional
    public void saveOrUpdate(User user) {
    	sessionFactory.getCurrentSession().saveOrUpdate(user);
    }
 
    @Transactional
    public void delete(int id) {
        User userToDelete = new User();
        userToDelete.setId(id);
        sessionFactory.getCurrentSession().delete(userToDelete);
    }
 
    @Transactional
    public User get(int id) {
        String hql = "from User where id=" + id;
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
         
        @SuppressWarnings("unchecked")
        List<User> listUser = (List<User>) query.list();
         
        if (listUser != null && !listUser.isEmpty()) {
            return listUser.get(0);
        }
         
        return null;
    }
    
    @Transactional
    public User get(String username) {
        String hql = "from User where username='" + username+"'";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
         
        @SuppressWarnings("unchecked")
        List<User> listUser = (List<User>) query.list();
         
        if (listUser != null && !listUser.isEmpty()) {
            return listUser.get(0);
        }
         
        return null;
    }
//    @Override
//    @Transactional
//    public User getUserFromToken(String token) {
//        String hql = "from User where token='" + token+"'";
//        Query query = sessionFactory.getCurrentSession().createQuery(hql);
//        
//        System.out.println("@@Query: "+query.getQueryString());
//         
//        @SuppressWarnings("unchecked")
//        List<User> listUser = (List<User>) query.list();
//         
//        if (listUser != null && !listUser.isEmpty()) {
//            return listUser.get(0);
//        }
//         
//        return null;
//    }
    @Transactional
    public User getUserFromToken(String token) {
    	//first get user id from UserToken table
    	UserToken userToken = userTokenDao.getUserTokenFromToken(token);
    	
    	if(userToken != null){
    		return get(userToken.getUser_id());
    	} else {    		
    		return null;
    	}
    	
    }

}
