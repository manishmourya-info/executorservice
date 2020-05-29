package com.idm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.idm.dao.ILeadDAO;
import com.idm.model.Lead;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RequestMapping("/leads")
@Api(value="Leads", description="Lead API Call")
@ApiResponses(value = {
        @ApiResponse(code = 200, message = "Success"),
        @ApiResponse(code = 401, message = "You are not authorized"),
        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
}
)

@RestController
public class LeadController {
	
		@Autowired
		private ILeadDAO leadDAO; 
		
		@GetMapping(path="/", produces = "application/json")
		public String root() {
			return "index";
		}
		
		@GetMapping(path="/home", produces = "application/json")
		public String home() {
			return "home";
		}
		
		@GetMapping(path="/getAllLead")
		public List<Lead> getAllLead() {
			return leadDAO.findAll();
		}
}
