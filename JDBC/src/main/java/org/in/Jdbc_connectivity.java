package org.in;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.cj.xdevapi.Statement;

public class Jdbc_connectivity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String dburl="jdbc:mysql://localhost:3306/employes";
		String user="root";
		String password="Vijayaramesh2@";
		String employee="use employes";
		try {
			Connection conn= DriverManager.getConnection(dburl, user, password);
			if (conn!=null) {
				System.out.println("connection is establised");
			} else {
				System.out.println("connection is not establised");

			}

		java.sql.Statement st=conn.createStatement();
		st.executeUpdate(employee);
		
		String create="create table employes(empid int ,empname varchar(25),empage int,empsalary varchar(20))";
		st.executeUpdate(create);
		String insert="insert into employes(empid,empname,empage,empsalary) values (101,'Jenny',25,'10000'),(102,'Jacky',30,'20000'),(103,'Joe',20,'40000'),(104,'John',40,'80000'),(105,'Shameer',25,'90000')";
		st.executeUpdate(insert);
		String select="select * from employes";
		ResultSet rs=st.executeQuery(select);
		while (rs.next()) {
			System.out.println(rs.getString("empid"));
			System.out.println(rs.getString("empname"));
			System.out.println(rs.getString("empage"));
			System.out.println(rs.getString("empsalary"));
			
		}
		conn.close();
		
		} catch (Exception e) {
			// TODO: handle exception
		}
		

	}

}
