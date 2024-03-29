 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.mgb.Controller;

import com.portfolio.mgb.Dto.dtoProyecto;
import com.portfolio.mgb.Entity.Proyecto;
import com.portfolio.mgb.Security.Controller.Mensaje;
import com.portfolio.mgb.Service.SProyecto;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pro")
@CrossOrigin(origins = "http://localhost:4200")
public class CProyecto {
    
    @Autowired
    SProyecto sProyecto;

    @GetMapping("/lista")
    public ResponseEntity<List< Proyecto>> list() {
        List<Proyecto> list = sProyecto.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyecto> getById(@PathVariable("id") int id) {
        if (!sProyecto.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        Proyecto proyecto = sProyecto.getOne(id).get();
        return new ResponseEntity(proyecto, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sProyecto.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        sProyecto.delete(id);
        return new ResponseEntity(new Mensaje("producto eliminado"), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoProyecto dtopro) {
        if (StringUtils.isBlank(dtopro.getNombrePro())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (sProyecto.existsByNombrePro(dtopro.getNombrePro())) {
            return new ResponseEntity(new Mensaje("Esa experiencia existe"), HttpStatus.BAD_REQUEST);
        }

        Proyecto proyectos = new Proyecto(dtopro.getNombrePro(), dtopro.getDescripcionPro(), dtopro.getImagenPro());
        sProyecto.save(proyectos);

        return new ResponseEntity(new Mensaje("Proyecto agregado!"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoProyecto dtopro) {
        //validamos ID
        if (!sProyecto.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        //compara nombres de experiencias
        if (sProyecto.existsByNombrePro(dtopro.getNombrePro()) && sProyecto.getByNombrePro(dtopro.getNombrePro()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Ese proyecto ya existe"), HttpStatus.BAD_REQUEST);
        }
        // no puede estar vacio
        if (StringUtils.isBlank(dtopro.getNombrePro())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Proyecto proyecto = sProyecto.getOne(id).get();
        proyecto.setNombrePro(dtopro.getNombrePro());
        proyecto.setDescripcionPro(dtopro.getDescripcionPro());

        sProyecto.save(proyecto);
        return new ResponseEntity(new Mensaje("Proyecto Actualizado"), HttpStatus.OK);
    }

}