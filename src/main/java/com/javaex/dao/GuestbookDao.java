package com.javaex.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.PersonVo;

@Repository
public class GuestbookDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	
	// 게시물 리스트---------------------------------------------------------------------------------------
	public List<PersonVo> getPersonList() {

		List<PersonVo> personList = sqlSession.selectList("guestbook.selectList");
		System.out.println(personList);

		return personList;
		

	}
	

	// 게시물 추가----------------------------------------------------------------------------------------

	public int guestbookInsert(PersonVo personVo) {
		int count = sqlSession.insert("guestbook.insert", personVo);
		return count;
	}

	
	// 게시물 삭제----------------------------------------------------------------------------------------

	public void guestbookDelete(int no, String pw) {
		System.out.println("dao.delete");
		
		Map<String, Object> gMap = new HashMap<String, Object>();
		gMap.put("no", no);
		gMap.put("pw", pw);
		sqlSession.delete("guestbook.delete", gMap);
	}
	
	
//	// 게시물 수정----------------------------------------------------------------------------------------
//
//	public int guestBookUpdate(PersonVo personVo) {
//		int count = 0;
//		getConnect();
//
//		try {
//
//			String query = "";
//			query += " update  guestbook ";
//			query += " set     name        = ? , ";
//			query += "         password    = ? , ";
//			query += "         content     = ?  ";
//			query += " where   no = ? ";
//
//			pstmt = conn.prepareStatement(query);
//			
//			pstmt.setString(1, personVo.getName());
//			pstmt.setString(2, personVo.getPw());
//			pstmt.setString(3, personVo.getContent());
//			pstmt.setInt(4, personVo.getNo());
//			
//			count = pstmt.executeUpdate();	//------> 업데이트 꼭 해줘야됩니다.....ㅜㅜ
//
//		} catch (SQLException e) {
//			System.out.println("error" + e);
//		}
//
//		close();
//		return count;
//
//	}
//

//
//
//
//	// 게시물 정보----------------------------------------------------------------------------------------
//
//	public PersonVo getGuest(int no) {
//
//		PersonVo personVo = null;
//
//		getConnect();
//		try {
//
//			String query = ""; // 쿼리문 문자열만들기, ? 주의
//			query += " select	no, ";
//			query += " 			name, ";
//			query += "     		password, ";
//			query += "     		content, ";
//			query += "     		reg_date ";
//			query += " from		guestbook ";
//			query += " where	no = ? ";
//
//			pstmt = conn.prepareStatement(query); // 쿼리로 만들기
//			pstmt.setInt(1, no);
//
//			rs = pstmt.executeQuery();
//
//			while (rs.next()) {
//				int num = rs.getInt("no");
//				String name = rs.getString("name");
//				String pw = rs.getString("password");
//				String content = rs.getString("content");
//
//				personVo = new PersonVo(num, name, pw, content);
//			}
//
//		} catch (SQLException e) {
//			System.out.println("error:" + e);
//		}
//		close();
//		return personVo;
//	}

}