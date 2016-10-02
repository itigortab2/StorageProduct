package ru.storageproduct.Model;

public class Product {

	private String title;
	private String description;
	private Double price;
	private Integer number;
	private String img;
	private Category cat;
	
	public Product() { }
	
	public void  initProduct(String title, String descr, 
			Double price, Integer number, String img, Category cat )
	{
		this.title = title;
		this.description = descr;
		this.price = price;
		this.number = number;
		this.img = img;
		
	}
	
	
	public String getTitle()
	{
		return title;
	}
	
	public void setTitle(String title)
	{
		this.title = title;
	}
	
	public String getDescription()
	{
		return description;
	}
	
	public void setDescription(String descr)
	{
		this.description = descr;
	}
	
	public Double getPrice()
	{
		return price;
	}
	
	public void setPrice(Double price)
	{
		this.price = price;
	}
	
	public Integer getNumber()
	{
		return number;
	}
	
	public void setNumber(Integer number)
	{
		this.number = number;
	}
	
	public String getImg()
	{
		return img;
	}
	
	public void setImg(String img)
	{
		this.img = img;
	}
	
	
}
