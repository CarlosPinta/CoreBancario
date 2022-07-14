package ec.edu.espe.arquitectura.corebancario.dao;

import ec.edu.espe.arquitectura.corebancario.model.Cliente;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClienteRepository extends MongoRepository<Cliente,String> {
}
