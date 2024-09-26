package com.ds.ds_test.ItemDto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemDto {
	private Integer i_idx;
	private String i_name;
	private LocalDateTime createdDate;
	
	private String u_nick;
}
