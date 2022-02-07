package com.test.view;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.biz.TestproductDAO;
import com.test.model.TestproductVO;

@WebServlet("/GetTestproductListCtrl2")
public class GetTestproductListCtrl2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		TestproductDAO dao = new TestproductDAO();
		ArrayList<TestproductVO> testproductList2 = dao.getTestproductList();
		
		System.out.println(testproductList2);	
		
		request.setAttribute("testproductList2", testproductList2);	//보낼 객체를 선언
		RequestDispatcher view = request.getRequestDispatcher("/product/getTestproductList2.jsp");	//보내질 곳 선언
		view.forward(request, response);  //실제 보낼 객체를 보내질 곳에 송신
	}
}