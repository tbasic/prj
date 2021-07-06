package notice.controller.customer;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.dao.NoticeDao;
import notice.vo.Notice;

public class NoticeDetailController {
	
	public void execute(HttpServletRequest request,HttpServletResponse response) 
			throws Exception {
		System.out.println("NoticeDetailController");
		String seq=request.getParameter("c");

		NoticeDao dao=new NoticeDao();
		Notice n=dao.getNotice(seq);
		
//		request에 n을 저장
		request.setAttribute("n", n);
//		jsp로 forward
		request.getRequestDispatcher("noticeDetail.jsp").forward(request, response);

	}

}
