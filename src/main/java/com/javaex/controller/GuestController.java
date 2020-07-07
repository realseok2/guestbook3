package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.dao.GuestbookDao;
import com.javaex.vo.PersonVo;

@Controller
@RequestMapping("/guest")
public class GuestController {

	@Autowired
	private GuestbookDao guestbookDao;
	
//	list ---------------------------------------------------------------------------------

	@RequestMapping(value = "/list", method = {RequestMethod.GET, RequestMethod.POST})
	public String list(Model model) {		
		List<PersonVo> pList = guestbookDao.getPersonList();
		
		model.addAttribute("pList", pList);
		
		return "addList";
	}	
	
//	insert ---------------------------------------------------------------------------------
	
	@RequestMapping("/insert")
	public String insert(@ModelAttribute PersonVo personVo) {
		guestbookDao.guestbookInsert(personVo);
		System.out.println(personVo);
		return "redirect:/guest/list";
	}
	
//	delete ---------------------------------------------------------------------------------
	
	@RequestMapping("/deleteForm/{no}")
	public String deleteForm(Model model, @RequestParam("no") int no) {
		System.out.println("deleteForm");
		model.addAttribute("no", no);
		
		return "deleteForm";
	}
	
	@RequestMapping("/delete")
	public String delete(@ModelAttribute PersonVo personVo) {
		System.out.println("delete");
		
		guestbookDao.guestbookDelete(personVo.getNo(), personVo.getPw());

		return "redirect:/guest/list";
	}
	
////update ---------------------------------------------------------------------------------
//
////@RequestMapping("/update")
////public String update()
//
//
//
	
	
}
