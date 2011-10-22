package org.raul.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Messages
 */
public class Messages extends HttpServlet {
	
	private static final String TEAM_PARAMETER = "team";
	
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String team = request.getParameter(TEAM_PARAMETER);
		
		Processor proc = new Processor();
		String json = proc.getMessagesAsJson(team);
		
		createResponse(response, json);
	}
	


	private void createResponse(HttpServletResponse response, String json)
			throws IOException {
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.print(json);
		out.flush();
	}


}
