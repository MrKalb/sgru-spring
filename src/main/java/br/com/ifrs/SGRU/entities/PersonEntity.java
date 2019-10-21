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

import lombok.Data;

/**
 *
 * @author igor
 */
@Entity
@Table(name = "person")
@DynamicUpdate
@Data
public class PersonEntity implements Serializable {

	@Id
	@SequenceGenerator(name = "person_id_seq", sequenceName = "person_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_id_seq")
	@Column(name = "id", columnDefinition = "serial")
	private Integer id;

	@Column(name = "registration_number")
	private String registrationNumber;

	@Column
	private String name;

	@Column
	private String phone;

	@Column
	private String email;

	@Column
	private String status;

	@Column(name="birthday")
	private LocalDateTime birthday;

	@Column
	private String cpf;

	@OneToOne
	private GroupEntity group;

	@OneToOne
	private CityEntity city;

	@OneToOne
	private WalletEntity wallet;

	@OneToOne
	private CourseEntity course;
}
