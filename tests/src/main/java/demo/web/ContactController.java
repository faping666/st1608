package demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import demo.bean.Contact;
import demo.service.BaseService;

@Controller
public class ContactController {
	
	@Autowired
	private BaseService service;

	@RequestMapping(value="/list")
	@ResponseBody
	public Object list() {
//		ModelAndView mv = new ModelAndView();
//		mv.addObject("calist", service.find("from Cardtype"));
		String hql = "select c from Contact c where 1=1 ";
//		String name = request.getParameter("name");
//		String sex = request.getParameter("sex");
//		String ctid = request.getParameter("ctid");
//		System.out.println("name:"+name+"  sex:"+sex+"   ctid:"+ctid);
//		if (!"".equals(name) && name!=null) {
//			System.out.println("1");     
//			hql += " and c.name like '%"+ name +"%' ";
//		}
//		if (!"".equals(sex) && sex!=null && !sex.equals("A") ) {
//			System.out.println("2");
//			hql += " and c.sex ='"+sex+"'";
//		}
//		if (!"".equals(ctid) &&  ctid!=null && !ctid.equals("A") ) {
//			System.out.println("3");
//			hql += " and c.ctid = " +ctid;
//		}
//		System.out.println("hql:"+hql);
//		mv.addObject("clist", service.find(hql));
//		mv.setViewName("/list");
//		System.out.println(mv);
		return service.find(hql);	
	}
	
	@RequestMapping(value="/add",method= {RequestMethod.GET})
	public ModelAndView add() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("calist", service.find("from Cardtype"));
		mv.setViewName("/add");
		System.out.println(mv);
		return mv;	
	}
	
	@RequestMapping(value="/add",method= {RequestMethod.POST})
	public ModelAndView add(Contact contact) {
		ModelAndView mv = new ModelAndView();
		service.add(contact);
		mv.setViewName("redirect:/list.sw");
		return mv;
	}
	
	@RequestMapping(value="/delete/{id}",method= {RequestMethod.GET})
	public ModelAndView delete(@PathVariable(name="id") Integer id) {
		ModelAndView mv = new ModelAndView();
		Contact lcContact = (Contact) service.load(Contact.class, id);
		service.delete(lcContact);
		mv.setViewName("redirect:/list.sw");
		System.out.println("id:"+id);
		return mv;	
	}
	
	@RequestMapping(value="/update/{id}",method= {RequestMethod.GET})
	public ModelAndView update(@PathVariable(name="id") Integer id) {
		ModelAndView mv = new ModelAndView();
		System.out.println("update id:"+id);
		mv.addObject("calist", service.find("from Cardtype"));
		mv.addObject("c", service.load(Contact.class, id));
		System.out.println(mv);
		mv.setViewName("/update");
		return mv;	
	}
	
	@RequestMapping(value="/update",method= {RequestMethod.POST})
	public ModelAndView update(Contact c) {
		ModelAndView mv = new ModelAndView();
		System.out.println(c);
		Contact lc = (Contact) service.load(Contact.class, c.getCid());
		lc.setCompany(c.getCompany());
		lc.setCtid(c.getCtid());
		lc.setHomeTelNum(c.getHomeTelNum());
		lc.setName(c.getName());
		lc.setOfficeTelNum(c.getOfficeTelNum());
		lc.setSex(c.getSex());
		service.update(lc);
		System.out.println(mv);
		mv.setViewName("redirect:/list.sw");
		return mv;	
	}
}
