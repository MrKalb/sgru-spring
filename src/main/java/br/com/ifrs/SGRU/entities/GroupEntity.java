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
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.DynamicUpdate;

import lombok.Data;

/**
 *
 * @author igor
 */
@Entity
@DynamicUpdate
@Table(name="person_group")
@Data
public class GroupEntity implements Serializable {

	@Id
	@SequenceGenerator(name = "person_group_id_seq", sequenceName = "person_group_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_group_id_seq")
	@Column(name = "id", columnDefinition = "serial")
	private Integer id;

	@Column(name = "description")
	@NotNull
	private String description;

	@Column(name = "value")
	@NotNull
	private Double value;

	@Column
	private String status;
}
