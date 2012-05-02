package org.springframework.security.oauth.examples.tonr.mvc;

import org.springframework.security.oauth.examples.tonr.AccountService;
import org.springframework.security.oauth.examples.tonr.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AccountController {
  
  private AccountService accountService;

  public void setAccountService(AccountService accountService) {
    this.accountService = accountService;
  }

  @RequestMapping(value = "/account", method = RequestMethod.GET)
  public ModelAndView accountDetails() {
    UserInfo userInfo = accountService.getCurrentUserInfo();
    ModelAndView template = new ModelAndView("layout:account");
    template.addObject("userInfo", userInfo);
    return template;
  }

}
