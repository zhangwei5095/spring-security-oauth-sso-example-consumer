package org.springframework.security.oauth.examples.tonr.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.oauth.examples.tonr.AccountService;
import org.springframework.security.oauth.examples.tonr.UserInfo;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.web.client.RestOperations;

public class AccountServiceImpl implements AccountService {
  
  private final Logger log = LoggerFactory.getLogger(getClass());

	private String accountDetailsURL;
	private RestOperations oauthRestTemplate;

	public UserInfo getCurrentUserInfo() {
	  UserInfo userInfo = new UserInfo();
	  userInfo.setUserId("testuser");
	  log.info("returning user");
	  return userInfo;
	  //return oauthRestTemplate.getForObject(accountDetailsURL, UserInfo.class);
	}

	public void setAccountDetailsURL(String accountDetailsURL) {
		this.accountDetailsURL = accountDetailsURL;
	}
	
	public void setOAuthRestTemplate(OAuth2RestTemplate oauthRestTemplate) {
		this.oauthRestTemplate = oauthRestTemplate;
	}

}
