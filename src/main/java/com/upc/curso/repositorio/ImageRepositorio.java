package com.upc.curso.repositorio;

import com.upc.curso.entidades.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepositorio extends JpaRepository<Image, Long> {
}
