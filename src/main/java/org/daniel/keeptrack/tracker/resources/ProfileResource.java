package org.daniel.keeptrack.tracker.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.daniel.keeptrack.model.Message;
import org.daniel.keeptrack.model.Profile;
import org.daniel.keeptrack.service.ProfileService;

@Path("/profiles")
public class ProfileResource {
	
	ProfileService profileService=new ProfileService();
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Profile> getAllProfiles()
	{
		return profileService.getAllProfiles();
	}
	
	@GET
	@Path("/{profileName}")
	@Produces(MediaType.APPLICATION_JSON)
	public Profile getProfile(@PathParam("profileName") String name)
	{
		return profileService.getProfile(name);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Profile addProfile(Profile profile)
	{
		return profileService.addProfile(profile);
	}
	
	@PUT
	@Path("/{profileName}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Profile updateProfile(@PathParam("profileName") String name,Profile profile)
	{
		
		profile.setProfileName(name);
		return profileService.updateProfile(profile);
	}
	
	@DELETE
	@Path("/{profileName}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteProfile(@PathParam("profileName") String name)
	{
		profileService.removeProfile(name);
	}

}
