import java.sql.*;

public class Demo1 {
    public static void main(String[] args) {
        String sql = "select * from emp";
        Connection conn = null;
        PreparedStatement stmst = null;
        ResultSet rs = null;
        try {
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","scott","tiger");
            System.out.println("连接成功");
            stmst = conn.prepareStatement(sql);
            rs = stmst.executeQuery();
            while(rs.next()){
                int empno = rs.getInt("empno");
                System.out.println("empno:"+empno);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                stmst.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
