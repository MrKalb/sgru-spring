package br.com.ifrs.SGRU.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

/**
 *
 * @author igor
 */
@Entity
@Table(name="wallet")
@Data
 public class WalletEntity implements Serializable {

	@Id
	@SequenceGenerator(name = "wallet_id_seq", sequenceName = "wallet_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "wallet_id_seq")
	@Column(name = "id", columnDefinition = "serial")
    private Integer id; 
    
    @Column(name="value")
    private Double value; 
}
