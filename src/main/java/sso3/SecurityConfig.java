package sso3;

import java.net.URI;
import java.util.Set;

import javax.annotation.security.PermitAll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
import org.springframework.security.oauth2.client.oidc.web.logout.OidcClientInitiatedLogoutSuccessHandler;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

@Configuration
//@EnableGlobalAuthentication
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	/*@Autowired(required=true)
	@Qualifier("authenticationProvider")
	AuthenticationProvider authenticationProvider;
	*/
	@Autowired(required=true)
	CustomUserDetailsService customUserDetailsService;
	
	@Autowired
	UserEntityRepo userEntityRepo;
/*	private OAuth2UserService<OAuth2UserRequest, OAuth2User> OAuth2UserService() {
		return customUserDtls;
	}*/
	
	@Override
	public void configure(HttpSecurity httpsec) throws Exception {
		
		
//		.defaultSuccessUrl("/homepage.html", true)
//        //.failureUrl("/login.html?error=true")
//        .failureHandler(authenticationFailureHandler())
		
	httpsec
		.authorizeRequests()
		.antMatchers("/", "/home").permitAll()
		.anyRequest().authenticated()
		.and()
	.formLogin()
		.loginPage("/login").permitAll()
		.and()
		.logout()
       // .logoutSuccessUrl("/login")
        .deleteCookies("JSESSIONID")
        .invalidateHttpSession(true)
	.and()
	.oauth2Login().loginPage("/login").userInfoEndpoint()
			//		.userService(customUserDetailsService)
			.oidcUserService(oidcUserService());
		
		 ///.csrf().disable()
         
             
		/*.oauth2Login(oauthLogin -> oauthLogin.loginPage("/login").userInfoEndpoint()
		//		.userService(customUserDetailsService)
		.oidcUserService(oidcUserService()))
		.logout(logout -> logout
		        .logoutSuccessHandler(oidcLogoutSuccessHandler()));*/
		
		/*httpsec
	      .authorizeRequests(authorizeRequests -> authorizeRequests
	        .mvcMatchers("/home").permitAll()
	        .anyRequest().authenticated())
	      .oauth2Login(oauthLogin -> oauthLogin.permitAll())
	      .logout(logout -> logout
	        .logoutSuccessHandler(oidcLogoutSuccessHandler()));*/
		
		
	}
	
	
	private OAuth2UserService<OidcUserRequest, OidcUser> oidcUserService() {
		final OidcUserService delegate = new OidcUserService();

		return (userRequest) -> {
			// Delegate to the default implementation for loading a user
			OidcUser oidcUser = delegate.loadUser(userRequest);
			
			
			OAuth2AccessToken accessToken = userRequest.getAccessToken();
			//Set<GrantedAuthority> mappedAuthorities = new HashSet<>();

			// TODO
			// 1) Fetch the authority information from the protected resource using accessToken
			// 2) Map the authority information to one or more GrantedAuthority's and add it to mappedAuthorities

			// 3) Create a copy of oidcUser but use the mappedAuthorities instead
			//oidcUser = new DefaultOidcUser(mappedAuthorities, oidcUser.getIdToken(), oidcUser.getUserInfo());
			
			oidcUser.getEmail();
			CustomUser customUser= new CustomUser(oidcUser.getName(), oidcUser.getAuthorities(),oidcUser.getAttributes());
					customUser.setC_userEntity(userEntityRepo.findByEmail(oidcUser.getEmail()));

			return customUser;
		};
	}
	
	/*@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider).userDetailsService(customUserDtls);
	}*/
	
	@Autowired
	private ClientRegistrationRepository clientRegistrationRepository;
	 
	private LogoutSuccessHandler oidcLogoutSuccessHandler() {
	    OidcClientInitiatedLogoutSuccessHandler oidcLogoutSuccessHandler =
	      new OidcClientInitiatedLogoutSuccessHandler(
	        this.clientRegistrationRepository);
	 
	    oidcLogoutSuccessHandler.setPostLogoutRedirectUri(
	      URI.create("http://localhost:8081/home"));
	 
	    return oidcLogoutSuccessHandler;
	}
	
	/* @Override
	    @Bean
	    public AuthenticationManager authenticationManagerBean() throws Exception {
	        return super.authenticationManagerBean();
	    }*/
	
	@Bean
	@Override
	public UserDetailsService userDetailsService() {
		UserDetails user =
			 User.withDefaultPasswordEncoder()
				.username("user")
				.password("password")
				.roles("USER")
				.build();

		return new InMemoryUserDetailsManager(user);
	}
}
