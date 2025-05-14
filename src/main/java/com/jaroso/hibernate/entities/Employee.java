package com.jaroso.hibernate.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "employees")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false) //Campo no nulo
    private String name;

    @Column(name = "age") //Nombre en la tabla
    private Integer age;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", foreignKey = @ForeignKey(name = "Emp_Add_FK"))
    private Address address;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "company_id", foreignKey = @ForeignKey(name = "Emp_Cmp_FK"))
    private Company company;


}
