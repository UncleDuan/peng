package sql;

/**
 * Created by pengsel on 2019/4/1.
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

    /**
     * 使用PreparedStatement实现验证用户名密码是否存在的方法
     *
     * @param username
     * @param password
     */
    public void login(String username, String password) {

        Connection con = null;

        // 通过Statement 的改为prepareStatement
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = null;

        try {
            // sql = "select * from users where NAME = '" + username+
            // "' and PWD= '" + password + "'";
            sql = "select * from users where NAME = ? and PWD = ?";
            // 使用PreparedStatement是将 "aa' or '1' = '1"
            // 作为一个字符串赋值给问号“?”，使其作为"用户名"字段的对应值，这样来防止SQL注入。

            System.out.println(sql);
            con = DBUtility.getConnection();

            // 对于JDBC而言,SQL注入攻击只对Statement有效,对PreparedStatement是无效的,这是因为PreparedStatement不允许在插入时改变查询的逻辑结构。
            stmt = con.prepareStatement(sql);
            // rs = stmt.executeQuery(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);
            rs = stmt.executeQuery();

            // 进行结果的遍历，并给出相应的提示
            if (rs.next()) {
                System.out.println("登录成功！");
            } else {
                System.out.println("登录失败！");
            }

            System.out.println("执行完毕！");
        } catch (SQLException e) {

            System.out.println("数据库访问异常!");
            throw new RuntimeException(e);

        } finally {

            // 最后关闭一下资源
            if (con != null) {
                DBUtility.closeConnection(con);
            }
        }
    }
}
