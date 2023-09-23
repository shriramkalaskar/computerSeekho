package com.example.entityGallary;

import java.util.Date;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.*;

@Entity
public class Album {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int album_id;
	private String album_name;
	private String album_description;
	private boolean album_is_active;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "album_id", referencedColumnName = "album_id")
	private Set<Image> images;
	
	private Date start_date;
	private Date end_date;

	public Set<Image> getImages() {
		return images;
	}

	public void setImages(Set<Image> images) {
		this.images = images;
	}

	public Date getStart_date() {
		return start_date;
	}

	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}

	public Date getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}

	public Album() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Album(int album_id, String album_name, String album_description, boolean album_is_active,
			Set<Image> images) {
		super();
		this.album_id = album_id;
		this.album_name = album_name;
		this.album_description = album_description;
		this.album_is_active = album_is_active;
		//this.images = images;
	}


	public int getAlbum_id() {
		return album_id;
	}

	public void setAlbum_id(int album_id) {
		this.album_id = album_id;
	}

	public String getAlbum_name() {
		return album_name;
	}

	public void setAlbum_name(String album_name) {
		this.album_name = album_name;
	}

	public String getAlbum_description() {
		return album_description;
	}

	public void setAlbum_description(String album_description) {
		this.album_description = album_description;
	}

	public boolean isAlbum_is_active() {
		return album_is_active;
	}

	public void setAlbum_is_active(boolean album_is_active) {
		this.album_is_active = album_is_active;
	}

	@Override
	public String toString() {
		return "Album [album_id=" + album_id + ", album_name=" + album_name + ", album_description=" + album_description
				+ ", album_is_active=" + album_is_active + ", images=" + images + ", start_date=" + start_date
				+ ", end_date=" + end_date + "]";
	}

}
