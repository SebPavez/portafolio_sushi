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
            <asp:BoundField DataField="Nombre" HeaderText="Nombre" />
            <asp:BoundField DataField="PrecioNormal" HeaderText="Precio"  />
            <asp:BoundField DataField="PrecioOferta" HeaderText="Precio oferta"  />
            <asp:BoundField DataField="EnOferta" headerText="En oferta" />
            <asp:BoundField DataField="Stock" HeaderText="Cantidad"  />            
            <asp:ButtonField Text="Eliminar" />
        </Columns>
    </asp:GridView>
    <asp:Button ID="BtnAnular" Text="Anular Compra" CssClass="btn btn-danger" 
        runat="server" onclick="BtnAnular_Click" />
    <asp:Button ID="BtnComprar" Text="Comprar" CssClass="btn btn-success" 
        runat="server" onclick="BtnComprar_Click" />
</div>    
</asp:Content>
