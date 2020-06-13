package com.fu.mDiUnnjf0.office.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class OfficePerson {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue( strategy= GenerationType.IDENTITY)
    private Integer id;
    private String userName;
    private Integer status;

    public OfficePerson( final String userName, final Integer status ) {
        this.userName = userName;
        this.status = status;
    }
}
