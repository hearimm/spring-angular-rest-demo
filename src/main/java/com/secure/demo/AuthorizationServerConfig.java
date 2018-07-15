package com.secure.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

  @Autowired TokenStore tokenStore;
  @Autowired AuthenticationManager authenticationManager;
  @Autowired PasswordEncoder passwordEncoder;

  @Override
  public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
    clients
        .inMemory()
        .withClient("foo")
        .secret(passwordEncoder.encode("bar"))
        .authorizedGrantTypes(
            "password", "authorization_code", "refresh_token", "client_credentials", "implicit")
        .scopes("read", "write", "trust")
        .accessTokenValiditySeconds(1 * 60 * 60)
        .refreshTokenValiditySeconds(6 * 60 * 60);
  }

  @Override
  public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
    endpoints.tokenStore(tokenStore).authenticationManager(authenticationManager);
  }

  //  @Bean
  //  public JwtAccessTokenConverter jwtAccessTokenConverter() {
  //    JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
  //    KeyPair keyPair =
  //        new KeyStoreKeyFactory(new ClassPathResource("server.jks"), "qweqwe".toCharArray())
  //            .getKeyPair("hello", "zaqwsx".toCharArray());
  //    converter.setKeyPair(keyPair);
  //    return converter;
  //  }
}
