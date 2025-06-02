import java.util.Random;
public class Problema1_EjecutorProducto {
    public static void main (String[] args) {
        // Valores predefinidos
        double[] precios = {950.0, 1200.5, 450.75, 999.99, 2000.0, 800.25};
        int[] cantidades = {5, 10, 2, 12, 1, 20};

        Random random = new Random();
        double precioProducto = precios[random.nextInt(precios.length)];
        int cantidadProducto = cantidades[random.nextInt(cantidades.length)];

        System.out.println("Precio aleatorio seleccionado: $" + precioProducto);
        System.out.println("Cantidad aleatoria seleccionada: " + cantidadProducto);

        // Crear objeto Producto con los valores aleatorios
        Producto producto = new Producto(precioProducto, cantidadProducto);

        // Calcular descuento y precio final
        producto.calcularDescuento(producto.precioProducto, producto.cantidadProducto);
        producto.calcularPrecioFinal();

        // Mostrar resumen
        System.out.println(producto);
    }
}

class Producto {
    public double precioProducto;
    public int cantidadProducto;
    public double descuento;
    public double precioFinal;
    public double montoDescuento;

    public Producto() {
        // Constructor vacío
    }

    public Producto(double precioProducto, int cantidadProducto) {
        this.precioProducto = precioProducto;
        this.cantidadProducto = cantidadProducto;
    }
    
    public double calcularDescuento(double precioProducto, int cantidadProducto) {
       if(this.precioProducto >= 1000 && this.cantidadProducto >= 10) {
           this.descuento = 10;
       } else if (this.precioProducto < 1000) {
           this.descuento = 5;
       } else {
           this.descuento = 0;
       }
        this.montoDescuento = (this.cantidadProducto * this.precioProducto) * (this.descuento / 100);
        return this.montoDescuento;
    }
    
    public double calcularPrecioFinal() {
        this.precioFinal = (this.cantidadProducto * this.precioProducto) - this.montoDescuento;
        return this.precioFinal;
}

    @Override
    public String toString() {
        return "\n--- Resumen de la compra ---\n" + 
                "{Precio unitario: $" + precioProducto + 
                ", \nCantidad de producto: " + cantidadProducto + 
                ", \nDescuento aplicado: " + descuento + "%" + 
                ", \nMonto de descuento: $" + montoDescuento +
                ", \nPrecio final: $" + precioFinal + '}';
    }   
}