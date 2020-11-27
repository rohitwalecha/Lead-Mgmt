package org.codejudge.sb.controller;


import java.net.URI;

import org.codejudge.sb.domain.Lead;
import org.codejudge.sb.error.ApiError;
import org.codejudge.sb.repo.LeadRepository;
import org.codejudge.sb.success.ApiSuccess;
import org.codejudge.sb.success.MarkLeadSuccess;
import org.codejudge.sb.util.CustomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path = "/api")
public class AppController {

	
	/**
	 * 
	 * NOTE : I have neglected to build a service layer so as to save Time.
	 * 
	 * 
	 */
	
	
	@Autowired
	LeadRepository leadRepository;
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	@ApiOperation("This API returns a Lead by Id")
    @GetMapping(value = {"/leads", "/leads/{id}"})
    public ResponseEntity<?> findOne(@PathVariable(required = false) Long id) {
    	if(id!=null) {
    		Lead lead = leadRepository.findById(id);
    		if(lead!=null) {
    			return ResponseEntity.ok(lead);
    		}else {
    			return ResponseEntity.notFound().build();
    		}
    	}else {
    		return ResponseEntity.badRequest().body(new ApiError("failure", "Lead Id is not Present In URI"));
    	}
    }
    
	
	/**
	 * This API posts a new Lead
	 * @param lead
	 * @return
	 */
	@ApiOperation("This API posts a new Lead")
    @PostMapping(value = {"/leads"})
    public ResponseEntity<?> create(@RequestBody Lead lead) {
    	if(lead.status == "" || lead.status == null) {
    		lead.status = "Created";
    	}
    	if(lead.communication == "" || lead.communication == null) {
    		lead.communication = "";
    	}
        return ResponseEntity.created(URI.create("/leads")).body(leadRepository.save(lead));
    }
    
	
	/**
	 * This API updates an existing Lead
	 * @param lead
	 * @param id
	 * @return
	 */
	@ApiOperation("This API updates an existing Lead")
    @PutMapping(value = {"/leads", "/leads/{id}"})
    public ResponseEntity<?> updateLead(@RequestBody Lead lead, @PathVariable(required = false) Long id) {
    	if(id!=null) {
    		Lead leadToUpdate = leadRepository.findById(id);
    		if(leadToUpdate!=null) {
    			CustomMapper.map(lead , leadToUpdate);
    			leadRepository.save(leadToUpdate); 
    			return ResponseEntity.accepted().body(new ApiSuccess("success"));
    		}else {
    			return ResponseEntity.notFound().build();
    		}
    	}else {
    		return ResponseEntity.badRequest().body(new ApiError("failure", "Lead Id is not Present In URI"));
    	}
    }
	
	
	/**
	 * This API deletes an existing Lead by Id
	 * @param id
	 * @return
	 */
	@ApiOperation("This API deletes an existing Lead by Id")
	@DeleteMapping(value = {"/leads", "/leads/{id}"})
    public ResponseEntity<?> delete(@PathVariable(required = false) Long id) {
		if(id!=null) {
    		leadRepository.delete(id);
    		return ResponseEntity.ok(new ApiSuccess("success"));
    	}else {
    		return ResponseEntity.badRequest().body(new ApiError("failure", "Lead Id is not Present In URI"));
    	}
    }
    
	/**
	 * This API deletes an existing Lead by Id
	 * @param id
	 * @return
	 */
	@ApiOperation("This API marks an existing Lead as Contacted")
	@PutMapping(value = {"/mark_lead", "/mark_lead/{id}"})
    public ResponseEntity<?> markLead(@RequestBody Lead lead, @PathVariable(required = false) Long id) {
		if(id!=null) {
			if(lead.communication!=null) {
				Lead leadToUpdate = leadRepository.findById(id);
	    		if(leadToUpdate!=null) {
	    			CustomMapper.map(lead , leadToUpdate);
	    			leadToUpdate.status = "Contacted";
	    			leadRepository.save(leadToUpdate); 
	    			return ResponseEntity.accepted().body(new MarkLeadSuccess(leadToUpdate.status, leadToUpdate.communication));
	    		}else {
	    			return ResponseEntity.notFound().build();
	    		}
			}else {
				return ResponseEntity.badRequest().body(new ApiError("failure", "Communication is not Present In Request Body"));
			}
    	}else {
    		return ResponseEntity.badRequest().body(new ApiError("failure", "Lead Id is not Present In URI"));
    	}
    }
	
}
