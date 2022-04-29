package POJO;

public class PojoTypicode {
	
	private String title;
	private String body;
	private int userId;
	private int Id;
	
	
	public PojoTypicode(String title, String body, int userId, int id) {
		super();
		this.title = title;
		this.body = body;
		this.userId = userId;
		Id = id;
	}
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	
	
	public PojoTypicode(String title, String body, int userId) {
		super();
		this.title = title;
		this.body = body;
		this.userId = userId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	

}
