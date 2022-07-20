package board_dto;

public class article {
		public int id;
		public String title;
		public String body;
		public String regDate;
		public int hit;
	public article (int id,String title,String body,String regDate,int hit) {
		this.id = id;
		this.title = title;
		this.body = body;
		this.regDate = regDate;
		this.hit = hit;
	}
	public article (int id,String title,String body,String regDate) {
		this (id,title,body,regDate,0);
	}
	public void increasehit() {
		hit ++;
	}
	
}
