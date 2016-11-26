<%@ Page Title="" Language="C#" MasterPageFile="~/Site1.Master" AutoEventWireup="true" CodeBehind="MainPage.aspx.cs" Inherits="WebApp.MainPage" %>
<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
</asp:Content>

<asp:Content ID="Content3" ContentPlaceHolderID="ContentPLaceHolder2" runat="server">
<div class="panel panel-danger">
                    <div class="panel-heading">
                        <h3 class="panel-title">
                            Búsqueda de productos</h3>
                    </div>
                    <div class="panel-body">
                        <div class="form-group">
                            <label class="control-label" for="nombre">
                            </label>
                            <input name="nombre" type="text" class="form-control" placeholder="Nombre producto"
                                required>
                        </div>
                        <div class="form-group">
                            <label for="cmbCategoria" class="control-label">
                            </label>
                            <select class="form-control" name="cmbCategoria" id="cmbCategoria">
                                <option value="">-- Selecciona producto --</option>
                                <option value="">Sushi roll</option>
                                <option value="">Promociones</option>
                                <option value="">Bebidas</option>
                            </select>
                        </div>
                        <button class="btn btn-danger">
                            Buscar</button>
                    </div>
                </div>
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">
<!-- modal para el carrito -->
 <!-- Trigger the modal with a button -->
  <button type="button" class="btn btn-info btn-lg pull-right" data-toggle="modal" data-target="#myModal">Carrito de compras
    <span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span>
  </button>

  <!-- Modal -->
  <div class="modal fade pu" id="myModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Carrito de compras</h4>
        </div>
        <div class="modal-body">
          <label>Cantidad de productos</label>
          <input type="number" />
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
      
    </div>
  </div>
    <div class="col-md-9">
                <div class="row carousel-holder">
                    <div class="col-md-12">
                        <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                            <ol class="carousel-indicators">
                                <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                                <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                                <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                            </ol>
                            <div class="carousel-inner">
                                <div class="item active">
                                    <img class="slide-image" src="http://placehold.it/800x300" alt="">
                                </div>
                                <div class="item">
                                    <img class="slide-image" src="http://placehold.it/800x300" alt="">
                                </div>
                                <div class="item">
                                    <img class="slide-image" src="http://placehold.it/800x300" alt="">
                                </div>
                            </div>
                            <a class="left carousel-control" href="#carousel-example-generic" data-slide="prev">
                                <span class="glyphicon glyphicon-chevron-left"></span>
                            </a>
                            <a class="right carousel-control" href="#carousel-example-generic" data-slide="next">
                                <span class="glyphicon glyphicon-chevron-right"></span>
                            </a>
                        </div>
                    </div>

                </div>

                <asp:UpdatePanel>
                <div class="row" id="filaElementos" runat="server">

                </div>
                </asp:UpdatePanel>
            </div>
</asp:Content>
