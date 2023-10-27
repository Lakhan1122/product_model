package com.lakhan.model;

import java.util.Date;

import jakarta.persistence.*;

@Entity
public class Review {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userId;
    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "cDate")
    private Date creationDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "uDate")
    private Date updateDate;
    
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    
    @PrePersist
    protected void onCreate() {
        creationDate = new Date();
        updateDate = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        updateDate = new Date();
    }

	public Review() {
		
		// TODO Auto-generated constructor stub
	}

	
	public Review(Long id, String userId, String description, Date creationDate, Date updateDate, Product product) {
		super();
		this.id = id;
		this.userId = userId;
		this.description = description;
		this.creationDate = creationDate;
		this.updateDate = updateDate;
		this.product = product;
	}

	@Override
	public String toString() {
		return "Review [id=" + id + ", userId=" + userId + ", description=" + description + ", creationDate="
				+ creationDate + ", updateDate=" + updateDate + ", product=" + product + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	
    

}
