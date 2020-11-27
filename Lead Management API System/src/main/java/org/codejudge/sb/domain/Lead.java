package org.codejudge.sb.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Lead {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, unique = true)
	public Long id;

	@NotNull(message = "first_name should not be null")
	@Column(nullable = false)
	public String first_name;
	
	
	@NotNull(message = "last_name should not be null")
	@Column(nullable = false)
	public String last_name;
	
	
	@NotNull(message = "mobile should not be null")
	@Column(nullable = false)
	public String mobile;
	
	
	@NotNull(message = "email should not be null")
	@Column(nullable = false, unique = true)
	public String email;
	
	
	@NotNull(message = "location_type should not be null")
	@Column(nullable = false)
	public String location_type;
	
	
	@NotNull(message = "location_string should not be null")
	@Column(nullable = false)
	public String location_string;
	
	@Column
	public String status = "Created";
	
	@Column
	public String communication;
	
	
	public Lead() {}


	public Lead(Long id, String first_name, String last_name, String mobile, String email, String location_type,
			String location_string, String status, String communication) {
		super();
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.mobile = mobile;
		this.email = email;
		this.location_type = location_type;
		this.location_string = location_string;
		this.status = status;
		this.communication = communication;
	}

}
