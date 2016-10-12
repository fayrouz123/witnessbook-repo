package entities;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Category
 *
 */
@Entity

public class Category implements Serializable {

	   
	@Id
	private Integer CategoryId;
	private String CategoryName;
	private static final long serialVersionUID = 1L;

	public Category() {
		super();
	}   
	public Integer getCategoryId() {
		return this.CategoryId;
	}

	public void setCategoryId(Integer CategoryId) {
		this.CategoryId = CategoryId;
	}   
	public String getCategoryName() {
		return this.CategoryName;
	}

	public void setCategoryName(String CategoryName) {
		this.CategoryName = CategoryName;
	}
	public Category(Integer categoryId, String categoryName) {
		super();
		CategoryId = categoryId;
		CategoryName = categoryName;
	}
   
}
