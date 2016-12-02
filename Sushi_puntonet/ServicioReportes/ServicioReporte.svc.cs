using System;
using System.Collections.Generic;
using System.Linq;
using System.Data.Entity;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;
using Negocio;
using DAL;

namespace Servicio
{
    // NOTA: puede usar el comando "Rename" del menú "Refactorizar" para cambiar el nombre de clase "ServicioReporte" en el código, en svc y en el archivo de configuración a la vez.
    public class ServicioReporte : IServicioReporte
    {
        public List<Negocio.Producto> Stock()
        {
            Negocio.Producto productoStock = new Negocio.Producto();

            List<Negocio.Producto> listaStock = new List<Negocio.Producto>();

            try
            {
                using (Entidades contexto = new Entidades())
                {
                    var devolverStock = (from stock in contexto.PRODUCTOes
                                         where stock.ID_PRODUCTO == productoStock.IdProducto
                                         select stock).FirstOrDefault();

                    productoStock.Nombre = devolverStock.NOMBRE;
                    productoStock.IdProducto = (int)devolverStock.ID_PRODUCTO;
                    productoStock.Stock = (int)devolverStock.STOCK;

                    listaStock.Add(productoStock);
                }
                return listaStock;
            }
            catch
            {
                return listaStock;
            }
        }

        public List<Negocio.Pedido> ReporteVentasRealizadas(DateTime FechaDesde, DateTime FechaHasta)
        {
            List<Negocio.Pedido> listaVentas = new List<Pedido>();
            List<Negocio.DetallePedido> listaDetallePedidos = new List<DetallePedido>();
            try
            {
                using (Entidades contexto = new Entidades())
                {
                    List<DAL.PEDIDO> listaVentasRecorrer = contexto.PEDIDOes.ToList<DAL.PEDIDO>();
                    List<DAL.DETALLE_PEDIDO> detallePedidos = contexto.DETALLE_PEDIDO.ToList<DAL.DETALLE_PEDIDO>();

                    foreach (DAL.PEDIDO item in listaVentasRecorrer)
                    {
                        Negocio.Pedido pedido = new Negocio.Pedido();
                        pedido.FechaHoraPedido = item.FECHA_HORA;
                        pedido.IdPedido = (int)item.ID_PEDIDO;
                        pedido.TotalVenta = (int)item.TOTAL_VENTA;
                        pedido.FormaEntrega = item.FORMA_ENTREGA;
                        pedido.Comentario = item.COMENTARIO;
                        pedido.TotalVenta = (int)item.TOTAL_VENTA;
                        pedido.RunCliente = item.RUN_CLIENTE;
                        pedido.Estado = (int)item.ID_ESTADO;

                        foreach (var det in detallePedidos)
                        {
                            Negocio.DetallePedido detalle = new DetallePedido();

                            detalle.IdDetalle = (int)det.ID_DETALLE;
                            detalle.IdPedido = (int)det.ID_PEDIDO;
                            detalle.IdProducto = (int)det.ID_PRODUCTO;
                            detalle.Cantidad = (int)det.CANTIDAD;

                            listaDetallePedidos.Add(detalle);
                        }

                        pedido.DetallePedido = listaDetallePedidos;

                        listaVentas.Add(pedido);
                    }

                }
                return listaVentas;
            }
            catch
            {
                return null;
            }
        }

        public List<Negocio.Pedido> reporteVentasAnuladas(DateTime FechaDesde, DateTime FechaHasta)
        {
            List<Negocio.Pedido> listaVentasAnuladas = new List<Negocio.Pedido>();
            List<Negocio.DetallePedido> listaDetallePedidos = new List<Negocio.DetallePedido>();

            try
            {
                using (Entidades contexto = new Entidades())
                {
                    var reporte = (from ventaAnulada in contexto.PEDIDOes
                                   where ventaAnulada.ID_ESTADO == (int)Estado.ANULADO
                                   select ventaAnulada).FirstOrDefault();

                    List<DAL.DETALLE_PEDIDO> listaAnuladasRecorrer = contexto.DETALLE_PEDIDO.ToList<DAL.DETALLE_PEDIDO>();

                    foreach (DAL.DETALLE_PEDIDO item in listaAnuladasRecorrer)
                    {
                        DetallePedido detalle = new DetallePedido();

                        detalle.IdDetalle = (int)item.ID_DETALLE;
                        detalle.IdPedido = (int)item.ID_PEDIDO;
                        detalle.IdProducto = (int)item.ID_PRODUCTO;
                        detalle.Cantidad = (int)item.CANTIDAD;

                        listaDetallePedidos.Add(detalle);
                    }

                    if (reporte == null)
                    {
                        Pedido pedido = new Pedido();

                        pedido.IdPedido = (int)reporte.ID_PEDIDO;
                        pedido.TotalVenta = (int)reporte.TOTAL_VENTA;
                        pedido.DetallePedido = listaDetallePedidos;
                        listaVentasAnuladas.Add(pedido);
                    }

                }
                return listaVentasAnuladas;
            }
            catch
            {
                return null;
            }

        }

    }
}
