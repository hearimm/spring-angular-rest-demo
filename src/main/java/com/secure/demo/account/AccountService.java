package com.secure.demo.account;

import com.secure.demo.account.entity.Account;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.security.auth.login.LoginException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AccountService implements UserDetailsService {

  @Autowired
  PasswordEncoder passwordEncoder;

  public static final Logger logger = LoggerFactory.getLogger(AccountService.class);
  @Autowired AccountRepository accountRepository;

  public Account save(Account account) {
    return accountRepository.save(account);
  }

  public Account getAccount(String username) {
    return accountRepository.findOneByUsername(username);
  }

  @PostConstruct
  public void init() {
    Account admin = accountRepository.findOneByUsername("admin");
    if (admin == null) {
      Account account = new Account();
      account.setUsername("admin");
      account.setPassword(passwordEncoder.encode("123"));
      account.setRole("ADMIN");
      Account save = this.save(account);
      logger.info(save.toString());
    }
  }

  public List getUserList() {
    List list = new ArrayList<>();
    accountRepository.findAll().iterator().forEachRemaining(list::add);
    return list;
  }

  public Account login(String username, String password) throws LoginException {
    Account account = accountRepository.findOneByUsername(username);
    if (!password.equals(account.getPassword())) {
      throw new LoginException("password not correct");
    }
    return account;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return accountRepository.findOneByUsername(username);
  }
}
