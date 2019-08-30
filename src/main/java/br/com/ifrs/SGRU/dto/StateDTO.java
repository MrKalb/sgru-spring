/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifrs.SGRU.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 *
 * @author igor
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class StateDTO {

	@JsonProperty("id")
	private Integer id;

	@JsonProperty("description")
	private String description;

	@JsonProperty("uf")
	private String uf;
}
