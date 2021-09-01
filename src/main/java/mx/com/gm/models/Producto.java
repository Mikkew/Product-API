package mx.com.gm.models;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
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
    
    @NotEmpty
    @Size(min= 4)
    @Column(name = "nombre", nullable = false)
    private String nombre;
    
}
