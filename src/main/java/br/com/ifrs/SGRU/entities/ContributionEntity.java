/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifrs.SGRU.entities;

import java.io.Serializable;
import java.math.BigDecimal;
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

import lombok.Data;

/**
 *
 * @author igor
 */
@Entity
@DynamicUpdate
@Table(name="contributions")
@Data
public class ContributionEntity implements AbstractEntity<Integer>, Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "contributions_id_seq", sequenceName = "contributions_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contributions_id_seq")
	@Column(name = "id", columnDefinition = "serial")
    private Integer id; 
    
    @Column
    private BigDecimal value; 
    
    @Column
    private String gru; 
    
    @Column
    private LocalDateTime date; 
    
    @OneToOne
    private PersonEntity person; 
    
    @Column(name="payment_status")
    private String paymentStatus; 
    
    @Override
    public Integer getId() {
        return id; 
    }
}
