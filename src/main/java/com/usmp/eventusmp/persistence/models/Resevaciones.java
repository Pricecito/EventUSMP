package com.usmp.eventusmp.persistence.models;

import org.hibernate.annotations.UuidGenerator;
import org.hibernate.annotations.UuidGenerator.Style;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
public class Resevaciones {
    @Id
    @UuidGenerator(style = Style.TIME)
    private Long id;

}
