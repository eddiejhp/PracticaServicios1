package com.idat.PracticaServicios1Prueba.service;

import java.util.List;

import com.idat.PracticaServicios1Prueba.model.Items;

public interface ItemsService {
	
	
	void guardarItem(Items item);
	void actualizarItem (Items item);
	void eliminarItem (Integer id);
	List<Items>listarItems();
	Items obtenerItemsId (Integer id);
	
	
}
