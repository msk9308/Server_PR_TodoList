package com.msk9308.todo.service;

import java.util.List;

import com.msk9308.todo.model.TodoVO;

public interface TodoService {
	
	public List<TodoVO> selectAll();
	public Integer insert(TodoVO tdVO);

}
