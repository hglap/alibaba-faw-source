package com.ebanma.cloud.usertestall.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.function.Function;

/**
 * @author 黄贵龙
 * @version $ Id: DaoUtils, v 0.1 2023/03/19 12:33 86139 Exp $
 */
public class DaoUtils {

    private static SqlSessionFactory factory;

    static {
        String resource = "mybatis.config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            System.err.println("read mybatis.config.xml fail");
            e.printStackTrace();
            System.exit(1);
        }
        // 加载mybatis-config.xml配置文件，并创建SqlSessionFactory对象
        factory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    public static <R> R execute(Function<SqlSession,R> function){
        SqlSession sqlSession = factory.openSession();
        try {
            R apply = function.apply(sqlSession);
            sqlSession.commit();
            return apply;
        } catch (Throwable t) {
            sqlSession.rollback();
            System.out.println("execute error");
            throw t;
        } finally {
            // 关闭 SqlSession
            sqlSession.close();
        }
    }

}
