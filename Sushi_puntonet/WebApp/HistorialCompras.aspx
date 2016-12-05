<%@ Page Title="" Language="C#" MasterPageFile="~/Site1.Master" AutoEventWireup="true" CodeBehind="HistorialCompras.aspx.cs" Inherits="WebApp.HistorialCompras" %>
<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
    <link rel="stylesheet" type="text/css" href="DataTables/datatables.min.css"/>
    <script type="text/javascript" src="DataTables/datatables.min.js"></script>
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
<div class="row">
    <asp:Label Text="" runat="server" ID="estadoGrilla" />
    <asp:GridView ID="grillaHistorial" ClientIDMode="Static" AutoGenerateColumns="false" runat="server" onprerender="grillaHistorial_PreRender">
        <Columns>
            <asp:BoundField HeaderText="ID Compra" DataField="IdPedido" />
            <asp:BoundField HeaderText="Estado pedido" DataField="Estado" />
            <asp:BoundField HeaderText="Fecha/Hora" DataField="FechaHoraPedido" />            
        </Columns>
    </asp:GridView>
</div>
<script type="text/javascript">
    $(document).ready(function () {
        $('#grillaHistorial').DataTable({
            "language": {
                "lengthMenu": "Mostrar _MENU_ registros por página",
                "zeroRecords": "No se encuentran registros",
                "info": "Mostrando página _PAGE_ de _PAGES_",
                "infoEmpty": "No hay registros disponibles",
                "infoFiltered": "(Filtrado de un total de _MAX_ registros)"
            }
        });
        
    });
</script>
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="ContentPLaceHolder2" runat="server">
    <a href="CarroCompras.aspx" class="btn btn-primary btn-lg">Ir al carro de compras</a>
</asp:Content>