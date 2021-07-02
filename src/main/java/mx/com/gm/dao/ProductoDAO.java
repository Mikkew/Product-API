package mx.com.gm.dao;

import mx.com.gm.models.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoDAO extends JpaRepository<Producto, Long>{
}
