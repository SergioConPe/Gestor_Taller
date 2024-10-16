package com.taller.gestion.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.taller.gestion.Model.Vehiculo;

@Repository
public interface VehiculoRepository extends JpaRepository<Vehiculo, String>{}

