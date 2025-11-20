package com.example.demo.entidad;


import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "venta")
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "producto_id", nullable = false)
    private Productos producto;

    @Column(name = "fecha_venta", nullable = false)
    private LocalDateTime fechaVenta = LocalDateTime.now();

    @Column(name = "precio", nullable = false)
    private BigDecimal precio;

    @Column(name = "cantidad", nullable = false)
    private Integer cantidad ;

    @Column(name = "descuento")
    private BigDecimal descuento;

    @Column(name = "total", nullable = false)
    private BigDecimal total;

    @Column(name = "mediodepago", nullable = false)
    private String metodoDepago;

    public Venta() {
    }

    public Venta(Cliente cliente, Long id, Productos producto, LocalDateTime fechaVenta, BigDecimal precio,
                 Integer cantidad, BigDecimal descuento, BigDecimal total, String metodoDepago) {
        this.cliente = cliente;
        this.id = id;
        this.producto = producto;
        this.fechaVenta = fechaVenta;
        this.precio = precio;
        this.cantidad = cantidad;
        this.descuento = descuento;
        this.total = total;
        this.metodoDepago = metodoDepago;
    }

    public Venta(Cliente cliente, Productos producto, LocalDateTime fechaVenta, BigDecimal precio,
                 Integer cantidad, BigDecimal descuento, BigDecimal total, String metodoDepago) {
        this.cliente = cliente;
        this.producto = producto;
        this.fechaVenta = fechaVenta;
        this.precio = precio;
        this.cantidad = cantidad;
        this.descuento = descuento;
        this.total = total;
        this.metodoDepago = metodoDepago;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Productos getProducto() {
        return producto;
    }

    public void setProducto(Productos producto) {
        this.producto = producto;
    }

    public LocalDateTime getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(LocalDateTime fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public BigDecimal getDescuento() {
        return descuento;
    }

    public void setDescuento(BigDecimal descuento) {
        this.descuento = descuento;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}
