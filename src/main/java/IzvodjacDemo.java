import java.sql.*;

public class IzvodjacDemo {

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root")) {
            System.out.println("Database connected");
            if (conn != null) {
                System.out.println("Connection established");

                // Prikaz izvođača čiji je tip "solo"
                prikaziSoloIzvodjace(conn);

                // Prikaz izvođača koji su formirani posle zadate godine
                int zadnjaGodina = 2000; // Unesite željenu godinu
                prikaziIzvodjacePosleGodine(conn, zadnjaGodina);
            }
        } catch (SQLException ex) {
            System.out.println("Greška u konekciji sa bazom:\n" + ex.getMessage());
        }
    }

    public static void prikaziSoloIzvodjace(Connection conn) throws SQLException {
        String query = "SELECT * FROM izvodjac WHERE tipIzvodjaca = 'Solo'";
        try (PreparedStatement st = conn.prepareStatement(query);
             ResultSet rs = st.executeQuery()) {
            System.out.println("Izvođači čiji je tip \"Solo\":");
            while (rs.next()) {
                System.out.println(rs.getString("nazivIzvodjaca"));
            }
        }
    }

    public static void prikaziIzvodjacePosleGodine(Connection conn, int godina) throws SQLException {
        String query = "SELECT * FROM izvodjac WHERE godinaFormacije > '2000'";
        try (PreparedStatement st = conn.prepareStatement(query)) {
            st.setInt(1, godina);
            try (ResultSet rs = st.executeQuery()) {
                System.out.println("Izvođači formirani posle " + godina + ". godine:");
                while (rs.next()) {
                    System.out.println(rs.getString("nazivIzvodjaca"));
                }
            }
        }
    }
}


