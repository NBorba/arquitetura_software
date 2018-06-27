import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { RouterModule } from '@angular/router';

import { AppComponent } from './app.component';
import { HttpClienteComponent } from './cliente/httpcliente.component';
import { HttpVendedorComponent } from './vendedor/httpvendedor.component';
import { HttpProdutoComponent } from './produto/httpproduto.component';

@NgModule({
  declarations: [
    AppComponent,
    HttpClienteComponent,
    HttpVendedorComponent,
    HttpProdutoComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    RouterModule.forRoot([
    {
    path: 'cliente',
    component: HttpClienteComponent
    },
    {
      path: 'cliente',
      component: HttpClienteComponent
    },
    {
      path: 'vendedor',
      component: HttpVendedorComponent
    },
    {
      path: 'produto',
      component: HttpProdutoComponent
    },
    {
      path: '',
      component: AppComponent
    }
])
  ],
  providers: [
    HttpClienteComponent,
    HttpVendedorComponent,
    HttpProdutoComponent
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
