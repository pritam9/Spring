package com.uncc.mhealth.dao;

import java.util.List;
import java.util.UUID;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.uncc.mhealth.model.BacLog;
import com.uncc.mhealth.model.Strategies;
import com.uncc.mhealth.model.User;
import com.uncc.mhealth.model.UserMIMapping;

public class BacLogDAOImpl implements BacLogDAO{

	private SessionFactory sessionFactory;
	 
    public BacLogDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
 
    @Transactional
    public List<BacLog> list() {
        @SuppressWarnings("unchecked")
        List<BacLog> listUser = (List<BacLog>) sessionFactory.getCurrentSession()
                .createCriteria(BacLog.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
 
        return listUser;
    }
 
    @Transactional
    public void saveOrUpdate(BacLog user) {
        sessionFactory.getCurrentSession().saveOrUpdate(user);
    }
 
    @Transactional
    public void delete(int id) {
    	BacLog userToDelete = new BacLog();
        userToDelete.setUser_id(id);
        sessionFactory.getCurrentSession().delete(userToDelete);
    }
 
    @Transactional
    public List<BacLog> get(int id) {
        String hql = "from BacLog where user_id=" + id;
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
         
        @SuppressWarnings("unchecked")
        List<BacLog> listUser = (List<BacLog>) query.list();
         
        return listUser;
    }

	@Transactional
	public List<BacLog> list(int user_id, String log_date) {
		String hql = "from BacLog where user_id=" + user_id;;
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
         
        @SuppressWarnings("unchecked")
        List<BacLog> listUser = (List<BacLog>) query.list();
		return listUser;
	}
}
