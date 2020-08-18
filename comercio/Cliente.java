package comercio;

import comercio.utilidades.carrito.CarritoDeCompras;

/**
 * Representa a un comparador en potencia presente en la aplicacion de comercio
 */
public class Cliente{
    private String nombre;
    private CarritoDeCompras carrito;
    
    public Cliente(String nombre){
        this.nombre = nombre;
        carrito = new CarritoDeCompras();
    }
    
    public String agregarProductoACarrito(Producto producto, int cantidad) throws Exception{
        carrito.agregarItem(producto, cantidad);
        return carrito.resumirEnTexto();
    }

    public String getNombre() {
        return nombre;
    }
    
    
}