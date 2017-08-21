package cn.itcast.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cn.itcast.pojo.Items;
import cn.itcast.pojo.Updatvo;
import cn.itcast.service.ItemService;

@Controller
public class ItemsController {
	@Autowired
	private ItemService itemservice;

	// 查找数据 展示到页面上
	@RequestMapping("listAll")
	public ModelAndView findAll()     {
		List<Items> itemList = itemservice.findAll();
		ModelAndView modelandview = new ModelAndView();
		modelandview.addObject("itemList", itemList);
		modelandview.setViewName("itemListDel");
		return modelandview;
	}

	@RequestMapping("deleitem") // 批量删除
	public String dele(Integer[] ids) {
		// 遍历数组 进行单条删除
		for (Integer id : ids) {
			itemservice.dele(id);
		}
		return "success";
	}

	@RequestMapping("updateItem")
	public ModelAndView updateItemfindAll() {
		List<Items> itemList = itemservice.findAll();
		ModelAndView modelandview = new ModelAndView();
		modelandview.addObject("itemList", itemList);
		modelandview.setViewName("itemListupdate");
		return modelandview;
	}
    /*
     * 请求转发和重定向
     * 请求转发 地址栏的url不发生改变 request域对象是同一个,request域中的的数据能够带到新的页面中
     * 重定向 地址栏中url发生变化 request域对象不是同一个,request域中的数据不能带到新的页面 
	*/
	@RequestMapping("updateItemsave") // 批量修改
	public String updateItemsave(Updatvo vo, Model model) {

		for (Items item : vo.getUpdateItemsList()) {
			itemservice.updateItemsave(item);
		
		}
		return "forward:updateItem.action";
	}
	@RequestMapping("itemEdit")//修改
	public ModelAndView itemEdit(Items item,Model model){
		Integer id = item.getId();
		Items items=itemservice.itemEdit(id);
		ModelAndView modelandview = new ModelAndView();
		modelandview.addObject("item", items);
		modelandview.setViewName("editItem");
		return modelandview;
		
	}
	@RequestMapping("edititemsave")//修改保存
	public String  edititemsave(Items item){
		itemservice.edititemsave(item);
		//return "forward:listAll.action";
		return "redirect:listAll.action";
		
	}
	@RequestMapping("fileupdate")//图片上传
	public String fileupdate(MultipartFile pictureFile,Items item,Model model) throws IllegalStateException, IOException{
		//获取原图片的名称
		String originalFilename = pictureFile.getOriginalFilename();
		//通过UUID的方式获取随机字符串和原图片的文件后缀名拼接成新的文件名称
		String newfilename=UUID.randomUUID().toString()+originalFilename.substring(originalFilename.lastIndexOf("."));
		//将图片保存到本地磁盘
		pictureFile.transferTo(new File("D:\\" + newfilename));
		//将文件名称保存到数据库
		item.setPic(newfilename);
		itemservice.fileupdate(item);
        model.addAttribute("id", item.getId());
		
		return "redirect:itemEdit.action";
	
		
	}
	
	
}
