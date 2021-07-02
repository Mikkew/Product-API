package mx.com.gm.models;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "PRODUCTOS")
public class Producto implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idProducto")
    private Long idProducto;
    
    @Column(name = "nombre", nullable = false, length = 30)
    private String nombre;
    
}
