package com.stage.hadhil.controller;
import com.stage.hadhil.entite.Achat;
import com.stage.hadhil.service.AchatService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/achat/")
public class AchatRestController {
    private final Logger log = LoggerFactory.getLogger(AchatRestController.class);

    private final AchatService achatService;

    public AchatRestController ( AchatService achatService ) {
        this.achatService = achatService;
    }

    @PostMapping("/create")
    public ResponseEntity <Achat> createAchat(@RequestBody Achat achat) {
        log.info("REST request to save achat : {}", achat);
        Achat result = achatService.create(achat);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/update")
    public ResponseEntity<Achat> updateAchat(@RequestBody Achat achat) {
        log.info("REST request to update achat : {}", achat);
        Achat result = achatService.update(achat);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Achat> deleteAchat(@RequestBody Achat achat) {
        log.info("REST request to delete achat : {}", achat);
        achatService.delete(achat);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @GetMapping("/all")
    public ResponseEntity< List <Achat> > getAllAchat( Pageable pageable) {
        final Page <Achat> page = achatService.getAll(pageable);
        return new ResponseEntity<>(page.getContent(), HttpStatus.OK);
    }

    @GetMapping("/tout")
    public  List <Achat> getTous( ) {
        return achatService.tous();
    }
}
