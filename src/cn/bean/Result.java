package cn.bean;

public class Result {
	private Integer id;
	private String resultName;
	private String resultDescribe;
	private String resultTime;
	private String resultAttachment;
	private String beginName;
	private String note;
	public Result() {
		
	}
	public Result(Integer id, String resultName, String resultDescribe, String resultTime, String resultAttachment,
			String beginName, String note) {
		super();
		this.id = id;
		this.resultName = resultName;
		this.resultDescribe = resultDescribe;
		this.resultTime = resultTime;
		this.resultAttachment = resultAttachment;
		this.beginName = beginName;
		this.note = note;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getResultName() {
		return resultName;
	}
	public void setResultName(String resultName) {
		this.resultName = resultName;
	}
	public String getResultDescribe() {
		return resultDescribe;
	}
	public void setResultDescribe(String resultDescribe) {
		this.resultDescribe = resultDescribe;
	}
	public String getResultTime() {
		return resultTime;
	}
	public void setResultTime(String resultTime) {
		this.resultTime = resultTime;
	}
	public String getResultAttachment() {
		return resultAttachment;
	}
	public void setResultAttachment(String resultAttachment) {
		this.resultAttachment = resultAttachment;
	}
	public String getBeginName() {
		return beginName;
	}
	public void setBeginName(String beginName) {
		this.beginName = beginName;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	@Override
	public String toString() {
		return "Result [id=" + id + ", resultName=" + resultName + ", resultDescribe=" + resultDescribe + ", resultTime="
				+ resultTime + ", resultAttachment=" + resultAttachment + ", beginName=" + beginName + ", note=" + note
				+ "]";
	}
	
	

}
