package org.springframework.security.oauth.examples.tonr.mvc;

import org.springframework.security.oauth.examples.tonr.AccountService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AccountController {

  private AccountService accountService;

  @RequestMapping("/account")
  public String photos(Model model) throws Exception {
    model.addAttribute("userInfo", accountService.getCurrentUserInfo());
    return "account";
  }

  public void setAccountService(AccountService accountService) {
    this.accountService = accountService;
  }

}
