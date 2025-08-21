package RestA;

import org.testng.annotations.Test;

public class jsonclass {
	
	@Test
	public void method() {
		String abc="{\r\n"
        		+ "\"reportedBy\": \"Sai\",\r\n"
        		+ "\"reportedByPhone\": \"9247899991\",\r\n"
        		+ "\"description\": \"Incident Happened near to the govt hospital\",\r\n"
        		+ "\"incidentType\": \"Fire Incident\",\r\n"
        		+ "\"userPriority\": \"MEDIUM\",\r\n"
        		+ "\"status\": \"OPEN\",\r\n"
        		+ "\"location\": \"hyd\",\r\n"
        		+ "\"dateReported\": \"2025-07-16T13:00:14.626857\",\r\n"
        		+ "\"address\": \"123 Main Street\",\r\n"
        		+ "\"village\": \"Nandigama\",\r\n"
        		+ "\"city\": \"Vijayawada\",\r\n"
        		+ "\"country\": \"India\",\r\n"
        		+ "\"state\": \"Andhra Pradesh\",\r\n"
        		+ "\"pincode\": \"520001\",\r\n"
        		+ "\"district\":\"Krishna\",\r\n"
        		+ "\"curr_lat\":\"18.9087\",\r\n"
        		+ "\"curr_lon\":\"19.2222\"\r\n"
        		+ "}";
		System.out.print("This is the another class result"+abc);
	}

}
