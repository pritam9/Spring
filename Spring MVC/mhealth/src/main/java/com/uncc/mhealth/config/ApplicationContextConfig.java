package com.uncc.mhealth.config;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.uncc.mhealth.dao.BacLogDAO;
import com.uncc.mhealth.dao.BacLogDAOImpl;
import com.uncc.mhealth.dao.FeedbackDAO;
import com.uncc.mhealth.dao.FeedbackDAOImpl;
import com.uncc.mhealth.dao.MIDAO;
import com.uncc.mhealth.dao.MIDAOImpl;
import com.uncc.mhealth.dao.MIOptionDAO;
import com.uncc.mhealth.dao.MIOptionDAOImpl;
import com.uncc.mhealth.dao.OptionDAO;
import com.uncc.mhealth.dao.OptionDAOImpl;
import com.uncc.mhealth.dao.ProsConsDAO;
import com.uncc.mhealth.dao.ProsConsDAOImpl;
import com.uncc.mhealth.dao.QuestionDAO;
import com.uncc.mhealth.dao.QuestionDAOImpl;
import com.uncc.mhealth.dao.StrategiesDAO;
import com.uncc.mhealth.dao.StrategiesDAOImpl;
import com.uncc.mhealth.dao.TriviaOptionDAO;
import com.uncc.mhealth.dao.TriviaOptionDAOImpl;
import com.uncc.mhealth.dao.TriviaQuestionDAO;
import com.uncc.mhealth.dao.TriviaQuestionDAOImpl;
import com.uncc.mhealth.dao.TriviaScoreDAO;
import com.uncc.mhealth.dao.TriviaScoreDAOImpl;
import com.uncc.mhealth.dao.UserDAO;
import com.uncc.mhealth.dao.UserDAOImpl;
import com.uncc.mhealth.dao.UserMIMappingDAO;
import com.uncc.mhealth.dao.UserMIMappingDAOImpl;
import com.uncc.mhealth.dao.UserSurveyDAO;
import com.uncc.mhealth.dao.UserSurveyDAOImpl;
import com.uncc.mhealth.dao.UserTokenDAO;
import com.uncc.mhealth.dao.UserTokenDAOImpl;
import com.uncc.mhealth.job.MyFutureJob;
import com.uncc.mhealth.job.MyJob;
import com.uncc.mhealth.job.SchedulerFactoryBeanWithWait;
import com.uncc.mhealth.service.MiService;
import com.uncc.mhealth.service.PushService;

@Configuration
//@ComponentScan("com.uncc.mhealth")
@EnableTransactionManagement
public class ApplicationContextConfig {
	

	@Autowired
    private UserDAO userDao;
	@Autowired
    private FeedbackDAO feedbackDao;
	@Autowired
    private UserMIMappingDAO userMIMappingDao;
	@Autowired
    private UserTokenDAO userTokenDao;
	@Autowired
    private BacLogDAO bacLogDAO;
    @Autowired
    private TriviaScoreDAO triviaScoreDao;
    @Autowired
	private MiService miService;
    @Autowired
	private PushService pushService;
 
	
//    @Bean(name = "viewResolver")
//    public InternalResourceViewResolver getViewResolver() {
//        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
//        viewResolver.setPrefix("/WEB-INF/views/");
//        viewResolver.setSuffix(".jsp");
//        return viewResolver;
//    }
     
    
//   @Bean(name = "dataSource")
//    public DataSource getDataSource() {
//    	BasicDataSource dataSource = new BasicDataSource();
//    	dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//    	dataSource.setUrl("jdbc:mysql://localhost:3306/usersdb");
//    	dataSource.setUsername("root");
//    	dataSource.addConnectionProperty("initialSize", "1");
//    	dataSource.addConnectionProperty("maxActive", "5");
//    	dataSource.addConnectionProperty("maxIdle", "2");
//    	dataSource.setPassword("mhealth");
//    	
//    	return dataSource;
//    }
//    
    
//    private Properties getHibernateProperties() {
//    	Properties properties = new Properties();
//    	properties.put("hibernate.show_sql", "true");
//    	properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
//    	return properties;
//    }
    
//    @Autowired
//    @Bean(name = "sessionFactory")
//    public SessionFactory getSessionFactory(DataSource dataSource) {
//    	LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
//    	sessionBuilder.addProperties(getHibernateProperties());
//    	sessionBuilder.addAnnotatedClasses(User.class);
//    	return sessionBuilder.buildSessionFactory();
//    }
    
//	@Autowired
//	@Bean(name = "transactionManager")
//	public HibernateTransactionManager getTransactionManager(
//			SessionFactory sessionFactory) {
//		HibernateTransactionManager transactionManager = new HibernateTransactionManager(
//				sessionFactory);
//
//		return transactionManager;
//	}
    
    @Autowired
    @Bean(name = "userDao")
    public UserDAO getUserDao(SessionFactory sessionFactory) {
    	return new UserDAOImpl(sessionFactory);
    }
    @Autowired
    @Bean(name = "questionDao")
    public QuestionDAO getQuestionDao(SessionFactory sessionFactory) {
    	return new QuestionDAOImpl(sessionFactory);
    }
    @Autowired
    @Bean(name = "optionDao")
    public OptionDAO getOptionDao(SessionFactory sessionFactory) {
    	return new OptionDAOImpl(sessionFactory);
    }
    @Autowired
    @Bean(name = "userSurveyDao")
    public UserSurveyDAO getUserSurveyDao(SessionFactory sessionFactory) {
    	return new UserSurveyDAOImpl(sessionFactory);
    }  
    @Autowired
    @Bean(name = "miDao")
    public MIDAO getMIDao(SessionFactory sessionFactory) {
    	return new MIDAOImpl(sessionFactory);
    }
    @Autowired
    @Bean(name = "miOptionDao")
    public MIOptionDAO getMIOptionDao(SessionFactory sessionFactory) {
    	return new MIOptionDAOImpl(sessionFactory);
    }
    @Autowired
    @Bean(name = "triviaQuestionDao")
    public TriviaQuestionDAO getTriviaQuestionDao(SessionFactory sessionFactory) {
    	return new TriviaQuestionDAOImpl(sessionFactory);
    }
    @Autowired
    @Bean(name = "triviaOptionDao")
    public TriviaOptionDAO getTriviaOptionDao(SessionFactory sessionFactory) {
    	return new TriviaOptionDAOImpl(sessionFactory);
    }
    @Autowired
    @Bean(name = "triviaScoreDao")
    public TriviaScoreDAO getTriviaScoreDao(SessionFactory sessionFactory) {
    	return new TriviaScoreDAOImpl(sessionFactory);
    }
    @Autowired
    @Bean(name = "feedbackDao")
    public FeedbackDAO getFeedbackDao(SessionFactory sessionFactory) {
    	return new FeedbackDAOImpl(sessionFactory);
    }
    @Autowired
    @Bean(name = "userMIMappingDao")
    public UserMIMappingDAO getUserMIMappingDAO(SessionFactory sessionFactory) {
    	return new UserMIMappingDAOImpl(sessionFactory);
    }
    
    @Autowired
    @Bean(name = "userTokenDao")
    public UserTokenDAO getUserTokenDAO(SessionFactory sessionFactory) {
    	return new UserTokenDAOImpl(sessionFactory);
    }
    @Autowired
    @Bean(name = "strategiesDao")
    public StrategiesDAO getStrategiesDAO(SessionFactory sessionFactory) {
    	return new StrategiesDAOImpl(sessionFactory);
    }
    @Autowired
    @Bean(name = "bacLogDao")
    public BacLogDAO getBacLogDAO(SessionFactory sessionFactory) {
    	return new BacLogDAOImpl(sessionFactory);
    }
    @Autowired
    @Bean(name = "prosConsDao")
    public ProsConsDAO getProsConsDAO(SessionFactory sessionFactory) {
    	return new ProsConsDAOImpl(sessionFactory);
    }
    
    
    //Quartz
    @Bean
	public JobDetailFactoryBean jobDetailFactoryBean(){
		JobDetailFactoryBean factory = new JobDetailFactoryBean();
		factory.setJobClass(MyJob.class);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("name", "RAM");
		map.put("count", 1);
		map.put("userDao", userDao);
		map.put("userMIMappingDao", userMIMappingDao);
		map.put("feedbackDao", feedbackDao);
		map.put("userTokenDao", userTokenDao);
		map.put("bacLogDAO", bacLogDAO);
		map.put("triviaScoreDao", triviaScoreDao);
		map.put("miService", miService);
		map.put("pushService", pushService);
		
		factory.setJobDataAsMap(map);
		factory.setGroup("mygroup");
		factory.setName("myjob");
		factory.setDurability(true);
		return factory;
	} 
    @Bean
	public JobDetailFactoryBean futureJobDetailFactoryBean(){
		JobDetailFactoryBean factory = new JobDetailFactoryBean();
		factory.setJobClass(MyFutureJob.class);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("name", "Future");
		//map.put("count", 1);
		map.put("userDao", userDao);
		map.put("userMIMappingDao", userMIMappingDao);
		map.put("feedbackDao", feedbackDao);
		map.put("userTokenDao", userTokenDao);
		map.put("bacLogDAO", bacLogDAO);
		map.put("triviaScoreDao", triviaScoreDao);
		map.put("miService", miService);
		map.put("pushService", pushService);
		
		factory.setJobDataAsMap(map);
		factory.setGroup("myfuturegroup");
		factory.setName("myfuturejob");
		factory.setDurability(true);
		return factory;
	} 
    @Bean
	public CronTriggerFactoryBean cronTriggerFactoryBean(){
		CronTriggerFactoryBean stFactory = new CronTriggerFactoryBean();
		stFactory.setJobDetail(jobDetailFactoryBean().getObject());
		stFactory.setStartDelay(3000);
		stFactory.setName("mytrigger");
		stFactory.setGroup("mygroup");
//		stFactory.setCronExpression("0 0/2 * 1/1 * ? *");//0 0 8,12,16 * * ?
//		stFactory.setCronExpression("0 20 11 * * ?");//0 0,30,0,30,0,30,0,30,0 13,14,16,17,19,20,22,23,1 * * ?
		stFactory.setCronExpression("0 30 8,9,11,12,14,15,17,18,20 * * ?");
		return stFactory;
	}
    @Bean
	public CronTriggerFactoryBean futureCronTriggerFactoryBean(){
		CronTriggerFactoryBean stFactory = new CronTriggerFactoryBean();
		stFactory.setJobDetail(futureJobDetailFactoryBean().getObject());
		stFactory.setStartDelay(3000);
		stFactory.setName("mytrigger1");
		stFactory.setGroup("myfuturegroup");
		stFactory.setCronExpression("0 0/3 * * * ?");
		return stFactory;
	}
    @Bean
	public SchedulerFactoryBean schedulerFactoryBean() {
		//SchedulerFactoryBean scheduler = new SchedulerFactoryBean();
		SchedulerFactoryBeanWithWait scheduler=new SchedulerFactoryBeanWithWait();
		//scheduler.setTriggers(cronTriggerFactoryBean().getObject());
		scheduler.setTriggers(cronTriggerFactoryBean().getObject(),futureCronTriggerFactoryBean().getObject());
		scheduler.setWaitForJobsToCompleteOnShutdown(true);
		return scheduler;
	}
    @Autowired
    @Bean(name = "passwordEncoder")
    public PasswordEncoder getPasswordEncoder() {
    	return new BCryptPasswordEncoder();
    }
}
