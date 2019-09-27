package com.ust.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ust.beans.Login_Details;
import com.ust.beans.VendorContact;
import com.ust.dao.VendorDao;

@RestController
public class VendorController {

	@Autowired	
VendorDao vdao;


//verify login
	@RequestMapping(value = "/api/user/{username}/{password}", method = RequestMethod.GET)
	@ResponseBody
	public Login_Details selectLogin_Details(@PathVariable("username") String username,
			@PathVariable("password") String password) {
		return vdao.selectRole(username,password);
	}
	
	//view vendors
	
		@RequestMapping(value = "/api/vendor/{v_Name}", method = RequestMethod.GET)
		@ResponseBody
		public List getVendor(Model m, @PathVariable("v_Name") String v_Name) {
			List list;
			if (v_Name.equals("null")) {
				list = vdao.getVendor();
			} else {
				list = vdao.getVendorByName(v_Name);
			}

			return list;
		}
		
		// view vendor list by id
		@RequestMapping(value = "/api/vendors/{v_Id}", method = RequestMethod.GET)
		@ResponseBody
		public List getvendors(Model m, @PathVariable("v_Id") long v_Id) {
			List list;
			list= vdao.getVendorById(v_Id);
			return list;
		}

		// Add Vendor
		@ResponseBody
		@RequestMapping(value = "/api/insertvendor", method = RequestMethod.POST)
		public void insertVendor(@RequestBody VendorContact vc) throws ParseException {
			vdao.saveVendor(vc);
		}
		
		// update Vendor
		@ResponseBody
		@RequestMapping(value = "/api/updatevendor", method = RequestMethod.PUT)
		public void updateVendor(@RequestBody VendorContact vc) throws ParseException {
			long v_Id = vc.getV_Id();
			long c_Id = vc.getC_Id();
			vdao.updateVendor(v_Id ,vc);
		}
		
		// to disable a vendor

		@RequestMapping(value = "/api/disablevendor/{v_Id}", method = RequestMethod.PUT)
		@ResponseBody
		public void disableStaff(@PathVariable("vId") long v_Id) {
		vdao.disableVendor(v_Id);
		}
		
		// view contact details by vendor id

		@RequestMapping(value = "/api/contactDetails/{v_Id}", method = RequestMethod.GET)
		@ResponseBody
		public List getContactDetails(Model m,@PathVariable("v_Id") long v_Id) {
			List list;
		list=vdao.getContactDetailsByVId(v_Id);
		return list;

		}

}