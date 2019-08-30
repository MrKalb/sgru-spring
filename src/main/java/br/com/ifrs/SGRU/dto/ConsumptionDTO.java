/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifrs.SGRU.dto;
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
public class ConsumptionDTO {
	
	@JsonProperty("id")
	private Integer id; 
	
	@JsonProperty("date")
    private LocalDateTime date;
    
	@JsonProperty("shift")
    private String shift; 
    
	@JsonProperty("status")
    private String status; 
      
}
