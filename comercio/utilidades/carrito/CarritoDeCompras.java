package comercio.utilidades.carrito;

import java.util.*;
import comercio.Producto;

/**
 * agrupador de los productos que un Cliente quiere comprar, es un facilitador de compra para el cliente, se encarga de administrar por el cliente los items de compra
 */
public class CarritoDeCompras{
    private ArrayList<Item> items;
    
    public CarritoDeCompras(){
        items = new ArrayList<>();
    }
    
    public void agregarItem(Producto producto, int cantidad) throws Exception{
        items.add(Item.createInstance(producto, cantidad));
    }
    
    public double calcularTotal() throws Exception{
        double total = 0;
        for (int i = 0; i < items.size(); i++){
            total += items.get(i).calcularTotal();
        }
        return total;
    }
    
    public String resumirEnTexto() throws Exception{
        String descripcion = "\n";
        for (int i = 0; i < items.size(); i++){
            descripcion += items.get(i).resumirEnTexto() + "\n";
        }
        descripcion += "Total a pagar = " + calcularTotal() + "\n";
        return descripcion;
    }
}