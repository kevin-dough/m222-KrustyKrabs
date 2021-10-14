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

}
