package org.raul.web;

import static junit.framework.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import junit.framework.Assert;

import org.apache.commons.logging.Log;
import org.junit.Test;
import org.raul.analyzer.Maluco;
import org.raul.model.Message;

public class ProcessorTest {

	@Test
	public void shouldProperlyConvertToJson() {
		
		Maluco maluco = mock(Maluco.class);
		
		Map<String, List<Message>> msgs = new HashMap<String, List<Message>>();
		
		List<Message> list = new ArrayList<Message>();
		list.add(Message.info().title("Message 1").addTag("DWM"));
		list.add(Message.info().title("Message 2").addTag("Urgent"));
		list.add(Message.info().title("Message 3").details("FriendlyURL").addTag("DWM"));
		
		msgs.put("PTR 12345", list);
		
		when(maluco.analyzeFor("FRW")).thenReturn(msgs);
		
		Processor p = new Processor(maluco);
		
		String messagesAsJson = p.getMessagesAsJson("FRW");
		
		assertNotNull(messagesAsJson);
		System.out.println(messagesAsJson);
		
	}

}
