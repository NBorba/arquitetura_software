import { Component } from '@angular/core';
import { HttpClienteService } from './httpcliente.service';
import { Cliente } from './cliente.component';

@Component({
  selector: 'app-root',
  templateUrl: './cliente.component.html',
  providers: [HttpClienteService] 
})
export class HttpClienteComponent {
  clientes: Cliente[];
  cliente: Cliente;

  constructor(private httpClientes: HttpClienteService) {
    this.cliente = new Cliente();
    this.getClientes();
  }

  getClientes() {
    this.httpClientes.getClientes().subscribe(
      clientes => this.clientes = clientes,
      error => alert(error),
      () => console.log('terminou')
    );
  }

  addCliente() {
    this.httpClientes.addCliente(this.cliente).subscribe(
      data => data,
      error => alert(error),
      () => this.getClientes()
    );
  }
  
  loadCliente(cliente: Cliente) {
	  this.cliente = cliente;
  }
  
  updateCliente() {
	    this.httpClientes.addCliente(this.cliente).subscribe(
	      data => data,
	      error => alert(error),
	      () => this.getClientes()
	    );
	  }

  removeCliente() {
      this.httpClientes.removeCliente(this.cliente).subscribe(
        data => data,
        error => alert(error),
        () => this.getClientes()
      );
    }
}
