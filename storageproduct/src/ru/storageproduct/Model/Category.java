package ru.storageproduct.Model;

import java.io.Serializable;

/* Стандартный javabean объект */

public class Category implements Serializable {

	private Integer idCat;
	private String title;
	private String description;

	public Category() {

		title = "";
		description = "";
	}

	public Category(String title, String descr) {
		super();

		this.title = title;
		this.description = descr;

	}

	public Integer getIdCat() {
		return idCat;
	}

	public void setIdCat(Integer idCat) {
		this.idCat = idCat;
	}

	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String descr) {
		this.description = descr;
	}

}
