package com.ibm.bluemix.shifttracking.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.ibm.bluemix.shifttracking.beans.UserIDBean;
import com.ibm.bluemix.shifttracking.dao.impl.UserIDDAO;
import com.ibm.commons.util.io.json.JsonException;
import com.ibm.commons.util.io.json.JsonFactory;
import com.ibm.commons.util.io.json.JsonGenerator;
import com.ibm.commons.util.io.json.JsonJavaFactory;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private final static String KEY_ACTION = "action";

	private static enum Action {
		Search("search"), Add("add"), Remove("remove"), GetAll("getall");
		String action;

		private Action(String action) {
			this.action = action;
		}

		public boolean equals(String value) {
			return action.equals(value);
		}
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String action = request.getParameter(KEY_ACTION);
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();

		if (Action.GetAll.equals(action)) {
			doGetAllUsers(request, out);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	private void doGetAllUsers(HttpServletRequest request, PrintWriter out)
			throws IOException {
		UserIDDAO dao = new UserIDDAO();
		List<UserIDBean> allusers = dao.getAllUsers();
		JSONArray json = new JSONArray();
		try {
			for (UserIDBean o : allusers) {
				JSONObject jsono = new JSONObject();
				jsono.put("userid", o.getUserID());
				jsono.put("password", "password");
				jsono.put("answer", o.getAnswer());
				json.put(jsono);
			}
		} catch (JSONException e) {
			e.printStackTrace();
		} finally {
			out.write(json.toString());
			out.close();
		}

	}

}
