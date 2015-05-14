package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

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
	@GeneratedValue
	private Long id;
	@Required
	private String name;
	private String description;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Pic> pics = new ArrayList<Pic>();
	
	
	public MenuItem(String name, String desc) {
		this.name = name;
		this.description = desc;
	}
	
	public MenuItem(String name, String desc, Pic pic) {
		this.name = name;
		this.description = desc;
		this.pics.add(pic);
	}
	
	/*
	 * Getters & Setters
	 */
	
	
	/* Getters */
	
	/**
	 * Obtener el id del Item del Menu
	 * @return Long id del item
	 */
	public Long getId() {
		return this.id;
	}
	
	/**
	 * Obtener el nombre del Item del Menu
	 * @return String nombre del item
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Obtener la descripcion del Item del Menu
	 * @return String la descripcion del producto
	 */
	public String getDescription() {
		return description;
	}
	
	public List<Pic> getPics() {
		return pics;
	}
	
	/* Setters */
	
	/**
	 * Settear el nombre del Item del Menu
	 * @param name nombre para el item
	 * 
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Settear la descripcion del Item del Menu
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void addPic(Pic pic) {
		this.pics.add(pic);
		this.save();
	}
	
	public void setPics(List<Pic> pics) {
		this.pics = pics;
	}
	
	/**
	 * Finder 
	 * @return Finder que se utiliza para las busquedas en la DB
	 */
	public static Finder<Long, MenuItem> find() {
		return new Finder<Long, MenuItem>(Long.class, MenuItem.class);
	}
	
	public static void create(MenuItem item) {
		item.save();
	}
	
	public static MenuItem create(String name, String desc, Pic pic) {
		MenuItem menuItem = new MenuItem(name, desc, pic);
		menuItem.save();
		return menuItem;
	}
	
	public static MenuItem create(String name, String desc, Long pic) {
		MenuItem menuItem = new MenuItem(name, desc, Pic.find().ref(pic));
		menuItem.save();
		return menuItem;
	}
	
	@Override
	public String toString() {
		return this.id + " " + this.name;
	}
}