package sso3;

import java.util.List;

import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class CustomUserDetailsService extends DefaultOAuth2UserService 
{

	 @Override
	    public OAuth2User loadUser(OAuth2UserRequest oAuth2UserRequest) throws OAuth2AuthenticationException {
	        OAuth2User oAuth2User = super.loadUser(oAuth2UserRequest);

	        try {
	            System.out.println("Service called");
	            
	            }
	        catch (Exception ex) {
	            // Throwing an instance of AuthenticationException will trigger the OAuth2AuthenticationFailureHandler
	            throw new InternalAuthenticationServiceException(ex.getMessage(), ex.getCause());
	        }
			//return new CustomUser("abcd", "String", false, false, false, false, AuthorityUtils.createAuthorityList("ROLE_USER"));
	        return null;
	    }


	

}
