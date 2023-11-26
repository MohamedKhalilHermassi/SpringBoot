package tn.esprit.com.foyer.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.com.foyer.entities.Bloc;
import tn.esprit.com.foyer.entities.Chambre;
import tn.esprit.com.foyer.repositories.BlocRepository;

import java.util.List;
import java.util.Set;

@Service
@Slf4j
@AllArgsConstructor
public class BlocServices implements IBlocService{
    BlocRepository blocRepository;

    @Override
    public List<Bloc> retrieveAllBlocs() {
        return blocRepository.findAll();
    }

    @Override
    public Bloc addBloc(Bloc b) {
        return blocRepository.save(b);
    }

    @Override
    public Bloc updateBloc(Bloc b) {
        return blocRepository.save(b);
    }

    @Override
    public Bloc retrieveBloc(Long idBloc) {
        return blocRepository.findById(idBloc).get();
    }

    @Override
    public void removeBloc(Long idBloc) {
        blocRepository.deleteById(idBloc);
    }

    @Scheduled(fixedRate = 10000)

    public void performTask() {
        log.info("start");
        List<Bloc> blocs = blocRepository.findAll();
        log.info("size : "+blocs.size());
       for (int i=0;i<blocs.size();i++)
        {
            log.info("La capacité du bloc "+blocs.get(i).getNomBloc()+ "est : " + blocs.get(i).getCapaciteBloc());
           Set<Chambre> chambres = blocs.get(i).getChambres();
            chambres.stream().forEach(
                    chambre -> {
                        log.info("le numero de la chambre est : "+ chambre.getNumeroChambre() + " et de type : " + chambre.getTypeC());
                    }
            );




        }



    }
}
