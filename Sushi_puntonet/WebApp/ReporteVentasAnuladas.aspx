<%@ Page Title="" Language="C#" MasterPageFile="~/Site1.Master" AutoEventWireup="true" CodeBehind="ReporteVentasAnuladas.aspx.cs" Inherits="WebApp.ReporteVentasAnuladas" %>
<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
</asp:Content>

<asp:Content ID="Content2" ContentPlaceHolderID="ContentPLaceHolder2" runat="server">
    <asp:Label ID="lblAnuladas" runat="server" Text="Buscar Ventas Anuladas" 
        Font-Size="Medium"></asp:Label>

        <div>
        <td> &nbsp;</td>
        </div>

    <asp:Label ID="lblFechaDesde" runat="server" Text="Desde"></asp:Label>
    <asp:TextBox ID="txtFechaDesde" runat="server"></asp:TextBox>

       <div>
       <td> &nbsp;</td>
       </div>

    <asp:Label ID="lblFechaHasta" runat="server" Text="Hasta"></asp:Label>
    <asp:TextBox ID="txtFechaHasta" runat="server"></asp:TextBox>

    <div>
    <td> &nbsp;</td>
    </div>

    <textarea id="txtVentasAnuladas" runat="server"> </textarea>

     <div>
        <td> &nbsp;</td>
    </div>

    <asp:Button ID="btnAnuladas" runat="server" Text="Visualizar" 
        onclick="btnAnuladas_Click" />
</asp:Content>

<asp:Content ID="Content3" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
</asp:Content>
