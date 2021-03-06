package com.jim.webtest.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.jim.webtest.model.JusticeLeagueMemberDetail;

public interface JusticeLeagueRepository extends MongoRepository<JusticeLeagueMemberDetail, String> {

	/**
	 * This method will retrieve the justice league member details pertaining to
	 * the name passed in.
	 * 
	 * @param superHeroName
	 *            the name of the justice league member to search and retrieve.
	 * @return an instance of {@link JusticeLeagueMemberDetail} with the member
	 *         details.
	 */
//	@Query("{ 'name' : {$regex: ?0, $options: 'i' }}")
	JusticeLeagueMemberDetail findByName(String name);
}
