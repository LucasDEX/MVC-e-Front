package service;

import java.util.ArrayList;
import java.util.List;

import dao.AreaDAO;
import model.Area;



public class AreaService {
	AreaDAO dao = new AreaDAO();
	
	public int criar(Area cliente) {
		return dao.criar(cliente);
	}
	
	public void atualizar(Area cliente){
		dao.atualizar(cliente);
	}
	
	public void excluir(int id){
		dao.excluir(id);
	}
	
	public Area carregar(int id){
		return dao.carregar(id);
	}
	
	
	
	public ArrayList<Area> carregarTodasAreas(){
		return dao.carregarTodasAreas();
	}
	public ArrayList<Area> carregarTodasAreas(String chave){
		return dao.carregarTodasAreas(chave);
	}

}
