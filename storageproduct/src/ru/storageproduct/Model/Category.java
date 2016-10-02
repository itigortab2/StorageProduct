package ru.storageproduct.Model;

public class Category {

	private String title;
	private String description;
	
	public Category(){ }
	
	public void initCategory(String title, String descr)
	{
		
		this.title = title;
		this.description = description;
	
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
