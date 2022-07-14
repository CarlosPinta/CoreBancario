package ec.edu.espe.arquitectura.corebancario.dao;

import ec.edu.espe.arquitectura.corebancario.model.Transaccion;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TransaccionRepository extends MongoRepository<Transaccion,String> {
}
