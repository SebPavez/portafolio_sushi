<%@ Page Title="" Language="C#" MasterPageFile="~/Site1.Master" AutoEventWireup="true" CodeBehind="Contacto.aspx.cs" Inherits="WebApp.Contacto" %>
<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
    <form>
<fieldset>
<legend>Déjenos su comentario</legend>
  <div class="form-group">
    <label for="ejemplo_email_1">Email</label>
      <asp:TextBox ID="txbCorreo" CssClass="form-control" runat="server" />   
  </div>
  <div class="form-group">
    <label for="comment">Comentario</label>
      <asp:TextBox runat="server" TextMode="MultiLine" Rows="5" ID="txbComentario" CssClass="form-control"/>
  </div>
    <asp:Button Text="Enviar" ID="btnEnviar" CssClass="btn btn-default" 
        runat="server" onclick="btnEnviar_Click"  />  
  </fieldset>   
</form>
</asp:Content>
