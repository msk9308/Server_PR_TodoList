package com.msk9308.todo.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.msk9308.todo.config.DBInfo;
import com.msk9308.todo.config.OracleConnection;
import com.msk9308.todo.model.TodoVO;

public class TodoServiceImplV1 implements TodoService {
	
	protected Connection dbConn;
	public TodoServiceImplV1() {
		this.dbConn = OracleConnection.getDBConnection();
	}
	
		
	
	
	@Override
	public List<TodoVO> selectAll() {
		PreparedStatement pStr = null;		
		String sql = "SELECT * FROM tbl_todo";
		
		try {
			pStr = dbConn.prepareStatement(sql);
			ResultSet rSet = pStr.executeQuery();
			List<TodoVO> tdList = new ArrayList<TodoVO>();
			
			while(rSet.next()) {
				
				TodoVO tdVO = new TodoVO();
				tdVO.setTd_num(rSet.getInt("td_num"));
				tdVO.setTd_work(rSet.getString("td_work"));
				tdVO.setTd_date(rSet.getString("td_date"));
				tdVO.setTd_time(rSet.getString("td_time"));
				tdVO.setTd_place(rSet.getString("td_place"));
				tdList.add(tdVO);
				System.out.println(tdList.toString());
				
				
			}
			
			rSet.close();
			pStr.close();
			return tdList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Integer insert(TodoVO tdVO) {
		String sql = " INSERT INTO tbl_todo ";
		sql += "(td_num,";
		sql += "td_work,";
		sql += "td_date,";
		sql += "td_time,";
		sql += "td_place)";
		sql += " VALUES(seq.nextval,?,?,?,?)";
		PreparedStatement pStr = null;
		System.out.println(tdVO);
		System.out.println(sql);
		
		try {
			pStr = dbConn.prepareStatement(sql);
//			pStr.setInt(0,tdVO.getTd_num());
			pStr.setString(1, tdVO.getTd_work());
			pStr.setString(2,tdVO.getTd_date());
			pStr.setString(3, tdVO.getTd_time());
			pStr.setString(4, tdVO.getTd_place());
			
			pStr.executeUpdate();
			pStr.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}

}
