package cn.test;

import cn.bean.Plan;
import cn.dao.PlanDao;

public class PlanDaoTest {
	private PlanDao planDao = new PlanDao();

	public static void main(String[] args) {
		PlanDaoTest test = new PlanDaoTest();
		 test.add();
//		 test.getall();
//		 test.update();
//		test.delete();

	}

	public void add() {

		Plan p = new Plan(null, "itemName", "planTime", "planDescribe", "percent", null);
		System.out.println(planDao.addPlan(p));
	}

	public void update() {
		Plan p = planDao.selectPlanByPlanTime("planTime");
		System.out.println("修改之前的" + p);
		// p.setId(2222);
		p.setItemName("1233221");
		p.setNote("note");
		System.out.println("修改之后的：" + p);
		planDao.updateplan(p);
	}

	public void getall() {
		System.out.println(planDao.getall());
	}

	public void delete() {
		Plan p = planDao.selectPlanByPlanTime("itemName");
		System.out.println(planDao.deletePlan(p));
	}
}
