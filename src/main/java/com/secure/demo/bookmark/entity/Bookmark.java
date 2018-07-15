package com.secure.demo.bookmark.entity;

import com.secure.demo.account.entity.Account;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.springframework.context.annotation.Scope;

@Entity
@Table(name = "Bookmark")
public class Bookmark {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String isbn;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "username")
  private Account account;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  public Account getAccount() {
    return account;
  }

  public void setAccount(Account account) {
    this.account = account;
  }
}
