import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Headers, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import 'rxjs/Rx';
import { Produto } from './produto.component';

@Injectable()
export class HttpProdutoService {
  constructor(private _http: Http) { }

  getProdutos(): Observable<Produto[]> {
    return this._http.
      get('https://node3110-env-1654973.cloud.unispace.io/rest/produto').
      map(this.extractData);
  }

  private extractData(res: Response) {
    return res.json();
  }

  addProduto(produto: Produto): Observable<string> {
    const json = JSON.stringify(produto);
    const headers = new Headers({ 'Content-Type': 'application/json' });
    const options = new RequestOptions({ headers: headers });
    return this._http.
      post('https://node3110-env-1654973.cloud.unispace.io/rest/produto',
      json, options).map(res => res.json());
  }
  
  updateProduto(produto: Produto): Observable<string> {
	    const json = JSON.stringify(produto);
	    const headers = new Headers({ 'Content-Type': 'application/json' });
	    const options = new RequestOptions({ headers: headers });
	    return this._http.
	      post('https://node3110-env-1654973.cloud.unispace.io/rest/produto',
	      json, options).map(res => res.json());
	  }
    
    removeProduto(produto: Produto): Observable<string> {
      const json = JSON.stringify(produto);
      const headers = new Headers({ 'Content-Type': 'application/json' });
      const options = new RequestOptions({ headers: headers });
      return this._http.
        post('https://node3110-env-1654973.cloud.unispace.io/rest/produto/excluir',
        json, options).map(res => res.json());
    }
}