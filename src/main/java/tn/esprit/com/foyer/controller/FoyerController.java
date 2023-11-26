package tn.esprit.com.foyer.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.com.foyer.entities.Foyer;
import tn.esprit.com.foyer.services.FoyerServices;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/foyer")
public class FoyerController {
    FoyerServices foyerServices;

    @GetMapping("/retrieve-all-foyer")
    public List<Foyer> retrieveAllFoyer(){
        return foyerServices.retrieveAllFoyers();
    }

    @GetMapping("/retrieve-foyer/{foyer-id}")
    public Foyer retrieveFoyer(@PathVariable("foyer-id") Long foyerId){
        return foyerServices.retrieveFoyer(foyerId);
    }

    @PostMapping("/add-foyer")
    public Foyer addFoyer(@RequestBody Foyer f){
        return foyerServices.addFoyer(f);
    }
    @DeleteMapping("/delete-foyer/{foyer-id}")
    public void deleteFoyer(@PathVariable("foyer-id") Long foyerId){
        foyerServices.deleteFoyer(foyerId);
    }

    @PostMapping("/archiver-foyer/{foyer-id}")
    public void archiverFoyer(@PathVariable("foyer-id") Long foyerId){
        foyerServices.archiverFoyer(foyerId);
    }
}
