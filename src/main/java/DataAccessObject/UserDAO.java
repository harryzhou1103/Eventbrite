package DataAccessObject;

import Objects.Ticket;
import Objects.User;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    private Connection con;

    public UserDAO() throws SQLException {
        String db = "user46";
        String username = "user46";
        String password = "user46";
        try {
            // load driver
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        }
        catch (Exception e) {
            System.err.println("Can't find driver");
            System.exit(1);
        }

        String urlString = "jdbc:mysql://sql.cs.usfca.edu/"+db;
        String timeZoneSettings = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

        con = DriverManager.getConnection(urlString + timeZoneSettings,
                username,
                password);
    }



    public boolean userValidate(String username, String password) throws SQLException {
        String selectStmt = "SELECT * FROM users where username=" + username;
        PreparedStatement stmt = con.prepareStatement(selectStmt);
        ResultSet result = stmt.executeQuery();


        return false;
    }


    private byte[] createSalt() {
        byte[] salt = new byte[16];
        try {
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
            random.nextBytes(salt);
            return salt;
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

    public void createAccount(String username, String password) throws NoSuchAlgorithmException{
        String salt = createSalt().toString();
        password += salt;
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] encodedhash = digest.digest(
                password.getBytes(StandardCharsets.UTF_8));




    }

    public int getUserIdByUserName(String name) {
        return 123;
    }

    public List<Ticket> getPurchasedTickets(String username) {
        List<Ticket>res = new ArrayList<Ticket>();

        return res;
    }

}
