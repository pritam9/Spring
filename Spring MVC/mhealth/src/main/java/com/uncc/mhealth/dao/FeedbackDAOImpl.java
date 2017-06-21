package com.uncc.mhealth.dao;

import java.util.List;
import java.util.UUID;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.uncc.mhealth.model.Feedback;
import com.uncc.mhealth.model.TriviaScore;
import com.uncc.mhealth.model.User;

public class FeedbackDAOImpl implements FeedbackDAO{

	private SessionFactory sessionFactory;
	 
    public FeedbackDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
 
    @Transactional
    public List<Feedback> list() {
        @SuppressWarnings("unchecked")
        List<Feedback> listUser = (List<Feedback>) sessionFactory.getCurrentSession()
                .createCriteria(Feedback.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
 
        return listUser;
    }
 
    @Transactional
    public void saveOrUpdate(Feedback user) {
        sessionFactory.getCurrentSession().saveOrUpdate(user);
    }
 
    @Transactional
    public void delete(int id) {
    	Feedback userToDelete = new Feedback();
        userToDelete.setUser_id(id);
        sessionFactory.getCurrentSession().delete(userToDelete);
    }
 
    @Transactional
    public Feedback get(int id) {
        String hql = "from Feedback where user_id=" + id;
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
         
        @SuppressWarnings("unchecked")
        List<Feedback> listUser = (List<Feedback>) query.list();
         
        if (listUser != null && !listUser.isEmpty()) {
            return listUser.get(0);
        }
         
        return null;
    }
   
}
