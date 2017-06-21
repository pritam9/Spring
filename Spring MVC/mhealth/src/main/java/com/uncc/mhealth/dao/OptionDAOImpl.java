package com.uncc.mhealth.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.uncc.mhealth.model.Option;

public class OptionDAOImpl implements OptionDAO{
	private SessionFactory sessionFactory;
	 
    public OptionDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
 
    @Transactional
    public List<Option> list() {
        @SuppressWarnings("unchecked")
        List<Option> listOption = (List<Option>) sessionFactory.getCurrentSession()
                .createCriteria(Option.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
 
        return listOption;
    }
 
    @Transactional
    public void saveOrUpdate(Option question) {
        sessionFactory.getCurrentSession().saveOrUpdate(question);
    }
 
    @Transactional
    public void delete(int id) {
    	Option optionToDelete = new Option();
    	optionToDelete.setId(id);
        sessionFactory.getCurrentSession().delete(optionToDelete);
    }
 
    @Transactional
    public Option get(int id) {
        String hql = "from options where id=" + id;
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
         
        @SuppressWarnings("unchecked")
        List<Option> listQuestion = (List<Option>) query.list();
         
        if (listQuestion != null && !listQuestion.isEmpty()) {
            return listQuestion.get(0);
        }
         
        return null;
    }
}
