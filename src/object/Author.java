package object;

public class Author extends Person{
	private int idAuthor;
	private String shortBio;
	private String credentials;
	public Author(Address address, String firstName, String lastName, String ID, String phoneNumber, String shortBio,
			String credentials) {
		super(address, firstName, lastName, ID, phoneNumber);
		this.shortBio = shortBio;
		this.credentials = credentials;
	}

	public String getShortBio() {
		return shortBio;
	}
	public void setShortBio(String shortBio) {
		this.shortBio = shortBio;
	}
	public String getCredentials() {
		return credentials;
	}
	public void setCredentials(String credentials) {
		this.credentials = credentials;
	}

	public int getIdAuthor() {
		return idAuthor;
	}

	public void setIdAuthor(int idAuthor) {
		this.idAuthor = idAuthor;
	}
}
