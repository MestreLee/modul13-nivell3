package com.example.demo.service;

import java.util.ArrayList;

import com.example.demo.beans.Empleat;
import com.example.demo.beans.Feina;

public interface IBaseDades {
	public void insertar(Empleat empleat);
	public void borrar(int id);
	public void modificar(Empleat empleat);
	public Empleat getEmpleat(int id);
	public ArrayList<Empleat> getEmpleats();
	public ArrayList<Empleat> buscar(Feina feina);
}
