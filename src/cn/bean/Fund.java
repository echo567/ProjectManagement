package cn.bean;

public class Fund {
	private Integer id;
	private String fund;
	private String addTime;	
	private String itemName;
	private String note;
	public Fund() {}
	public Fund(Integer id, String fund, String addTime, String itemName, String note) {
		super();
		this.id = id;
		this.fund = fund;
		this.addTime = addTime;
		this.itemName = itemName;
		this.note = note;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFund() {
		return fund;
	}
	public void setFund(String fund) {
		this.fund = fund;
	}
	public String getAddTime() {
		return addTime;
	}
	public void setAddTime(String addTime) {
		this.addTime = addTime;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	@Override
	public String toString() {
		return "Fund [id=" + id + ", fund=" + fund + ", addTime=" + addTime + ", itemName=" + itemName + ", note="
				+ note + "]";
	}
	
	
}
