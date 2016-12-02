<%@ Page Title="" Language="C#" MasterPageFile="~/Site1.Master" AutoEventWireup="true" CodeBehind="CarroCompras.aspx.cs" Inherits="WebApp.CarroCompras" %>
<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
    <link rel="stylesheet" type="text/css" href="DataTables/datatables.min.css"/>
    <script type="text/javascript" src="DataTables/datatables.min.js"></script>
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
<div class="row">
    <asp:Label Text="" ID="estadoCarro" runat="server" />
</div>
<div class="row">
    <asp:GridView ID="grillaCompras" ClientIDMode="Static" AutoGenerateColumns="false" runat="server" 
        onprerender="grillaCompras_PreRender">
        <Columns>
            <asp:BoundField DataField="Id" HeaderText="ID" />
            <asp:BoundField DataField="Nombre" HeaderText="Nombre"  />
            <asp:BoundField DataField="Cantidad" HeaderText="Cantidad"  />
            <asp:BoundField DataField="PrecioUnidad" headerText="Precio Unitario" />              
            <asp:BoundField DataField="TotalDetalle" headerText="Total detalle" />                          
        </Columns>
    </asp:GridView>    
</div>
<div class="row" id="panelComentario" runat="server">
    <div class="panel panel-primary">
        <div class="panel-heading">
            <h3 class="panel-title">Comentario</h3>
        </div>
        <div class="panel-body">
            <asp:TextBox ClientIDMode="Static" CssClass="form-control" Rows="3" TextMode="MultiLine" ID="txbComentario" runat="server">
            </asp:TextBox>
        </div>
    </div>    
</div>
<div class="row" id="panelFormaEntrega" runat="server">
    <div class="panel panel-primary">
        <div class="panel-heading"><h3 class="panel-title">Forma de entrega</h3></div>
        <div>
            <asp:DropDownList CssClass="form-control" ID="dropFormaEntrega" runat="server">
                <asp:ListItem Text="Domicilio" />
                <asp:ListItem Text="Retiro en local" />
            </asp:DropDownList>
        </div>
    </div>
</div>
<div class="row">
    <asp:Button ID="BtnAnular" Text="Anular Compra" CssClass="btn btn-danger" 
        runat="server" onclick="BtnAnular_Click" />
    <asp:Button ID="BtnComprar" Text="Comprar" CssClass="btn btn-success" 
        runat="server" onclick="BtnComprar_Click" />
</div>
    

    
<script type="text/javascript">
    $(document).ready(function () {
        $('#grillaCompras').DataTable({
            "language": {
                "lengthMenu": "Mostrar _MENU_ registros por página",
                "zeroRecords": "No se encuentran registros",
                "info": "Mostrando página _PAGE_ de _PAGES_",
                "infoEmpty": "No hay registros disponibles",
                "infoFiltered": "(Filtrado de un total de _MAX_ registros)"
            }
        });
        $('#txbComentario').css('resize', 'none');
    });
    </script>
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="ContentPLaceHolder2" runat="server">
    <a href="HistorialCompras.aspx" class="btn btn-primary btn-lg">Ir al historial de compras</a>
</asp:Content>