package cn.itcast.service;

import java.util.List;

import cn.itcast.pojo.Items;

public interface ItemService {
	
	public List<Items> selectByExample();
	
	public Items findById(Integer id);

	public void updateItems(Items items);

	public List<Items> findAll();

	public void dele(Integer id);

	public void updateItemsave(Items item);

	public Items itemEdit(Integer id);

	public void edititemsave(Items item);

	public void fileupdate(Items item);

	//List<Items> findAll() ;


}
