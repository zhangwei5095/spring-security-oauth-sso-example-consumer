package org.springframework.security.oauth.examples.tonr.impl;

import org.springframework.security.oauth.examples.tonr.AccountService;
import org.springframework.security.oauth.examples.tonr.UserInfo;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.web.client.RestOperations;

public class AccountServiceImpl implements AccountService {

	private String accountDetailsURL;
	
	private RestOperations oauthRestTemplate;
	
	public void setAccountDetailsURL(String accountDetailsURL) {
	  this.accountDetailsURL = accountDetailsURL;
	}
	
	public void setOAuthRestTemplate(OAuth2RestTemplate oauthRestTemplate) {
	  this.oauthRestTemplate = oauthRestTemplate;
	}

	public UserInfo getCurrentUserInfo() {
	  return oauthRestTemplate.getForObject(accountDetailsURL, UserInfo.class);
	}

}
