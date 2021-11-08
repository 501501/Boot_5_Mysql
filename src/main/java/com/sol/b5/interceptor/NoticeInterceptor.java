package com.sol.b5.interceptor;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.sol.b5.member.MemberVO;

@Component
public class NoticeInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		boolean check = false;
		
		HttpSession session = request.getSession();
		MemberVO memberVO = (MemberVO) session.getAttribute("member");
		
		if (memberVO != null && memberVO.getRole().equals("A")) {
			check = true;
		} else {
			//response.sendRedirect("../member/memberLogin");
			request.setAttribute("msg", "관리자만 가능합니다.");
			request.setAttribute("path", "./selectList");
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/result.jsp");
			view.forward(request, response);
		}
		
		return check;
	}
	
}
