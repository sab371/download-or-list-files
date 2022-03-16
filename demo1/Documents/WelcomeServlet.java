import java.io.PrintStream;
import javax.servlet.*;

class WelcomeServlet extends GenericServlet{
	public void service(ServletRequest request, ServletResponse response) throws IOException,ServletException{
		response.setContentType("text/html");
		PrintStream p = response.getWriter();
		p.println("<b>Hello!</b>");
		p.close();
	}
}
