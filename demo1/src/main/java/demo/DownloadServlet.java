package demo;
import java.io.*;  
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;  
@WebServlet("/Document/*")
public class DownloadServlet extends HttpServlet {  
  
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
  
		 
			PrintWriter out = response.getWriter();
			String url = request.getRequestURI();
			System.out.println(url);
			String filename=null;
			filename=url.substring(17);
			System.out.println(filename);
			String fpath = getServletContext().getInitParameter("path");
		
			response.setContentType("APPLICATION/OCTET-STREAM");   
			response.setHeader("Content-Disposition","attachment; filename=\"" + filename + "\"");   
  
			FileInputStream fileInputStream = new FileInputStream(fpath+"/"+filename);  
            
			int i;   
			while ((i=fileInputStream.read()) != -1) {  
				out.write(i);   
			}   
			fileInputStream.close();   
			out.close();   
	}  
  
} 
