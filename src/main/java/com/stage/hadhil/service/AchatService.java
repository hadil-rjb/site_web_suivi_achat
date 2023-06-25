package com.stage.hadhil.service;
import com.stage.hadhil.entite.Achat;
import com.stage.hadhil.repository.AchatRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class AchatService {
    private final AchatRepository achatRepository;

    public AchatService ( AchatRepository achatRepository ) {
        this.achatRepository = achatRepository;
    }

    public Achat create( Achat achat) {
        return achatRepository.save(achat);
    }

    public Achat update(Achat achat) {
        if (achatRepository.existsById(achat.getId())) {
            return achatRepository.save(achat);
        }
        return null;
    }

    public void delete(Achat achat) {
        achatRepository.deleteById(achat.getId());
    }

    public Achat getById( Long id) {
        return achatRepository.findById(id).orElse(null);
    }


    public Page <Achat> getAll( Pageable pageable) {
        return achatRepository.findAll(pageable);
    }

    public List<Achat> tous( ) {
        return achatRepository.findAll();
    }
}
