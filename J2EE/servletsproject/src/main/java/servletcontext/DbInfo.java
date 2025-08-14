package servletcontext;

//Object of this class can be created and added into ServletContext Object
public class DbInfo {
   String url,user,password;

	public DbInfo(String url, String user, String password) {
		super();
		this.url = url;
		this.user = user;
		this.password = password;
	}
   
}
