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
import org.springframework.transaction.annotation.Transactional;

import com.team12.web.model.CountAdvancedPerson;

/**
 	* A data access object (DAO) providing persistence and search support for CountAdvancedPerson entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .CountAdvancedPerson
  * @author MyEclipse Persistence Tools 
 */
@Repository
public class CountAdvancedPersonDAO  {
	     private static final Logger log = LoggerFactory.getLogger(CountAdvancedPersonDAO.class);
		//property constants
	public static final String ALL_PERSON_NUMBER = "allPersonNumber";
	public static final String DEAD_ADVANCED_PERSON_NUM = "deadAdvancedPersonNum";
	public static final String RETIRE_ADVANCED_PERSON_NUM = "retireAdvancedPersonNum";
	public static final String WORKING_ADVANCED_PERSON_NUM = "workingAdvancedPersonNum";
	public static final String COMPANY_LEADER_NUM = "companyLeaderNum";
	public static final String INSTITUTION_LEADER_NUM = "institutionLeaderNum";
	public static final String COMPANY_MODEL_WORKER_NUM = "companyModelWorkerNum";
	public static final String INSTITUTION_MODEL_WORKER_NUM = "institutionModelWorkerNum";
	public static final String STAFF_MODEL_WORKER_NUM = "staffModelWorkerNum";
	public static final String AGRICULTURE_MODEL_WORKER_NUM = "agricultureModelWorkerNum";
	public static final String PRIVATE_COMPANY_MODEL_WORKER_NUM = "privateCompanyModelWorkerNum";


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
    
    public void save(CountAdvancedPerson transientInstance) {
        log.debug("saving CountAdvancedPerson instance");
        try {
            getCurrentSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(CountAdvancedPerson persistentInstance) {
        log.debug("deleting CountAdvancedPerson instance");
        try {
            getCurrentSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public CountAdvancedPerson findById( java.util.Date id) {
        log.debug("getting CountAdvancedPerson instance with id: " + id);
        try {
            CountAdvancedPerson instance = (CountAdvancedPerson) getCurrentSession()
                    .get("com.team12.web.model.CountAdvancedPerson", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List<CountAdvancedPerson> findByExample(CountAdvancedPerson instance) {
        log.debug("finding CountAdvancedPerson instance by example");
        try {
            List<CountAdvancedPerson> results = (List<CountAdvancedPerson>) getCurrentSession() .createCriteria("com.team12.web.model.CountAdvancedPerson").add( create(instance) ).list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    public List findByProperty(String propertyName, Object value) {
      log.debug("finding CountAdvancedPerson instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from CountAdvancedPerson as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getCurrentSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List<CountAdvancedPerson> findByAllPersonNumber(Object allPersonNumber
	) {
		return findByProperty(ALL_PERSON_NUMBER, allPersonNumber
		);
	}
	
	public List<CountAdvancedPerson> findByDeadAdvancedPersonNum(Object deadAdvancedPersonNum
	) {
		return findByProperty(DEAD_ADVANCED_PERSON_NUM, deadAdvancedPersonNum
		);
	}
	
	public List<CountAdvancedPerson> findByRetireAdvancedPersonNum(Object retireAdvancedPersonNum
	) {
		return findByProperty(RETIRE_ADVANCED_PERSON_NUM, retireAdvancedPersonNum
		);
	}
	
	public List<CountAdvancedPerson> findByWorkingAdvancedPersonNum(Object workingAdvancedPersonNum
	) {
		return findByProperty(WORKING_ADVANCED_PERSON_NUM, workingAdvancedPersonNum
		);
	}
	
	public List<CountAdvancedPerson> findByCompanyLeaderNum(Object companyLeaderNum
	) {
		return findByProperty(COMPANY_LEADER_NUM, companyLeaderNum
		);
	}
	
	public List<CountAdvancedPerson> findByInstitutionLeaderNum(Object institutionLeaderNum
	) {
		return findByProperty(INSTITUTION_LEADER_NUM, institutionLeaderNum
		);
	}
	
	public List<CountAdvancedPerson> findByCompanyModelWorkerNum(Object companyModelWorkerNum
	) {
		return findByProperty(COMPANY_MODEL_WORKER_NUM, companyModelWorkerNum
		);
	}
	
	public List<CountAdvancedPerson> findByInstitutionModelWorkerNum(Object institutionModelWorkerNum
	) {
		return findByProperty(INSTITUTION_MODEL_WORKER_NUM, institutionModelWorkerNum
		);
	}
	
	public List<CountAdvancedPerson> findByStaffModelWorkerNum(Object staffModelWorkerNum
	) {
		return findByProperty(STAFF_MODEL_WORKER_NUM, staffModelWorkerNum
		);
	}
	
	public List<CountAdvancedPerson> findByAgricultureModelWorkerNum(Object agricultureModelWorkerNum
	) {
		return findByProperty(AGRICULTURE_MODEL_WORKER_NUM, agricultureModelWorkerNum
		);
	}
	
	public List<CountAdvancedPerson> findByPrivateCompanyModelWorkerNum(Object privateCompanyModelWorkerNum
	) {
		return findByProperty(PRIVATE_COMPANY_MODEL_WORKER_NUM, privateCompanyModelWorkerNum
		);
	}
	

	public List findAll() {
		log.debug("finding all CountAdvancedPerson instances");
		try {
			String queryString = "from CountAdvancedPerson";
	         Query queryObject = getCurrentSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public CountAdvancedPerson merge(CountAdvancedPerson detachedInstance) {
        log.debug("merging CountAdvancedPerson instance");
        try {
            CountAdvancedPerson result = (CountAdvancedPerson) getCurrentSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(CountAdvancedPerson instance) {
        log.debug("attaching dirty CountAdvancedPerson instance");
        try {
            getCurrentSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(CountAdvancedPerson instance) {
        log.debug("attaching clean CountAdvancedPerson instance");
        try {
                      	getCurrentSession().buildLockRequest(LockOptions.NONE).lock(instance);
          	            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static CountAdvancedPersonDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (CountAdvancedPersonDAO) ctx.getBean("CountAdvancedPersonDAO");
	}
}