package org.craftedsw.tripservicekata.trip;

import static org.mockito.Mockito.when;

import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class TripServiceTest {

	@Mock
	private TripDAO tripDAO;

	@InjectMocks
	private TripService tripService = new TripService();

	private static final User GUEST = null;
	private static final User A_USER = new User();
	private static final User A_REGISTERED_USER = new User();
	private static final User ANOTHER_USER = new User();
	private static final Trip EGYPT = new Trip();
	private static final Trip TUNISIA = new Trip();

	@Test
	public void should_return_exception_if_user_not_logged_in() {
		Assertions.assertThrows(UserNotLoggedInException.class, () -> tripService.getFriendTrips(A_USER, GUEST));
	}

	@Test
	public void should_return_trips_when_user_are_friends() {
		User friend = UserBuilder.createUser().friendsWith(ANOTHER_USER, A_REGISTERED_USER).withTripsTo(EGYPT, TUNISIA)
				.build();

		when(tripDAO.fetchTrips(friend)).thenReturn(friend.trips());

		Assertions.assertTrue(!tripService.getFriendTrips(friend, A_REGISTERED_USER).isEmpty());
	}

	@Test
	public void should_not_return_trips_when_user_are_not_friends() {
		User friend = UserBuilder.createUser().friendsWith(ANOTHER_USER).withTripsTo(EGYPT).build();

		Assertions.assertTrue(tripService.getFriendTrips(friend, A_REGISTERED_USER).isEmpty());
	}

}
