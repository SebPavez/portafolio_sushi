<%@ Page Title="" Language="C#" MasterPageFile="~/Site1.Master" AutoEventWireup="true" CodeBehind="ReporteVentas.aspx.cs" Inherits="WebApp.ReporteVentas" %>
<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
</asp:Content>

<asp:Content ID="Content2" ContentPlaceHolderID="ContentPLaceHolder2" runat="server">
    <asp:Label ID="lblVentas" runat="server" Text="Buscar ventas realizadas" 
        Font-Bold="True" Font-Size="Medium"></asp:Label>

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

    <textarea id="txtVentasRealizadas" runat="server"> </textarea>

    &nbsp;<asp:Chart ID="Chart1" runat="server">
        <Series>
            <asp:Series Name="Ventas">
            </asp:Series>
        </Series>
        <ChartAreas>
            <asp:ChartArea Name="ChartArea1">
            </asp:ChartArea>
        </ChartAreas>
    </asp:Chart>

    <div>
        <td> &nbsp;</td>
    </div>

    <asp:Button ID="btnVentas" runat="server" Text="Visualizar" 
        onclick="btnVentas_Click" />

</asp:Content>

<asp:Content ID="Content3" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
</asp:Content>
