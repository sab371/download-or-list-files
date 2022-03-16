import java.io.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;  

@WebServlet("/*")
public class DownloadServlet extends HttpServlet {  
  
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
  
			PrintWriter out = response.getWriter();
			String url = request.getRequestURI().replaceAll("%20", " ");
			String filename="";
			System.out.println(url);
			if(!url.equals("/")) {
				String segments[] = url.split("/");
				System.out.println(segments.length);
				filename=segments[segments.length-1];
				System.out.println(filename);
			}
			//else url="/";
			String fpath = getServletContext().getInitParameter("path");
			File f = new File(fpath+url);
			if(f.isFile()) {
				
				response.setContentType("APPLICATION/OCTET-STREAM");   
				response.setHeader("Content-Disposition","attachment; filename=\"" + filename + "\"");   
	  
				FileInputStream fileInputStream = new FileInputStream(fpath+url);  
	            
				int i;   
				while ((i=fileInputStream.read()) != -1) {  
					out.write(i);   
				}   
				fileInputStream.close();   
				out.close();
			}
			else {
				out.println("<html><head>\n"
						+ "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n"
						+ "<script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>"
						+ "</head>\n<body>");
				File arr[]=f.listFiles();
				for(File a:arr) {
					if(a.isFile()) {
						out.println("<i class='far fa-file' style='font-size:24px'></i>");
						out.println("<a href=\""+filename+"/"+a.getName()+"\">"+a.getName()+"</a><br>");
					}
					if(a.isDirectory()) {
							out.println("<i class='far fa-folder-open' style='font-size:24px'></i>"
									+ "<a href=\""+filename+"/"+a.getName()+"\">"+a.getName()+"</a><br>");
					}
				}
				out.println("<form action=\"../\" method=\"get\">"
						+ "<input type=\"submit\" value=\"Back\">"
						+ "</form>");
				out.println("</body></html>");
			}		   
	}
}