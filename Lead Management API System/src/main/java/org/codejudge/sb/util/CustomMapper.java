package org.codejudge.sb.util;

import org.codejudge.sb.domain.Lead;


public class CustomMapper {
	
	public static void map(Lead from , Lead to) {
//		to.first_name = from.first_name;
//		to.last_name = from.last_name;
//		to.mobile = from.mobile;
//		to.email = from.email;
//		to.location_type = from.location_type;
//		to.location_string = from.location_string;
//		to.status = "Created";
//		to.communication = from.communication;
		
		to.first_name = from.first_name!=null ? from.first_name : to.first_name ;
		to.last_name = from.last_name!=null ? from.last_name : to.last_name ;
		to.mobile = from.mobile!=null ? from.mobile : to.mobile ;
		to.email = from.email!=null ? from.email : to.email ;
		to.location_type = from.location_type!=null ? from.location_type : to.location_type ;
		to.location_string = from.location_string!=null ? from.location_string : to.location_string ;
		to.status = "Created";
		to.communication = from.communication!=null ? from.communication : to.communication ;
	}
	
}
