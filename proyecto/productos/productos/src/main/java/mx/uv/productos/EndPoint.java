package mx.uv.productos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import https.t4is_uv_mx.productos.RegistrarProductoRequest;
import https.t4is_uv_mx.productos.RegistrarProductoResponse;

@Endpoint
public class EndPoint {
    private static final String nameSpace_uri = "https://t4is.uv.mx/productos";
    @Autowired
    private ProductoRepositorio productoRepositorio;

    @PayloadRoot(localPart = "RegistrarProductoRequest", namespace = nameSpace_uri)
    @ResponsePayload
    public RegistrarProductoResponse Registrar(@RequestPayload RegistrarProductoRequest peticion) {
        RegistrarProductoResponse respuesta = new RegistrarProductoResponse();
        Producto producto = new Producto();

        producto.setNombre(peticion.getNombre());
        producto.setCategoria(peticion.getCategoria());
        producto.setMarca(peticion.getMarca());
        producto.setPrecio(peticion.getPrecio());
        productoRepositorio.save(producto);

        respuesta.setRespuesta("El producto " + peticion.getNombre() + " de la marca " + peticion.getMarca()
                + " se ha registrado con éxito");

        return respuesta;
    }
}
