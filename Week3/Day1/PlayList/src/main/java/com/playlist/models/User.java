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
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


@Entity
@Table(name="users")
public class User {

	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	// userName
	@NotNull(message="Username is required!")
    @Size(min=3, max=30, message="Username must be between 3 and 30 characters")
    private String userName;
	
	//Email
	@NotNull
	@NotEmpty
	@Email(message="Please enter a valid email")
	private String email;
	
	//Password
	@Size(min=3,message="The password must be more than 2 characters")
	private String password;
	
	// confirmPassword
	 @Transient
	 @Size(min=3,message="The confirm password must be more than 2 characters")
	 private String confirm;
	 
	 
	 @Column(updatable=false)
	    private Date createdAt;
	    private Date updatedAt;
	    
	    //One to many
	    @OneToMany(mappedBy="creator", fetch = FetchType.LAZY)
	    List<Song> mySongs;
	    
	    //ManyToMany
	    @ManyToMany
	    @JoinTable(name="songs_users",
	    		joinColumns = @JoinColumn(name = "user_id"), 
	            inverseJoinColumns = @JoinColumn(name = "song_id")
	    )
	    List<Song> playList;	   
	    
	    // methods on create & on update 
	    @PrePersist
	    protected void onCreate(){
	        this.createdAt = new Date();
	        this.updatedAt = new Date();
	    }
	    @PreUpdate
	    protected void onUpdate(){
	        this.updatedAt = new Date();
	    }
	    
	    //empty constructor 
	    public User() {}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
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
		public String getConfirm() {
			return confirm;
		}
		public void setConfirm(String confirm) {
			this.confirm = confirm;
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
		public List<Song> getMySongs() {
			return mySongs;
		}
		public void setMySongs(List<Song> mySongs) {
			this.mySongs = mySongs;
		}
		public List<Song> getPlayList() {
			return playList;
		}
		public void setPlayList(List<Song> playList) {
			this.playList = playList;
		}
	    
	    
	    
}
