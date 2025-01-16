package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



    @RestController
    @RequestMapping("/api/stands")
    public class DatabaseController {


        @Autowired
        private StandRepository standRepository;
        @PostMapping("/addStand")
        public void addStand(@RequestBody Stand stand){
            standRepository.save(stand);
        }


    }

