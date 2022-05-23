package com.portfolio.mgb.Interface;

import com.portfolio.mgb.Entity.Persona;
import java.util.List;

public interface IPersonaService {
    //traer una lista de personas
    public List<Persona> getPersona();
    
    //guardar un objeto de tipo persona
    public void savePersona(Persona persona);
    
    //elimina un objeto
    public void deletePersona(Long id);
   
    //buscar persona por id
    public Persona findpersona(Long id);
   
    
}
