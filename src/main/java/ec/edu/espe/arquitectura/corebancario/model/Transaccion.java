package ec.edu.espe.arquitectura.corebancario.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Data
@Builder
@Document(collection = "transacciones")
@TypeAlias("transacciones")
public class Transaccion {
    @Id
    private String id;

    private String codInterno;

    private String cuentaOrigen;

    private String cuentaDestino;

    private BigDecimal valor;

    private String estado;

}
