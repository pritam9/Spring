package com.uncc.mhealth.dao;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.type.TypeFactory;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.uncc.mhealth.model.MI;
import com.uncc.mhealth.model.MIOption;
import com.uncc.mhealth.model.Question;
import com.uncc.mhealth.model.TriviaOption;
import com.uncc.mhealth.model.TriviaQuestion;

public class TriviaQuestionDAOImpl implements TriviaQuestionDAO{
	private SessionFactory sessionFactory;
	 
    public TriviaQuestionDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
 
    @SuppressWarnings("unchecked")
    @Transactional
    public List<TriviaQuestion> list(int category) {
        @SuppressWarnings("unchecked")
        List<TriviaQuestion> listQuestion = (List<TriviaQuestion>) sessionFactory.getCurrentSession()
                .createCriteria(TriviaQuestion.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
        System.out.println("@@ questions : "+listQuestion.size());
        
        String hql = "FROM TriviaQuestion WHERE category = "+category+" ORDER BY rand()";
        Query query = sessionFactory.getCurrentSession().createQuery(hql).setMaxResults(10);
        listQuestion =(List<TriviaQuestion>) query.list();
        
//        for(TriviaQuestion question: listQuestion){
//        	String json = question.getOptions_json();
//        	question.setOptions_json("");
//        	ObjectMapper mapper = new ObjectMapper();
//        	try {
//				Set<TriviaOption> option = mapper.readValue(json, TypeFactory.collectionType(Set.class, TriviaOption.class));
//				question.setOptions(option);
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//        }
        
        
        return listQuestion;
    }
 
    @Transactional
    public void saveOrUpdate(TriviaQuestion question) {
        sessionFactory.getCurrentSession().saveOrUpdate(question);
    }
 
    @Transactional
    public void delete(int id) {
    	TriviaQuestion questionToDelete = new TriviaQuestion();
        questionToDelete.setTrivia_id(id);
        sessionFactory.getCurrentSession().delete(questionToDelete);
    }
 
    @Transactional
    public TriviaQuestion get(int id) {
        String hql = "from trivia_questions where trivia_id=" + id;
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
         
        @SuppressWarnings("unchecked")
        List<TriviaQuestion> listQuestion = (List<TriviaQuestion>) query.list();
         
        if (listQuestion != null && !listQuestion.isEmpty()) {
            return listQuestion.get(0);
        }
         
        return null;
    }
}
