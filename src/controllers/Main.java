package controllers;

import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;
import com.thoughtworks.xstream.io.xml.DomDriver;

import models.User;
import utils.FileLogger;

public class Main {

	  public static void main(String[] args) throws IOException
	  {    
	    PacemakerAPI pacemakerAPI = new PacemakerAPI();

	    pacemakerAPI.createUser("Bart",  "Simpson", "bart@simpson.com",  "secret");
	    pacemakerAPI.createUser("Homer", "Simpson", "homer@simpson.com", "secret");
	    pacemakerAPI.createUser("Lisa",  "Simpson", "lisa@simpson.com",  "secret");

	    Collection<User> users = pacemakerAPI.getUsers();
	    System.out.println(users);
	    
	    User homer = pacemakerAPI.getUserByEmail("homer@simpson.com");
	    System.out.println(homer);
	    
	    pacemakerAPI.deleteUser(homer.id);
	    users = pacemakerAPI.getUsers();
	    System.out.println(users);

//	    logger.log("Serializing contacts to XML");
//	    XStream xstream = new XStream(new DomDriver());
//	    ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("users.xml"));
//	    out.writeObject(users);
//	    out.close();    
//	    
//	    logger.log("Serializing contacts to JSON");
//	    XStream xstreamJ = new XStream(new JettisonMappedXmlDriver());
//	    ObjectOutputStream json = xstreamJ.createObjectOutputStream(new FileWriter("users.json"));
//	    json.writeObject(users);
//	    json.close(); 
//
//	    logger.log("Finished - shutting down");
	  }

}
