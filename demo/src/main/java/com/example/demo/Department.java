package com.example.demo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "isbn")
public class Department {

    @Id
    @Column(name = "ISBN")
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private Long isbn;
    
    @Column(name = "URL")
    private String url;
    
    // private String departmentAddress;
    // @Column(name = "departmentCode")
    // private String departmentCode;
}
