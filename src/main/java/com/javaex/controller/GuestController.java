package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
		
		List<PersonVo> pList = guestbookDao.getPersonList();
		
		model.addAttribute("pList", pList);
		
		return "addList";
	}	
	
//	insert ---------------------------------------------------------------------------------
	
	@RequestMapping("/insert")
	public String insert(@ModelAttribute PersonVo personVo) {
		guestbookDao.guestBookInsert(personVo);
		System.out.println(personVo);
		return "redirect:/guestbook/list";
	}
	
	
//	update ---------------------------------------------------------------------------------
	
//	@RequestMapping("/update")
//	public String update()
	
	
	
//	delete ---------------------------------------------------------------------------------
	
	@RequestMapping("/deleteForm/{no}")
	public String deleteForm(Model model, @RequestParam("no") int num) {
		model.addAttribute("num", num);
		
		return "deleteForm";
	}
	
	@RequestMapping("/delete/{no}")
	public String delete(@RequestParam("no") int no, @RequestParam("pw") String pw) {
		
		guestbookDao.guestBookDelete(no, pw);
		
		return "redirect:/guestbook/list";
	}
	
	
	
	
}
