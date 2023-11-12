package tn.esprit.com.foyer.services;

import tn.esprit.com.foyer.entities.Chambre;

import java.util.List;

public interface IChambreService {
    List<Chambre> retrieveAllChambre();

    Chambre addChambre(Chambre c);

    Chambre updateChambre(Chambre c);

    Chambre retrieveChambre(Long idChambre);

    void removeChambre(Long idChambre);
}
