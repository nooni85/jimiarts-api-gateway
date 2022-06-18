package com.jimiarts.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name="\"user\"")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User extends BaseTimeEntity {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @NotBlank
    @Size(max = 30)
    @Column(length = 30, nullable = false, unique = true)
    String username;

    @NotBlank
    @Size(max = 72)
    @Column(length = 72, nullable = false)
    String password;

    @NotBlank
    @Size(max = 255)
    @Column(nullable = false, unique = true)
    String email;
}
