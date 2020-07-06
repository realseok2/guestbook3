package com.javaex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.PersonVo;

@Repository
public class GuestbookDao {
	
	@Autowired
	private DataSource dataSource;

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;// select에서만 사용됩니다.


	// Connect 얻어오기
	private void getConnect() {
		try {
			
			conn = dataSource.getConnection();

		} catch (SQLException e) {
			System.out.println("error:" + e);
		}
	}

	// 자원정리
	private void close() {
		try {
			if (rs != null) {
				rs.close();// select에서만 사용됩니다.
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			System.out.println("error:" + e);
		}
	}

	// 게시물 추가----------------------------------------------------------------------------------------

	public void guestBookInsert(PersonVo personVo) {
		getConnect();

		try {

			String query = "INSERT INTO guestbook VALUES (seq_no.nextval, ?, ?, ?, sysdate)";
			pstmt = conn.prepareStatement(query);

			pstmt.setString(1, personVo.getName());
			pstmt.setString(2, personVo.getPw());
			pstmt.setString(3, personVo.getContent());

			int count = pstmt.executeUpdate();

			System.out.println(count + "건 처리되었습니다.");

		} catch (SQLException e) {
			System.out.println("error:" + e);
		}
		close();

	}

	// 게시물 수정----------------------------------------------------------------------------------------

	public int guestBookUpdate(PersonVo personVo) {
		int count = 0;
		getConnect();

		try {

			String query = "";
			query += " update  guestbook ";
			query += " set     name        = ? , ";
			query += "         password    = ? , ";
			query += "         content     = ?  ";
			query += " where   no = ? ";

			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, personVo.getName());
			pstmt.setString(2, personVo.getPw());
			pstmt.setString(3, personVo.getContent());
			pstmt.setInt(4, personVo.getNo());
			
			count = pstmt.executeUpdate();	//------> 업데이트 꼭 해줘야됩니다.....ㅜㅜ

		} catch (SQLException e) {
			System.out.println("error" + e);
		}

		close();
		return count;

	}

	// 게시물 삭제----------------------------------------------------------------------------------------

	public void guestBookDelete(int no, String pw) {
		getConnect();

		try {

			String query = "";
			query += " delete from	guestbook ";
			query += " where		no 			= ? ";
			query += " and			password 	= ? ";

			pstmt = conn.prepareStatement(query);

			pstmt.setInt(1, no);
			pstmt.setString(2, pw);

			int count = pstmt.executeUpdate();

			System.out.println(count + "건 처리되었습니다.");
		} catch (SQLException e) {
			System.out.println("error:" + e);
		}
		close();
	}

	// 게시물 리스트---------------------------------------------------------------------------------------
	public List<PersonVo> getPersonList() {
		getConnect();

		List<PersonVo> personList = new ArrayList<PersonVo>();

		try {

			String query = "";
			query += " SELECT		no, ";
			query += " 				name,";
			query += " 				password,";
			query += " 				content,";
			query += " 				reg_date";
			query += " FROM        	guestbook";
			query += " order by    	no 		asc";

			pstmt = conn.prepareStatement(query);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				int no = rs.getInt("no");
				String name = rs.getString("name");
				String pw = rs.getString("password");
				String content = rs.getString("content");
				String date = rs.getString("reg_date");

				PersonVo personVo = new PersonVo(no, name, pw, content, date);
				personList.add(personVo);
			}

		} catch (SQLException e) {
			System.out.println("error:" + e);

		}
		close();
		return personList;

	}

	// 게시물 정보----------------------------------------------------------------------------------------

	public PersonVo getGuest(int no) {

		PersonVo personVo = null;

		getConnect();
		try {

			String query = ""; // 쿼리문 문자열만들기, ? 주의
			query += " select	no, ";
			query += " 			name, ";
			query += "     		password, ";
			query += "     		content, ";
			query += "     		reg_date ";
			query += " from		guestbook ";
			query += " where	no = ? ";

			pstmt = conn.prepareStatement(query); // 쿼리로 만들기
			pstmt.setInt(1, no);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				int num = rs.getInt("no");
				String name = rs.getString("name");
				String pw = rs.getString("password");
				String content = rs.getString("content");

				personVo = new PersonVo(num, name, pw, content);
			}

		} catch (SQLException e) {
			System.out.println("error:" + e);
		}
		close();
		return personVo;
	}

}