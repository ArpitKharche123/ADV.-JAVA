package pojos;

import org.springframework.stereotype.Component;

@Component
public class Book {
	public void read() {
		System.out.println("Reading a book 📖📖📖...");
	}
}
