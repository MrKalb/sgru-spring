package br.com.ifrs.SGRU.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 *
 * @author igor
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class WalletDTO {

	@JsonProperty("id")
	private Integer id;

	@JsonProperty("leftover")
	private Double leftover;
}
