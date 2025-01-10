package org.example;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


    @RestController
    @RequestMapping("/api/stands")
    public class DatabaseController {

        @PersistenceContext
        private EntityManager entityManager;
        // GET: Alle Stands abrufen
        @GetMapping
        public List<Stand> getAllStands(String name) {
            return entityManager.createQuery("SELECT s FROM Stand s WHERE s.standname LIKE :standname", Stand.class).setParameter("standname",name).getResultList();
        }
    }

