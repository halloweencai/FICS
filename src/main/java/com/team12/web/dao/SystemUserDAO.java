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

import com.team12.web.model.SystemUser;

/**
 	* A data access object (DAO) providing persistence and search support for SystemUser entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .SystemUser
  * @author MyEclipse Persistence Tools 
 */
@Repository
public class SystemUserDAO  {
	     private static final Logger log = LoggerFactory.getLogger(SystemUserDAO.class);
		//property constants
	public static final String PASSWORD = "password";
	public static final String USER_PERMISSION = "userPermission";
	public static final String USER_UNIT = "userUnit";
	public static final String EMAIL = "email";
	public static final String SEX = "sex";
	public static final String IDNUMBER = "idnumber";
	public static final String TELEPHONE_NUMBER = "telephoneNumber";


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
    
    public void save(SystemUser transientInstance) {
        log.debug("saving SystemUser instance");
        try {
            getCurrentSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(SystemUser persistentInstance) {
        log.debug("deleting SystemUser instance");
        try {
            getCurrentSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public SystemUser findById( java.lang.String id) {
        log.debug("getting SystemUser instance with id: " + id);
        try {
            SystemUser instance = (SystemUser) getCurrentSession()
                    .get("com.team12.web.model.SystemUser", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List<SystemUser> findByExample(SystemUser instance) {
        log.debug("finding SystemUser instance by example");
        try {
            List<SystemUser> results = (List<SystemUser>) getCurrentSession() .createCriteria("com.team12.web.model.SystemUser").add( create(instance) ).list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    public List findByProperty(String propertyName, Object value) {
      log.debug("finding SystemUser instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from SystemUser as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getCurrentSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List<SystemUser> findByPassword(Object password
	) {
		return findByProperty(PASSWORD, password
		);
	}
	
	public List<SystemUser> findByUserPermission(Object userPermission
	) {
		return findByProperty(USER_PERMISSION, userPermission
		);
	}
	
	public List<SystemUser> findByUserUnit(Object userUnit
	) {
		return findByProperty(USER_UNIT, userUnit
		);
	}
	
	public List<SystemUser> findByEmail(Object email
	) {
		return findByProperty(EMAIL, email
		);
	}
	
	public List<SystemUser> findBySex(Object sex
	) {
		return findByProperty(SEX, sex
		);
	}
	
	public List<SystemUser> findByIdnumber(Object idnumber
	) {
		return findByProperty(IDNUMBER, idnumber
		);
	}
	
	public List<SystemUser> findByTelephoneNumber(Object telephoneNumber
	) {
		return findByProperty(TELEPHONE_NUMBER, telephoneNumber
		);
	}
	

	public List findAll() {
		log.debug("finding all SystemUser instances");
		try {
			String queryString = "from SystemUser";
	         Query queryObject = getCurrentSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public SystemUser merge(SystemUser detachedInstance) {
        log.debug("merging SystemUser instance");
        try {
            SystemUser result = (SystemUser) getCurrentSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(SystemUser instance) {
        log.debug("attaching dirty SystemUser instance");
        try {
            getCurrentSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(SystemUser instance) {
        log.debug("attaching clean SystemUser instance");
        try {
                      	getCurrentSession().buildLockRequest(LockOptions.NONE).lock(instance);
          	            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static SystemUserDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (SystemUserDAO) ctx.getBean("SystemUserDAO");
	}
}