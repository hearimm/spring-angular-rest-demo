package com.secure.demo.bookmark;

import com.secure.demo.account.entity.Account;
import com.secure.demo.bookmark.entity.Bookmark;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("bookmark")
public class BookmarkController {

  public static final Logger logger = LoggerFactory.getLogger(BookmarkController.class);
  @Autowired BookmarkService service;

  @PostMapping(value = "/register")
  public ResponseEntity<?> create(@RequestBody Bookmark bookmark) {
    if (isExists(bookmark)) {
      logger.error("isbn Already exist " + bookmark.getIsbn());
      return new ResponseEntity(
          "user with username " + bookmark.getIsbn() + "already exist ", HttpStatus.CONFLICT);
    }
    return new ResponseEntity<Bookmark>(service.save(bookmark), HttpStatus.CREATED);
  }

  private boolean isExists(Bookmark bookmark) {
    return service.getBookmarkByIsbn(bookmark.getIsbn(), bookmark.getAccount().getUsername())
        != null;
  }

  @GetMapping("/list")
  public List getBookMarkList(@RequestParam("username") String username) {
    return service.getBookmarkList(username);
  }
}
