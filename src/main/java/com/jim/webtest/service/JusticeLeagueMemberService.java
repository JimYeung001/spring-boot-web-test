package com.jim.webtest.service;

import com.jim.webtest.model.JusticeLeagueMemberDetail;

/**
 * This interface defines the functionality exposed on the justice league
 * management system.
 * 
 * @author dinuka
 *
 */
public interface JusticeLeagueMemberService {

	/**
	 * This method will add a new member to the system.
	 * 
	 * @param justiceLeagueMember
	 *            an instance of JusticeLeagueMemberDTO with the member
	 *            details.
	 */
//	void addMember(final JusticeLeagueMemberDTO justiceLeagueMember);
	
	public JusticeLeagueMemberDetail findMember(String name);
}
