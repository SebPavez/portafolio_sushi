<%@ Page Title="" Language="C#" MasterPageFile="~/Site1.Master" AutoEventWireup="true" CodeBehind="ReporteStock.aspx.cs" Inherits="WebApp.Reportes" %>

<%@ Register Assembly="System.Web.DataVisualization, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35"
    Namespace="System.Web.UI.DataVisualization.Charting" TagPrefix="asp" %>
<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
</asp:Content>

<asp:Content ID="Content2" ContentPlaceHolderID="ContentPLaceHolder2" runat="server">
    <asp:Label ID="lblVenta" runat="server" 
        Text="Stock de productos dentro del local" BorderStyle="None" Font-Bold="False" 
        Font-Italic="False" Font-Overline="False" Font-Size="Medium" 
        Font-Strikeout="False" Font-Underline="False"></asp:Label>

        <div>
        <td> &nbsp;</td>
        </div>

    <asp:GridView ID="gridStock" runat="server" AutoGenerateColumns="False" 
    DataKeyNames="ID_PRODUCTO" DataSourceID="CustomersSource">
        <Columns>
            <asp:BoundField DataField="ID_PRODUCTO" HeaderText="ID_PRODUCTO" 
                ReadOnly="True" SortExpression="ID_PRODUCTO" />
            <asp:BoundField DataField="STOCK" HeaderText="STOCK" SortExpression="STOCK" />
            <asp:BoundField DataField="NOMBRE" HeaderText="NOMBRE" 
                SortExpression="NOMBRE" />
        </Columns>
    </asp:GridView>

    <asp:SqlDataSource ID="CustomersSource" runat="server" 
    ConnectionString="<%$ ConnectionStrings:ConnectionString %>" 
    ProviderName="<%$ ConnectionStrings:ConnectionString.ProviderName %>" 
    SelectCommand="SELECT &quot;ID_PRODUCTO&quot;, &quot;STOCK&quot;, &quot;NOMBRE&quot; FROM &quot;PRODUCTO&quot;">
</asp:SqlDataSource>

    </asp:Content>

<asp:Content ID="Content3" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
</asp:Content>
