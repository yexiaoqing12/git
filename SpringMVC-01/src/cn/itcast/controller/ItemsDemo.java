package cn.itcast.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

//import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.itcast.pojo.Items;
import cn.itcast.service.ItemService;

@Controller
public class ItemsDemo {
	
	@Autowired
	private ItemService itemService;
	@RequestMapping("list")
	public ModelAndView list(){
		List<Items> itemsList = itemService.selectByExample();
		
		//设置返回页面时返回的数据，和返回页面指定的地址
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.addObject("itemList", itemsList);//底层实现的是request.setAttribute(key,value)方式
		modelAndView.setViewName("itemList");
		
		//将数据和视图对象返回
		return modelAndView;
	}
	
	//@RequestMapping("itemEdit")
	public String edit(HttpServletRequest request,Model model){
		Integer id = Integer.valueOf(request.getParameter("id"));
		Items items = itemService.findById(id);
		model.addAttribute("item", items);
		return "editItem";
	}
	//@RequestMapping("updateitem")
	/*public String update(Integer id,String name,Float price,String detail){
		Items items = new Items();
		items.setDetail(detail);
		items.setId(id);
		items.setName(name);
		items.setPrice(price);
		items.setCreatetime(new Date());
		itemService.updateItems(items);
		return "success";
	}*/
	public String update(Items items){
		itemService.updateItems(items);
		return "success";
	}
}
