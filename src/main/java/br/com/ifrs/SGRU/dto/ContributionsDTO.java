/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifrs.SGRU.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 *
 * @author igor
 */
@JsonIgnoreProperties(ignoreUnknown=true)
@Data
public class ContributionsDTO  {

	@JsonProperty("id")
	private Integer id; 
    
	@JsonProperty("value")
    private BigDecimal value; 
    
	@JsonProperty("gru")
    private String gru; 
    
	@JsonProperty("date")
    private LocalDateTime date; 
   
	@JsonProperty("paymentStatus")
	private String paymentStatus; 
	
	private PersonDTO person; 
    
}
