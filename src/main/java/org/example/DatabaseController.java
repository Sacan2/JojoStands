package org.example;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


    @RestController
    @RequestMapping("/api/stands")
    public class DatabaseController {

        @PersistenceContext
        private EntityManager entityManager;
        // GET: Alle Stands abrufen
        @GetMapping
        public List<Stand> getAllStands(String name) {
            return entityManager.createQuery("SELECT s FROM Stand s WHERE s.standname LIKE :standname", Stand.class).setParameter("standname","%" + name + "%").getResultList();
        }
        
        @PostMapping("/addStand")
        public String addStand(
                @RequestParam String standname,
                @RequestParam String ability,
                @RequestParam int range) {

            Stand stand = new Stand();
            stand.setStandname(standname);
            stand.setAbility(ability);
            stand.setRange(range);


            return "Details got Saved to Database";
        }


    }

