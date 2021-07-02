package mx.com.gm.rest;

import java.util.*;
import mx.com.gm.dao.ProductoDAO;
import mx.com.gm.models.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping({"", "/"})
public class ProductREST {
    
    @Autowired
    private ProductoDAO productoDAO;
    
    @GetMapping
    //@RequestMapping(value = "hello", method = RequestMethod.GET)
    public String hello() {
        return "Hello World!";
    }
    
    @GetMapping("producto")
    public ResponseEntity<Producto> getProduct() {
        Producto producto = new Producto();
        producto.setIdProducto(1L);
        producto.setNombre("Coca");
        return ResponseEntity.ok(producto);
    }
    
    @GetMapping("productos")
    public ResponseEntity< List<Producto> > getProducts() {
        List<Producto> productos = productoDAO.findAll();
        return ResponseEntity.ok(productos);
    }
    
    @GetMapping("producto/{idProducto}")
    public ResponseEntity<Producto> getProductById(
             @PathVariable Long idProducto) {
        Producto producto = productoDAO.findById(idProducto).orElse(null);
        return ResponseEntity.ok(producto);
    }
    
    @PostMapping("producto")
    public ResponseEntity<Producto> createProduct(
            @RequestBody Producto producto) {
        Producto productoNuevo = productoDAO.save(producto);
        return ResponseEntity.ok(productoNuevo);
    }
    
    @DeleteMapping("producto/{idProducto}")
    public ResponseEntity<Void> deleteProductById( 
            @PathVariable Long idProducto) {
        productoDAO.deleteById(idProducto);
        return ResponseEntity.ok(null);
    }
    
    @PutMapping("producto/{idProducto}")
    public ResponseEntity<Producto> updateProduct(
            @RequestBody Producto producto,
            @PathVariable Long idProducto) {
        Optional<Producto> productoRecuperar = productoDAO.findById(idProducto);
        if(productoRecuperar.isPresent()){
            Producto productoModificado = productoRecuperar.get();
            productoModificado.setNombre( producto.getNombre() );
            productoDAO.save( productoModificado );
            return ResponseEntity.ok(productoModificado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
