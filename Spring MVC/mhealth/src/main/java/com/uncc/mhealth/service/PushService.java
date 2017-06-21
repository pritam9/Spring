package com.uncc.mhealth.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.notnoop.apns.APNS;
import com.notnoop.apns.ApnsService;
import com.uncc.mhealth.model.UserToken;

@Service
public class PushService {
	public void pushMessage(List<UserToken> tokenList, String message){
		try{
			//mac jetty
//		ApnsService service =
//			    APNS.newService()
//			    .withCert("Certificates.p12", "mHealth*15")
//			    .withSandboxDestination()
//			    .build();
		//amazon ec-2
		ApnsService service =
			    APNS.newService()
			    .withCert("/usr/share/tomcat8/conf/Certificates.p12", "mHealth*15")
			    .withSandboxDestination()
			    .build();
		ApnsService newService =
			    APNS.newService()
			    .withCert("/usr/share/tomcat8/conf/Certificates_New.p12", "mhealth")
			    .withProductionDestination()
			    .build();
		
		String payload = APNS.newPayload().alertBody(message).build();
		//TODO: default user
		if(tokenList == null || tokenList.size() < 1) {
			tokenList = new ArrayList<UserToken>();
			UserToken userToken = new UserToken();
			userToken.setToken("a01812c389808b0e14d3243a5d300767d6d80cd63884026d7c03d655c6487f26");
			tokenList.add(userToken);
		}
		for(UserToken token : tokenList){
			System.out.println("## sending push to : "+token);
			if(token.getToken() == null || token.getToken().equals("NA")){//don't push to null or NA(web sessions) device ids
				continue;
			}
			if(token.getIsWithNewCert().equals("Y")){
				newService.push(token.getToken(), payload);
			}else{
				service.push(token.getToken(), payload);
			}
		}
		
		Map<String, Date> inactiveDevices = service.getInactiveDevices();
		for (String deviceToken : inactiveDevices.keySet()) {
		    Date inactiveAsOf = inactiveDevices.get(deviceToken);
		    System.out.println(""+inactiveAsOf);
		}
		Map<String, Date> inactiveDevicesNewCert = newService.getInactiveDevices();
		for (String deviceToken : inactiveDevicesNewCert.keySet()) {
		    Date inactiveAsOf = inactiveDevicesNewCert.get(deviceToken);
		    System.out.println(""+inactiveAsOf);
		}
		}catch(Exception e){
			e.printStackTrace();
		}

	}
}
