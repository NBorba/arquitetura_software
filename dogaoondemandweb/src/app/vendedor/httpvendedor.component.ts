import { Component } from '@angular/core';
import { HttpVendedorService } from './httpvendedor.service';
import { Vendedor } from './vendedor.component';

@Component({
  selector: 'app-root',
  templateUrl: './vendedor.component.html',
  providers: [HttpVendedorService]
})
export class HttpVendedorComponent {
  vendedores: Vendedor[];
  vendedor: Vendedor;

  constructor(private httpVendedores: HttpVendedorService) {
    this.vendedor = new Vendedor();
    this.getVendedores();
  }

  getVendedores() {
    this.httpVendedores.getVendedores().subscribe(
      vendedors => this.vendedores = vendedors,
      error => alert(error),
      () => console.log('terminou')
    );
  }

  addVendedor() {
    this.httpVendedores.addVendedor(this.vendedor).subscribe(
      data => data,
      error => alert(error),
      () => this.getVendedores()
    );
  }
  
  loadVendedor(vendedor: Vendedor) {
	  this.vendedor = vendedor;
  }
  
  updateVendedor() {
	    this.httpVendedores.addVendedor(this.vendedor).subscribe(
	      data => data,
	      error => alert(error),
	      () => this.getVendedores()
	    );
	  }

  removeVendedor(vendedor: Vendedor) {
      this.httpVendedores.removeVendedor(vendedor).subscribe(
        data => data,
        error => alert(error),
        () => this.getVendedores()
      );
    }
}
