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
		if (subPath.equals("/insert")) {
			TodoVO tdVO = new TodoVO();
			SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat st = new SimpleDateFormat("HH:mm:ss");
			Date date = new Date(System.currentTimeMillis());
			tdVO.setTd_num(0);
			tdVO.setTd_date(subPath);
			tdVO.setTd_time(subPath);
			req.setAttribute("TD", tdVO);

		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		System.out.println("11111");
		String subPath = req.getPathInfo();
		System.out.println("2222222222");
		System.out.println(subPath);
		System.out.println("3333333");
		String td_num = req.getParameter("td_num");
		String td_date = req.getParameter("td_date");
		System.out.println("4444444");
		String td_time = req.getParameter("td_time");
		String td_work = req.getParameter("td_work");
		String td_place = req.getParameter("td_place");
		TodoVO tdVO = new TodoVO();
		System.out.println("55555555");

		tdVO.setTd_work(td_work);
		System.out.println("6666666");
		tdVO.setTd_date(td_date);
		tdVO.setTd_time(td_time);
		tdVO.setTd_place(td_place);
		System.out.println("777777");
		if (subPath.equals("/insert")) {
			System.out.println("5555");
			tdService.insert(tdVO);
			resp.sendRedirect("/todo/");

		}

	}
}
