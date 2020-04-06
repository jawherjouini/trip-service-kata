package org.craftedsw.tripservicekata.trip;

import org.craftedsw.tripservicekata.user.User;

public class UserBuilder {
	private User[] friends = new User[] {};
	private Trip[] trips = new Trip[] {};

	public static UserBuilder createUser() {
		return new UserBuilder();
	}

	public User build() {
		User user = new User();
		addTripsToUser(user);
		addFriendsToUser(user);
		return user;
	}

	private void addTripsToUser(User user) {
		for (Trip trip : trips) {
			user.addTrip(trip);
		}
	}

	private void addFriendsToUser(User user) {
		for (User friend : friends) {
			user.addFriend(friend);
		}
	}

	public UserBuilder withTripsTo(Trip... trips) {
		this.trips = trips;
		return this;
	}

	public UserBuilder friendsWith(User... friends) {
		this.friends = friends;
		return this;
	}

}