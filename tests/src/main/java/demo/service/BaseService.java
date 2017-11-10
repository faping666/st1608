package demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.dao.BaseDao;

@Service("baseservice")
public class BaseService {

	@Autowired
	private BaseDao basedao;
	
	@Transactional
	public void add(Object obj) {
		basedao.add(obj);
	}
	@Transactional
	public void update(Object obj) {
		basedao.update(obj);
	}
	@Transactional
	public void delete(Object obj) {
		basedao.delete(obj);
	}
	@Transactional
	public Object load(Class claxx , Integer id) {
		return basedao.load(claxx, id);
	}
	@Transactional
	public List find(String hql) {
		return basedao.find(hql);
	}
	@Transactional
	public List find(String hql, Object[] params) {
		return basedao.find(hql, params);
	}
}
