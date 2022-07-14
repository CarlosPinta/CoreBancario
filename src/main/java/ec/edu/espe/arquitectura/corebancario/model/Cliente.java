package ec.edu.espe.arquitectura.corebancario.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Data
@Builder
@Document(collection = "clientes")
@TypeAlias("clientes")
public class Cliente {
    @Id
    private String id;

    private String nombreCompleto;

    private BigDecimal estado;
}
