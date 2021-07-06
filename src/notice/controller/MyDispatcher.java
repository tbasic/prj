package notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.controller.customer.NoticeDetailController;

public class MyDispatcher extends HttpServlet {
	
	protected void doService(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("doGetdoPost 모두받기");
		String uri=request.getRequestURI();
		String conPath=request.getContextPath();
		String com=uri.substring(conPath.length());
		
		
		System.out.println("uri : "+uri);
		System.out.println("conPath : "+conPath);
		System.out.println("com : "+com);
		
		NoticeDetailController controller1=new NoticeDetailController();
		
		try {
			if(com.equals("/customer/noticeDetail.do")) {
				controller1.execute(request, response);
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doService(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doService(request, response);
	}
	
	
	

}
