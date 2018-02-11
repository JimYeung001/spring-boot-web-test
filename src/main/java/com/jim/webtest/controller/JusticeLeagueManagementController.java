package com.jim.webtest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jim.webtest.model.JusticeLeagueMemberDetail;
import com.jim.webtest.service.JusticeLeagueMemberService;

/**
 * This class exposes the REST API for the system.
 * 
 * @author dinuka
 *
 */
@RestController
@RequestMapping("/justiceleague")
public class JusticeLeagueManagementController {

	@Autowired
	private JusticeLeagueMemberService memberService;

	
	
	@RequestMapping(method = RequestMethod.GET, path = "/{name}", produces = {
			MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public JusticeLeagueMemberDetail findJusticeLeagueMember(@PathVariable String name) {
		JusticeLeagueMemberDetail member = null;
		try {
			member = memberService.findMember(name);
			String lname = member.getName();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return member;
	}
	
}
