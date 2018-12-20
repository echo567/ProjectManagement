package cn.bean;

public class Resource {
	private Integer id;
	private String itemName;
	private String resource;
	private String addTime;
	private String resoName;
	private String note;
	public Resource() {}
	public Resource(Integer id, String itemName, String resource, String addTime, String resoName ,String note) {
		super();
		this.id = id;
		this.itemName = itemName;
		this.resource = resource;
		this.addTime = addTime;
		this.resoName = resoName;
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
	public String getResource() {
		return resource;
	}
	public void setResource(String resource) {
		this.resource = resource;
	}
	public String getAddTime() {
		return addTime;
	}
	public void setAddTime(String addTime) {
		this.addTime = addTime;
	}
	public String getResoName() {
		return resoName;
	}
	public void setResoName(String resoName) {
		this.resoName = resoName;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	@Override
	public String toString() {
		return "Resource [id=" + id + ", itemName=" + itemName + ", resource=" + resource + ", addTime=" + addTime
				+ ", resoName=" + resoName + ", note=" + note + "]";
	}
	

}
