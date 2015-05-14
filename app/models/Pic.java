package models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

/**
 * 
 * Pic representa a una foto de un Item del Menu
 * 
 * @author martin
 *
 */

@Entity
@Table(name = "pics")
public class Pic extends Model{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne
	@JsonBackReference
	private MenuItem menuItem;
	
	private String src = null;
	
	
	public Pic(String src) {
		this.src = src;
	}
	
	/* Getters & Setters */
	
	/* Getters */
	
	/**
	 * 
	 * @return
	 */
	public Long getId() {
		return id;
	}
	
	/**
	 * 
	 * @return
	 */
	public MenuItem getMenuItem() {
		return menuItem;
	}
	
	public String getSrc() {
		return src;
	}
	
	/* Setters */
	
	public void setMenuItem(MenuItem item) {
		this.menuItem = item;
	}
	
	public void setSrc(String src) {
		this.src = src;
	}
	
	/**
	 * Finder 
	 * @return Finder que se utiliza para las busquedas en la DB
	 */
	public static Finder<Long, Pic> find() {
		return new Finder<Long, Pic>(Long.class, Pic.class);
	}
	
	public static void create(Pic pic) {
		pic.save();
	}
	
	public static Pic create(Pic pic, Long item) {
		pic.menuItem = MenuItem.find().ref(item);
		pic.save();
		return pic;
	}
}
