package com.uncc.mhealth.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import com.uncc.mhealth.model.Question;
import com.uncc.mhealth.model.User;

public class QuestionDAOImpl implements QuestionDAO{
	private SessionFactory sessionFactory;
	 
    public QuestionDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
 
    @Transactional
    public List<Question> list() {
        @SuppressWarnings("unchecked")
        List<Question> listQuestion = (List<Question>) sessionFactory.getCurrentSession()
                .createCriteria(Question.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
        System.out.println("@@ questions : "+listQuestion.size());
        return listQuestion;
    }
    @Transactional
    public List<Question> getSurvey(String survey) {
        String hql = "from Question where survey='" + survey+"' ORDER BY index";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
         
        @SuppressWarnings("unchecked")
        List<Question> listQuestion = (List<Question>) query.list();
        
        
        
        System.out.println("@@ questions : "+listQuestion.size());
        return listQuestion;
    }
    @Transactional
    public List<Question> getSurvey(String survey,int pageNo) {
       Criteria criteria= sessionFactory.getCurrentSession().createCriteria(Question.class);
        criteria.add(Restrictions.eq("survey", survey));
        criteria.add(Restrictions.eq("pageNo", pageNo));
        criteria.add(Restrictions.eq("active_yn","Y"));
        criteria.addOrder(Property.forName("orderNo").asc() );
        @SuppressWarnings("unchecked")
        List<Question> listQuestion = (List<Question>) criteria.list();
        
        System.out.println("@@ questions : "+listQuestion.size());
        return listQuestion;
    }
    @Transactional
    public List<Question> getSixWeekSurvey(String survey,int pageNo) {
       Criteria criteria= sessionFactory.getCurrentSession().createCriteria(Question.class);
        criteria.add(Restrictions.eq("survey", survey));
        criteria.add(Restrictions.eq("pageNo", pageNo));
        criteria.add(Restrictions.eq("active_yn","Y"));
        criteria.add(Restrictions.eq("sixWeekFlag","Y"));
        criteria.addOrder(Property.forName("orderNo").asc() );
        @SuppressWarnings("unchecked")
        List<Question> listQuestion = (List<Question>) criteria.list();
        
        System.out.println("@@ questions : "+listQuestion.size());
        return listQuestion;
    }
 
    @Transactional
    public void saveOrUpdate(Question question) {
        sessionFactory.getCurrentSession().saveOrUpdate(question);
    }
 
    @Transactional
    public void delete(int id) {
        Question questionToDelete = new Question();
        questionToDelete.setId(id);
        sessionFactory.getCurrentSession().delete(questionToDelete);
    }
 
    @Transactional
    public Question get(int id) {
        String hql = "from questions where id=" + id;
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
         
        @SuppressWarnings("unchecked")
        List<Question> listQuestion = (List<Question>) query.list();
         
        if (listQuestion != null && !listQuestion.isEmpty()) {
            return listQuestion.get(0);
        }
         
        return null;
    }
    @Transactional
    public Question getQuestion(int id) {
        String hql = "from Question where id=" + id;
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
         
        @SuppressWarnings("unchecked")
        List<Question> listQuestion = (List<Question>) query.list();
         
        if (listQuestion != null && !listQuestion.isEmpty()) {
            return listQuestion.get(0);
        }
         
        return null;
    }
}
