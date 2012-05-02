package org.springframework.security.oauth.examples.tonr.mvc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.oauth.examples.tonr.AccountService;
import org.springframework.security.oauth.examples.tonr.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AccountController {
  
  private final Logger log = LoggerFactory.getLogger(getClass());
  
  private AccountService accountService;

  @RequestMapping(value = "/account")
  public ModelAndView accountDetails() {
    UserInfo userInfo = accountService.getCurrentUserInfo();
    ModelAndView template = new ModelAndView("layout:account");
    template.addObject("userInfo", userInfo);
    log.info("Added user {}", userInfo.getUserId());
    return template;
  }

  public void setAccountService(AccountService accountService) {
    this.accountService = accountService;
  }

}
