import java.sql.*;

public class Main {

    static final String USER = "root";
    static final String PASSWORD = "kokolove123";
    static final String URL = "jdbc:mysql://localhost:3306/beauty_shop";

    static final String CREATE_USER_TABLE = "create table test(id bigint primary key auto_increment, name varchar(255) not null, password varchar(255) not null)";
    static final String INSERT_USER = "insert into user(name, password) values ('%s', '%s')";

    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
//        Statement statement = connection.createStatement();
//        statement.execute(CREATE_USER_TABLE);
//        statement.close();

//        Statement statement = connection.createStatement();
//        ResultSet resultSet = statement.executeQuery("select  * from test");
//        while (resultSet.next()){
//            long id = resultSet.getLong("id");
//            String name = resultSet.getString("name");
//            String password = resultSet.getString("password");
//            System.out.println(id + ", " + name + " " + password);
//        }
//        statement.close();

        PreparedStatement preparedStatement = connection.prepareStatement("select * from test where name like ? and password =?");
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("input name");
//        String name = scanner.next();
//                System.out.println("input pass");
//        String pass = scanner.next();
        preparedStatement.setString(1, "%k%");
        preparedStatement.setString(2, "q1w2e3");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Long id = resultSet.getLong("id");
            String name = resultSet.getString("name");
            String password = resultSet.getString("password");
            System.out.println(id + ", " + name + " " + password);
        }

        connection.close();
    }

}
