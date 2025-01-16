package org.example;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "stands")
public class Stand {
    // Getter und Setter
    @Id
    private int id;

    @Column(name = "standname")
    private String standname;

    @Column(name = "ability")
    private String ability;

    @Column(name = "range")
    private int range;

}
