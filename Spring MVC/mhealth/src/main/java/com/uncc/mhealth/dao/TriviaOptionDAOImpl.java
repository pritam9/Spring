package com.uncc.mhealth.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.uncc.mhealth.model.Option;
import com.uncc.mhealth.model.TriviaOption;

public class TriviaOptionDAOImpl implements TriviaOptionDAO{
	private SessionFactory sessionFactory;
	 
    public TriviaOptionDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
 
    @Transactional
    public List<TriviaOption> list() {
        @SuppressWarnings("unchecked")
        List<TriviaOption> listOption = (List<TriviaOption>) sessionFactory.getCurrentSession()
                .createCriteria(TriviaOption.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
 
        return listOption;
    }
 
    @Transactional
    public void saveOrUpdate(TriviaOption question) {
        sessionFactory.getCurrentSession().saveOrUpdate(question);
    }
 
    @Transactional
    public void delete(int id) {
    	TriviaOption optionToDelete = new TriviaOption();
    	optionToDelete.setId(id);
        sessionFactory.getCurrentSession().delete(optionToDelete);
    }
 
    @Transactional
    public TriviaOption get(int id) {
        String hql = "from trivia_options where id=" + id;
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
         
        @SuppressWarnings("unchecked")
        List<TriviaOption> listQuestion = (List<TriviaOption>) query.list();
         
        if (listQuestion != null && !listQuestion.isEmpty()) {
            return listQuestion.get(0);
        }
         
        return null;
    }
}
