package com.aleon.app.rest.Controller;

import com.aleon.app.rest.Model.Persona;
import com.aleon.app.rest.Repository.PersonasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonasController {
    @Autowired
    private PersonasRepository personasRepository;

    @GetMapping(value= "/")
    public String holaMundo(){
        return "Hola Mundo!";
    }

    @GetMapping(value= "/personas")
    public List<Persona> getPersonas(){
        return personasRepository.findAll();
    }

    @PostMapping(value= "/savepersonas")
    public String savePersona(@RequestBody Persona persona){
        personasRepository.save(persona);
        return "Persona guardada";
    }

    @PutMapping(value="/update/{id}")
    public String updatePersona(@PathVariable long id, @RequestBody Persona persona){
        Persona updatedPersona = personasRepository.findById(id).get();
        updatedPersona.setNombre(persona.getNombre());
        updatedPersona.setApellido(persona.getApellido());
        updatedPersona.setEdad(persona.getEdad());
        personasRepository.save(updatedPersona);
        return "Persona actualizada";
    }

    @DeleteMapping(value="delete/{id}")
    public String deletePersona(@PathVariable long id){
        Persona deletedPersona= personasRepository.findById(id).get();
        personasRepository.delete(deletedPersona);
        return "Persona borrada";
    }
}
