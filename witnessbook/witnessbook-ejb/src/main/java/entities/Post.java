package entities;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Post
 *
 */
@Entity

public class Post implements Serializable {

	   
	@Id
	private Integer IdPost;
	private String PostDescription;
	private String PostFile;
	private Date PostDate;
	private static final long serialVersionUID = 1L;

	public Post() {
		super();
	}   
	public Integer getIdPost() {
		return this.IdPost;
	}

	public void setIdPost(Integer IdPost) {
		this.IdPost = IdPost;
	}   
	public String getPostDescription() {
		return this.PostDescription;
	}

	public void setPostDescription(String PostDescription) {
		this.PostDescription = PostDescription;
	}   
	public String getPostFile() {
		return this.PostFile;
	}

	public void setPostFile(String PostFile) {
		this.PostFile = PostFile;
	}   
	public Date getPostDate() {
		return this.PostDate;
	}

	public void setPostDate(Date PostDate) {
		this.PostDate = PostDate;
	}
   
}
