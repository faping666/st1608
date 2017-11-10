package demo.dao;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;

@Component("basedao")
public class BaseDao extends HibernateDaoSupport{

	@Resource(name="sessionFactory")
	public void setFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}
	@Transactional
	public void add(Object obj) {
		super.getHibernateTemplate().save(obj);
	}
	@Transactional
	public void update(Object obj) {
		super.getHibernateTemplate().update(obj);
	}
	@Transactional
	public void delete(Object obj) {
		super.getHibernateTemplate().delete(obj);
	}
	@Transactional
	public Object load(Class claxx , Integer id) {
		return super.getHibernateTemplate().get(claxx, id);
	}
	@Transactional
	public List find(String hql) {
		return super.getHibernateTemplate().find(hql);
	}
	@Transactional
	public List find(String hql, Object[] params) {
		return super.getHibernateTemplate().find(hql, params);
	}
}
