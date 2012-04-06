package org.cloudfoundry.samples;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CounterIncrementServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("Request received to increment counter");
		List<String> requestParameterNames = Collections
				.list((Enumeration<String>) req.getParameterNames());

		for (String parameterName : requestParameterNames) {
			System.out.println("parameter name = " + parameterName);
			if (parameterName != null && "delta".equals(parameterName)) {
				String deltaString = req.getParameter("delta");
				int delta = Integer.parseInt(deltaString);
				int finalCounter = CounterDAO.incrementContactsCounterBy(delta);
				response.setContentType("application/json");
				response.setStatus(200);
				PrintWriter writer = response.getWriter();
				System.out.println("counter incremented by " + delta);
				System.out.println("Final counter = " + finalCounter);

				String responseString = "{\"counter\":" + "\"" + finalCounter
						+ "\"}";

				writer.println(responseString);

				writer.close();
				return;
			} else if (parameterName != null
					&& "plansShown".equals(parameterName)) {
				String deltaString = req.getParameter("plansShown");
				int delta = Integer.parseInt(deltaString);
				int finalCounter = CounterDAO.incrementSTPCounterBy(
						delta);
				response.setContentType("application/json");
				response.setStatus(200);
				PrintWriter writer = response.getWriter();
				System.out.println("STP counter incremented by " + delta);
				System.out.println("Final STP counter = " + finalCounter);

				String responseString = "{\"totalPlans\":" + "\""
						+ finalCounter + "\"}";
				writer.println(responseString);
				writer.close();
				return;
			}

		}

	}

}
