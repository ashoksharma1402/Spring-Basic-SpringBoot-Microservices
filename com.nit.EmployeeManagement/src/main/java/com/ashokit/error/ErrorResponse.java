package com.ashokit.error;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class ErrorResponse {
	private String msg;
	private Integer statusCode;
	private String statusValue;
	private Date date;

}
