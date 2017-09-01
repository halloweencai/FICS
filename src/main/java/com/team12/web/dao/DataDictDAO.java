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

import com.team12.web.model.DataDict;

/**
 	* A data access object (DAO) providing persistence and search support for DataDict entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .DataDict
  * @author MyEclipse Persistence Tools 
 */
@Repository
public class DataDictDAO  {
	     private static final Logger log = LoggerFactory.getLogger(DataDictDAO.class);
		//property constants
	public static final String DATA_ITEM = "dataItem";
	public static final String DATA_TYPE = "dataType";
	public static final String DATA_STREAM = "dataStream";
	public static final String DATA_STORAGE = "dataStorage";
	public static final String PROCESSING_PROCEDURE = "processingProcedure";


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
    
    public void save(DataDict transientInstance) {
        log.debug("saving DataDict instance");
        try {
            getCurrentSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(DataDict persistentInstance) {
        log.debug("deleting DataDict instance");
        try {
            getCurrentSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public DataDict findById( Short id) {
        log.debug("getting DataDict instance with id: " + id);
        try {
            DataDict instance = (DataDict) getCurrentSession()
                    .get("com.team12.web.model.DataDict", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List<DataDict> findByExample(DataDict instance) {
        log.debug("finding DataDict instance by example");
        try {
            List<DataDict> results = (List<DataDict>) getCurrentSession() .createCriteria("com.team12.web.model.DataDict").add( create(instance) ).list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    public List findByProperty(String propertyName, Object value) {
      log.debug("finding DataDict instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from DataDict as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getCurrentSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List<DataDict> findByDataItem(Object dataItem
	) {
		return findByProperty(DATA_ITEM, dataItem
		);
	}
	
	public List<DataDict> findByDataType(Object dataType
	) {
		return findByProperty(DATA_TYPE, dataType
		);
	}
	
	public List<DataDict> findByDataStream(Object dataStream
	) {
		return findByProperty(DATA_STREAM, dataStream
		);
	}
	
	public List<DataDict> findByDataStorage(Object dataStorage
	) {
		return findByProperty(DATA_STORAGE, dataStorage
		);
	}
	
	public List<DataDict> findByProcessingProcedure(Object processingProcedure
	) {
		return findByProperty(PROCESSING_PROCEDURE, processingProcedure
		);
	}
	

	public List findAll() {
		log.debug("finding all DataDict instances");
		try {
			String queryString = "from DataDict";
	         Query queryObject = getCurrentSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public DataDict merge(DataDict detachedInstance) {
        log.debug("merging DataDict instance");
        try {
            DataDict result = (DataDict) getCurrentSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(DataDict instance) {
        log.debug("attaching dirty DataDict instance");
        try {
            getCurrentSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(DataDict instance) {
        log.debug("attaching clean DataDict instance");
        try {
                      	getCurrentSession().buildLockRequest(LockOptions.NONE).lock(instance);
          	            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static DataDictDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (DataDictDAO) ctx.getBean("DataDictDAO");
	}
}