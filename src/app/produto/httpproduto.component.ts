import { Component } from '@angular/core';
import { HttpProdutoService } from './httpproduto.service';
import { Produto } from './produto.component';

@Component({
  selector: 'app-root',
  templateUrl: './produto.component.html',
  providers: [HttpProdutoService]
})
export class HttpProdutoComponent {
  produtos: Produto[];
  produto: Produto;

  constructor(private httpProdutos: HttpProdutoService) {
    this.produto = new Produto();
    this.getProdutos();
  }

  getProdutos() {
    this.httpProdutos.getProdutos().subscribe(
      produtos => this.produtos = produtos,
      error => alert(error),
      () => console.log('terminou')
    );
  }

  addProduto() {
    this.httpProdutos.addProduto(this.produto).subscribe(
      data => data,
      error => alert(error),
      () => this.getProdutos()
    );
  }
  
  loadProduto(produto: Produto) {
	  this.produto = produto;
  }
  
  updateProduto() {
	    this.httpProdutos.addProduto(this.produto).subscribe(
	      data => data,
	      error => alert(error),
	      () => this.getProdutos()
	    );
	  }

  removeProduto(produto: Produto) {
      this.httpProdutos.removeProduto(produto).subscribe(
        data => data,
        error => alert(error),
        () => this.getProdutos()
      );
    }
}
