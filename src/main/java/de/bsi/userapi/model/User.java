package de.bsi.userapi.model;

import java.util.ArrayList;
import java.util.List;

public class User {
    
    private int id;
    private String firstName;
    private String lastName;
    private List<Object> ownedItems = new ArrayList<>();
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public List<Object> getOwnedItems() {
        return ownedItems;
    }
    
    public void setOwnedItems(List<Object> ownedItems) {
        this.ownedItems = ownedItems;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        
        User user = (User) o;
        
        if (id != user.id) return false;
        if (firstName != null ? !firstName.equals(user.firstName) : user.firstName != null) return false;
        if (lastName != null ? !lastName.equals(user.lastName) : user.lastName != null) return false;
        return ownedItems != null ? ownedItems.equals(user.ownedItems) : user.ownedItems == null;
    }
    
    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (ownedItems != null ? ownedItems.hashCode() : 0);
        return result;
    }
    
    @Override
    public String toString() {
        return "User{" +
            "id=" + id +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", ownedItems=" + ownedItems +
            '}';
    }
}
