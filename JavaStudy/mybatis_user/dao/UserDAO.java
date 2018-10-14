/*
 * Copyright (c) 2018. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package dao;

import bean.UserDTO;
import com.ibatis.common.resources.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;


public class UserDAO {
    // singleton

    private static UserDAO instance;

    private SqlSessionFactory factory;



    public static UserDAO getInstance() {

        if (instance == null) {

            synchronized (UserDAO.class) {

                instance = new UserDAO();

            }

        }

        return instance;

    }



    // constructor

    public UserDAO() {

        //InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

        try {

            Reader reader = Resources.getResourceAsReader("resources/mybatisConfig.xml");

            factory = new SqlSessionFactoryBuilder().build(reader);

        } catch (IOException e) {

            e.printStackTrace();

        }

    }



    // 유저 등록

    public void userWrite(UserDTO userDto) {

        SqlSession sqlSession = factory.openSession();

        sqlSession.insert("userSQL.userWrite", userDto);

        sqlSession.commit();

        sqlSession.close();

        // userSQL 이라는 namespace안에 userWrite라는 mapper를 찾아간다. (in userMapper.xml)

    } // userWrite()



    // 유저 삭제

    public void userDelete(UserDTO userDto) {

        SqlSession sqlSession = factory.openSession();

        sqlSession.delete("userSQL.userDelete", userDto);

        sqlSession.commit();

        sqlSession.close();

    } // userDelete()



    // 유저 리스트

    public List<UserDTO> getUserList() {

        SqlSession sqlSession = factory.openSession();

        List<UserDTO> list = sqlSession.selectList("userSQL.getUserList");

        sqlSession.close();

        return list;

    } // getUserList()



    // 유저정보 얻어오기

    public UserDTO getUser(String id) {

        UserDTO userDto = new UserDTO();

        SqlSession sqlSession = factory.openSession();

        userDto = sqlSession.selectOne("userSQL.getUser", id);

        sqlSession.close();

        return userDto;

    }



    // 유저 업데이트

    public int updateUser(UserDTO userDto) {

        int su = 0;

        SqlSession sqlSession = factory.openSession();

        su = sqlSession.update("userSQL.updateUser", userDto);

        sqlSession.commit();

        sqlSession.close();

        return su;

    }

}
