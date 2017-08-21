package cn.itcast.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.itcast.dao.ItemsMapper;
import cn.itcast.pojo.Items;

@Service
public class ItemServiceImpl implements ItemService {
	@Autowired
	private ItemsMapper itemsMapper;
	@Override
	public List<Items> selectByExample() {
		return itemsMapper.selectByExampleWithBLOBs(null);
	}
	@Override
	public Items findById(Integer id) {
		Items items = itemsMapper.selectByPrimaryKey(id);
		return items;
	}
	@Override
	public void updateItems(Items items) {
		itemsMapper.updateByPrimaryKeyWithBLOBs(items);
	}
	@Override
	public List<Items> findAll()  {
		return itemsMapper.selectByExampleWithBLOBs(null);
	}
	@Override
	public void dele(Integer id) {
		
		itemsMapper.deleteByPrimaryKey(id);
	}
	@Override
	public void updateItemsave(Items item) {
		itemsMapper.updateByPrimaryKey(item);
	}
	@Override
	public Items itemEdit(Integer id) {
		
		return itemsMapper.selectByPrimaryKey(id);
	}
	@Override
	public void edititemsave(Items item) {
		
		itemsMapper.updateByPrimaryKeyWithBLOBs(item);
	}
	@Override
	public void fileupdate(Items item) {
		itemsMapper.updateByPrimaryKeyWithBLOBs(item);
		
	}

	

}
