package pojos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Getter;

@Component
@Getter
public class Bag {

	//Object injection Using @Autowired
	
	//with variable
	@Autowired  //book object will automatically get injected in Bag object
	private Book book;

	//with constructor
	@Autowired
	public Bag(Book book) {
		super();
		this.book = book;
	}

	//with setter
	@Autowired
	public void setBook(Book book) {
		this.book = book;
	}
	

	
	
	
}
