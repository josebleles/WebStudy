package br.com.Univercode.WebStudy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


import br.com.Univercode.WebStudy.domain.Domain;
import br.com.Univercode.WebStudy.domain.TypeUser;
import br.com.Univercode.WebStudy.domain.User;

public class UserDAO implements IDAO{

	@Override
	public void save(Domain obj) {
		Connection conn = null;
		try {
			String sql = "INSERT INTO tb_user ( name_user, login_user , password_user, type_user) "
					+ "VALUES ( ? , ? , ? , ? )";
			conn = MyConnection.getConnection();
			
			PreparedStatement pstm = conn.prepareStatement(sql);
			User user = (User) obj;
			pstm.setString(1, user.getName());
			pstm.setString(2, user.getLogin());
			pstm.setString(3, user.getPassword());
			pstm.setString(4, user.getType().toString());
			
			pstm.execute();
			
		} catch (Exception e) {
			obj = null;
			System.out.println(e.getMessage());
		}finally{
			MyConnection.closeConnection(conn);
		}
	}

	@Override
	public void update(Domain obj) {
		Connection conn = null;
		try {
			String sql = "UPDATE tb_user "
					+ "set name_user =?"
					+ ", login_user =?"
					+ ", password_user=?"
					+ ", acess_lvl_user =? "
					+ "WHERE cod_user =? ";
			conn = MyConnection.getConnection();
			
			PreparedStatement pstm = conn.prepareStatement(sql);
			User user = (User) obj;
			pstm.setString(1, user.getName());
			pstm.setString(2, user.getLogin());
			pstm.setString(3, user.getPassword());
			pstm.setString(4, user.getType().toString());
			pstm.setInt(5, user.getId());
			pstm.execute();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally{
			MyConnection.closeConnection(conn);
		}
	}

	@Override
	public void delete(int id) {
		String sql = "DELETE FROM tb_user where cod_user = ? ";
		Connection con = MyConnection.getConnection();
		try {
			PreparedStatement psmt = con.prepareStatement(sql);
			psmt.setInt(1, id);
			psmt.execute();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally{
			MyConnection.closeConnection(con);
		}
	}

	@Override
	public Domain findById(int id) {
		String sql = "SELECT * FROM tb_user where cod_user = ? ";
		Connection con = MyConnection.getConnection();
		User user = null;
		try {
			PreparedStatement psmt = con.prepareStatement(sql);
			psmt.setInt(1, id);
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				user = new User(rs.getInt("cod_user")
						,rs.getString("name_user")
						,rs.getString("login_user")
						,rs.getString("password_user")
						,UserDAO.getTypeUser(rs.getString("acess_lvl_user")));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally{
			MyConnection.closeConnection(con);
		}
		return user;
	}

	@Override
	public ArrayList<Domain> list() {
		Connection conn = MyConnection.getConnection();
		try {
			ArrayList<Domain> domains = new ArrayList<Domain>();
			String sql = "select * from tb_user";
			PreparedStatement pstm = conn.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while(rs.next()){
				User user = new User(rs.getInt("cod_user")
						,rs.getString("name_user")
						,rs.getString("login_user")
						,rs.getString("password_user")
						,getTypeUser(rs.getString("acess_lvl_user")));
				domains.add(user);
			}
			return domains;
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally{
			MyConnection.closeConnection(conn);
		}
		return null;
	}
	
	public static TypeUser getTypeUser(String type){
		return type.equals(TypeUser.TEACHER.toString())?TypeUser.TEACHER:TypeUser.STUDENT;
	}

}
