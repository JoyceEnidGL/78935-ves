package uv.mx.clientes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import https.t4is_mx_uv.clientes.BuscarClienteRequest;
import https.t4is_mx_uv.clientes.BuscarClienteResponse;
import https.t4is_mx_uv.clientes.BuscarTodosResponse;
import https.t4is_mx_uv.clientes.EditarClienteRequest;
import https.t4is_mx_uv.clientes.EditarClienteResponse;
import https.t4is_mx_uv.clientes.EliminarClienteRequest;
import https.t4is_mx_uv.clientes.EliminarClienteResponse;
import https.t4is_mx_uv.clientes.RegistrarClienteRequest;
import https.t4is_mx_uv.clientes.RegistrarClienteResponse;

@Endpoint
public class EndPoint {
    private static final String nameSpace_uri = "https://t4is.mx.uv/clientes";
    @Autowired
    private ClienteRepositorio clienteRepositorio;

    @PayloadRoot(localPart = "RegistrarClienteRequest", namespace = nameSpace_uri)
    @ResponsePayload
    public RegistrarClienteResponse Saludar(@RequestPayload RegistrarClienteRequest peticion) {
        RegistrarClienteResponse respuesta = new RegistrarClienteResponse();
        Cliente cliente = new Cliente();

        // Guardar base de datos
        cliente.setName(peticion.getNombre());
        cliente.setApellido(peticion.getApellido());
        cliente.setTelefono(peticion.getTelefono());
        clienteRepositorio.save(cliente);

        respuesta.setRespuesta("Se ha registrado el empleado " + peticion.getNombre() + " " + peticion.getApellido());

        return respuesta;
    }

    @PayloadRoot(localPart = "BuscarClienteRequest", namespace = nameSpace_uri)
    @ResponsePayload
    public BuscarClienteResponse Buscar(@RequestPayload BuscarClienteRequest peticion) {
        BuscarClienteResponse respuesta = new BuscarClienteResponse();
        Cliente cliente = clienteRepositorio.findById(peticion.getBuscadorId()).get();

        respuesta.setRespuestaCliente("ID: " + cliente.getId() + " Nombre: "
                + cliente.getName() + " " + cliente.getApellido() + " Oficio: "
                + cliente.getTelefono());

        return respuesta;
    }

    @PayloadRoot(localPart = "EditarClienteRequest", namespace = nameSpace_uri)
    @ResponsePayload
    public EditarClienteResponse Editar(@RequestPayload EditarClienteRequest peticion) {
        EditarClienteResponse respuesta = new EditarClienteResponse();
        Cliente cliente = clienteRepositorio.findById(peticion.getEditarId()).get();

        cliente.setName(peticion.getEditarNombre());
        cliente.setApellido(peticion.getEditarApellido());
        cliente.setTelefono(peticion.getEditarTelefono());

        clienteRepositorio.save(cliente);

        respuesta.setRespuestaEditar("Se han actualizados los datos del cliente " + cliente.getName());

        return respuesta;
    }

    @PayloadRoot(localPart = "EliminarEmpleadoRequest", namespace = nameSpace_uri)
    @ResponsePayload
    public EliminarClienteResponse Eliminar(@RequestPayload EliminarClienteRequest peticion) {
        EliminarClienteResponse respuesta = new EliminarClienteResponse();

        Cliente cliente = clienteRepositorio.findById(peticion.getEliminarId()).get();

        respuesta.setRespuestaEliminar("Se ha eliminado el cliente No." + cliente.getId() + " " + cliente.getName());

        clienteRepositorio.delete(cliente);

        // Nota: también se puede eliminar por el id deleteById

        return respuesta;
    }

    @PayloadRoot(localPart = "BuscarTodosRequest", namespace = nameSpace_uri)
    @ResponsePayload
    public BuscarTodosResponse BuscarTodos() {
        BuscarTodosResponse respuesta = new BuscarTodosResponse();
        ArrayList<Cliente> empleado;
        empleado = (ArrayList<Cliente>) clienteRepositorio.findAll();

        for (int i = 0; i < empleado.size(); i++) {
            respuesta.getRespuestaTodos().add("ID: " + empleado.get(i).getId() + " Nombre: "
                    + empleado.get(i).getName() + " " + empleado.get(i).getApellido() + " Telefono: "
                    + empleado.get(i).getTelefono());
        }

        return respuesta;
    }
}
