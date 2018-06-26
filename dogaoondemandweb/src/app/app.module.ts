import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { RouterModule } from '@angular/router';

import { AppComponent } from './app.component';
import { HttpAlunoComponent } from './aluno/httpaluno.component';
import { HttpClienteComponent } from './cliente/httpcliente.component';

@NgModule({
  declarations: [
    AppComponent,
    HttpAlunoComponent,
    HttpClienteComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    RouterModule.forRoot([
  {
    path: 'aluno',
    component: HttpAlunoComponent
  },
  {
    path: 'cliente',
    component: HttpClienteComponent
  }
])
  ],
  providers: [HttpAlunoComponent, 
    HttpClienteComponent],
  bootstrap: [AppComponent]
})
export class AppModule { }
