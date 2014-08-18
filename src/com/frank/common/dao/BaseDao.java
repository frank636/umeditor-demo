package com.frank.common.dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class BaseDao extends JdbcDaoSupport {
	
	/**
	 * 插入数据
	 * <P>Title: save</p>
	 * @param insertSql 插入数据sql
	 * @param params 参数
	 * @return
	 */
	public int save(String insertSql, Object[] params) {
		int num = 0;
		num = this.getJdbcTemplate().update(insertSql, params);
		return num;
	}
	
	/**
	 * 更改数据
	 * <P>Title: update</p>
	 * @param updateSql 更新数据sql
	 * @param params 参数
	 * @return
	 */
	public int update(String updateSql, Object[] params) {
		int num = 0;
		num = this.getJdbcTemplate().update(updateSql, params);
		return num;
	}
	
	/**
	 * 删除数据
	 * <P>Title: delete</p>
	 * @param deleteSql 删除数据sql
	 * @param params 参数
	 * @return
	 */
	public int delete(String deleteSql, Object[] params) {
		int num = 0;
		num = this.getJdbcTemplate().update(deleteSql, params);
		return num;
	}
		
}
