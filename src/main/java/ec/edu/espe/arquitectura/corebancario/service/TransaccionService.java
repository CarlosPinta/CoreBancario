package ec.edu.espe.arquitectura.corebancario.service;

import ec.edu.espe.arquitectura.corebancario.dao.CuentaRepository;
import ec.edu.espe.arquitectura.corebancario.dao.TransaccionRepository;
import ec.edu.espe.arquitectura.corebancario.model.Cuenta;
import ec.edu.espe.arquitectura.corebancario.model.Transaccion;
import lombok.RequiredArgsConstructor;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TransaccionService {

    private static final String BASE_URL = "http://localhost:8080/observados";
    private final TransaccionRepository transaccionRepository;
    private final CuentaRepository cuentaRepository;
    private final RestTemplate restTemplate;

    public TransaccionService(TransaccionRepository transaccionRepository, CuentaRepository cuentaRepository, RestTemplate restTemplate) {
        this.transaccionRepository = transaccionRepository;
        this.cuentaRepository = cuentaRepository;
        this.restTemplate = new RestTemplate(getClientHttpRequestFactory());
    }

    public Transaccion transaccion(Transaccion transaccion){
        Optional<Cuenta> cuentaOrigenOpt = this.cuentaRepository.findByCodInterno(transaccion.getCuentaOrigen());
        Optional<Cuenta> cuentaDestinoOpt = this.cuentaRepository.findByCodInterno(transaccion.getCuentaDestino());
        if (cuentaDestinoOpt.isPresent() && cuentaOrigenOpt.isPresent()){
            Cuenta cuentaOrigenDB = cuentaOrigenOpt.get();
            Cuenta cuentaDestinoDB =cuentaDestinoOpt.get();
            cuentaDestinoDB.setSaldo(cuentaDestinoDB.getSaldo().add(transaccion.getValor()));
            cuentaDestinoDB.setUltimoMovimiento(new Date());
            cuentaOrigenDB.setSaldo(cuentaOrigenDB.getSaldo().subtract(transaccion.getValor()));
            cuentaOrigenDB.setUltimoMovimiento(new Date());
        }else{
            throw new RuntimeException("Error no se encuentran las cuentas");
        }
        transaccion.setEstado("EJE");
        return this.transaccionRepository.save(transaccion);

    }

    private ClientHttpRequestFactory getClientHttpRequestFactory() {
        HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
        int connectTimeout = 5000;
        int readTimeout = 5000;
        clientHttpRequestFactory.setConnectTimeout(connectTimeout);
        clientHttpRequestFactory.setReadTimeout(readTimeout);
        return clientHttpRequestFactory;
    }
}
