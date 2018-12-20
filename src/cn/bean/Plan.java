package cn.bean;

public class Plan {
	private Integer id;
	private String itemName;
	private String planTime;
	private String planDescribe;
	private String percent;
	private String note;
	public Plan() {}
	public Plan(Integer id, String itemName, String planTime, String planDescribe, String percent, String note) {
		super();
		this.id = id;
		this.itemName = itemName;
		this.planTime = planTime;
		this.planDescribe = planDescribe;
		this.percent = percent;
		this.note = note;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getPlanTime() {
		return planTime;
	}
	public void setPlanTime(String planTime) {
		this.planTime = planTime;
	}
	public String getPlanDescribe() {
		return planDescribe;
	}
	public void setPlanDescribe(String planDescribe) {
		this.planDescribe = planDescribe;
	}
	public String getPercent() {
		return percent;
	}
	public void setPercent(String percent) {
		this.percent = percent;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	@Override
	public String toString() {
		return "Plan [id=" + id + ", itemName=" + itemName + ", planTime=" + planTime + ", planDescribe=" + planDescribe
				+ ", percent=" + percent + ", note=" + note + "]";
	}
	
	
	

}
