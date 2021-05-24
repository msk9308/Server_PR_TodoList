package com.msk9308.todo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.msk9308.todo.model.TodoVO;
import com.msk9308.todo.service.TodoService;
import com.msk9308.todo.service.TodoServiceImplV1;

@WebServlet("/")
public class HomeController extends HttpServlet{
	
	protected TodoService tdService;
	public HomeController() {
		tdService = new TodoServiceImplV1();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<TodoVO> tdList = tdService.selectAll();
		req.setAttribute("TDLIST", tdList);
		req.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(req, resp);
	
	}

	
}
