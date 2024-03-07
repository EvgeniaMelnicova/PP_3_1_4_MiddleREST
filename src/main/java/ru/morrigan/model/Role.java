package ru.morrigan.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@NoArgsConstructor
@Data
@Entity
@Table(name = "roles")
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;

    //@ManyToMany(mappedBy = "roles", fetch = FetchType.EAGER)
    // private Collection<User> users;

    @Override
    public String getAuthority() {
        return getName();
    }

    // Попробуем так
    @Override
    public String toString() {
        return name;
    }
}
