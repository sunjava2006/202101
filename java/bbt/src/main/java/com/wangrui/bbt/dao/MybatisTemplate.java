package com.wangrui.bbt.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

public class MybatisTemplate {

	public   int update(String statement, Object arg) {
		int count = -1;
		SqlSession session = null;
		try {
			session  = SessionUtil.getSession();
			count = session.update(statement, arg);
			session.commit();
		} catch (Exception e) {
			session.rollback();
			throw e;
		} finally {
			if(null != session) {
				session.close();
			}
		}
		return count;
	}
	
	public   int update(String statement) {
		int count = -1;
		SqlSession session = null;
		try {
			session  = SessionUtil.getSession();
			count = session.update(statement);
			session.commit();
		} catch (Exception e) {
			session.rollback();
			throw e;
		} finally {
			if(null != session) {
				session.close();
			}
		}
		return count;
	}
	
	public   int insert(String statement, Object arg) {
		int count = -1;
		SqlSession session = null;
		try {
			session  = SessionUtil.getSession();
			count = session.insert(statement, arg);
			session.commit();
		} catch (Exception e) {
			session.rollback();
			throw e;
		} finally {
			if(null != session) {
				session.close();
			}
		}
		return count;
	}
	
	public   int insert(String statement) {
		int count = -1;
		SqlSession session = null;
		try {
			session  = SessionUtil.getSession();
			count = session.insert(statement);
			session.commit();
		} catch (Exception e) {
			session.rollback();
			throw e;
		} finally {
			if(null != session) {
				session.close();
			}
		}
		return count;
	}
	
	public   int delete(String statement, Object arg) {
		int count = -1;
		SqlSession session = null;
		try {
			session  = SessionUtil.getSession();
			count = session.delete(statement, arg);
			session.commit();
		} catch (Exception e) {
			session.rollback();
			throw e;
		} finally {
			if(null != session) {
				session.close();
			}
		}
		return count;
	}
	
	public   int delete(String statement) {
		int count = -1;
		SqlSession session = null;
		try {
			session  = SessionUtil.getSession();
			count = session.delete(statement);
			session.commit();
		} catch (Exception e) {
			session.rollback();
			throw e;
		} finally {
			if(null != session) {
				session.close();
			}
		}
		return count;
	}
	
	public   <T>T selectOne(String statement, Object arg) {
		T t = null;
		SqlSession session = null;
		try {
			session  = SessionUtil.getSession();
			t = session.selectOne(statement, arg);
			
			session.commit();
		} catch (Exception e) {
			session.rollback();
			throw e;
		} finally {
			if(null != session) {
				session.close();
			}
		}
		return t;
	}
	public   <T>T selectOne(String statement) {
		T t = null;
		SqlSession session = null;
		try {
			session  = SessionUtil.getSession();
			t = session.selectOne(statement);
			session.commit();
		} catch (Exception e) {
			session.rollback();
			throw e;
		} finally {
			if(null != session) {
				session.close();
			}
		}
		return t;
	}
	
	
	public  <T> List<T> selectList(String statement, Object arg) {
		 List<T> list = null;
		SqlSession session = null;
		try {
			session  = SessionUtil.getSession();
			list = session.selectList(statement, arg);
			session.commit();
		} catch (Exception e) {
			session.rollback();
			throw e;
		} finally {
			if(null != session) {
				session.close();
			}
		}
		return list;
	}
	
	public  <T> List<T> selectList(String statement) {
		 List<T> list = null;
		SqlSession session = null;
		try {
			session  = SessionUtil.getSession();
			list = session.selectList(statement);
			session.commit();
		} catch (Exception e) {
			session.rollback();
			throw e;
		} finally {
			if(null != session) {
				session.close();
			}
		}
		return list;
	}
	
}
