package br.com.ifrs.SGRU.dto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 *
 * @author igor
 */
@JsonIgnoreProperties(ignoreUnknown=true)
@Data
public class PersonDTO {

	@JsonProperty("id")
    private Integer id;
    
	@JsonProperty("name")
    private String name; 
    
	@JsonProperty("phone")
    private String phone; 
    
	@JsonProperty("email")
    private String email; 
    
	@JsonProperty("status")
    private String status; 
    
	@JsonProperty("age")
    private String birthday;
	
	@JsonProperty
	private String registrationNumber;
    
	@JsonProperty("cpf")
    private String cpf; 
    
	@JsonProperty("group")
    private GroupDTO group; 
    
	@JsonProperty("city")
    private CityDTO city;
    
	@JsonProperty("wallet")
    private WalletDTO wallet; 
	
	@JsonProperty("course")
	private CourseDTO course; 
       
}
