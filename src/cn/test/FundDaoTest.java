package cn.test;

import cn.bean.Fund;
import cn.dao.FundDao;

public class FundDaoTest {
	private FundDao fundDao = new FundDao();

	public static void main(String[] args) {
		FundDaoTest test = new FundDaoTest();
		 test.add();
//		 test.getall();
//		 test.update();
//		test.delete();

	}

	public void add() {

		Fund f = new Fund(null, "fund", "addTime", "itemName",  null);
		System.out.println(fundDao.addFund(f));
	}

	public void update() {
		Fund f = fundDao.selectFundByItemName("itemName");
		System.out.println("修改之前的" + f);
		// p.setId(2222);
		f.setItemName("1233221");
		f.setNote("note");
		System.out.println("修改之后的：" + f);
		fundDao.updateFund(f);
	}

	public void getall() {
		System.out.println(fundDao.getall());
	}

	public void delete() {
		Fund f = fundDao.selectFundByItemName("itemName");
		System.out.println(fundDao.deleteFund(f));
	}

}
