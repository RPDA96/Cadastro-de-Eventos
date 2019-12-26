package com.eventoapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.eventoapp.models.Convidado;
import com.eventoapp.models.Evento;

@Repository
public interface ConvidadoRepository extends CrudRepository<Convidado, String>{
	Iterable<Convidado> findByEvento(Evento evento);
	Convidado findByCodigo(long codigo);
}
