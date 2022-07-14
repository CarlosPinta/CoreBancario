package ec.edu.espe.arquitectura.corebancario.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
@Document(collection = "cuentas")
@TypeAlias("cuentas")
public class Cuenta {
    @Id
    private String id;

    private String idCliente;

    private String codInterno;

    private BigDecimal saldo;

    private Date ultimoMovimiento;

    private String estado;

}
