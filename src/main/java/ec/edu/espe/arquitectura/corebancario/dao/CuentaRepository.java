package ec.edu.espe.arquitectura.corebancario.dao;

import ec.edu.espe.arquitectura.corebancario.model.Cuenta;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CuentaRepository extends MongoRepository<Cuenta,String> {

    Optional<Cuenta> findByIdCliente(String codCliente);
    Optional<Cuenta> findByCodInterno(String codInterno);

}
