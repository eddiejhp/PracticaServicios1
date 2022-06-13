package com.idat.PracticaServicios1Prueba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.idat.PracticaServicios1Prueba.model.Items;
import com.idat.PracticaServicios1Prueba.service.ItemsService;

@Controller
@RequestMapping(path = "/item/v1")
public class ItemsController {
	
	@Autowired
	private ItemsService service;
	
	//Listar Item
	@RequestMapping("/listar")
	public @ResponseBody ResponseEntity<List<Items>> listar(){
		
		return new ResponseEntity<List<Items>>(service.listarItems(), HttpStatus.OK);
	}

	//Guardar Item
	@RequestMapping( path = "/guardar", method = RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody Items item) {
		service.guardarItem(item);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	//Eliminar Item
	@RequestMapping( path = "/eliminar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
		
		Items item = service.obtenerItemsId(id);
		
		if(item !=null) {
		service.eliminarItem(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	//Actualizar Item
	@RequestMapping( path = "/actualizar", method = RequestMethod.PUT)
	public ResponseEntity<Void> actualizar(@RequestBody Items item) {
		
	Items items =service.obtenerItemsId(item.getIdItem());
	
	if(item !=null) {
	    service.actualizarItem(item);
		return new ResponseEntity<Void>(HttpStatus.OK);
		
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	//Obtener Item
	@RequestMapping( path = "/listar/{id}", method = RequestMethod.GET)
	public ResponseEntity<Items> obtenerId(@PathVariable Integer id) {
		
		Items item =service.obtenerItemsId(id);
	
		if(item !=null) {
			return new ResponseEntity<Items>(service.obtenerItemsId(id),(HttpStatus.OK));
	}
	
		return new ResponseEntity<Items>(HttpStatus.NOT_FOUND);
	}
	
}
