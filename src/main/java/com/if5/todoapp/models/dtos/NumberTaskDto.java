package com.if5.todoapp.models.dtos;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NumberTaskDto {

	private Date startDate;
	private Date endDate;
}
