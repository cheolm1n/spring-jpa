package com.roytuts.spring.data.jpa.batch.insertion.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.domain.Persistable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employee")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee implements Persistable {
    @Id
    @Column(name = "id")
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Override
    public Object getId() {
        return this.id;
    }

    @Override
    public boolean isNew() {
        return true;
    }
}