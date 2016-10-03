package ru.storageproduct.Model;

public class Category {

	private Integer idCategory;
	private String title;
	private String description;
	
	public Category(){ }
	
	public void initCategory(Integer id, String title, String descr)
	{
		this.idCategory = id;
		this.title = title;
		this.description = description;
	
	}
	

	public Integer getIdCategory()
	{
		return idCategory;
	}
	
	public void setIdCategory(Integer id)
	{
		this.idCategory = id;
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
	
	
	
}
