package org.springframework.security.oauth.examples.tonr;


public interface AccountService {

	/**
	 * Get the user details the current user from the OAuth server.
	 * 
	 * @return The user details the current user from the OAuth server.
	 */
	UserInfo getCurrentUserInfo();

}
