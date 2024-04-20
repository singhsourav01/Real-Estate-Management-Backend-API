package com.example.ExcleRBackEndCode;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

//RealEstateEntities.java
@Entity
 class Broker {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 private String name;
 private String email;
 private String password;
 public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public Long getBroker_id() {
	return id;
}
public void setBroker_id(Long id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public Long getContact() {
	return contact;
}
public void setContact(Long contact) {
	this.contact = contact;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
private Long contact;
 private String address;

 

 // Getters and setters
 // ...
}

@Entity
class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long prop_id;
    private String address;
    private Long Price;
    private String type;
    private String area;
    private String facing;
    private String negotiable;
    private Long floor_no;
    private String year_built;
    private Long rent;
    private Long deposite;

    @Column(name = "id") // Mapping the broker_id column
    private Long brokerId; // Only store the broker id

    public Long getBrokerId() {
        return brokerId;
    }

    public void setBrokerId(Long brokerId) {
        this.brokerId = brokerId;
    }

	public Long getProp_id() {
		return prop_id;
	}

	public void setProp_id(Long prop_id) {
		this.prop_id = prop_id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getPrice() {
		return Price;
	}

	public void setPrice(Long price) {
		Price = price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getFacing() {
		return facing;
	}

	public void setFacing(String facing) {
		this.facing = facing;
	}

	public String getNegotiable() {
		return negotiable;
	}

	public void setNegotiable(String negotiable) {
		this.negotiable = negotiable;
	}

	public Long getFloor_no() {
		return floor_no;
	}

	public void setFloor_no(Long floor_no) {
		this.floor_no = floor_no;
	}

	public String getYear_built() {
		return year_built;
	}

	public void setYear_built(String year_built) {
		this.year_built = year_built;
	}

	public Long getRent() {
		return rent;
	}

	public void setRent(Long rent) {
		this.rent = rent;
	}

	public Long getDeposite() {
		return deposite;
	}

	public void setDeposite(Long deposite) {
		this.deposite = deposite;
	}

	
}



@Entity
@Table(name = "users")
class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable=false)
    private String email;
    private String password;
    private String username;
    
    public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
}

@Entity
 class user_status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "prop_id")
    private Long propId;
    
    @Column(name = "broker_id")
    private Long brokerId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getPropId() {
		return propId;
	}

	public void setPropId(Long propId) {
		this.propId = propId;
	}

	public Long getBrokerId() {
		return brokerId;
	}

	public void setBrokerId(Long brokerId) {
		this.brokerId = brokerId;
	}

    // Getters and setters
}
@Entity
class Admin {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String username;
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
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
private String email;
private String password;
}
