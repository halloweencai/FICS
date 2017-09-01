package com.team12.web.dao;
// default package

import java.util.List;
import javax.annotation.Resource;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;
import com.team12.web.model.AdvancedPerson;

/**
 	* A data access object (DAO) providing persistence and search support for AdvancedPerson entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .AdvancedPerson
  * @author MyEclipse Persistence Tools 
 */
@Repository  
public class AdvancedPersonDAO  {
	     private static final Logger log = LoggerFactory.getLogger(AdvancedPersonDAO.class);
		//property constants
	public static final String NAME = "name";
	public static final String SEX = "sex";
	public static final String NATION = "nation";
	public static final String POLITICAL_STATUS = "politicalStatus";
	public static final String DEGREE_OF_EDUCATION = "degreeOfEducation";
	public static final String TELEPHONE_NUMBER = "telephoneNumber";
	public static final String WORKPLACE = "workplace";
	public static final String JOB = "job";
	public static final String HEALTH_STATUS = "healthStatus";
	public static final String CITY_OWNED_INDUTRIES = "cityOwnedIndutries";
	public static final String EMPLOYMENT_STATUS = "employmentStatus";
	public static final String FAMILY_TROUBLE = "familyTrouble";
	public static final String OUTSTANDING_DEEDS = "outstandingDeeds";
	public static final String HONORARY_TITLE = "honoraryTitle";
	public static final String TREAMENT = "treament";
	public static final String MODEL_WORKER_STATUS = "modelWorkerStatus";
	public static final String MODEL_WORKER_TITLE = "modelWorkerTitle";


	@Resource
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory){
       this.sessionFactory = sessionFactory;
    }

    private Session getCurrentSession(){
     return sessionFactory.getCurrentSession(); 
    }
	protected void initDao() {
		//do nothing
	}
    
    public void save(AdvancedPerson transientInstance) {
        log.debug("saving AdvancedPerson instance");
        try {
            getCurrentSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(AdvancedPerson persistentInstance) {
        log.debug("deleting AdvancedPerson instance");
        try {
            getCurrentSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public AdvancedPerson findById( java.lang.String id) {
        log.debug("getting AdvancedPerson instance with id: " + id);
        try {
            AdvancedPerson instance = (AdvancedPerson) getCurrentSession()
                    .get("com.team12.web.model.AdvancedPerson", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List<AdvancedPerson> findByExample(AdvancedPerson instance) {
        log.debug("finding AdvancedPerson instance by example");
        try {
            List<AdvancedPerson> results = (List<AdvancedPerson>) getCurrentSession() .createCriteria("com.team12.web.model.AdvancedPerson").add( create(instance) ).list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    public List findByProperty(String propertyName, Object value) {
      log.debug("finding AdvancedPerson instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from AdvancedPerson as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getCurrentSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List<AdvancedPerson> findByName(Object name
	) {
		return findByProperty(NAME, name
		);
	}
	
	public List<AdvancedPerson> findBySex(Object sex
	) {
		return findByProperty(SEX, sex
		);
	}
	
	public List<AdvancedPerson> findByNation(Object nation
	) {
		return findByProperty(NATION, nation
		);
	}
	
	public List<AdvancedPerson> findByPoliticalStatus(Object politicalStatus
	) {
		return findByProperty(POLITICAL_STATUS, politicalStatus
		);
	}
	
	public List<AdvancedPerson> findByDegreeOfEducation(Object degreeOfEducation
	) {
		return findByProperty(DEGREE_OF_EDUCATION, degreeOfEducation
		);
	}
	
	public List<AdvancedPerson> findByTelephoneNumber(Object telephoneNumber
	) {
		return findByProperty(TELEPHONE_NUMBER, telephoneNumber
		);
	}
	
	public List<AdvancedPerson> findByWorkplace(Object workplace
	) {
		return findByProperty(WORKPLACE, workplace
		);
	}
	
	public List<AdvancedPerson> findByJob(Object job
	) {
		return findByProperty(JOB, job
		);
	}
	
	public List<AdvancedPerson> findByHealthStatus(Object healthStatus
	) {
		return findByProperty(HEALTH_STATUS, healthStatus
		);
	}
	
	public List<AdvancedPerson> findByCityOwnedIndutries(Object cityOwnedIndutries
	) {
		return findByProperty(CITY_OWNED_INDUTRIES, cityOwnedIndutries
		);
	}
	
	public List<AdvancedPerson> findByEmploymentStatus(Object employmentStatus
	) {
		return findByProperty(EMPLOYMENT_STATUS, employmentStatus
		);
	}
	
	public List<AdvancedPerson> findByFamilyTrouble(Object familyTrouble
	) {
		return findByProperty(FAMILY_TROUBLE, familyTrouble
		);
	}
	
	public List<AdvancedPerson> findByOutstandingDeeds(Object outstandingDeeds
	) {
		return findByProperty(OUTSTANDING_DEEDS, outstandingDeeds
		);
	}
	
	public List<AdvancedPerson> findByHonoraryTitle(Object honoraryTitle
	) {
		return findByProperty(HONORARY_TITLE, honoraryTitle
		);
	}
	
	public List<AdvancedPerson> findByTreament(Object treament
	) {
		return findByProperty(TREAMENT, treament
		);
	}
	
	public List<AdvancedPerson> findByModelWorkerStatus(Object modelWorkerStatus
	) {
		return findByProperty(MODEL_WORKER_STATUS, modelWorkerStatus
		);
	}
	
	public List<AdvancedPerson> findByModelWorkerTitle(Object modelWorkerTitle
	) {
		return findByProperty(MODEL_WORKER_TITLE, modelWorkerTitle
		);
	}
	

	public List findAll() {
		log.debug("finding all AdvancedPerson instances");
		try {
			String queryString = "from AdvancedPerson";
	         Query queryObject = getCurrentSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public AdvancedPerson merge(AdvancedPerson detachedInstance) {
        log.debug("merging AdvancedPerson instance");
        try {
            AdvancedPerson result = (AdvancedPerson) getCurrentSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(AdvancedPerson instance) {
        log.debug("attaching dirty AdvancedPerson instance");
        try {
            getCurrentSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(AdvancedPerson instance) {
        log.debug("attaching clean AdvancedPerson instance");
        try {
                      	getCurrentSession().buildLockRequest(LockOptions.NONE).lock(instance);
          	            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static AdvancedPersonDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (AdvancedPersonDAO) ctx.getBean("AdvancedPersonDAO");
	}
}