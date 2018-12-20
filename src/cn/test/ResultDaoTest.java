package cn.test;

import cn.bean.Result;
import cn.dao.ResultDao;

public class ResultDaoTest {
	private ResultDao resultDao = new ResultDao();

	public static void main(String[] args) {
		ResultDaoTest test = new ResultDaoTest();
//		 test.add();
//		 test.getall();
//		 test.update();
		test.delete();

	}

	public void add() {

		Result r = new Result(null, "resultName", "resultDEscribe", "resultTime", "resultAttachment" , "beginName" ,null);
		System.out.println(resultDao.addResult(r));
	}

	public void update() {
		Result f = resultDao.selectResultByresultName("resultName");
		System.out.println("修改之前的" + f);
		// p.setId(2222);
		f.setBeginName("1233221");
		f.setNote("note");
		System.out.println("修改之后的：" + f);
		resultDao.updateResult(f);
	}

	public void getall() {
		System.out.println(resultDao.getall());
	}

	public void delete() {
		Result f = resultDao.selectResultByresultName("resultName");
		System.out.println(resultDao.deleteResult(f));
	}

}
