package uv.mx.clientes;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface ClienteRepositorio extends CrudRepository<Cliente, Integer> {
    Optional<Cliente> findByName(String name);

    Iterable<Cliente> findAllByName(String name);
}
