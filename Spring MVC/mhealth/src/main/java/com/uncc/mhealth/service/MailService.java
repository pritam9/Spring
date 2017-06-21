package com.uncc.mhealth.service;

import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Service;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import com.sun.jersey.core.util.MultivaluedMapImpl;


@Service
public class MailService {

	public static ClientResponse SendSimpleMessage() {
	    Client client = Client.create();
	    client.addFilter(new HTTPBasicAuthFilter("api",
	                "key-8328ca4f70c8e31230185cefa3dd8ec9"));
	    WebResource webResource =
	        client.resource("https://api.mailgun.net/v3/sandbox393dab980bee4192878e5866169ba945.mailgun.org/messages");
	    MultivaluedMapImpl formData = new MultivaluedMapImpl();
	    formData.add("from", "mHealth <support@mhealth.edu>");
	    formData.add("to", "Kapil <kkshemka@uncc.edu>");
	    formData.add("subject", "mHealth:: University of North Carolina at Charlotte");
	    formData.add("html", "<html><body>Hi Kapil,<br><br>Thank you for submitting the survey. <br><br>Now you can start using our iPhone App. Please install iPhone app from http://mhealth.uncc.edu<br><br>Regards,<br>mHealth Team</body><html>");
	    return webResource.type(MediaType.APPLICATION_FORM_URLENCODED).
	                                                post(ClientResponse.class, formData);
	}
	

}
