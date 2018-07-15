package com.secure.demo.account;

import com.secure.demo.account.entity.Account;
import java.util.List;
import javax.security.auth.login.LoginException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("account")
public class AccountController {

  public static final Logger logger = LoggerFactory.getLogger(AccountController.class);

  @Autowired AccountService service;

  @PostMapping(value = "/register")
  public ResponseEntity<?> createUser(@RequestBody Account newUser) {
    if (service.getAccount(newUser.getUsername()) != null) {
      logger.error("username Already exist " + newUser.getUsername());
      return new ResponseEntity(
          "user with username " + newUser.getUsername() + "already exist ", HttpStatus.CONFLICT);
    }
    newUser.setRole("USER");
    logger.info(" createUser >> " + newUser.getUsername());
    return new ResponseEntity<Account>(service.save(newUser), HttpStatus.CREATED);
  }

  @RequestMapping(value = "/create", method = RequestMethod.GET)
  public Account create() {
    Account account = new Account("admin", "123", "123");
    account.setRole("USER");
    return service.save(account);
  }

  @GetMapping("/userlist")
  public List getUserList() {
    return service.getUserList();
  }

  @PostMapping("/login")
  public Account login(@RequestBody Account account) throws LoginException {
    return service.login(account.getUsername(), account.getPassword());
  }
}
