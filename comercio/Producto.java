package comercio;
/**
 * clase que representa un producto o clase de producto, del cual se sabe el nombre, el precio, las unidades disponibles y mas
 */
public class Producto{
    private String SKU;
    private String nombre;
    private String descripcion;
    private int unidadesDisponibles;
    private double precio;
    
    public Producto(String SKU,String nombre,String descripcion,int unidadesDisponibles,double precio){
        this.SKU = SKU;
        this.nombre=nombre;
        this.descripcion=descripcion;
        this.unidadesDisponibles=unidadesDisponibles;
        this.precio=precio;
    }
    
    public boolean tieneUnidadesDisponibles(int cantidad){
        return cantidad <= unidadesDisponibles;
    }
    
    public String resumirEnTexto(){
        return SKU + ": " + nombre + " con " + unidadesDisponibles + " unidades disponibles a $" + precio;
    }
    
    public double getPrecio(){
        return precio;
    }
    
    public String getSKU(){
        return SKU;
    }
    
    public String getNombre(){
        return nombre;
    }
}