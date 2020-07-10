package sso3;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserEntity {

	 @Id
	  @GeneratedValue(strategy=GenerationType.AUTO)
	  private Long id;
	 
	 String email;
	 String res_address;

	 
	 
	 
	public String getUe_email() {
		return email;
	}

	public void setUe_email(String ue_email) {
		this.email = ue_email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRes_address() {
		return res_address;
	}

	public void setRes_address(String res_address) {
		this.res_address = res_address;
	}

	@Override
	public String toString() {
		return "UserEntity [id=" + id + ", email=" + email + ", res_address=" + res_address + "]";
	}
	 
	 
	
}
