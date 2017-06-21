package com.uncc.mhealth.dao;

import java.util.List;
import java.util.UUID;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.transaction.annotation.Transactional;

import com.uncc.mhealth.model.TriviaScore;
import com.uncc.mhealth.model.User;

public class TriviaScoreDAOImpl implements TriviaScoreDAO{

	private SessionFactory sessionFactory;
	 
    public TriviaScoreDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
 
    @Transactional
    public List<TriviaScore> list() {
        @SuppressWarnings("unchecked")
        List<TriviaScore> listUser = (List<TriviaScore>) sessionFactory.getCurrentSession()
                .createCriteria(TriviaScore.class)
                .addOrder(Order.desc("score"))
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
 
        return listUser;
    }
 
    @Transactional
    public void saveOrUpdate(TriviaScore user) {
        sessionFactory.getCurrentSession().saveOrUpdate(user);
    }
 
    @Transactional
    public void delete(int id) {
    	TriviaScore userToDelete = new TriviaScore();
        userToDelete.setUser_id(id);
        sessionFactory.getCurrentSession().delete(userToDelete);
    }
 
    @Transactional
    public TriviaScore get(int id) {
        String hql = "from TriviaScore where user_id=" + id;
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
         
        @SuppressWarnings("unchecked")
        List<TriviaScore> listUser = (List<TriviaScore>) query.list();
         
        if (listUser != null && !listUser.isEmpty()) {
            return listUser.get(0);
        }
         
        return null;
    }

	public TriviaScore getHighScore() {
		return null;
	}
   
}
