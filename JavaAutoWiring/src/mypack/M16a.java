package mypack;

import org.springframework.stereotype.Component;

@Component
public class M16a implements Guns{

	
	
	
	private String gun="M16a";

	
	@Override
	public void shoot() {
		// TODO Auto-generated method stub
		System.out.println("Shooting with M16a");
	}
	
	
	
	

}
