import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DemoServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		//String path = "/home/sabrin-pt4677/eclips-workspace/demo1/src/main/webapp/index.html";
		
		String name = getServletContext().getInitParameter("path");
		File f = new File(name);
		PrintWriter p = res.getWriter();
		p.println("<html><head>\n"
				+ "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n"
				+ "<script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>"
				+ "</head>\n<body>");
		File arr[]=f.listFiles();
		for(File a:arr) {
			if(a.isFile()) {
				p.println("<i class='far fa-file' style='font-size:24px'></i>");
				p.println("<a href=\""+a.getName()+"\">"+a.getName()+"</a><br>");
			}
			if(a.isDirectory()) {
					p.println("<i class='far fa-folder-open' style='font-size:24px'></i>"
							+ "<a href=\""+a.getName()+"\">"+a.getName()+"</a><br>");
			}
		}
		p.println("</body></html>");
	}
}