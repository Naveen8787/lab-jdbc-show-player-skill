package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Skill;
import utility.ConnectionManager;

public class SkillDAO{

	public List<Skill> listAll_Skills () throws Exception {
		List<Skill> list=new ArrayList<Skill>();
		
		Skill skill = null;
		
		Connection con=ConnectionManager.getConnection();
		
		Statement st=con.createStatement();
		String sql="select name from Skill1";
		ResultSet rs=st.executeQuery(sql);	
		
		while(rs.next()) {
			skill = new Skill();
			//System.out.println(rs.getString("name"));
			skill.setSkillName(rs.getString("name"));
			list.add(skill);
		}
		
		rs.close();
		st.close();
		con.close();
		return list;
		
	}
}