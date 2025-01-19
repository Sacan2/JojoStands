package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
    @RequestMapping("/api/stands")
    public class DatabaseController {



        @PersistenceContext
        private EntityManager entityManager;
        @GetMapping
        public List<Stand> getAllStands(String name) {
            return entityManager.createQuery("SELECT s FROM Stand s WHERE s.standname LIKE :standname",
                    Stand.class).setParameter("standname","%" + name + "%").getResultList();
        }
        @Autowired
        private StandRepository standRepository;
        @PostMapping("/addStand")
        public void addStand(@RequestBody Stand stand){


            standRepository.save(stand);
        }
    }

