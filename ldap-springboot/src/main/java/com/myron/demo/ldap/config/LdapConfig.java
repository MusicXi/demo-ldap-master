package com.myron.demo.ldap.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.ldap.repository.config.EnableLdapRepositories;
import org.springframework.ldap.core.ContextSource;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.core.support.LdapContextSource;

/**
 * @author myron
 */
@Configuration
@EnableLdapRepositories
public class LdapConfig {

	@Value("${ldap.url}")
	private String ldapUrl;
	@Value("${ldap.base}")
	private String ldapBase;
	@Value("${ldap.username}")
	private String ldapUsername;
	@Value("${ldap.password}")
	private String ldapPassword;
 
	@Bean
	ContextSource contextSource() {
		LdapContextSource ldapContextSource = new LdapContextSource();
		ldapContextSource.setUrl(ldapUrl);
		ldapContextSource.setBase(ldapBase);
		ldapContextSource.setUserDn(ldapUsername);
		ldapContextSource.setPassword(ldapPassword);
 		ldapContextSource.setReferral("follow");
		return ldapContextSource;
	}
 
	@Bean
	LdapTemplate ldapTemplate(ContextSource contextSource) {
		return new LdapTemplate(contextSource);
	}
}
