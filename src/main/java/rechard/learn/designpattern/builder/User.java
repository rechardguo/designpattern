package rechard.learn.designpattern.builder;


//利用inner class来建立建造者模式
public class User {
	
	private int id;
    private String name;
    private String passwd;
    private String sex;
    private String address;
    
    public User(){}
    
	public User(User target) {
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

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", name='" + name + '\'' +
				", passwd='" + passwd + '\'' +
				", sex='" + sex + '\'' +
				", address='" + address + '\'' +
				'}';
	}

	public static class Builder{
		private User target;

		private Builder(){};

		private Builder(User user){
			this.target=user;
		};

		public static Builder newBuilder(){
			return new Builder(new User());
		}
		
		public Builder setName(String name){
			target.setName(name);
			return this;
		}
		
		public Builder setId(int id) {
			target.setId(id);
			return this;
		}
		
		public User build(){
			return target;
		}
	}
	
	//建造者模式
	public static void main(String[]args){
		User user=User.Builder.newBuilder().setName("ls").setId(1).build();
		System.out.println(user);
	}
	
}
