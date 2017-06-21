package com.uncc.mhealth.dao;

import java.io.IOException;
import java.util.ArrayList;
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

public class MIDAOImpl implements MIDAO{
	private SessionFactory sessionFactory;
	 
    public MIDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
 
    @Transactional
    public List<MI> list() {
        @SuppressWarnings("unchecked")
        List<MI> listMI = (List<MI>) sessionFactory.getCurrentSession()
                .createCriteria(MI.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
        System.out.println("@@ MI : "+listMI.size());
//        for(MI mi: listMI){
//        	String json = mi.getOptions_json();
//        	mi.setOptions_json("");
//        	ObjectMapper mapper = new ObjectMapper();
//        	try {
//				Set<MIOption> option = mapper.readValue(json, TypeFactory.collectionType(Set.class, MIOption.class));
//				mi.setMioptions(option);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//        }
        return listMI;
    }
    
 
    @Transactional
    public void saveOrUpdate(MI mi) {
        sessionFactory.getCurrentSession().saveOrUpdate(mi);
    }
 
    @Transactional
    public void delete(int id) {
    	MI miToDelete = new MI();
        miToDelete.setId(id);
        sessionFactory.getCurrentSession().delete(miToDelete);
    }
 
    @Transactional
    public MI get(int id) {
        String hql = "from mi where id=" + id;
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
         
        @SuppressWarnings("unchecked")
        List<MI> listMI = (List<MI>) query.list();
         
        if (listMI != null && !listMI.isEmpty()) {
            return listMI.get(0);
        }
         
        return null;
    }
}
