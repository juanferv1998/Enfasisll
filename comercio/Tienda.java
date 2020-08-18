package comercio;

import java.util.*;

/**
 * clase que representa un establecimiento la aplicacion de comercio como tal 
 */
public class Tienda{
    private double acumulado;
    private ArrayList<Cliente> clientes;
    private ArrayList<Producto> productos;
    
    public Tienda(){
        acumulado = 0;
        clientes = new ArrayList<>();
        productos = new ArrayList<>();
    }
    
    public String agregarProductoACarrito(Producto producto, int cantidad, Cliente cliente) throws Exception{
        if (producto.tieneUnidadesDisponibles(cantidad)){
            return cliente.agregarProductoACarrito(producto, cantidad);
        } else {
            throw new Exception("cantidad inexistente de producto " + producto.getNombre() + "("+cantidad+")");
        }
    }
    
    public static void main(String[] args) throws Exception {
        Tienda tienda = new Tienda();
        pruebaDiego(tienda);
    }
    
    private static void pruebaDiego(Tienda tienda) throws Exception{
        tienda.productos.add(new Producto("SP80345","Dani Jedrysik","Morbi porttitor lorem id ligula.",213,1035.3));
        tienda.productos.add(new Producto("WE285878","Lucio Alishoner","Morbi non lectus.",264,1845.7));
        tienda.productos.add(new Producto("WE210393","Jasper Lamonby","Phasellus sit amet erat.",195,1922.6));
        tienda.productos.add(new Producto("SP24328","Jacquetta Gruby","Aliquam augue quam, sollicitudin vitae, consectetuer eget, rutrum at, lorem.",177,1398.0));
        tienda.productos.add(new Producto("EA260962","Janella Bess","Morbi vel lectus in quam fringilla rhoncus.",124,1851.6));
        tienda.productos.add(new Producto("SP47922","Wilton Arbuckle","Proin interdum mauris non ligula pellentesque ultrices.",153,1951.1));
        tienda.productos.add(new Producto("EA203013","Benji Durtnel","Fusce congue, diam id ornare imperdiet, sapien urna pretium nisl, ut volutpat sapien arcu sed augue.",204,2812.2));
        tienda.productos.add(new Producto("SP54730","Morry Kirkwood","Mauris lacinia sapien quis libero.",194,2842.8));
        tienda.productos.add(new Producto("WE169960","Tracy Minnette","Nulla mollis molestie lorem.",165,1652.6));
        tienda.productos.add(new Producto("WE174467","Mart Filipowicz","Aliquam sit amet diam in magna bibendum imperdiet.",20,1477.1));
        tienda.productos.add(new Producto("SP96623","Peder Gooden","Aenean auctor gravida sem.",61,2937.6));
        tienda.productos.add(new Producto("EA234072","Mathew Longfield","Fusce lacus purus, aliquet at, feugiat non, pretium quis, lectus.",293,1780.2));
        tienda.productos.add(new Producto("EA112140","Aime Silvers","Maecenas tincidunt lacus at velit.",131,1790.2));
        tienda.productos.add(new Producto("WE296480","Conrado Paolicchi","Etiam justo.",26,2225.2));
        tienda.productos.add(new Producto("PSE283", "cuca", "pedazos de torta con el inigualable sabor a cuca", 10, 3000.0));
        tienda.clientes.add(new Cliente("Diego Felipe"));
        tienda.clientes.add(new Cliente("Juan Vergara"));
        
        System.out.println("Productos a usar...");
        System.out.println("con el cliente "+tienda.clientes.get(0).getNombre()+":");
        System.out.println(tienda.productos.get(4).resumirEnTexto());
        System.out.println(tienda.productos.get(5).resumirEnTexto());
        System.out.println(tienda.productos.get(2).resumirEnTexto());
        System.out.println("con el cliente "+tienda.clientes.get(1).getNombre()+":");
        System.out.println(tienda.productos.get(6).resumirEnTexto());
        System.out.println(tienda.productos.get(14).resumirEnTexto());
        
        System.out.print(tienda.agregarProductoACarrito(tienda.productos.get(4), 120, tienda.clientes.get(0)));
        try {
            System.out.print(tienda.agregarProductoACarrito(tienda.productos.get(6), 120, tienda.clientes.get(1)));
            System.out.print(tienda.agregarProductoACarrito(tienda.productos.get(5), 155, tienda.clientes.get(0)));
        } catch(Exception e) {
            System.out.println(e.getMessage());
            System.out.print(tienda.agregarProductoACarrito(tienda.productos.get(2), 195, tienda.clientes.get(0)));
            try {
                System.out.print(tienda.agregarProductoACarrito(tienda.productos.get(14), 6, tienda.clientes.get(1)));
            } catch(Exception ex) {
                System.out.println(ex.getMessage());
                System.out.println("Todo bien");
                return;
            }
        }
        System.out.println("Algo no esta bien");
        return;
    }
}
