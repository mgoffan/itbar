package models;

import java.util.Set;

@MongoEntity("menuItems")
public class MenuItem extends MongoModel {

	private String _id;
	private String name;
	private Set<String> pic;
	private String description;
	
	public String getId() {
		return this._id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getPic() {
		
	}
	
}