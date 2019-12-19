package dao.impl;

import dao.IUserDao;
import domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * @Description:
 * @author: lk
 * @create: 2019-12-18   9:59
 */
public class UserDaoImpl implements IUserDao {
    private SqlSessionFactory factory;

    public UserDaoImpl(SqlSessionFactory factory){
        this.factory = factory;
    }

    public List<User> findAll() {
        //使用工厂创建SqlSession对象
        SqlSession session = factory.openSession();
        //使用session执行查询所有方法
        List<User> users = session.selectList("dao.IUserDao.findAll");
        session.close();
        //返回执行结果
        return users;
    }
}
