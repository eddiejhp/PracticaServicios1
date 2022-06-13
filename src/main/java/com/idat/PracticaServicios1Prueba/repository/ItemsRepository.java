package com.idat.PracticaServicios1Prueba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idat.PracticaServicios1Prueba.model.Items;

@Repository
public interface ItemsRepository extends JpaRepository<Items, Integer>{

}
