package com.aleon.app.rest.Repository;

import com.aleon.app.rest.Model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonasRepository extends JpaRepository<Persona, Long> {
}
