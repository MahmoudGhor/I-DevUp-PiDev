/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author mahmo
 */
public class Client {
    private String username;
    private String email;
    private String password;
    private Date last_login;
    private String firstname;
    private String lastname;
    private String phone;
    private String town;
    private String address;
    private String postalcode;
    private String picture;
    private String facebook;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getLast_login() {
        return last_login;
    }

    public void setLast_login(Date last_login) {
        this.last_login = last_login;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    

    public Client() {
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Client other = (Client) obj;
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        return true;
    }

    public Client(String username, String email, String password, Date last_login, String firstname, String lastname, String phone, String town, String address, String postalcode, String picture, String facebook) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.last_login = last_login;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
        this.town = town;
        this.address = address;
        this.postalcode = postalcode;
        this.picture = picture;
        this.facebook = facebook;
    }

    public Client(String username, String email, String password, String firstname, String lastname, String phone, String town, String address, String postalcode, String picture, String facebook) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
        this.town = town;
        this.address = address;
        this.postalcode = postalcode;
        this.picture = picture;
        this.facebook = facebook;
    }

    public Client(String email, String firstname, String lastname, String phone, String town, String address, String postalcode, String facebook) {
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
        this.town = town;
        this.address = address;
        this.postalcode = postalcode;
        this.facebook = facebook;
    }

    public Client(String email, String firstname, String lastname, String phone, String town, String address, String postalcode, String picture, String facebook) {
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
        this.town = town;
        this.address = address;
        this.postalcode = postalcode;
        this.picture = picture;
        this.facebook = facebook;
    }


    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
