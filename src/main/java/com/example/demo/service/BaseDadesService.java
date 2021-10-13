package com.example.demo.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.beans.Empleat;
import com.example.demo.beans.Feina;
import com.example.demo.repository.BaseDades;

@Service
public class BaseDadesService implements IBaseDades {
	
	@Autowired
	BaseDades bd;

	@Override
	public void insertar(Empleat empleat) {bd.save(empleat);}

	@Override
	public void borrar(int id) {bd.deleteById(id);}

	@Override
	public void modificar(Empleat empleat) {bd.save(empleat);}

	@Override
	public Empleat getEmpleat(int id) {return bd.findById(id).get();}

	@Override
	public ArrayList<Empleat> getEmpleats() {return (ArrayList<Empleat>) bd.findAll();}
	
	@Override
	public ArrayList<Empleat> buscar(Feina feina){
		ArrayList<Empleat> empleats = new ArrayList<Empleat>();
		
		try {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			String conex = "jdbc:mysql://localhost:3306/treballadors_bd";
			Connection connexio = DriverManager.getConnection(conex,"root", "");
			Statement s = connexio.createStatement();
			String sql = "SELECT * FROM treballadors WHERE FEINA = '" + feina.toString() + "'";
			s.execute(sql);
			ResultSet rs = s.getResultSet();
			while(rs.next()) {
				Empleat empleat = new Empleat(rs.getInt(1), rs.getString(2), Feina.valueOf(rs.getString(3)));
				empleats.add(empleat);
			}
			
		}catch (SQLException ex) {
			System.out.print(ex.getMessage());
		}	
		return empleats;	
	}

}
