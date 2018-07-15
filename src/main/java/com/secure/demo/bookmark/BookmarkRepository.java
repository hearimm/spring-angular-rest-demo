package com.secure.demo.bookmark;

import com.secure.demo.account.entity.Account;
import com.secure.demo.bookmark.entity.Bookmark;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookmarkRepository extends CrudRepository<Bookmark, Long> {
  List<Bookmark> findByAccount(Account account);

  Bookmark findOneByIsbnAndAccount(String isbn, Account account);
}
