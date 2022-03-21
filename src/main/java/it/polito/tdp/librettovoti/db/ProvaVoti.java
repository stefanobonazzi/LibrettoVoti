package it.polito.tdp.librettovoti.db;

import java.sql.*;

public class ProvaVoti {

	public void aggiungiVoto(String nome, int punti) {
		String url = "jdbc:mysql://localhost:3306/libretto?user=stefanobonazzi&password=psw2810";
		
		try {
			Connection conn = DriverManager.getConnection(url);
			String sql = "INSERT INTO voti (nome, punti) VALUES(?, ?);";
			PreparedStatement st = conn.prepareStatement(sql);
			
			//String sql = "INSERT INTO voti (nome, punti) VALUES('" + nome +"', " + punti +");";
			
			st.setString(1, nome);
			st.setInt(2, punti);
			
			int res = st.executeUpdate();
			st.close();
			
			if(res == 1)
				System.out.println("Dato correttamente inserito.");
			
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public static void main(String[] args) {
		
		ProvaVoti provavoti = new ProvaVoti();
		provavoti.aggiungiVoto("Economia Aziendale", 28);
		
		String url = "jdbc:mysql://localhost:3306/libretto?user=stefanobonazzi&password=psw2810";
		
		try {
			Connection conn = DriverManager.getConnection(url);
			System.out.println("Connessione aperta.");
			Statement st = conn.createStatement();
			
			String sql = "SELECT * FROM voti";
			ResultSet res = st.executeQuery(sql);
			
			while(res.next()) {
				String nome = res.getString("nome");
				int voto = res.getInt("punti");
				System.out.println(nome + " " +voto);
			}
			
			st.close();
			conn.close();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}

	}

}
