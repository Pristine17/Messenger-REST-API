package org.daniel.keeptrack.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.daniel.keeptrack.database.DatabaseClass;
import org.daniel.keeptrack.model.Message;
import org.daniel.keeptrack.model.Profile;

public class ProfileService {
	
private Map<String,Profile> profiles=DatabaseClass.getProfiles();
	
	


	public ProfileService()
	{
		profiles.put("Creator",new Profile(1,"Creator","Daniel","David"));
		profiles.put("Admin",new Profile(2,"Admin","YOLO","SWAG"));
		
	}
	
	public List<Profile> getAllProfiles()
	{
		return new ArrayList(profiles.values());
		
	}
	
	public Profile getProfile(String name)
	{
		return profiles.get(name);
	}
	
	public Profile addProfile(Profile profile)
	{
		profile.setId(profiles.size()+1);
		profiles.put(profile.getProfileName(),profile);
		return profile;
	}
	
	public Profile updateProfile(Profile profile)
	{
		if(profile.getId()<=0)
		{
			return null;
		}
		
		profiles.put(profile.getProfileName(),profile);
		return profile;
	}
	
	public Profile removeProfile(String name)
	{
		return profiles.remove(name);
	}

}
