package co.eju.prj.comm;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DataSource {
	//DAO객채니까 singlton클래스로만들어주자
	private static SqlSessionFactory sqlSessionFactory;
	
	//나를 밖에서 생성하지 못하도록 private 키워드를 통해서 생성자를 만들어줌
	private DataSource() {}
	
	
	public static SqlSessionFactory getDataSource() {
		String resource = "mybatis-config.xml";
					//리소스의 위치 중요! copy 떠 올때 꼭 잘 파악하자
		try {
			InputStream	inputStream = Resources.getResourceAsStream(resource);
			 sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return sqlSessionFactory;
	}
}
