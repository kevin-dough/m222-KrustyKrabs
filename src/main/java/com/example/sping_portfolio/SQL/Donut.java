package com.example.sping_portfolio.SQL;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Donut {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @NonNull
    @Size(min = 2, max = 30, message = "Name (2 to 30 chars)")
    private String name;

    @NonNull
    @Size(min = 2, max = 30, message = "Store name(2 to 30 chars)")
    private String store;

    @NonNull
    @Size(min = 1, max = 5, message = "Add a rating")
    private int rating;


    public Donut(String name, String store, Integer rating){
        this.name = name;
        this.store = store;
        this.rating = rating;
    }

}
