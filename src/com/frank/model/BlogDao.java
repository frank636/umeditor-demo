package com.frank.model;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.frank.common.dao.BaseDao;
import com.frank.model.entity.Blog;

public class BlogDao extends BaseDao {

	public void saveBlog(String title, String content, String ip) {
		Object[] params = null;
		// try {
		params = new Object[] { title, content.getBytes(), new Date(), ip };
		this
				.save(
						"insert into blog (title, content, time, ip) values(?, ?, ?, ?)",
						params);
		// } catch (UnsupportedEncodingException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
	}

	// public List<Blog> getBlog(Long id) {
	// return this.getJdbcTemplate().query("", new RowMapper<Blog>(){
	//
	// @Override
	// public Blog mapRow(ResultSet arg0, int arg1) throws SQLException {
	// return null;
	// }
	//			
	// });
	// }
	//	
	public Blog getBlog(Long id) {

		return this.getJdbcTemplate().query(
				"select id, title, time, ip, content from blog where id= ?",
				new Object[] { id }, new ResultSetExtractor<Blog>() {

					@Override
					public Blog extractData(ResultSet rs) throws SQLException,
							DataAccessException {
						Blog blog = new Blog();
						while (rs.next()) {
							blog.setId(rs.getLong("id"));
							blog.setTitle(rs.getString("title"));
							blog.setTime(rs.getDate("time"));
							blog.setIp(rs.getString("ip"));
							Blob blob = rs.getBlob("content");
							StringBuffer sBlob = new StringBuffer();
							InputStream in = blob.getBinaryStream();
							byte[] buffer = new byte[1024];
							int len = 0;
							try {
								while ((len = in.read(buffer)) != -1) {
									sBlob.append(new String(buffer, 0, len));
								}
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} finally {
								try {
									in.close();
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
							System.out.println("SQL****:" + sBlob.toString());
							blog.setContent(sBlob.toString());
							// blog.setContent(rs.getString("content").toString());
						}
						return blog;
					}
				});
	}
}
