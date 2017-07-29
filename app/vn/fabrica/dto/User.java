package vn.fabrica.dto;

import java.util.Date;

import play.data.validation.Constraints;
import vn.fabrica.validators.BasicDate;
import vn.fabrica.validators.FieldMatch;
import play.data.format.Formats;

@FieldMatch(first = "fullname", second = "phone", message = "The password fields must match")
public class User {
    private Integer id;
    
    @Constraints.Required
    private String fullname;
    
    @Formats.DateTime(pattern = "yyyy-MM-dd")
    private Date birthday;
    
    @BasicDate(pattern = "yyyy-MM-dd", fraction = 100)
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
