package com.example.demo.ModuloVentas.DetalleVenta;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

public interface DetalleVentaRepositorio extends JpaRepository<DetalleVenta, Long> {

    @Query("SELECT  SUM(cantidad) FROM DetalleVenta")
    BigDecimal sumaproductos();

    @Query("SELECT COALESCE(SUM(dv.cantidad), 0) FROM DetalleVenta dv " +
            "WHERE dv.venta.fechaVenta >= :inicio AND dv.venta.fechaVenta < :fin")
    Long sumaProductosPorDia(@Param("inicio") LocalDateTime inicio,
                             @Param("fin") LocalDateTime fin);

}
