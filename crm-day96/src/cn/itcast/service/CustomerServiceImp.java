package cn.itcast.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.itcast.dao.CustomerDao;
import cn.itcast.pojo.BaseDict;
import cn.itcast.pojo.Customer;
import cn.itcast.pojo.QueryVo;
import cn.itcast.utils.Page;

@Service
@Transactional
public class CustomerServiceImp implements CustomerService {
    @Autowired
	private CustomerDao customerdao;
	@Override//查询数据回显
	public List<BaseDict> getBaseDictList(String string) {
		
		return customerdao.getBaseDictList(string);
	}
	@Override//数据列表展示
	public Page<Customer> getCustList(QueryVo vo) {
		
		Page<Customer>page=new Page<>();
		vo.setStart((vo.getPage()-1)*vo.getSize());
		List<Customer>custList=customerdao.getCustList( vo);
		//给page对象赋值 返回page
		page.setPage(vo.getPage());
		page.setRows(custList);
		page.setSize(vo.getSize());
		int total=customerdao.getCustomerCount(vo);
		page.setTotal(total);
		return page;
	}
	@Override//修改的数据回显
	
	public Customer findCustomer(Long id) {
	     
		return customerdao.findCustomerById(id);
	}
	@Override//保存修改客户
	public void updateCustomer(Customer customer) {
		customerdao.updateCustomerById(customer);
	}
	@Override
	public void deleteCustomerById(Long id) {
	
		customerdao.deleteCustomerById(id);
	}

}
