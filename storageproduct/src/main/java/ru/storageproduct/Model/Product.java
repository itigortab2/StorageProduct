package ru.storageproduct.Model;

import java.io.Serializable;

public class Product implements Serializable {

	private Integer idProduct;
	private String title;
	private String description;
	private Double price;
	private Integer number;
	private String img;
	private Integer cat;

	public Product() {

		idProduct = 0;
		title = "";
		description = "";
		price = 0.0;
		number = 0;
		img = "";
		cat = 0;
	}

	public Product(String title, String descr, Double price, Integer number,
			String img, Integer cat) {
		super();

		this.title = title;
		this.description = descr;
		this.price = price;
		this.number = number;
		this.img = img;
		this.cat = cat;
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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public void setIdProduct(Integer id) {
		this.idProduct = id;
	}

	public Integer getIdProduct() {
		return idProduct;
	}

	public Integer getCat() {
		return cat;
	}

	public void setCat(Integer cat) {
		this.cat = cat;
	}

}
