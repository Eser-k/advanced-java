package app.model;

import java.util.Objects;

public class Book {

	private Long id;

	private String author;

	private String title;

	public Book() {

	}

	public Book(String author, String title) {
		this.author = author;
		this.title = title;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public int hashCode() {
		return Objects.hash(author, id, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(author, other.author) && Objects.equals(id, other.id)
				&& Objects.equals(title, other.title);
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", author=" + author + ", title=" + title + "]";
	}

}
