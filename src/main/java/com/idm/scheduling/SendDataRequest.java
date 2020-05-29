package com.idm.scheduling;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.Callable;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.idm.dao.ILeadDAO;
import com.idm.model.Lead;

public class SendDataRequest implements Callable<Lead> {
	
	 private static final Logger log = LoggerFactory.getLogger(SendDataRequest.class);
	    
	
	private Lead lead;
	private ILeadDAO leadDAO;

	public SendDataRequest(Lead lead,ILeadDAO leadDAO) {
		super();
		this.lead = lead;
		this.leadDAO = leadDAO;
	}


	@Override
	public Lead call() throws Exception {
		return process(lead);
	 }
	
	
	public Lead process(Lead lead) {
		CloseableHttpClient  httpClient = HttpClients.createDefault();
	    try
	    {
	        //Define a postRequest request
	        HttpPost postRequest = new HttpPost(lead.getApiURL());
	         
	        //Set the API  headers
	        if (lead.getLeadHeaders().contains(";")) {
	        	 String[] headers = lead.getLeadHeaders().split(";");
	        	 for(int i=0;i<headers.length;i++) {
	        		 String[] header =  headers[i].split(":");
		        	 postRequest.setHeader(header[0], header[1]);
	        	 }
	        } else if (lead.getLeadHeaders().contains(":")){
	        	String[] header =  lead.getLeadHeaders().split(":");
	        	 postRequest.setHeader(header[0], header[1]);
	        }
	       
	        //Set the request post body
	        StringEntity userEntity = new StringEntity(lead.getLeadJson());
	        postRequest.setEntity(userEntity);
	          
	        //Send the request; It will immediately return the response in HttpResponse object if any
	        CloseableHttpResponse response = httpClient.execute(postRequest);
	         
	        //verify the valid error code first
	        int statusCode = response.getStatusLine().getStatusCode();
	        lead.setResponseCode(statusCode);
	        lead.setResponseJson(EntityUtils.toString(response.getEntity(), "UTF-8"));
	    	if (statusCode != 200) 
	        {
	    		lead.setDataSend(false);
	    		lead.setFailureMessage("");
	        } else {
	        	lead.setDataSend(true);
	        }
	    } catch (UnsupportedEncodingException e) {
	    	log.error("UnsupportedEncodingException ",e);
	    	lead.setDataSend(false);
    		lead.setFailureMessage("UnsupportedEncodingException");
		} catch (ClientProtocolException e) {
		   	log.error("ClientProtocolException ",e);
			lead.setDataSend(false);
    		lead.setFailureMessage("ClientProtocolException");
		} catch (IOException e) {
		   	log.error("IOException ",e);
			lead.setDataSend(false);
    		lead.setFailureMessage("IOException");
		}
	    finally
	    {
	    	try {
				httpClient.close();
			} catch (IOException e) {
				lead.setDataSend(false);
	    		lead.setFailureMessage("IOException");
			}
	    }
	    lead = leadDAO.save(lead);
		return lead;
	}
}
