package tn.esprit.com.foyer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.com.foyer.entities.Bloc;
import java.util.List;

@Repository
public interface BlocRepository extends JpaRepository<Bloc,Long> {



    public Bloc findByNomBloc(String nom);
}
