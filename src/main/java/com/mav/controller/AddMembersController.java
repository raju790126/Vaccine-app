package com.mav.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mav.dao.AddMemberImpl;
import com.mav.entity.AddMemberEntity;
import com.mav.entity.RegisterEntity;

@Controller
public class AddMembersController {
	
	private AddMemberImpl addmember;
	public AddMembersController() {
		System.out.println("Default constructor of addMember");
	}

	@Autowired
	public AddMembersController(AddMemberImpl addmember) {
		super();
		this.addmember = addmember;
	}

	
	@RequestMapping(value = "/backToHome")
	public String goToHome()
	{
		return "/WEB-INF/homepage.jsp";
	}
	@RequestMapping(value = "/backToHome2")
	public String goToHome2()
	{
		return "/WEB-INF/homepage.jsp";
	}
	
	@RequestMapping(value = "/backToViewmembers")
	public String goToViewMembers()
	{
		return "/WEB-INF/viewmembers.jsp";
	}
	
	@RequestMapping(value = "/addmembers")
	public String addMemberPage(HttpServletRequest req, Model model)
	{
		HttpSession session = req.getSession();
		RegisterEntity check = (RegisterEntity)session.getAttribute("Mainentity");
		if(check.getMembercount()<= 3)
		{
			return "/WEB-INF/addmember.jsp";
		}
		else
		{
			model.addAttribute("message", "Your adding memebers limit is 4 it's fulled, you can't add member");
			return"/WEB-INF/homepage.jsp";
		}
	}
	
	@RequestMapping(value = "/saveTheMember")
	public String saveMember(@RequestParam String memname, @RequestParam String gender,@RequestParam String birth,
			@RequestParam String idProof,@RequestParam String proofno,@RequestParam String vaccType,@RequestParam int dose,
			Model model, HttpServletRequest req)
	{
		System.out.println("Invoked into saveMember()");
		HttpSession session = req.getSession();
		String email = (String) session.getAttribute("email");
		System.out.println(email);
		System.out.println(memname);
		System.out.println(gender);
		System.out.println(birth);
		System.out.println(idProof);
		System.out.println(proofno);
		System.out.println(vaccType);
		AddMemberEntity memberEntity = new AddMemberEntity(email, memname, gender, birth, idProof, proofno, vaccType, dose);
		if(addmember.saveAddMember(memberEntity))
		{
			addmember.updateRegisterMember((RegisterEntity)session.getAttribute("Mainentity"));
				model.addAttribute("message", "Successfully saved the details");
				return "/WEB-INF/addmember.jsp";
		}
		else
		{
			model.addAttribute("message", "Something went wrong Please try again!!!!");
			return "/WEB-INF/addmember.jsp";
		}
		
	}
	
	@RequestMapping(value = "/viewmembers")
	public String viewMembers(Model model,HttpServletRequest req)
	{
		System.out.println("Invoked into viewMembers()");
		HttpSession session = req.getSession();
		RegisterEntity obj = (RegisterEntity) session.getAttribute("Mainentity");
		System.out.println((String)session.getAttribute("email"));
		List<AddMemberEntity> members = addmember.setAllAddMembers((String)session.getAttribute("email"));
		if(obj.getMembercount()>0)
		{
			System.out.println("list is not null");
			for(AddMemberEntity mem : members)
			{
				System.out.println(mem);
			}
			model.addAttribute("list", members);
			return "/WEB-INF/viewmembers.jsp";
		}
		else
		{
			System.out.println("List is null");
			model.addAttribute("message", "you didn't add atlest one member");
			return "/WEB-INF/viewmembers.jsp";
		}
	}

	@RequestMapping(value = "/editMemberDetails/{id}")
	public String editMemberDetails(@PathVariable int id, Model model, HttpServletRequest req) {
		System.out.println("Invoked into editMemberDetails() Controller");
		
		AddMemberEntity entity = addmember.getDetailsById(id);
		HttpSession session = req.getSession();
		session.setAttribute("id", id);
		if(entity != null) {
			model.addAttribute("name", entity.getMemberName());
			model.addAttribute("gender", entity.getGender());
			model.addAttribute("birth", entity.getBirth());
			model.addAttribute("idproof", entity.getIdProof());
			model.addAttribute("proofno", entity.getProofNo());
			model.addAttribute("vaccinetype", entity.getVaccineType());
			model.addAttribute("dose", entity.getDose());
			
			return "/WEB-INF/editmember.jsp";
		}
		else {
			model.addAttribute("message", "SomeThing went wrong, please try again !!!");
			return "/WEB-INF/viewmembers.jsp";
		}
		
	}
	
	@RequestMapping(value = "/updateMember")
	public String updateMemberDetails(@RequestParam String name,@RequestParam String gender,
			@RequestParam String birth,@RequestParam String idproof,@RequestParam String proofno,
			@RequestParam String vacctype,@RequestParam int dose,Model model,  HttpServletRequest req)
	{
		HttpSession session = req.getSession();
		AddMemberEntity memberEntity = new AddMemberEntity((int)session.getAttribute("id"), (String) session.getAttribute("email"), name, gender, birth, idproof, proofno, vacctype, dose);
		if(addmember.updateMemberDetails(memberEntity))
		{
			return"redirect:/WEB-INF/viewmembers.jsp";
		}
		else
		{
			model.addAttribute("message1", "SomeThing went wrong, please try again !!!");
			return "/WEB-INF/viewmembers.jsp";
			
		}
	}
	
	@RequestMapping(value = "/deleteMember/{id}")
	public String deleteMember(@PathVariable int id,HttpServletRequest req, Model model) {
		
		System.out.println("Invoked into deleteMember contoller");
		HttpSession session = req.getSession();
		if(addmember.deleteMemberDetails(id))
		{
			addmember.decreaseCountRegisterMember((RegisterEntity)session.getAttribute("Mainentity"));
			return"redirect:/viewmembers";
		}
		else {
			model.addAttribute("message1", "SomeThing went wrong, please try again !!!");
			return "/WEB-INF/viewmembers.jsp";
		}
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
}