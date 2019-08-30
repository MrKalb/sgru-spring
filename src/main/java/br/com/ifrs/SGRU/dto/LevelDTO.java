package br.com.ifrs.SGRU.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown=true)
public class LevelDTO {
	
	private Integer id; 
	
	private String description; 
	

}
