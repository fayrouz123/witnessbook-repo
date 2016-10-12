package entities;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: WordList
 *
 */
@Entity

public class WordList implements Serializable {

	   
	@Id
	private String Words;
	private static final long serialVersionUID = 1L;

	public WordList() {
		super();
	}   
	public String getWords() {
		return this.Words;
	}

	public void setWords(String Words) {
		this.Words = Words;
	}
   
}
