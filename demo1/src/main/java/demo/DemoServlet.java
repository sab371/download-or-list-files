package demo;

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
				+ "<title>Font Awesome Icons</title>\n"
				+ "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n"
				+ "<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\n"
				+ "</head>\n<body>");
		File arr[]=f.listFiles();
		for(File a:arr) {
			if(a.isFile()) {
				p.println("<i class=\"fa fa-file\" style='color:blue'></i>");
				p.println(a.getName());
				p.println("<a href=\"Documents/"+a.getName()+"\">Click here to download</a><br>");
			}
			if(a.isDirectory()) {
					p.println("<a href=\"/demo/"+a.getName()+"\">"+a.getName()+"</a><br>");
			}
		}
		p.println("</body></html>");
	}
}

