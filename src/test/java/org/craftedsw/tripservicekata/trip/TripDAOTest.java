package org.craftedsw.tripservicekata.trip;

import org.craftedsw.tripservicekata.exception.CollaboratorCallException;
import org.craftedsw.tripservicekata.user.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TripDAOTest {

	@Test
	public void should_throw_exception_when_trips_are_returned() {
		Assertions.assertThrows(CollaboratorCallException.class, () -> new TripDAO().fetchTrips(new User()));

	}
}
