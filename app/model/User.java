package model;

import play.data.validation.Constraints;

public class User {
    private Integer id;
    
    @Constraints.Required
    private String name;

    public User() {}
    
    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
