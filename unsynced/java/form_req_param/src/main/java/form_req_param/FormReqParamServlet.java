package form_req_param;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Iterator;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class FormReqParamServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Enumeration<String> params = req.getParameterNames();
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		for (Iterator<String> iterator = params.asIterator(); iterator.hasNext();) {
			String param = iterator.next();
			out.println(param + ": " + req.getParameter(param) + "<br />");
		}
		out.close();
	}

}
