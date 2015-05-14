package models;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.avaje.ebean.Ebean;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
@Table(name = "menuItems")
public class MenuItem extends Model {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private Long id;
	@Required
	private String name;
	private String description;
	
	/*
	 * Getters & Setters
	 */
	
	public Long getId() {
		return this.id;
	}
	
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
	
	public static Finder<Long, MenuItem> find() {
		return new Finder<Long, MenuItem>(Long.class, MenuItem.class);
	}
	
	public static void create(MenuItem item) {
		item.save();
	}
	
	@Override
	public String toString() {
		return this.id + " " + this.name;
	}
}