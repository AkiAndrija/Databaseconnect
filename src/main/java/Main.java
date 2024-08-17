import java.sql.*;

public class Main {

    public static void main(String[] args) {
        // IzvodjacDao izvodjacDao = new IzvodjacDao();

        Izvodjac izvodjac = new Izvodjac(4, "John Bon Jovi", "Band", 1980, 2000, "https://www.bonjovi.com/");
        Izvodjac izvodjac1 = new Izvodjac(5, "MichaelJackson", "Solo", 1982, 2007, "https://www.michaeljackson.com/");
        Izvodjac izvodjac2 = new Izvodjac(6, "Sting", "Band", 1985, 2005, "https://www.sting.com/");

        System.out.println("Connecting database...");


        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root")) {
            System.out.println("Database connected");
            if (conn != null) {
                System.out.println("Connection established");

                String query = "INSERT INTO izvodjac (ID, nazivIzvodjaca, tipIzvodjaca, godinaFormacije, godinaRaspada, zvanicanSajt) VALUES (?, ?, ?, ?, ?, ?)";
                PreparedStatement st = conn.prepareStatement(query);
                st.setInt(1, izvodjac1.getId());
                st.setString(2, izvodjac1.getNazivIzvodjaca());
                st.setString(3, izvodjac1.getTipIzvodjaca());
                st.setInt(4, izvodjac1.getGodinaFormacije());
                st.setInt(5, izvodjac1.getGodinaRaspada());
                st.setString(6, izvodjac1.getZvanicanSajt());

                int rows = st.executeUpdate();
                if (rows > 0) {
                    System.out.println("Izvođač je uspešno dodat.");
                } else {
                    System.out.println("Nema redova koji odgovaraju datim vrednostima.");
                }

                conn.close();
            }
        } catch (SQLException e) {
            System.out.println("Greška u konekciji sa bazom:\n" + e.getMessage());
        }
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root")) {
            System.out.println("Database connected");
            if (conn != null) {
                System.out.println("Connection established");

                String query = "INSERT INTO izvodjac (ID, nazivIzvodjaca, tipIzvodjaca, godinaFormacije, godinaRaspada, zvanicanSajt) VALUES (?, ?, ?, ?, ?, ?)";
                PreparedStatement st = conn.prepareStatement(query);
                st.setInt(1, izvodjac.getId());
                st.setString(2, izvodjac.getNazivIzvodjaca());
                st.setString(3, izvodjac.getTipIzvodjaca());
                st.setInt(4, izvodjac.getGodinaFormacije());
                st.setInt(5, izvodjac.getGodinaRaspada());
                st.setString(6, izvodjac.getZvanicanSajt());

                int rows2 = st.executeUpdate();

                st.setInt(1, izvodjac2.getId());
                st.setString(2, izvodjac2.getNazivIzvodjaca());
                st.setString(3, izvodjac2.getTipIzvodjaca());
                st.setInt(4, izvodjac2.getGodinaFormacije());
                st.setInt(5, izvodjac2.getGodinaRaspada());
                st.setString(6, izvodjac2.getZvanicanSajt());

                int rows3 = st.executeUpdate();


                if (rows2 > 0 && rows3 > 0) {
                    System.out.println("Izvođači su uspešno dodati u bazu podataka.");
                } else {
                    System.out.println("Nema redova koji odgovaraju datim vrednostima.");
                }

                conn.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root")) {
            String sql = "UPDATE izvodjac SET nazivIzvodjaca = ? , tipIzvodjaca=?, godinaFormacije=?,godinaRaspada=?, zvanicanSajt=? WHERE ID=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, izvodjac.getNazivIzvodjaca());
            ps.setString(2, izvodjac.getTipIzvodjaca());
            ps.setInt(3, izvodjac.getGodinaFormacije());
            ps.setInt(4, izvodjac.getGodinaRaspada());
            ps.setString(5, izvodjac.getZvanicanSajt());
            ps.setInt(6, izvodjac.getId());
            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("The user information has been updated...");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root")) {
            String query = "DELETE FROM izvodjac WHERE ID=?";
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, izvodjac.getId());

            int rows = st.executeUpdate();
            if (rows > 0) {
                System.out.println("Izvođač je uspešno obrisan.");
            } else {
                System.out.println("Nema redova koji odgovaraju datom ID-u.");
            }
        } catch (SQLException e) {
            System.out.println("Greška u konekciji sa bazom:\n" + e.getMessage());
        }


        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
            String sql = "SELECT * from izvodjac";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int ID = resultSet.getInt("ID");
                String nazivIzvodjaca = resultSet.getString("nazivIzvodjaca");
                String tipIzvodjaca = resultSet.getString("tipIzvodjaca");
                int godinaFormacije = resultSet.getInt("godinaFormacije");
                int godinaRaspada = resultSet.getInt("godinaRaspada");
                String zvanicanSajt = resultSet.getString("zvanicanSajt");

                System.out.println(ID + ":" + nazivIzvodjaca + ":" + tipIzvodjaca + ":" + godinaFormacije + ":" + godinaRaspada + ":" + zvanicanSajt);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}



