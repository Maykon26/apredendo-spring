package com.javanauta.apredendospring.Infrastructure.Repository;

import com.javanauta.apredendospring.Infrastructure.Entity.Telefone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TelefoneRepository extends JpaRepository<Telefone, Long> {
}
