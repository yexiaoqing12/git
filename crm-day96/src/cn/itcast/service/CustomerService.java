package cn.itcast.service;

import java.util.List;

import cn.itcast.pojo.BaseDict;
import cn.itcast.pojo.Customer;
import cn.itcast.pojo.QueryVo;
import cn.itcast.utils.Page;

public interface CustomerService {

	List<BaseDict> getBaseDictList(String string);

	Page<Customer> getCustList(QueryVo vo);
    //修改的数据回显
	Customer findCustomer(Long id);
    //保存修改信息
	void updateCustomer(Customer customer);

	void deleteCustomerById(Long id);

}
