package model;


public class Assistant {
	private int id;
	private String first_name;
	private String last_name;
	private String email;
	private String gender;
	private String country;
	private String photo;
	private String birthday;
	private Assistant left;
	private Assistant right;
	
	
	
	//methods
	public Assistant(int id, String first_name, String last_name, String email, String gender, String country, String photo,
			String birthday) {
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.gender = gender;
		this.country = country;
		this.photo = photo;
		this.birthday = birthday;
		this.left = null;
		this.right = null;
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


	public Assistant getLeft() {
		return left;
	}


	public void setLeft(Assistant left) {
		this.left = left;
	}


	public Assistant getRight() {
		return right;
	}


	public void setRight(Assistant right) {
		this.right = right;
	}


	public void insert(Assistant p) throws AssistantRepetidoException {
		
		if(p.id==id) 
			throw new AssistantRepetidoException(p.id);
		if(p.id>id) {
			if(right==null)
				right = p;
			else 
				right.insert(p);
		}else 
			if(left==null)
				left = p;
			else 
				left.insert(p);
	}
	public boolean isLeaf( )
    {
        return left == null && right == null;
    }

	public Assistant search(int aidi) {
		if( aidi == id )
            return this;
        else if( aidi < id)
            return ( left == null ) ? null : left.search(aidi );
        else
            return ( right == null ) ? null : right.search( aidi );
	}
	public String toString() {
		return ("ID: "+id + "\nName: "+ first_name +" "+ last_name+"\nEmail: " + email+"\nGender: "+ gender+"\nBirthday: " + birthday+"\nCountry:"+country);
		
	}
	
	
}
