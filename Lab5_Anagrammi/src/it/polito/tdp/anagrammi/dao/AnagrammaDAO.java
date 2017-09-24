package it.polito.tdp.anagrammi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.polito.tdp.anagrammi.exception.AnagrammiException;

public class AnagrammaDAO {

	public boolean isCorrect(String anagramma) throws AnagrammiException {
		
		String query = "select 1 from parola where lower(nome) = lower(?)";
		
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try{
			c = ConnectDB.getConnection();
			ps = c.prepareStatement(query);
			ps.setString(1, anagramma);
			
			rs = ps.executeQuery();
			
			return rs.next();	
			
		} catch(SQLException sqle){
			sqle.printStackTrace();
			System.out.println("Errore generico nella verifica su DB: " + sqle.getMessage());
			throw new AnagrammiException("Errore generico nella verifica su DB: " + sqle.getMessage());
			
		} finally {
			ConnectDB.closeResources(c, ps, rs);
		}
		
		
	}
}
