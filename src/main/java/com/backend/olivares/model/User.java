
package com.backend.olivares.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "loginuser")
@AllArgsConstructor
@Data
@NoArgsConstructor
public class User implements Serializable   {
    
    @Id
    private String userId;
    private String password;
    private boolean loggedIn;
    
    public User(String userId, String password) {
        this.userId = userId;
        this.password = password;
        this.loggedIn = false;
    }
    
    public String getUserId() {
        return userId;
    }
     public void setUserId(String userId) {
        this.userId = userId;
     }
     
    public Object getPassword(){
        return password;
    } 
      public void setPassword(String password) {
        this.password = password;
    }
    
    
    
    public boolean isLoggedIn() {
        return loggedIn;
    }
    
         public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }
        
    
     @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(userId, user.userId) &&
                Objects.equals(password, user.password);
    }
    @Override
    public int hashCode() {
        return Objects.hash(userId, password, 
                            loggedIn);
    }
    
    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", password='" + password + '\'' +
                ", loggedIn=" + loggedIn +
                '}';
    }
}

