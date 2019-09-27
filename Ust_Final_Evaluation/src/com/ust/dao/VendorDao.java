package com.ust.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.ust.beans.Login_Details;
import com.ust.beans.VendorContact;

public class VendorDao {
	JdbcTemplate jdbcTemplate;

	public void setTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	
	//UST Login
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}


	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


	public Login_Details selectRole(String username, String password) {
		String sql = "select user_id from login where username='"
				+ username
				+ "' and password='" + password + "'";
		return jdbcTemplate.queryForObject(sql, new Object[] {},
				new BeanPropertyRowMapper<Login_Details>(Login_Details.class));
	}
	
	//get all vendor details
	
	public List<VendorContact> getVendor() {
		return jdbcTemplate
				.query("select v_Id,v_Name,v_Addr,v_Loc,v_Serv,pincode from vendor_details where isActive='No'",
						new RowMapper<VendorContact>() {
							public VendorContact mapRow(ResultSet rs, int row)
									throws SQLException {
								VendorContact vc = new VendorContact();
								vc.setV_Id(rs.getLong(1));
								vc.setV_Name(rs.getString(2));
								vc.setV_Addr(rs.getString(3));
								vc.setV_Loc(rs.getString(4));
								vc.setV_Serv(rs.getString(5));
								vc.setPincode(rs.getInt(6));
								return vc;
							}
						});
	}
	
	//get vendor by name
	
		public List<VendorContact> getVendorByName(String v_Name) {
			return jdbcTemplate
					.query("select v_Id,v_Name,v_Addr,v_Loc,v_Serv,pincode from vendor_details where isActive='No' and v_Name='"+ v_Name + "'",
							new RowMapper<VendorContact>() {
								public VendorContact mapRow(ResultSet rs, int row)
										throws SQLException {
									VendorContact vc = new VendorContact();
									vc.setV_Id(rs.getLong(1));
									vc.setV_Name(rs.getString(2));
									vc.setV_Addr(rs.getString(3));
									vc.setV_Loc(rs.getString(4));
									vc.setV_Serv(rs.getString(5));
									vc.setPincode(rs.getInt(6));
									return vc;
								}
							});
		}
	
		//get vendor details by id
				public List<VendorContact> getVendorById(long vendor_id) {
					return jdbcTemplate
							.query("select vc.v_Id,vc.v_Name,vc.v_Addr,vc.v_Loc,vc.v_Serv,vc.pincode,cd.c_Name,cd.department,cd.email,cd.phone,cd.c_Id from vendor_details vc join contact_details cd on vc.v_Id=cd.v_Id where vc.isActive='No' and vc.v_Id='"+ vendor_id + "'",
									new RowMapper<VendorContact>() {
										public VendorContact mapRow(ResultSet rs, int row)
												throws SQLException {
											VendorContact vc = new VendorContact();
											vc.setV_Id(rs.getLong(1));
											vc.setV_Name(rs.getString(2));
											vc.setV_Addr(rs.getString(3));
											vc.setV_Loc(rs.getString(4));
											vc.setV_Serv(rs.getString(5));
											vc.setPincode(rs.getInt(6));
											vc.setC_Name(rs.getString(7));
											vc.setDepartment(rs.getString(8));
											vc.setEmail(rs.getString(9));
											vc.setPhone(rs.getString(10));
											vc.setC_Id(rs.getLong(11));
											return vc;
										}
									});
				}
			
			//Add vendors
			
			public int saveVendor(VendorContact vc) {

				String sql1 = "insert into vendor_details(v_Name,v_Addr,v_Loc,v_Serv,pincode,isActive) values "
						+ "('"
						+ vc.getV_Name()
						+ "','"
						+ vc.getV_Addr()
						+ "','"
						+ vc.getV_Loc()
						+ "','"
						+ vc.getV_Serv()
						+ "','"
						+ vc.getPincode()
						+ "',"
						+ "'No'"
						+ ")";

				 jdbcTemplate.update(sql1);
				 
				 Integer maxId = getSequence();
				 String sql2="insert into contact_details(v_Id,c_Name,department,email,phone) values ("
						 + maxId
							+ ",'"
							+ vc.getC_Name()
							+ "','"
							+ vc.getDepartment()
							+ "','"
							+ vc.getEmail()
							+ "','" + vc.getPhone() + "')";
				 return jdbcTemplate.update(sql2);

						 
				 
			}
			
			// get vendor id
			private Integer getSequence() {
				Integer seq;
				String sql = "select MAX(v_Id)from vendor_details";
				seq = jdbcTemplate.queryForObject(sql, new Object[] {}, Integer.class);
				return seq;
			}
			
			//update vendor
			public int updateVendor(long v_Id, VendorContact vc) {

				String sql = "update vendor_details set v_Name='" + vc.getV_Name()
						+ "' ,v_Addr='" + vc.getV_Addr() + "' ,v_Loc='"
						+ vc.getV_Loc() + "',v_Serv='" + vc.getV_Serv() + "',pincode='" + vc.getPincode() + "',isActive=" + vc.getIsActive() + " "
						+ "where v_Id =" + v_Id;
				jdbcTemplate.update(sql);

				// Integer maxId = getSequence();

				String sql1 = "update contact_details set v_Id=" + v_Id + ",name='"
						+ vc.getC_Name() + "',dept='"
						+ vc.getDepartment() + "',email='"
						+ vc.getEmail() + "',phone='" + vc.getPhone() + "'where c_Id = " + vc.getC_Id();

				return jdbcTemplate.update(sql1);
			}
			
			// get contact details by id

			public List<VendorContact> getContactDetailsByVId(long v_Id) {
			return jdbcTemplate.query("select c_Id,c_Name,department,v_Id,email,phone from contact_details where v_Id="+v_Id+"", new RowMapper<VendorContact>() {
				public VendorContact mapRow(ResultSet rs, int row)
						throws SQLException {
					VendorContact vc = new VendorContact();
					vc.setC_Id(rs.getLong(1));
					vc.setC_Name(rs.getString(2));
					vc.setDepartment(rs.getString(3));
					vc.setV_Id(rs.getLong(4));
					vc.setEmail(rs.getString(5));
					vc.setPhone(rs.getString(6));
					return vc;
				}
			});
			}
			//to disable a vendor
			public int disableVendor(long v_Id) {

			String sql = "update vendor_details set isActive='1' where v_Id=" + v_Id
			+ "";

			return jdbcTemplate.update(sql);
			}
			
}