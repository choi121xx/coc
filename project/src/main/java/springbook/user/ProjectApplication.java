package springbook.user;

import java.sql.SQLException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import springbook.bean.domain.UserBean;
import springbook.user.dao.NUserDao;
import springbook.user.dao.UserDao;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class ProjectApplication {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		SpringApplication.run(ProjectApplication.class, args);
		
		NUserDao dao = new NUserDao();
		
		UserBean user = new UserBean();
		user.setId("abcd4");
		user.setName("hong Dong");
		user.setPassword("1234");
		
		dao.add(user);
		
		System.out.println("성공");
		
		UserBean user2 = dao.get(user.getId());
		System.out.println("id:" + user2.getId());
		System.out.println("name:" + user2.getName());
		System.out.println("password:" + user2.getPassword());
	}

}
