package org.daniel.keeptrack.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.daniel.keeptrack.database.DatabaseClass;
import org.daniel.keeptrack.model.Message;

public class MessageService {
	
	private Map<Long,Message> messages=DatabaseClass.getMessages();
	
	public MessageService()
	{
		messages.put(1L,new Message(1,"Hello world","Daniel"));
		messages.put(2L,new Message(2,"Hello Jersey","Daniel"));
		
	}
	
	public List<Message> getAllMessages()
	{
		return new ArrayList(messages.values());
		
	}
	
	public List<Message> getAllMessageForYear(int year)
	{
		List<Message> messageForYear=new ArrayList<>();
		Calendar cal=Calendar.getInstance();
		for(Message message:messages.values())
		{
			cal.setTime(message.getCreated());
			if(cal.get(Calendar.YEAR)==year)
			{
				messageForYear.add(message);
			}
		}
		
		return messageForYear;
	}
	
	public List<Message> getAllMessagesPaginated(int start,int size)
	{
		ArrayList<Message> list= new ArrayList<Message>(messages.values());
		if((start+size)>list.size())
		{
			return new ArrayList<Message>();
		}
		return list.subList(start, start+size);
	}
	
	public Message getMessage(long id)
	{
		return messages.get(id);
	}
	
	public Message addMessage(Message message)
	{
		message.setId(messages.size()+1);
		messages.put(message.getId(),message);
		return message;
	}
	
	public Message updateMessage(Message message)
	{
		if(message.getId()<=0)
		{
			return null;
		}
		
		messages.put(message.getId(),message);
		return message;
	}
	
	public Message removeMessage(long id)
	{
		return messages.remove(id);
	}

}