package com.msk9308.todo.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.msk9308.todo.config.DBInfo;
import com.msk9308.todo.model.TodoVO;
import com.msk9308.todo.service.TodoService;
import com.msk9308.todo.service.TodoServiceImplV1;

@WebServlet("/todo/*")
public class TodoController extends HttpServlet {

	protected TodoService tdService;

	public TodoController() {
		tdService = new TodoServiceImplV1();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String subPath = req.getPathInfo();
		if(subPath.equals("/insert")) {
			TodoVO tdVO = new TodoVO();
			SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date(System.currentTimeMillis());
			tdVO.setTd_num(0);
			
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String td_num = req.getParameter(DBInfo.td_num);
		String td_work = req.getParameter(DBInfo.td_work);
		String td_date = req.getParameter(DBInfo.td_date);
		String td_place = req.getParameter(DBInfo.td_place);
		
		TodoVO tdVO = new TodoVO();
//		tdVO.setTd_num(td_num);
		tdVO.setTd_work(td_work);
		tdVO.setTd_date(td_date);
		tdVO.setTd_place(td_place);
		
		resp.sendRedirect("/todo/");
		
	}

}