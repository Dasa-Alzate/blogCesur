package com.example.BlogCesur.repositorios;

import com.example.BlogCesur.entidades.Noticia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioNoticias extends JpaRepository<Noticia, Long> {

}
