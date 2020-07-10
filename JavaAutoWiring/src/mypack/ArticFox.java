package mypack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ArticFox implements Players{

	private Guns gun;
	
	@Autowired
	public ArticFox(Guns gun){
		this.gun=gun;
	}
	
	@Override
	public void getReady() {
		// TODO Auto-generated method stub
		System.out.println("ArticFox ready" );
	gun.shoot();
	
	}
}
