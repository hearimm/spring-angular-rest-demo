package com.secure.demo.account.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.secure.demo.bookmark.entity.Bookmark;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "Account")
@Scope("session")
public class Account implements UserDetails {


  /** Description of the property id. */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  /** Description of the property email. */
  @JsonSetter("username")
  @Column(unique = true)
  private String username;


  /** Description of the property password. */
  @JsonSetter("password")
  @JsonProperty(access = Access.WRITE_ONLY)
  private String password;
  /** Description of the property role , to grant authority to the user . */
  private String role;
  /** Description of the property full name. */
  private String fullName;

  @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
  private List<Bookmark> orders;


  public Account() {}

  public Account(String username, String password, String fullName) {
    this.username = username;
    this.password = password;
    this.fullName = fullName;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return Arrays.asList(new SimpleGrantedAuthority("USER"));
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public List<Bookmark> getOrders() {
    return orders;
  }

  public void setOrders(List<Bookmark> orders) {
    this.orders = orders;
  }
}
