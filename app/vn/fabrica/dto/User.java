package vn.fabrica.dto;

import java.util.Date;

import play.data.validation.Constraints;
import play.data.format.Formats;

public class User {
    private Integer id;
    
    @Constraints.Required
    private String fullname;
    
    @Formats.DateTime(pattern = "yyyy-MM-dd")
    private Date birthday;
    
    private String phone;
    
    @Constraints.Email
    private String email;
    
    private Date dateAdded;
    
    private Date dateModified;

    public User() {}

    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id){
    	this.id = id;
    }

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}

	public Date getDateModified() {
		return dateModified;
	}

	public void setDateModified(Date dateModified) {
		this.dateModified = dateModified;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
}
