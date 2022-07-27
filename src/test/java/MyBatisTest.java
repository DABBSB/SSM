import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisTest {
    @Test
    public void testInsert() throws IOException {
        InputStream stream = Resources.getResourceAsStream("mybatis-config.xml");

        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(stream);

        SqlSession sqlSession = sqlSessionFactory.openSession(false);

//        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//        System.out.println(mapper.insertUser());

        int insert = sqlSession.insert("com.mapper.myBatis.mapper.UserMapper.insertUser");
        System.out.println(insert);
        sqlSession.commit();
        sqlSession.close();
    }
}
