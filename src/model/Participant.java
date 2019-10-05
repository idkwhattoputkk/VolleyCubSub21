package model;

public class Participant {
	private int id;
	private String first_name;
	private String last_name;
	private String email;
	private String gender;
	private String country;
	private String photo;
	private String birthday;
	private Participant next;
	private Participant prev;
	
	
	
	//methods
	public Participant(int id, String first_name, String last_name, String email, String gender, String country, String photo,
			String birthday) {
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.gender = gender;
		this.country = country;
		this.photo = photo;
		this.birthday = birthday;
		this.next = null;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public Participant getNext() {
		return next;
	}

	public void setNext(Participant next) {
		this.next = next;
	}

	public Participant getPrev() {
		return prev;
	}

	public void setPrev(Participant prev) {
		this.prev = prev;
	}

	public String toString() {
		return ("ID: "+id + "\nName: "+ first_name +" "+ last_name+"\nEmail: " + email+"\nGender: "+ gender+"\nBirthday: " + birthday+"\nCountry:"+country);
		
	}

	public void addBefore(Participant n) {
		if( prev != null )
			prev.next = n;
		n.prev = prev;
		n.next = this;
		prev = n;
	}

	public void addAfter(Participant n) {
		n.next = next;
		if( next != null )
			next.prev = n;
		n.prev = this;
		next = n;
	}
}
