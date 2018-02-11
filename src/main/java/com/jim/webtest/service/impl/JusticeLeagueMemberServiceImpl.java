package com.jim.webtest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jim.webtest.model.JusticeLeagueMemberDetail;
import com.jim.webtest.repository.JusticeLeagueRepository;
import com.jim.webtest.service.JusticeLeagueMemberService;

/**
 * This service class implements the {@link JusticeLeagueMemberService} to
 * provide the functionality required for the justice league system.
 * 
 * @author dinuka
 *
 */
@Service
public class JusticeLeagueMemberServiceImpl implements JusticeLeagueMemberService {

	@Autowired
	private JusticeLeagueRepository justiceLeagueRepo;

//	/**
//	 * {@inheritDoc}
//	 */
//	public void addMember(JusticeLeagueMemberDTO justiceLeagueMember) {
//		JusticeLeagueMemberDetail dbMember = justiceLeagueRepo.findByName(justiceLeagueMember.getName());
//
//		if (dbMember != null) {
//			throw new JusticeLeagueManagementException(ErrorMessages.MEMBER_ALREDY_EXISTS);
//		}
//		JusticeLeagueMemberDetail memberToPersist = DTOToDomainTransformer.transform(justiceLeagueMember);
//		justiceLeagueRepo.insert(memberToPersist);
//	}
	
	public JusticeLeagueMemberDetail findMember(String name) {
		
		return this.justiceLeagueRepo.findByName(name);
		
	}

}
