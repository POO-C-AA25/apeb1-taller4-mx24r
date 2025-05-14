import java.util.Scanner;
public class Problema1_EjecutorProducto {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el precio del producto: ");
        double precioProducto = sc.nextDouble();        
        System.out.print("Ingrese la cantidad de productos: ");
        int cantidadProducto = sc.nextInt();        
        // Crear objeto Producto con los datos ingresados
        Producto producto = new Producto(precioProducto, cantidadProducto);
        // Calcular descuento y precio final
        producto.calcularDescuento(producto.precioProducto, producto.cantidadProducto);
        producto.calcularPrecioFinal();
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
                "Precio unitario: $" + precioProducto + 
                ", Cantidad de producto: " + cantidadProducto + 
                ", Descuento aplicado: " + descuento + "%" + 
                ", Monto de descuento: $" + montoDescuento +
                ", Precio final: $" + precioFinal + '}';
    }   
}