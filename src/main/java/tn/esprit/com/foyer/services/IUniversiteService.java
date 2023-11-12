package tn.esprit.com.foyer.services;

import tn.esprit.com.foyer.entities.Universite;

import java.util.List;

public interface IUniversiteService {
    List<Universite> retrieveAllUniversities();
    Universite addUniversity (Universite u);
    Universite updateUniversity (Universite u);
    Universite retrieveUniversity (long idUniversite);
    void removeUniversity  (long idUniversity );
}
