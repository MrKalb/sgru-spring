/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifrs.SGRU.entities;
import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

/**
 *
 * @author igor
 */
@Entity
@DynamicUpdate
@Table(name="consumption")
@Data
public class ConsumptionEntity implements AbstractEntity<Integer>,Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "consumption_id_seq", sequenceName = "consumption_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "consumption_id_seq")
	@Column(name = "id", columnDefinition = "serial")
	private Integer id; 
	
	@Column
    private LocalDateTime date;
    
    @Column
    private String shift; 
    
    @Column
    private String status;
    
    @OneToOne
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private PersonEntity person; 
        
	@Override
	public Integer getId() {
		return this.id;
	}
}
