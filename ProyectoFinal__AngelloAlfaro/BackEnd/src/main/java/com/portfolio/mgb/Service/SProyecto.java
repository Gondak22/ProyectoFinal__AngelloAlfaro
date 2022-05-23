/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.mgb.Service;

import com.portfolio.mgb.Entity.Proyecto;
import com.portfolio.mgb.Repository.RProyecto;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SProyecto {
   @Autowired
    RProyecto rProyecto;

    public List<Proyecto> list() {
        return rProyecto.findAll();
    }

    public Optional<Proyecto> getOne(int id) {
        return rProyecto.findById(id);
    }
    
   public Optional <Proyecto> getByNombrePro(String nombreP){
       return rProyecto.findByNombrePro(nombreP);
   }
   
   public void save(Proyecto pro) {
       rProyecto.save(pro);
   }
   
   public void delete(int id){
       rProyecto.deleteById(id);
   }
   
   public boolean existsById(int id){
       return rProyecto.existsById(id);
   }
   
   public boolean existsByNombrePro(String nombreP){
       return rProyecto.existsByNombrePro(nombreP);
   }
}