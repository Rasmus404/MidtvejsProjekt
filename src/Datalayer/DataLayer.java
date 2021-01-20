package Datalayer;

import logic.Hold;
import logic.Kamp;

import java.sql.*;
import java.util.ArrayList;

public class DataLayer {
    private Connection connection;
    public DataLayer(String databaseName) {
        loadJdbcDriver();
        openConnection(databaseName);
    }

    private boolean loadJdbcDriver() {
        try {
            System.out.println("Loading JDBC driver...");

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            System.out.println("JDBC driver loaded");

            return true;
        }
        catch (ClassNotFoundException e) {
            System.out.println("Could not load JDBC driver!");
            return false;
        }
    }
    private boolean openConnection(String databaseName) {
        String connectionString =
                "jdbc:sqlserver://localhost:1433;" +
                        "instanceName=SQLEXPRESS;" +
                        "databaseName=" + databaseName + ";" +
                        "integratedSecurity=true;";
        connection = null;

        try {
            System.out.println("Connecting to database...");

            connection = DriverManager.getConnection(connectionString);

            System.out.println("Connected to database");

            return true;
        }
        catch (SQLException e) {
            System.out.println("Could not connect to database!");
            System.out.println(e.getMessage());

            return false;
        }
    }

    public boolean addHold(Hold hold) {
        try {
            String sql = "INSERT INTO hold VALUES ('" +
                    hold.getHoldNavn()+ "','" +
                    hold.getScore() + "')";

            System.out.println(sql);

            Statement statement = connection.createStatement();

            int affectedRows = statement.executeUpdate(sql);
            // få fat i autogeneret nøgle
            ResultSet resultSet =
                    statement.executeQuery("SELECT SCOPE_IDENTITY()");
            if (resultSet.next()) {
                int autoKey = resultSet.getInt(1);

                hold.setId(autoKey);
            }

            return true;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<Hold> getAllHold() {
        return getHoldTableByCondition("0=0");
    }

    public Hold getHoldById(int hold_id) {
        ArrayList<Hold> result =
                getHoldTableByCondition("id=" + hold_id);

        if (result.size() > 0)
            return result.get(0);
        else
            return null;
    }
    public ArrayList<String> getALLHoldNavne() {

        ArrayList<String> holdNavneList = new ArrayList<>();

        try {
            String sql = "SELECT hold_navn FROM hold;";

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                holdNavneList.add(resultSet.getString("hold_navn"));
            }

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return holdNavneList;
    }

    public Hold getHoldByHoldNavn(String holdNavn) {
        return getHoldTableByCondition("hold_navn LIKE '%" + holdNavn + "%'").get(0);
    }

    public ArrayList<Hold> getHoldToKamp(String hjemmeHold, String udeHold) {
        return getHoldTableByCondition("hold_navn LIKE '%" + hjemmeHold + "%','" + udeHold + "'");
    }

    private ArrayList<Hold> getHoldTableByCondition(String condition) {
        ArrayList<Hold> holdtable = new ArrayList<Hold>();

        System.out.println("condition: " + condition);
        try {
            String sql = "SELECT * FROM hold WHERE " + condition;

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            // iteration starter 'before first'
            while (resultSet.next()) {
                // hent data fra denne række
                int hold_id = resultSet.getInt("hold_id");
                String holdNavn = resultSet.getString("hold_navn");
                int score = resultSet.getInt("score");
                Hold hold = new Hold();
                hold.setHoldNavn(holdNavn);
                hold.setId((hold_id));
                hold.setScore(score);


                holdtable.add(hold);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return holdtable;
    }

    public boolean updateHold(Hold hold) {
        try {
            StringBuffer assignments = new StringBuffer();
            //assignments.append("hold_id='" + hold.getId() + "', ");
            assignments.append("hold_navn='" + hold.getHoldNavn() + "', ");
            assignments.append("hold_score='" + hold.getScore());



            String condition = "hold_id=" + hold.getId();

            String sql = "UPDATE student SET " + assignments +
                    " WHERE " + condition;

            System.out.println(sql);

            Statement statement = connection.createStatement();

            int affectedRows = statement.executeUpdate(sql);

            return (affectedRows == 1);
        }
        catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteHold(Hold hold) {
        try {
            String condition = "id=" + hold.getId();
            String sql = "DELETE FROM student WHERE " + condition;

            System.out.println(sql);

            Statement statement = connection.createStatement();

            int affectedRows = statement.executeUpdate(sql);

            return (affectedRows == 1);

//      if (affectedRows == 1)
//        return true;
//      else
//        return false;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<Kamp> getAllKampe() {
        return getKampTableByCondition("0=0");
    }

    public boolean addKamp(Kamp kamp) {

        try {
            String sql = "INSERT INTO kamp VALUES ('" +
                    kamp.getHjemmehold().getId()+ "','" +
                    kamp.getUdehold().getId() + "','" +
                    kamp.getTimeStamp() + "')";

            System.out.println(sql);

            Statement statement = connection.createStatement();

            int affectedRows = statement.executeUpdate(sql);
            // få fat i autogeneret nøgle
            ResultSet resultSet =
                    statement.executeQuery("SELECT SCOPE_IDENTITY()");
            if (resultSet.next()) {
                int autoKey = resultSet.getInt(1);

                kamp.setId(autoKey);
            }

            return true;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private ArrayList<Kamp> getKampTableByCondition(String condition) {
        ArrayList<Kamp> kamptable = new ArrayList<Kamp>(20);

        System.out.println("condition: " + condition);
        try {
            String sql = "SELECT * FROM kamp WHERE " + condition;

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            // iteration starter 'before first'
            while (resultSet.next()) {
                // hent data fra denne række
                int kamp_id = resultSet.getInt("kamp_id");
                int hjemmeHoldId = resultSet.getInt("hold_id_hjemme");
                int udeHoldId = resultSet.getInt("hold_id_ude");
                String kampTidspunkt = resultSet.getString("kamp_tidspunkt");

                Kamp kamp = new Kamp(getHoldByHoldId(hjemmeHoldId), getHoldByHoldId(udeHoldId), kampTidspunkt);

                kamp.setId((kamp_id));



                kamptable.add(kamp);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return kamptable;
    }

    public Hold getHoldByHoldId(int holdId) {
        return getHoldTableByCondition("hold_navn LIKE '%" + holdId + "%'").get(0);
    }
}

