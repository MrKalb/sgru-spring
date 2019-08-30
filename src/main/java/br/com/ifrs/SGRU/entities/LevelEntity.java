/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifrs.SGRU.entities;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import lombok.Data;

/**
 *
 * @author igor
 */
@Entity
@Table(name="level")
@DynamicUpdate
@Data
public class LevelEntity implements AbstractEntity<Integer>, Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "level_id_seq", sequenceName = "level_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "level_id_seq")
	@Column(name = "id", columnDefinition = "serial")
    private Integer id; 
    
	@Column
    private String description;
    
    @Override
    public Integer getId() {
        return id; 
    }
}
