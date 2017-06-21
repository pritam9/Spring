package com.uncc.mhealth.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.uncc.mhealth.model.MIOption;
import com.uncc.mhealth.model.Option;

public class MIOptionDAOImpl implements MIOptionDAO{
	private SessionFactory sessionFactory;
	 
    public MIOptionDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
 
    @Transactional
    public List<MIOption> list() {
        @SuppressWarnings("unchecked")
        List<MIOption> listOption = (List<MIOption>) sessionFactory.getCurrentSession()
                .createCriteria(MIOption.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
 
        return listOption;
    }
 
    @Transactional
    public void saveOrUpdate(MIOption question) {
        sessionFactory.getCurrentSession().saveOrUpdate(question);
    }
 
    @Transactional
    public void delete(int id) {
    	MIOption optionToDelete = new MIOption();
    	optionToDelete.setId(id);
        sessionFactory.getCurrentSession().delete(optionToDelete);
    }
 
    @Transactional
    public MIOption get(int id) {
        String hql = "from mioptions where id=" + id;
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
         
        @SuppressWarnings("unchecked")
        List<MIOption> listQuestion = (List<MIOption>) query.list();
         
        if (listQuestion != null && !listQuestion.isEmpty()) {
            return listQuestion.get(0);
        }
         
        return null;
    }
}
