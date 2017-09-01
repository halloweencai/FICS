package com.team12.web.dao;

import java.util.Date;
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

import com.team12.web.model.Honor;

/**
 * A data access object (DAO) providing persistence and search support for Honor
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.team12.web.dao.HonorService
 * @author MyEclipse Persistence Tools
 */
@Repository
public class HonorDAO {
	private static final Logger log = LoggerFactory.getLogger(HonorDAO.class);
	// property constants
	public static final String FILE_NAME = "fileName";
	public static final String HONOR_CONTENT = "honorContent";
	public static final String GRANT_UNIT = "grantUnit";
	public static final String DISPATCH_UNIT = "dispatchUnit";
	public static final String RECORD = "record";
	public static final String HONOR_TITLE_TREATMENT = "honorTitleTreatment";
	public static final String OUTSTANDING_DEEDS = "outstandingDeeds";
	public static final String BASIS_OF_ASSERTING = "basisOfAsserting";
	public static final String ADVICE = "advice";

	@Resource
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	protected void initDao() {
		// do nothing
	}

	public void save(Honor transientInstance) {
		log.debug("saving Honor instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Honor persistentInstance) {
		log.debug("deleting Honor instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Honor findById(java.lang.Integer id) {
		log.debug("getting Honor instance with id: " + id);
		try {
			Honor instance = (Honor) getCurrentSession().get("com.team12.web.dao.Honor", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Honor> findByExample(Honor instance) {
		log.debug("finding Honor instance by example");
		try {
			List<Honor> results = (List<Honor>) getCurrentSession().createCriteria("com.team12.web.dao.Honor")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Honor instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Honor as model where model." + propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Honor> findByFileName(Object fileName) {
		return findByProperty(FILE_NAME, fileName);
	}

	public List<Honor> findByHonorContent(Object honorContent) {
		return findByProperty(HONOR_CONTENT, honorContent);
	}

	public List<Honor> findByGrantUnit(Object grantUnit) {
		return findByProperty(GRANT_UNIT, grantUnit);
	}

	public List<Honor> findByDispatchUnit(Object dispatchUnit) {
		return findByProperty(DISPATCH_UNIT, dispatchUnit);
	}

	public List<Honor> findByRecord(Object record) {
		return findByProperty(RECORD, record);
	}

	public List<Honor> findByHonorTitleTreatment(Object honorTitleTreatment) {
		return findByProperty(HONOR_TITLE_TREATMENT, honorTitleTreatment);
	}

	public List<Honor> findByOutstandingDeeds(Object outstandingDeeds) {
		return findByProperty(OUTSTANDING_DEEDS, outstandingDeeds);
	}

	public List<Honor> findByBasisOfAsserting(Object basisOfAsserting) {
		return findByProperty(BASIS_OF_ASSERTING, basisOfAsserting);
	}

	public List<Honor> findByAdvice(Object advice) {
		return findByProperty(ADVICE, advice);
	}

	public List findAll() {
		log.debug("finding all Honor instances");
		try {
			String queryString = "from Honor";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Honor merge(Honor detachedInstance) {
		log.debug("merging Honor instance");
		try {
			Honor result = (Honor) getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Honor instance) {
		log.debug("attaching dirty Honor instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Honor instance) {
		log.debug("attaching clean Honor instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static HonorDAO getFromApplicationContext(ApplicationContext ctx) {
		return (HonorDAO) ctx.getBean("HonorDAO");
	}
}