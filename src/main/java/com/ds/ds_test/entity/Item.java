package com.ds.ds_test.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Item {
	
	@Id
	@Column(name="i_idx")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer iidx;
	
	@Column(nullable = false, name = "i_name")
    private String iname;
		
	@Column(nullable = false, name = "created_date")
    private LocalDateTime createdDate;
	
	@ManyToOne
	@JoinColumn(name = "u_idx")
	@JsonIgnore
	private User user;
	
}
