package comercio.utilidades.carrito;

import comercio.*;

/**
 * es la clase que representa la eleccion de un tipo de producto para el Carrito, el carrito esta compuesto de items que le ayudan con la logica de venta de cada producto independientemente
 */
abstract class Item{
    protected Producto producto;
    protected int cantidad;

    public Item(Producto producto, int cantidad){
        this.producto = producto;
        this.cantidad = cantidad;
    }
    
    /**
     * fabricador de instancias que garantiza que se use el Tipo correcto
     */
    public static Item createInstance(Producto producto, int cantidad) throws Exception{
        if (producto.getSKU().startsWith("EA")){
            return new ItemEA(producto, cantidad);
        } else if (producto.getSKU().startsWith("WE")){
            return new ItemWE(producto, cantidad);
        } else if (producto.getSKU().startsWith("SP")){
            return new ItemSP(producto, cantidad);
        } else {
            throw new Exception("codigo SKU("+producto.getSKU()+") desconocido");
        }
    }
    
    public abstract double calcularTotal();
    
    public String resumirEnTexto() throws Exception{
        return producto.getNombre() + " x"+cantidad+": $" + calcularTotal();
    }
    
    private static class ItemEA extends Item {

        public ItemEA(Producto producto, int cantidad){
            super(producto, cantidad);
        }
        public double calcularTotal(){
            return producto.getPrecio() * cantidad;
        }
    }

    private static class ItemWE extends Item {

        public ItemWE(Producto producto, int cantidad){
            super(producto, cantidad);
        }
        public double calcularTotal(){
            return producto.getPrecio() * 1000 * cantidad;
        }
    }

    private static class ItemSP extends Item {

        public ItemSP(Producto producto, int cantidad){
            super(producto, cantidad);
        }
        public double calcularTotal(){
            double descuento = 0;
            for (int conteo=1; conteo <= cantidad && descuento < 0.5; conteo++){
                if (conteo%3 == 0){
                    descuento += 0.2;
                }
            } 
            return (1-descuento)*producto.getPrecio();
        }
    }
}