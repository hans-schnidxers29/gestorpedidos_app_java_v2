package com.example.demo.servicio;

import com.example.demo.entidad.Pedidos;
import com.example.demo.repositorio.PedidoRepositorio;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidosServiceImp implements PedidoService{

    @Autowired
    private PedidoRepositorio repositorio;

    @Override
    public List<Pedidos> listarpedidos() {
        return repositorio.findAll();
    }

    @Override
    public Pedidos guardarpedidos(Pedidos pedidos) {
        return repositorio.save(pedidos);
    }

    @Override
    public void deletepedidos(Long id) {
        repositorio.deleteById(id);
    }

    @Override
    public Pedidos pedidosByid(Long id) {
        return repositorio.findById(id).orElse(null);
    }
    @Override
    @Transactional
    public void Updatepedido(Long id, Pedidos pedidos) {
        Pedidos pedidos1 = repositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido no encontrado con ID: " + id));

        // Actualizar campos simples
        pedidos1.setCliente(pedidos.getCliente());
        pedidos1.setFechaEntrega(pedidos.getFechaEntrega());
        pedidos1.setFechaPedido(pedidos.getFechaPedido());
        pedidos1.setEstado(pedidos.getEstado());
        pedidos1.setObservaciones(pedidos.getObservaciones());

        // ✅ Actualizar detalles usando el método helper
        pedidos1.actualizarDetalles(pedidos.getDetalles());

        // Actualizar totales
        pedidos1.setSubtotal(pedidos.getSubtotal());
        pedidos1.setImpuesto(pedidos.getImpuesto());
        pedidos1.setTotal(pedidos.getTotal());

        System.out.println("Pedido actualizado correctamente");
        repositorio.save(pedidos1);
    }
}
