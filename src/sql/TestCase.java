package sql;



import java.sql.SQLException;

import org.junit.Test;
public class TestCase {

    /**
     * 测试是否连接
     *
     * @throws SQLException
     */
    @Test
    public void testgetConnection() throws SQLException {
        DBUtility db = new DBUtility();
        System.out.println(db.getConnection());
    }


    @Test
    public void testPreparedStatementLogin() {

        UserDAO dao = new UserDAO();
        // 用户名不正确
        dao.login("Tom1", "123");
        // 用户名不正确
        dao.login("Tom", "1234");
        // 正确
        dao.login("Tom", "123");
        // 测试是否还存在sql注入问题，不能登陆成功，说明我们已经解决了sql注入问题
        dao.login("Tom", " a' OR 'b'='b  ");
        /**
         * 实现机制不同,注入只对SQL语句的准备(编译)过程有破坏作用,而PreparedStatement已经准备好了，
         * 执行阶段只是把输入串作为数据处理，不再需要对SQL语句进行解析、准备，因此也就避免了SQL注入问题。
         */

    }

}