package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javaex.dao.GuestbookDao;
import com.javaex.vo.PersonVo;

@Controller
@RequestMapping("/guestbook")
public class GuestController {

	@Autowired
	private GuestbookDao guestbookDao;
	
//	list ---------------------------------------------------------------------------------

	@RequestMapping(value = "/list", method = {RequestMethod.GET, RequestMethod.POST})
	public String list(Model model) {
		System.out.println("/gb3/guestbook/list");
		
		List<PersonVo> pList = GuestbookDao.getPersonList();
	}
	
	
	
	
	
	
	
	
	
//	insert ---------------------------------------------------------------------------------
	
	
//	update ---------------------------------------------------------------------------------
	
	
	
	
	
//	delete ---------------------------------------------------------------------------------
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
