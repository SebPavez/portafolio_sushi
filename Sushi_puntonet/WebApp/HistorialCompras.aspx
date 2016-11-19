<%@ Page Title="" Language="C#" MasterPageFile="~/Site1.Master" AutoEventWireup="true" CodeBehind="HistorialCompras.aspx.cs" Inherits="WebApp.HistorialCompras" %>
<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
<div class="row">
    <asp:GridView ID="grillaHistorial" ClientIDMode="Static" AutoGenerateColumns="false" runat="server" onprerender="grillaHistorial_PreRender">
        <Columns>
            <asp:BoundField HeaderText="ID Compra" />
            <asp:BoundField HeaderText="Estado pedido" />
            <asp:BoundField HeaderText="Total compra" />
            <asp:ButtonField Text="Anular" />
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