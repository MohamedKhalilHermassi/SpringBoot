package tn.esprit.com.foyer.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.com.foyer.entities.Bloc;
import tn.esprit.com.foyer.entities.Chambre;
import tn.esprit.com.foyer.entities.TypeChambre;
import tn.esprit.com.foyer.repositories.BlocRepository;
import tn.esprit.com.foyer.repositories.ChambreRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Slf4j
@AllArgsConstructor
public class ChambreServices implements IChambreService{
    ChambreRepository chambreRepository;
    BlocRepository blocRepository;
    @Override
    public List<Chambre> retrieveAllChambre() {
        return chambreRepository.findAll();
    }

    @Override
    public Chambre addChambre(Chambre c) {
        return chambreRepository.save(c);
    }

    @Override
    public Chambre updateChambre(Chambre c) {
        return chambreRepository.save(c);
    }

    @Override
    public Chambre retrieveChambre(Long idChambre) {
        return chambreRepository.findById(idChambre).get();
    }

    @Override
    public void removeChambre(Long idChambre) {
        chambreRepository.deleteById(idChambre);
    }

    public Bloc affecterChambresABloc(List<Long> numChambre, String nomBloc)
    {
    Bloc b = blocRepository.findByNomBloc(nomBloc);
        for(int i=0;i<numChambre.size();i++)
    {
      long k=  numChambre.get(i);
        System.out.println(k);
        Chambre ch = chambreRepository.findById(k).get();
      ch.setBloc(b);
      chambreRepository.save(ch);
    }
        return b;
    }
    public List<Chambre> getChambresParNomBloc ( String nomBloc )
    {
        Bloc b = blocRepository.findByNomBloc(nomBloc);
        List<Chambre> chambres = b.getChambres().stream().toList();
        return chambres;
    }

    public long nbChambreParTypeEtBloc(TypeChambre type, long idBloc )
    {
    Bloc b = blocRepository.findById(idBloc).get();
    List<Chambre> chambres;
    chambres = chambreRepository.findByTypeAndBlocJPQL(type,b);
    return chambres.size();


    }



}
