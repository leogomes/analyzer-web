package org.raul.web;

import java.util.Map;

import net.sf.json.JSONObject;

import org.raul.analyzer.Maluco;

class Processor {

	private Maluco maluco;

	Processor(Maluco m) {
		this.maluco = m;
	}

	Processor() {
		this.maluco = new Maluco();
	}

	String getMessagesAsJson(String team) {
		Map msgs = maluco.analyzeFor(team);
		return JSONObject.fromObject(msgs).toString();
	}

}
