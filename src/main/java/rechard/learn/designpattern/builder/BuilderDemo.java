package rechard.learn.designpattern.builder;


//利用inner class来建立建造者模式
public class BuilderDemo {
	
	private int id;
    private String name;
    private String passwd;
    private String sex;
    private String address;
    
    public BuilderDemo(){}
    
	public BuilderDemo(BuilderDemo target) {
		this.id=target.getId();
		this.name=target.getName();
		this.passwd=target.getPasswd();
		this.sex=target.getSex();
		this.address=target.getAddress();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public static class builder{		
		private BuilderDemo target;
		
		public builder(){
			target = new BuilderDemo();
		}
		
		public builder setName(String name){
			target.setName(name);
			return this;
		}
		
		public builder setId(int id) {
			target.setId(id);
			return this;
		}
		
		public BuilderDemo build(){
			return new BuilderDemo(target);
		}
	}
	
	//建造者模式
	public static void main(String[]args){
		new BuilderDemo.builder().setName("ls").setId(1).build();
		System.out.println(new BuilderDemo.builder() == new BuilderDemo.builder());
	}
	
}
