package com.example.entityCourseBatchStd;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Course")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int course_id;
	
	private String course_name;
	
	private String course_description;
	
	private int course_duration;
	
	private String course_syllabus;
	
	private String age_grp_type;
	
	private boolean course_is_active;
	
	private String cover_photo;
	
	private int video_id;

//	private Set<Batch> batches;
//	@OneToMany(cascade = CascadeType.ALL)
//	@JoinColumn(name = "course_id", referencedColumnName="course_id")
//	private Set<Student> Student;

	/**
	 * @return the course_id
	 */
	public int getCourse_id() {
		return course_id;
	}

	/**
	 * @param course_id the course_id to set
	 */
	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}

	/**
	 * @return the course_name
	 */
	public String getCourse_name() {
		return course_name;
	}

	/**
	 * @param course_name the course_name to set
	 */
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}

	/**
	 * @return the course_description
	 */
	public String getCourse_description() {
		return course_description;
	}

	/**
	 * @param course_description the course_description to set
	 */
	public void setCourse_description(String course_description) {
		this.course_description = course_description;
	}

	/**
	 * @return the course_duration
	 */
	public int getCourse_duration() {
		return course_duration;
	}

	/**
	 * @param course_duration the course_duration to set
	 */
	public void setCourse_duration(int course_duration) {
		this.course_duration = course_duration;
	}

	/**
	 * @return the course_syllabus
	 */
	public String getCourse_syllabus() {
		return course_syllabus;
	}

	/**
	 * @param course_syllabus the course_syllabus to set
	 */
	public void setCourse_syllabus(String course_syllabus) {
		this.course_syllabus = course_syllabus;
	}

	/**
	 * @return the age_grp_type
	 */
	public String getAge_grp_type() {
		return age_grp_type;
	}

	/**
	 * @param age_grp_type the age_grp_type to set
	 */
	public void setAge_grp_type(String age_grp_type) {
		this.age_grp_type = age_grp_type;
	}

	/**
	 * @return the course_is_active
	 */
	public boolean isCourse_is_active() {
		return course_is_active;
	}

	/**
	 * @param course_is_active the course_is_active to set
	 */
	public void setCourse_is_active(boolean course_is_active) {
		this.course_is_active = course_is_active;
	}

	/**
	 * @return the cover_photo
	 */
	public String getCover_photo() {
		return cover_photo;
	}

	/**
	 * @param cover_photo the cover_photo to set
	 */
	public void setCover_photo(String cover_photo) {
		this.cover_photo = cover_photo;
	}

	/**
	 * @return the video_id
	 */
	public int getVideo_id() {
		return video_id;
	}

	/**
	 * @param video_id the video_id to set
	 */
	public void setVideo_id(int video_id) {
		this.video_id = video_id;
	}

//	public Set<Batch> getBatches() {
//		return batches;
//	}
//
//	public void setBatches(Set<Batch> batches) {
//		this.batches = batches;
//	}
	@Override
	public String toString() {
		return "Course [course_id=" + course_id + ", course_name=" + course_name + ", course_description="
				+ course_description + ", course_duration=" + course_duration + ", course_syllabus=" + course_syllabus
				+ ", age_grp_type=" + age_grp_type + ", course_is_active=" + course_is_active + ", cover_photo="
				+ cover_photo + ", video_id=" + video_id + "]";
	}
	
	
	
}
