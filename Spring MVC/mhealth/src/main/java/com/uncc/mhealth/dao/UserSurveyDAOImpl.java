package com.uncc.mhealth.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import com.uncc.mhealth.model.Question;
import com.uncc.mhealth.model.UserSurvey;
import com.uncc.mhealth.model.UserSurveyResponse;

public class UserSurveyDAOImpl implements UserSurveyDAO {

	private SessionFactory sessionFactory;

	public UserSurveyDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void saveOrUpdate(UserSurvey userSurvey) {
		sessionFactory.getCurrentSession().saveOrUpdate(userSurvey);
	}

	@Transactional
	public void saveOrUpdate(UserSurveyResponse userResponse) {
		sessionFactory.getCurrentSession().saveOrUpdate(userResponse);
	}

	@Transactional
	public void delete(int id) {
		UserSurvey userSurveyToDelete = new UserSurvey();
		userSurveyToDelete.setId(id);
		sessionFactory.getCurrentSession().delete(userSurveyToDelete);
	}

	@Transactional
	public UserSurvey get(int id, String survey) {
		String hql = "from UserSurvey where id=" + id + " and survey = '" + survey + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);

		@SuppressWarnings("unchecked")
		List<UserSurvey> listUserSurvey = (List<UserSurvey>) query.list();

		if (listUserSurvey != null && !listUserSurvey.isEmpty()) {
			return listUserSurvey.get(0);
		}
		return null;
	}

	@Transactional
	public List<UserSurvey> get(int id) {

		String testvalue = "baseline_survey_page";

		String hql = "from UserSurvey where id=" + id + " and survey LIKE :surveyname ";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter("surveyname", "%" + testvalue + "%");

		@SuppressWarnings("unchecked")
		List<UserSurvey> listUserSurvey = (List<UserSurvey>) query.list();

		return listUserSurvey;
	}

	@Transactional
	public List<UserSurveyResponse> getUserSurveyResponse(int id, String surveyName) {

		String hql = "from UserSurveyResponse where id=" + id + " and survey = :surveyname ";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter("surveyname", surveyName);

		@SuppressWarnings("unchecked")
		List<UserSurveyResponse> listUserSurvey = (List<UserSurveyResponse>) query.list();

		return listUserSurvey;
	}

	@Transactional
	public List<UserSurveyResponse> getAllUserSurveyResponse(int id) {

		String hql = "from UserSurveyResponse where id= :id";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter("id", id);

		@SuppressWarnings("unchecked")
		List<UserSurveyResponse> listUserSurvey = (List<UserSurveyResponse>) query.list();

		return listUserSurvey;
	}
	@Transactional
	public List<Question> getMentorFeedback(int userid) {

		String hql = "from UserSurveyResponse where id=" + userid + " and questionId in (9,111,112,113,73) ";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<UserSurveyResponse> listUserSurvey = (List<UserSurveyResponse>) query.list();
		
		/*Criteria criteria= sessionFactory.getCurrentSession().createCriteria(Question.class);
        criteria.add(Restrictions.eq("survey", "baseline"));
        criteria.add(Restrictions.eq("pageNo", 1));
        criteria.add(Restrictions.eq("active_yn","Y"));
        criteria.add(Restrictions.eq("type",10));
        criteria.addOrder(Property.forName("orderNo").asc() );
        @SuppressWarnings("unchecked")
        List<Question> listQuestion = (List<Question>) criteria.list();*/
		String sql = "SELECT question_id, text FROM questions where survey='baseline' and pageNo=1 and active_yn='Y' and type=10";
        SQLQuery query1 = sessionFactory.getCurrentSession().createSQLQuery(sql);
        query1.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
        List data = query1.list();

        
        List<Question> mentorFeedbackQuestions = new ArrayList<Question>();
        for(Object object : data){
        	Map row = (Map)object;
        	int question_id=(Integer) row.get("question_id");
        	String ques_text=(String) row.get("text");
        	for(UserSurveyResponse response:listUserSurvey){
        		if(question_id==response.getQuestionId()){
        			Question q=new Question();
        			q.setId(question_id);
        			q.setText(ques_text);
        			q.setAnswer(response.getAnswer());
        			mentorFeedbackQuestions.add(q);
        			break;
        		}
        	}
        }
       
        
        //return listUserSurvey;
        return mentorFeedbackQuestions;
		
	}

}
