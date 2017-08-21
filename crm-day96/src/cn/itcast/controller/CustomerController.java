package cn.itcast.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.itcast.pojo.BaseDict;
import cn.itcast.pojo.Customer;
import cn.itcast.pojo.QueryVo;
import cn.itcast.service.CustomerService;
import cn.itcast.utils.Page;

@Controller
@RequestMapping("customer")
public class CustomerController {
    @Autowired
	private CustomerService customerServiceImp;
    @RequestMapping("/list")
    public String showCustomerList(Model model,QueryVo vo) throws Exception{
    	String custName = vo.getCustName();
		if (custName != null && !"".equals(custName)) {
			custName = new String(custName.getBytes("iso8859-1"), "utf-8");
			vo.setCustName(custName);
		}
    	//查询条件数据回显
    	List<BaseDict>list1= customerServiceImp.getBaseDictList("002");//查找客户的来源
    	List<BaseDict>list2= customerServiceImp.getBaseDictList("001");//查找客户的所属行业
    	List<BaseDict>list3= customerServiceImp.getBaseDictList("006");//查找客户的级别
		//将值传递给页面
    	model.addAttribute("fromType", list1);
    	model.addAttribute("industryType", list2);
    	model.addAttribute("levelType", list3);
    	//展示客户列表
    	Page<Customer>page=customerServiceImp.getCustList(vo);
    	//把page放入到request域中
    	model.addAttribute("page",page);
    	//页面回显
    	model.addAttribute("custName", vo.getCustName());
    	model.addAttribute("custSource", vo.getCustSource());
    	model.addAttribute("custIndustry", vo.getCustIndustry());
    	model.addAttribute("custLevel", vo.getCustLevel());
    	
    	return "customer";
    }
    //修改数据回显
    @RequestMapping("/toEdit")
    @ResponseBody
    public Customer findCustomer(Long id){
    	Customer customer=customerServiceImp.findCustomer(id);
    	
    	return customer;
    	
    } 
   //修改数据保存
    @RequestMapping(value="/update",method=RequestMethod.POST)
    @ResponseBody
    public String updateCustomer(Customer customer){
		
    	customerServiceImp.updateCustomer(customer);
    	
    	return "ok";
    	
    }
    @RequestMapping(value="/delete",method=RequestMethod.POST)
    @ResponseBody
    public String deleteCustomerById(Long id){
    	customerServiceImp.deleteCustomerById(id);
    	
    	return "ok";
    	
    }
}
