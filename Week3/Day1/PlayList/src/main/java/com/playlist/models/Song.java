package com.playlist.models;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="songs")
public class Song {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	// songTitle
		@NotNull(message="Title is required!")
	    @Size(min=3, max=30, message="title must be between 3 and 30 characters")
	    private String title;
	
		// song url
				@NotNull(message="URL is required!")
			    @Size(min=3, max=30, message="url must be between 3 and 30 characters")
			    private String url;
				
		// song descrip
				@NotNull(message="Description is required!")
			    @Size(min=3, max=30, message="description must be between 3 and 30 characters")
			    private String description;		
	
	//ManyToOne
				@ManyToOne(fetch = FetchType.LAZY)
			    @JoinColumn(name="user_id")
			    User creator;
	// ManyToMany
				@ManyToMany
				@JoinTable(name="songs_users",
			    		joinColumns = @JoinColumn(name = "song_id"), 
			            inverseJoinColumns = @JoinColumn(name = "user_id")
			    )
			    List<User> usersAddedThisSong;
				
				 @Column(updatable=false)
				    private Date createdAt;
				    private Date updatedAt;

				    @PrePersist
				    protected void onCreate(){
				        this.createdAt = new Date();
				        this.updatedAt = new Date();
				    }
				    @PreUpdate
				    protected void onUpdate(){
				        this.updatedAt = new Date();
				    }
				    
				    // empty Constructor
				    
				    public Song() {}
					public Long getId() {
						return id;
					}
					public void setId(Long id) {
						this.id = id;
					}
					public String getTitle() {
						return title;
					}
					public void setTitle(String title) {
						this.title = title;
					}
					public String getUrl() {
						return url;
					}
					public void setUrl(String url) {
						this.url = url;
					}
					public String getDescription() {
						return description;
					}
					public void setDescription(String description) {
						this.description = description;
					}
					public User getCreator() {
						return creator;
					}
					public void setCreator(User creator) {
						this.creator = creator;
					}
					public List<User> getUsersAddedThisSong() {
						return usersAddedThisSong;
					}
					public void setUsersAddedThisSong(List<User> usersAddedThisSong) {
						this.usersAddedThisSong = usersAddedThisSong;
					}
					public Date getCreatedAt() {
						return createdAt;
					}
					public void setCreatedAt(Date createdAt) {
						this.createdAt = createdAt;
					}
					public Date getUpdatedAt() {
						return updatedAt;
					}
					public void setUpdatedAt(Date updatedAt) {
						this.updatedAt = updatedAt;
					}
				    
				    
}
