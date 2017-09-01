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

import com.team12.web.model.CountAdvancedGroup;

/**
 	* A data access object (DAO) providing persistence and search support for CountAdvancedGroup entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .CountAdvancedGroup
  * @author MyEclipse Persistence Tools 
 */
@Repository   
public class CountAdvancedGroupDAO  {
	     private static final Logger log = LoggerFactory.getLogger(CountAdvancedGroupDAO.class);
		//property constants
	public static final String COUNTRY_ADVANCED_PRODUCTION_COMPANY_NUMBER = "countryAdvancedProductionCompanyNumber";
	public static final String COUNTRY_MAY_DAY_AWARD_COMPANY_NUMBER = "countryMayDayAwardCompanyNumber";
	public static final String PROVINCE_ADVANCED_PRODUCTION_COMPANY_NUMBER = "provinceAdvancedProductionCompanyNumber";
	public static final String SI_CHUAN_MAY_DAY_COMPANY_NUMBER = "siChuanMayDayCompanyNumber";
	public static final String COUNTRY_PIONEER_WORKER_NUMBER = "countryPioneerWorkerNumber";
	public static final String SI_CHUAN_PIONEER_WORKER_NUMBER = "siChuanPioneerWorkerNumber";
	public static final String CITY_PIONEER_WORKER_NUMBER = "cityPioneerWorkerNumber";
	public static final String COMPANY_PIONEER_WORKER_NUMBER = "companyPioneerWorkerNumber";


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
    
    public void save(CountAdvancedGroup transientInstance) {
        log.debug("saving CountAdvancedGroup instance");
        try {
            getCurrentSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(CountAdvancedGroup persistentInstance) {
        log.debug("deleting CountAdvancedGroup instance");
        try {
            getCurrentSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public CountAdvancedGroup findById( java.util.Date id) {
        log.debug("getting CountAdvancedGroup instance with id: " + id);
        try {
            CountAdvancedGroup instance = (CountAdvancedGroup) getCurrentSession()
                    .get("com.team12.web.model.CountAdvancedGroup", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List<CountAdvancedGroup> findByExample(CountAdvancedGroup instance) {
        log.debug("finding CountAdvancedGroup instance by example");
        try {
            List<CountAdvancedGroup> results = (List<CountAdvancedGroup>) getCurrentSession() .createCriteria("com.team12.web.model.CountAdvancedGroup").add( create(instance) ).list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    public List findByProperty(String propertyName, Object value) {
      log.debug("finding CountAdvancedGroup instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from CountAdvancedGroup as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getCurrentSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List<CountAdvancedGroup> findByCountryAdvancedProductionCompanyNumber(Object countryAdvancedProductionCompanyNumber
	) {
		return findByProperty(COUNTRY_ADVANCED_PRODUCTION_COMPANY_NUMBER, countryAdvancedProductionCompanyNumber
		);
	}
	
	public List<CountAdvancedGroup> findByCountryMayDayAwardCompanyNumber(Object countryMayDayAwardCompanyNumber
	) {
		return findByProperty(COUNTRY_MAY_DAY_AWARD_COMPANY_NUMBER, countryMayDayAwardCompanyNumber
		);
	}
	
	public List<CountAdvancedGroup> findByProvinceAdvancedProductionCompanyNumber(Object provinceAdvancedProductionCompanyNumber
	) {
		return findByProperty(PROVINCE_ADVANCED_PRODUCTION_COMPANY_NUMBER, provinceAdvancedProductionCompanyNumber
		);
	}
	
	public List<CountAdvancedGroup> findBySiChuanMayDayCompanyNumber(Object siChuanMayDayCompanyNumber
	) {
		return findByProperty(SI_CHUAN_MAY_DAY_COMPANY_NUMBER, siChuanMayDayCompanyNumber
		);
	}
	
	public List<CountAdvancedGroup> findByCountryPioneerWorkerNumber(Object countryPioneerWorkerNumber
	) {
		return findByProperty(COUNTRY_PIONEER_WORKER_NUMBER, countryPioneerWorkerNumber
		);
	}
	
	public List<CountAdvancedGroup> findBySiChuanPioneerWorkerNumber(Object siChuanPioneerWorkerNumber
	) {
		return findByProperty(SI_CHUAN_PIONEER_WORKER_NUMBER, siChuanPioneerWorkerNumber
		);
	}
	
	public List<CountAdvancedGroup> findByCityPioneerWorkerNumber(Object cityPioneerWorkerNumber
	) {
		return findByProperty(CITY_PIONEER_WORKER_NUMBER, cityPioneerWorkerNumber
		);
	}
	
	public List<CountAdvancedGroup> findByCompanyPioneerWorkerNumber(Object companyPioneerWorkerNumber
	) {
		return findByProperty(COMPANY_PIONEER_WORKER_NUMBER, companyPioneerWorkerNumber
		);
	}
	

	public List findAll() {
		log.debug("finding all CountAdvancedGroup instances");
		try {
			String queryString = "from CountAdvancedGroup";
	         Query queryObject = getCurrentSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public CountAdvancedGroup merge(CountAdvancedGroup detachedInstance) {
        log.debug("merging CountAdvancedGroup instance");
        try {
            CountAdvancedGroup result = (CountAdvancedGroup) getCurrentSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(CountAdvancedGroup instance) {
        log.debug("attaching dirty CountAdvancedGroup instance");
        try {
            getCurrentSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(CountAdvancedGroup instance) {
        log.debug("attaching clean CountAdvancedGroup instance");
        try {
                      	getCurrentSession().buildLockRequest(LockOptions.NONE).lock(instance);
          	            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static CountAdvancedGroupDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (CountAdvancedGroupDAO) ctx.getBean("CountAdvancedGroupDAO");
	}
}