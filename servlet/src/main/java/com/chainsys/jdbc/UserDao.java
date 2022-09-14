package com.chainsys.jdbc;

    import java.util.*;  
	import java.sql.*;  
	  
	public class UserDao {
	  
	    public static Connection getConnection(){  
	        Connection con=null;  
	        try{  
	            Class.forName("oracle.jdbc.driver.OracleDriver");  
	            con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","akshacsys18");  
	        }catch(Exception e){System.out.println(e);}  
	        return con;  
	    }  
	    public static int save(Userdata e){  
	        int status=0;  
	        try{  
	            Connection con=UserDao.getConnection();  
	            PreparedStatement ps=con.prepareStatement(  "insert into userdata(user_Id,name,password,email,country) values (?,?,?,?,?)");  
	            ps.setInt(1, e.getUserId());
	            ps.setString(2,e.getName());  
	            ps.setString(3,e.getPassword());  
	            ps.setString(4,e.getEmail());  
	            ps.setString(5,e.getCountry());  
	              
	            status=ps.executeUpdate();  
	              
	            con.close();  
	        }catch(Exception ex){ex.printStackTrace();}  
	          
	        return status;  
	    }  
	    public static int update(Userdata e){  
	        int status=0;  
	        try{  
	            Connection con=UserDao.getConnection();  
	            PreparedStatement ps=con.prepareStatement(  
	                         "update userdata set name=?,password=?,email=?,country=? where user_Id=?");  
	            
	         //   ps.setInt(1, e.getUserId());
	            ps.setString(1,e.getName());  
	            ps.setString(2,e.getPassword());  
	            ps.setString(3,e.getEmail());  
	            ps.setString(4,e.getCountry()); 
	            
	            ps.setInt(5, e.getUserId());
	            status=ps.executeUpdate(); 
	            
	            con.close();  
	        }catch(Exception ex){ex.printStackTrace();}  
	          
	        return status;  
	    }  
	    public static int delete(int id){  
	        int status=0;  
	        try{  
	            Connection con=UserDao.getConnection();  
	            PreparedStatement ps=con.prepareStatement("delete from userdata where user_id=?");  
	            ps.setInt(1,id);  
	            status=ps.executeUpdate();  
	              
	            con.close();  
	        }catch(Exception e){e.printStackTrace();}  
	          
	        return status;  
	    }  
	    public static Userdata getUserById(int id){  
	    	Userdata e=new Userdata();  
	          
	        try{  
	            Connection con=UserDao.getConnection();  
	            PreparedStatement ps=con.prepareStatement("select * from userdata where user_id=?");  
	            ps.setInt(1,id);  
	            ResultSet rs=ps.executeQuery();  
	            if(rs.next()){  
	                e.setUserId(rs.getInt(1));  
	                e.setName(rs.getString(2));  
	                e.setPassword(rs.getString(3));  
	                e.setEmail(rs.getString(4));  
	                e.setCountry(rs.getString(5));  
	            }  
	            con.close();  
	        }catch(Exception ex){ex.printStackTrace();}  
	          
	        return e;  
	    }  
	    public static List<Userdata> getAllUsers(){  
	        List<Userdata> list=new ArrayList<Userdata>();  
	          
	        try{  
	            Connection con=UserDao.getConnection();  
	            PreparedStatement ps=con.prepareStatement("select * from userdata");  
	            ResultSet rs=ps.executeQuery();  
	            while(rs.next()){  
	                Userdata e=new Userdata();  
	                e.setUserId(rs.getInt(1));  
	                e.setName(rs.getString(2));  
	                e.setPassword(rs.getString(3));  
	                e.setEmail(rs.getString(4));  
	                e.setCountry(rs.getString(5));  
	                list.add(e);  
	            }  
	            con.close();  
	        }catch(Exception e){e.printStackTrace();}  
	          
	        return list;  
	    }  
	}  


