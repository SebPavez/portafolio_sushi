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
                            <label class="control-label" for="nombre"></label>
                            <input name="nombre" type="text" class="form-control" placeholder="Nombre producto" required>
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
                        <button class="btn btn-danger disabled">Buscar</button>
                    </div>
                </div>
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" runat="server">

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
