package com.secure.demo.bookmark;

import com.secure.demo.account.AccountService;
import com.secure.demo.account.entity.Account;
import com.secure.demo.bookmark.entity.Bookmark;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookmarkService {

  @Autowired AccountService accountService;
  @Autowired BookmarkRepository bookmarkRepository;

  public Bookmark save(Bookmark bookmark) {
    return bookmarkRepository.save(bookmark);
  }

  public List<Bookmark> getBookmarkList(String username) {
    Account account = accountService.getAccount(username);
    return bookmarkRepository.findByAccount(account);
  }

  @PostConstruct
  public void init() {
    List<Bookmark> list = this.getBookmarkList("admin");
    if (list == null) {
      Account admin = accountService.getAccount("admin");
      Bookmark b1 = new Bookmark();
      b1.setIsbn("1");
      b1.setAccount(admin);
      this.save(b1);

      Bookmark b2 = new Bookmark();
      b2.setIsbn("12");
      b2.setAccount(admin);
      this.save(b2);
    }
  }

  public Bookmark getBookmarkByIsbn(String isbn, String username) {
    Account account = accountService.getAccount(username);
    return bookmarkRepository.findOneByIsbnAndAccount(isbn, account);
  }
}
