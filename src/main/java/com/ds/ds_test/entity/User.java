package com.ds.ds_test.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
	@Id
	@Column(name="u_idx")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer uidx;
	
	@Column(nullable = false, unique = true, name="u_id")
    private String uid;
	
	@Column(nullable = false, name = "u_pw")
    private String upw;
	
	@Column(nullable = false, name = "u_nick")
    private String unick;
	
	@Column(nullable = false, name = "created_date")
    private LocalDateTime createdDate;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Item> items;
	
}
