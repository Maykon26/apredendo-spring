package com.javanauta.apredendospring.Infrastructure.Repository;

import com.javanauta.apredendospring.Infrastructure.Entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
