/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifrs.SGRU.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 *
 * @author igor
 */
@Entity
@Table(name="state")
@Data
public class StateEntity implements AbstractEntity<Integer>, Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    private Integer id; 
    
    @Column
    private String description; 
    
    @Column
    private String uf; 
    
    @Override
    public Integer getId() {
        return id; 
    }
}
