package org.craftedsw.tripservicekata.trip;

import java.util.ArrayList;
import java.util.List;

import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.User;
import org.springframework.beans.factory.annotation.Autowired;

public class TripService {
	@Autowired
	private TripDAO tripDAO;

	public List<Trip> getFriendTrips(User friend, User loggedInUser) throws UserNotLoggedInException {
		validateLoggedInUser(loggedInUser);

		return friend.isFriendsWith(loggedInUser) ? findUserTrips(friend) : noTripsFound();
	}

	private ArrayList<Trip> noTripsFound() {
		return new ArrayList<Trip>();
	}

	private void validateLoggedInUser(User loggedInUser) {
		if (loggedInUser == null)
			throw new UserNotLoggedInException();
	}

	private List<Trip> findUserTrips(User user) {
		return tripDAO.fetchTrips(user);
	}

}
