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

import com.team12.web.model.AdvancedGroup;
import com.team12.web.model.AdvancedGroupId;

/**
 	* A data access object (DAO) providing persistence and search support for AdvancedGroup entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .AdvancedGroup
  * @author MyEclipse Persistence Tools 
 */
@Repository  
public class AdvancedGroupDAO  {
	     private static final Logger log = LoggerFactory.getLogger(AdvancedGroupDAO.class);
		//property constants
	public static final String PERSON_IN_CHARGE = "personInCharge";
	public static final String TELEPHONE_NUMBER = "telephoneNumber";
	public static final String OUTSTANDING_DEEDS = "outstandingDeeds";
	public static final String HONORARY_TITLE = "honoraryTitle";


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
    
    public void save(AdvancedGroup transientInstance) {
        log.debug("saving AdvancedGroup instance");
        try {
            getCurrentSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(AdvancedGroup persistentInstance) {
        log.debug("deleting AdvancedGroup instance");
        try {
            getCurrentSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public AdvancedGroup findById( AdvancedGroupId id) {
        log.debug("getting AdvancedGroup instance with id: " + id);
        try {
            AdvancedGroup instance = (AdvancedGroup) getCurrentSession()
                    .get("com.team12.web.model.AdvancedGroup", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List<AdvancedGroup> findByExample(AdvancedGroup instance) {
        log.debug("finding AdvancedGroup instance by example");
        try {
            List<AdvancedGroup> results = (List<AdvancedGroup>) getCurrentSession() .createCriteria("com.team12.web.model.AdvancedGroup").add( create(instance) ).list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    public List findByProperty(String propertyName, Object value) {
      log.debug("finding AdvancedGroup instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from AdvancedGroup as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getCurrentSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List<AdvancedGroup> findByPersonInCharge(Object personInCharge
	) {
		return findByProperty(PERSON_IN_CHARGE, personInCharge
		);
	}
	
	public List<AdvancedGroup> findByTelephoneNumber(Object telephoneNumber
	) {
		return findByProperty(TELEPHONE_NUMBER, telephoneNumber
		);
	}
	
	public List<AdvancedGroup> findByOutstandingDeeds(Object outstandingDeeds
	) {
		return findByProperty(OUTSTANDING_DEEDS, outstandingDeeds
		);
	}
	
	public List<AdvancedGroup> findByHonoraryTitle(Object honoraryTitle
	) {
		return findByProperty(HONORARY_TITLE, honoraryTitle
		);
	}
	

	public List<AdvancedGroup> findAll() {
		log.debug("finding all AdvancedGroup instances");
		try {
			String queryString = "from AdvancedGroup";
	         Query queryObject = getCurrentSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public AdvancedGroup merge(AdvancedGroup detachedInstance) {
        log.debug("merging AdvancedGroup instance");
        try {
            AdvancedGroup result = (AdvancedGroup) getCurrentSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(AdvancedGroup instance) {
        log.debug("attaching dirty AdvancedGroup instance");
        try {
            getCurrentSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(AdvancedGroup instance) {
        log.debug("attaching clean AdvancedGroup instance");
        try {
                      	getCurrentSession().buildLockRequest(LockOptions.NONE).lock(instance);
          	            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static AdvancedGroupDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (AdvancedGroupDAO) ctx.getBean("AdvancedGroupDAO");
	}
}