package com.uncc.mhealth.dao;

import java.util.List;
import java.util.UUID;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.uncc.mhealth.model.BacLog;
import com.uncc.mhealth.model.ProsCons;
import com.uncc.mhealth.model.Strategies;
import com.uncc.mhealth.model.User;
import com.uncc.mhealth.model.UserMIMapping;

public class ProsConsDAOImpl implements ProsConsDAO{

	private SessionFactory sessionFactory;
	 
    public ProsConsDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
 
    @Transactional
    public List<ProsCons> list() {
        @SuppressWarnings("unchecked")
        List<ProsCons> listUser = (List<ProsCons>) sessionFactory.getCurrentSession()
                .createCriteria(ProsCons.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
 
        return listUser;
    }
 
    @Transactional
    public void saveOrUpdate(ProsCons user) {
        sessionFactory.getCurrentSession().saveOrUpdate(user);
    }
 
    @Transactional
    public void delete(int id) {
    	ProsCons userToDelete = new ProsCons();
        userToDelete.setUser_id(id);
        sessionFactory.getCurrentSession().delete(userToDelete);
    }
 
    @Transactional
    public List<ProsCons> get(int id) {
        String hql = "from ProsCons where user_id=" + id;
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
         
        @SuppressWarnings("unchecked")
        List<ProsCons> listUser = (List<ProsCons>) query.list();
         
        return listUser;
    }
}
