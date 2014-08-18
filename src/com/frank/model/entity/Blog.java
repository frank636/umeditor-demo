package com.frank.model.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Blog implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Long id;
	private String title;
	private String content;
	private Date time;
	private String ip;
}
