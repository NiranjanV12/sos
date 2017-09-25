package ws;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="myUser")
public class MyUser {

	 String name; 
	 String id;
	public String getName() {
		return name; 
	}
	
	@XmlElement
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	
	@XmlElement
	public void setId(String id) {
		this.id = id; 
	}
	 
	 
}
