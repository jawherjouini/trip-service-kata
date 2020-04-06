package org.craftedsw.tripservicekata.user;

import org.craftedsw.tripservicekata.trip.UserBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserTest {

	private static final User RON = new User();
	private static final User HARRY = new User();

	@Test
	public void should_inform_when_users_are_not_friends() {
		User user = UserBuilder.createUser().friendsWith(RON).build();

		Assertions.assertFalse(user.isFriendsWith(HARRY));
	}
	
	@Test
	public void should_inform_when_users_are_friends() {
		User user = UserBuilder.createUser().friendsWith(RON, HARRY).build();

		Assertions.assertTrue(user.isFriendsWith(HARRY));
	}

}
