package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import play.db.ebean.Model;

@Entity
@Table(name = "institutions")
public class Institution extends Model {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private String id;
	
	private String name;
	
	@OneToMany
	private List<Bar> bars;

	public Institution(String name, Bar bar) {
		this.name = name;
		this.bars.add(bar);
	}
	
	public Institution(String name, Long bar) {
		this.name = name;
		this.bars.add(Bar.find().byId(bar));
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * 
	 * @return bars
	 */
	public List<Bar> getBars() {
		return bars;
	}
	
	/**
	 * 
	 * @param bars
	 */
	public void setBars(List<Bar> bars) {
		this.bars = bars;
	}
	
	/**
	 * Finder 
	 * @return Finder que se utiliza para las busquedas en la DB
	 */
	public static Finder<Long, Institution> find() {
		return new Finder<Long, Institution>(Long.class, Institution.class);
	}
}
