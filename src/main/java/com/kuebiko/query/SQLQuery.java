package com.kuebiko.query;

public interface SQLQuery {
	public static String DELETE_MOVIE_BY_NAME="delete from movie_tbl where name = ?";
	public static String INSERT_MOVIE="insert into movie_tbl(name,year,rating,budget,teams,createdate) values(?,?,?,?,?,?)";
	public static String UPDATE_MOVIE="update movie_tbl set year =?, budget=?  where name =?";
	public static String SELECT_ALL_MOVIE="select mid,name,year,rating,budget,teams,createdate from movie_tbl";
	
	
	public static String INSERT_SIGNUP="insert into signup_tbl(username,password,email,name,salutation,datecreated) values(?,?,?,?,?,?)";
	public static String UPDATE_SIGNUP_BY_SID="update signup_tbl set username=?,password=?,email=?,name=?,salutation=? where sid=?";
	public static String DELETE_SIGNUP="delete from signup_tbl where sid=?";
	
	public static String SELECT_SIGNUP_USERNAME_PASSWORD="select  username,password,email,"
			+ "name,salutation,datecreated,role from signup_tbl  where username  = ? and password=? ";
	public static String SELECT_SIGNUPS="select sid,username,password,email,name,salutation,datecreated from signup_tbl";
	public static String SELECT_SIGNUPS_SID="select sid,username,password,email,name,salutation,datecreated from signup_tbl where sid=?";
}

