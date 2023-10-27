package com.lakhan.model;

import java.util.Date;
import java.util.*;

import jakarta.persistence.*;


@Entity
public class Product {
	
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String name;
	    private double price;

	    @Temporal(TemporalType.TIMESTAMP)
	    @Column(name = "cDate")
	 
	    private Date creationDate;

	    @Temporal(TemporalType.TIMESTAMP)
	    @Column(name = "uDate")
	    private Date updateDate;
	    
	    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	    private List<Review> reviews=new ArrayList<>();
	    
	    @PrePersist
	    protected void onCreate() {
	        creationDate = new Date();
	        updateDate = new Date();
	    }

	    @PreUpdate
	    protected void onUpdate() {
	        updateDate = new Date();
	    }

		public Product() {
			
			// TODO Auto-generated constructor stub
		}
		
		

		@Override
		public String toString() {
			return "Product [id=" + id + ", name=" + name + ", price=" + price + ", creationDate=" + creationDate
					+ ", updateDate=" + updateDate + ", reviews=" + reviews + "]";
		}

		public Product(Long id, String name, double price, Date creationDate, Date updateDate, List<Review> reviews) {
			super();
			this.id = id;
			this.name = name;
			this.price = price;
			this.creationDate = creationDate;
			this.updateDate = updateDate;
			this.reviews = reviews;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public double getPrice() {
			return price;
		}

		public void setPrice(double price) {
			this.price = price;
		}

		public Date getCreationDate() {
			return creationDate;
		}

		public void setCreationDate(Date creationDate) {
			this.creationDate = creationDate;
		}

		public Date getUpdateDate() {
			return updateDate;
		}

		public void setUpdateDate(Date updateDate) {
			this.updateDate = updateDate;
		}

		public List<Review> getReviews() {
			return reviews;
		}

		public void setReviews(List<Review> reviews) {
			this.reviews = reviews;
		}

		

}
