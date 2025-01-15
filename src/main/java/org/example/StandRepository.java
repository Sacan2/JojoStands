package org.example;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StandRepository extends JpaRepository<Stand, Integer> {
    // Custom Query Method: Suche nach dem Standnamen
    Stand findByStandname(String standname);

    // Optional: Suche nach einer Fähigkeit
    Stand findByAbility(String ability);
}
