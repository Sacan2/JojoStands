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
        public void addStand(@RequestParam int id, String name, String ability, int range){
            Stand stand = new Stand();

            stand.setId(id);
            stand.setStandname(name);
            stand.setAbility(ability);
            stand.setRange(range);
            standRepository.save(stand);
        }


        @PatchMapping
        public void updateRow(@RequestParam int id, String standname){
            Stand stand = standRepository.findById(id);
            stand.setStandname(standname);
            standRepository.save(stand);

        }

        @DeleteMapping
        public void deleteRow(@RequestParam int id){
            Stand stand = standRepository.findById(id);
            standRepository.delete(stand);


        }



    }

