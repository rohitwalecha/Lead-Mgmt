package org.codejudge.sb.repo;

import org.codejudge.sb.domain.Lead;
import org.springframework.data.repository.CrudRepository;

public interface LeadRepository extends CrudRepository<Lead, Long> {

	Lead findById(Long id);
	
	Lead save (Lead lead);

	void delete(Long id);
}
