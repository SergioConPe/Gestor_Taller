package com.taller.gestion.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.taller.gestion.Model.Reparacion;

@Repository
public interface ReparacionRepository extends JpaRepository<Reparacion, Long>{}
