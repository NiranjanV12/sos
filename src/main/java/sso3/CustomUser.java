package sso3;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.oidc.OidcIdToken;
import org.springframework.security.oauth2.core.oidc.OidcUserInfo;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.oauth2.core.user.OAuth2User;

public class CustomUser extends User implements OidcUser, Serializable {
	
/*	Name: [117116071224349836849],
	Granted Authorities: [[ROLE_USER,
	SCOPE_https://www.googleapis.com/auth/userinfo.email,
	SCOPE_https://www.googleapis.com/auth/userinfo.profile,
	SCOPE_openid]],
	User Attributes: [{at_hash=0QVNL6w_BucL-Ur8A6TpCA,
	sub=117116071224349836849,
	email_verified=true,
	iss=https://accounts.google.com,
	given_name=Niranjan,
	locale=en-GB,
	nonce=1XhXTckTcNWLnQ_4ahL0J_r50qqhdDof31pvwxcLRk0,
	picture=https://lh3.googleusercontent.com/a-/AOh14GgYf0LgEj2n06In0iqS25DcwXSinlC0JAchk0wb=s96-c,
	aud=[1014776119376-rnp4vjlh7cq9kack5ik019n3mi3f2r9h.apps.googleusercontent.com],
	azp=1014776119376-rnp4vjlh7cq9kack5ik019n3mi3f2r9h.apps.googleusercontent.com,
	name=Niranjan Vaity,
	exp=2020-07-09T07:53:39Z,
	family_name=Vaity,
	iat=2020-07-09T06:53:39Z,
	email=niranjanvaity@gmail.com}]*/
	
	private Collection<? extends GrantedAuthority> c_authorities =
			AuthorityUtils.createAuthorityList("ROLE_USER");
		private Map<String, Object> c_attributes;
		private String c_id;
		private String c_name;
		private String c_email;
		private String c_email_verified;
		private UserEntity c_userEntity;


	public CustomUser(String name2, Collection<? extends GrantedAuthority> authorities2,
			Map<String, Object> attributes2) {
		// TODO Auto-generated constructor stub
		super(name2, "placeholder", false, false, false, false, authorities2);
		this.c_attributes=attributes2;
		this.c_authorities=authorities2;
		this.c_name=attributes2.get("name")!=null?attributes2.get("name").toString():"";
		this.c_email=attributes2.get("email")!=null?attributes2.get("email").toString():"";
		this.c_email_verified=attributes2.get("email_verified")!=null?attributes2.get("email_verified").toString():"";

	}



	public UserEntity getC_userEntity() {
		return c_userEntity;
	}



	public void setC_userEntity(UserEntity c_userEntity) {
		this.c_userEntity = c_userEntity;
	}



	public String getId() {
		return c_id;
	}


	public String getEmail() {
		return c_email;
	}


	public String getEmail_verified() {
		return c_email_verified;
	}


	@Override
	public Map<String, Object> getAttributes() {
		// TODO Auto-generated method stub
		return c_attributes;
	}


	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return c_name;
	}


	@Override
	public Map<String, Object> getClaims() {
		// TODO Auto-generated method stub
		return c_attributes;
	}


	@Override
	public OidcUserInfo getUserInfo() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public OidcIdToken getIdToken() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String toString() {
		return "CustomUser [c_authorities=" + c_authorities + ", c_attributes=" + c_attributes + ", c_id=" + c_id
				+ ", c_name=" + c_name + ", c_email=" + c_email + ", c_email_verified=" + c_email_verified
				+ ", c_userEntity=" + c_userEntity + "]";
	}





		
}
