package com.secure.demo.account;

import com.secure.demo.account.entity.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {

  Account findOneByUsername(String username);
}
