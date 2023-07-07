package com.sohaib.controllers;


import com.sohaib.security.conf.CustomConfiguration;
import com.sohaib.dao.Services.PersonneService;
import com.sohaib.entitires.PersonneEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/prop")
public class DataController {

    @Autowired
    PersonneService personneService;

    @GetMapping("/props")
    public ResponseEntity<String> getgetrecupererProps(){
        System.out.println("CONF 02: "+ CustomConfiguration.getConfiguration().getIsModeDebug());
        System.out.println("CONF 03: "+ CustomConfiguration.getConfiguration().getMsg());
        return new ResponseEntity<String>(CustomConfiguration.getConfiguration().getMsg(),HttpStatus.OK);
    }

    @GetMapping("/personnes")
    public ResponseEntity<Set<PersonneEntity>> recupererToutesLesPersonnes(){
        return new ResponseEntity<>(personneService.recupererToutesLesPersonnes(),HttpStatus.OK);
    }

    @PostMapping("/personne")
    public ResponseEntity creerPersonne(@RequestBody PersonneEntity personne){
        personneService.creerPersonne(personne);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
