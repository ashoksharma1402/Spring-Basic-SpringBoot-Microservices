package com.ashokit.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PanCardDto {
	private String panNo;

	
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date panIssueDate;
	private Long pC_FK;


}
