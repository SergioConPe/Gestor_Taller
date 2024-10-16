package com.taller.gestion.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.taller.gestion.Model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{}
