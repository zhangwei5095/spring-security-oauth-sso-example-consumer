package org.springframework.security.oauth.examples.tonr;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.http.AccessTokenRequiredException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.web.client.RestOperations;

public class OAuthSSOFilter extends AbstractAuthenticationProcessingFilter {

  public RestOperations restTemplate;

  private String userInfoUrl;

  public void setRestTemplate(RestOperations restTemplate) {
    this.restTemplate = restTemplate;
  }

  public void setUserInfoUrl(String userInfoUrl) {
    this.userInfoUrl = userInfoUrl;
  }

  public OAuthSSOFilter(String defaultFilterProcessesUrl) {
    super(defaultFilterProcessesUrl);
  }

  @Override
  public Authentication attemptAuthentication(HttpServletRequest request,
      HttpServletResponse response) throws AuthenticationException,
      IOException, ServletException {
    UserInfo userInfo = restTemplate.getForObject(userInfoUrl, UserInfo.class);
    if (userInfo.getUserId() == null) {
      throw new BadCredentialsException("User info does not contain userId");
    }
    List<? extends GrantedAuthority> authorities = Collections
        .unmodifiableList(Arrays
            .asList(new SimpleGrantedAuthority("ROLE_USER")));
    OAuthSSOUserDetails user = new OAuthSSOUserDetails(userInfo.getUserId(),
        authorities);
    return new UsernamePasswordAuthenticationToken(user, null, authorities);
  }

  @Override
  protected void unsuccessfulAuthentication(HttpServletRequest request,
      HttpServletResponse response, AuthenticationException failed)
      throws IOException, ServletException {
    if (failed instanceof AccessTokenRequiredException) {
      // Need to force a redirect via the OAuth2 client filter, so rethrow here
      throw failed;
    } else {
      // If the exception is not a Spring Security exception this will result in
      // a default error page
      super.unsuccessfulAuthentication(request, response, failed);
    }
  }

}
