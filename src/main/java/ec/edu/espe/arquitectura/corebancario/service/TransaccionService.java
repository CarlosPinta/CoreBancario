package ec.edu.espe.arquitectura.corebancario.service;

import ec.edu.espe.arquitectura.corebancario.dao.TransaccionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class TransaccionService {
    private final TransaccionRepository transaccionRepository;


    public void transaccion(String cuentaOrigen, String cuentaDestino, BigDecimal valor){
        if (valor>=1000){

        }


    }
}
