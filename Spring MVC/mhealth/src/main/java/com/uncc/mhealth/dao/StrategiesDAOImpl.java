package com.uncc.mhealth.dao;

import java.util.List;
import java.util.UUID;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.uncc.mhealth.model.Strategies;
import com.uncc.mhealth.model.User;
import com.uncc.mhealth.model.UserMIMapping;

public class StrategiesDAOImpl implements StrategiesDAO{

	private SessionFactory sessionFactory;
	 
    public StrategiesDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
 
    @Transactional
    public List<Strategies> list() {
        @SuppressWarnings("unchecked")
        List<Strategies> listUser = (List<Strategies>) sessionFactory.getCurrentSession()
                .createCriteria(Strategies.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
 
        return listUser;
    }
 
    @Transactional
    public void saveOrUpdate(Strategies user) {
        sessionFactory.getCurrentSession().saveOrUpdate(user);
    }
 
    @Transactional
    public void delete(int id) {
    	Strategies userToDelete = new Strategies();
        userToDelete.setUser_id(id);
        sessionFactory.getCurrentSession().delete(userToDelete);
    }
 
    @Transactional
    public Strategies get(int id) {
        String hql = "from Strategies where user_id=" + id;
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
         
        @SuppressWarnings("unchecked")
        List<Strategies> listUser = (List<Strategies>) query.list();
         
        if (listUser != null && !listUser.isEmpty()) {
            return listUser.get(0);
        }
         
        return null;
    }

	@Transactional
	public List<Strategies> list(int user_id) {
		String hql = "from Strategies where user_id=" + user_id;;
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
         
        @SuppressWarnings("unchecked")
        List<Strategies> listUser = (List<Strategies>) query.list();
		return listUser;
	}
}
