<%@ Page Title="" Language="C#" MasterPageFile="~/Site1.Master" AutoEventWireup="true" CodeBehind="Perfil.aspx.cs" Inherits="WebApp.Perfil" %>
<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">

<form class="form-horizontal">
<fieldset>
<legend>Editar perfil</legend>
<div class="form-group">
    <label for="txbNombreUsuario" class="col-lg-3 control-label">Nombre Completo</label>
    <div class="col-lg-9">
        <input type="text" class="form-control" name="txbNombreUsuario" id="txbNombreUsuario">
    </div>    
</div>
<div class="form-group">
    <label for="txbRun" class="col-lg-3 control-label">RUN</label>
    <div class="col-lg-9">
        <input type="text" class="form-control" name="txbRun" id="txbRun">
    </div>    
</div>
<div class="form-group">
    <label for="txbFechaNacimiento" class="col-lg-3 control-label">Nombre Completo</label>
    <div class="col-lg-9">
        <input type="text" class="form-control" name="txbFechaNacimiento" id="txbFechaNacimiento">
    </div>    
</div>
<div class="form-group">
      <label class="col-lg-3 control-label">Género</label>
      <div class="col-lg-9">
        <div class="radio">
          <label>
            <input name="optionsRadios" id="rdbMasculino" value="Masculino" type="radio">
            Másculino
          </label>
        </div>
        <div class="radio">
          <label>
            <input name="optionsRadios" id="rdbFemenino" value="Femenino" type="radio">
            Femenino
          </label>
        </div>
      </div>
    </div>
<div class="form-group">
    <label for="txbPassword" class="col-lg-3 control-label">Contraseña</label>
    <div class="col-lg-9">
        <input type="password" class="form-control" name="txbPassword" id="txbPassword">
    </div>    
</div>
<div class="form-group">
    <label for="txbEMail" class="col-lg-3 control-label">Correo electrónico</label>
    <div class="col-lg-9">
        <input type="email" class="form-control" name="txbEMail" id="txbEMail">
    </div>    
</div>
<div class="form-group">
    <label for="txbTelefono" class="col-lg-3 control-label">Número telefónico</label>
    <div class="col-lg-9">
        <input type="email" class="form-control" name="txbTelefono" id="txbTelefono">
    </div>    
</div>

<div class="form-group">
    <label for="txbRegion" class="col-lg-3 control-label">Región</label>
    <div class="col-lg-9">
        <input type="email" class="form-control" name="txbRegion" id="txbRegion">
    </div>    
</div>

<div class="form-group">
    <label for="txbProvincia" class="col-lg-3 control-label">Provincia</label>
    <div class="col-lg-9">
        <input type="email" class="form-control" name="txbProvincia" id="txbProvincia">
    </div>    
</div>

<div class="form-group">
    <label for="txbComuna" class="col-lg-3 control-label">Comuna</label>
    <div class="col-lg-9">
        <input type="email" class="form-control" name="txbComuna" id="txbComuna">
    </div>    
</div>

<div class="form-group">
    <label for="txbDireccion" class="col-lg-3 control-label">Dirección</label>
    <div class="col-lg-9">
        <input type="email" class="form-control" name="txbDireccion" id="txbDireccion">
    </div>    
</div>

</fieldset>
</form>
    
</asp:Content>
