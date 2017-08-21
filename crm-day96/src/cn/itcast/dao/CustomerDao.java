package cn.itcast.dao;

import java.util.List;

import cn.itcast.pojo.BaseDict;
import cn.itcast.pojo.Customer;
import cn.itcast.pojo.QueryVo;

public interface CustomerDao {

	
	List<BaseDict> getBaseDictList(String string);

	List<Customer> getCustList(QueryVo vo);

	int getCustomerCount(QueryVo vo);
    //修改的数据回显
	Customer findCustomerById(Long id);
    //保存修改数据
	void updateCustomerById(Customer customer);

	void deleteCustomerById(Long id);

}
