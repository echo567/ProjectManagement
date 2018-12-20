package cn.test;

import cn.bean.Fund;
import cn.bean.Resource;
import cn.dao.FundDao;
import cn.dao.ResourceDao;

public class ResourceDaoTest {
	private ResourceDao resourceDao = new ResourceDao();

	public static void main(String[] args) {
		ResourceDaoTest test = new ResourceDaoTest();
//		 test.add();
//		 test.getall();
//		 test.update();
//		test.delete();

	}

	public void add() {

		Resource r = new Resource(null, "itemName", "resource", "addTime", "resoName" ,null);
		System.out.println(resourceDao.addResource(r));
	}

	public void update() {
		Resource f = resourceDao.selectResourceByresoName("resoName");
		System.out.println("修改之前的" + f);
		// p.setId(2222);
		f.setItemName("1233221");
		f.setNote("note");
		System.out.println("修改之后的：" + f);
		resourceDao.updateResource(f);
	}

	public void getall() {
		System.out.println(resourceDao.getall());
	}

	public void delete() {
		Resource f = resourceDao.selectResourceByresoName("itemName");
		System.out.println(resourceDao.deleteResource(f));
	}


}
