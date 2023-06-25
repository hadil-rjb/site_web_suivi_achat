package com.stage.hadhil.repository;
import com.stage.hadhil.entite.Achat;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface AchatRepository extends JpaRepository < Achat, Long >  {
    Optional <Achat> findById (Long id );

    Achat save ( Achat achat );

    void deleteById ( Long id );

    Page < Achat > findAll ( Pageable pageable );
}
