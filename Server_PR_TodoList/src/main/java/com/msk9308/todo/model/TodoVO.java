package com.msk9308.todo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class TodoVO {
	
	private Integer td_num = 0;
	private String td_work;
	private String td_date;
	private String td_time;
	private String td_place;
	

}
