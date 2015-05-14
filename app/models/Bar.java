package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import play.db.ebean.Model;
import play.db.ebean.Model.Finder;

@Entity
@Table(name = "bars")
public class Bar extends Model {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne
	private Institution institution;
	
	public Long getId() {
		return id;
	}
	
	public Institution getInstitution() {
		return institution;
	}
	
	/**
	 * Finder 
	 * @return Finder que se utiliza para las busquedas en la DB
	 */
	public static Finder<Long, Bar> find() {
		return new Finder<Long, Bar>(Long.class, Bar.class);
	}
}
