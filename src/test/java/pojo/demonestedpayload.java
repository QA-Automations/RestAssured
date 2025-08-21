package pojo;

import java.util.Arrays;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class demonestedpayload {
    
    @Test    
    void done() throws JsonProcessingException {
        // Create insidePro objects for Frontend
        insidePro fe1 = new insidePro();
        fe1.setTitle("React with Redux");
        fe1.setCost(60);

        insidePro fe2 = new insidePro();
        fe2.setTitle("Angular Fundamentals");
        fe2.setCost(50);

        // Create insidePro objects for Backend
        insidePro be1 = new insidePro();
        be1.setTitle("Node.js with Express");
        be1.setCost(70);

        insidePro be2 = new insidePro();
        be2.setTitle("Spring Boot with Java");
        be2.setCost(80);

        // Create insidePro objects for Mobile
        insidePro mb1 = new insidePro();
        mb1.setTitle("Flutter Mobile Development");
        mb1.setCost(55);

        insidePro mb2 = new insidePro();
        mb2.setTitle("Swift iOS Development");
        mb2.setCost(65);

        // Programs object
        Progms progms = new Progms();
        progms.setFrontendCourses(Arrays.asList(fe1, fe2));
        progms.setBackendCourses(Arrays.asList(be1, be2));
        progms.setMobileCourses(Arrays.asList(mb1, mb2));

        // Trainer object
        Trainer trainer = new Trainer();
        trainer.setTrainerName("JohnDoe");
        trainer.setWebsite("johndoeacademy.com");
        trainer.setSupportType("trainingSupport");
        trainer.setSpecialization("Full Stack Development");
        trainer.setPrograms(progms);
        trainer.setProfileLink("https://www.linkedin.com/in/johndoe-trainer/");

        // Convert to JSON
        ObjectMapper mapper = new ObjectMapper();
        String jsonOutput = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(trainer);
        
        System.out.println(jsonOutput);
    }
}
