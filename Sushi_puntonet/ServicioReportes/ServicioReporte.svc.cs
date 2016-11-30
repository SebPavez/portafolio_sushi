using System;
using System.Collections.Generic;
using System.Linq;
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
        public Negocio.Producto Stock(int idProducto)
        {
            Negocio.Producto productoReporte = new Negocio.Producto();
            try
            {
                using (Entidades contexto = new Entidades())
                {
                    var devolverStock = (from stock in contexto.PRODUCTOes
                                         where stock.ID_PRODUCTO == idProducto
                                         select stock).FirstOrDefault();

                    productoReporte.Nombre = devolverStock.NOMBRE;
                    productoReporte.Stock = (int)devolverStock.STOCK;
                }
                return productoReporte;
            }
            catch
            {
                return productoReporte;
            }
        }

        public List<Negocio.Pedido> ReporteVentasRealizadas()
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
                    contexto.Dispose();
                }
                return listaVentas;
            }
            catch
            {
                return null;
            }
        }

        public List<Negocio.Pedido> reporteVentasAnuladas()
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
                        DetallePedido d = new DetallePedido();

                        d.IdDetalle = (int)item.ID_DETALLE;
                        d.IdPedido = (int)item.ID_PEDIDO;
                        d.IdProducto = (int)item.ID_PRODUCTO;
                        d.Cantidad = (int)item.CANTIDAD;

                        listaDetallePedidos.Add(d);
                    }

                    if (reporte == null)
                    {
                        Pedido p = new Pedido();

                        p.IdPedido = (int)reporte.ID_PEDIDO;
                        p.DetallePedido = listaDetallePedidos;
                        listaVentasAnuladas.Add(p);
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
