import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Headers, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import 'rxjs/Rx';
import { Cliente } from './cliente.component';

@Injectable()
export class HttpClienteService {
  constructor(private _http: Http) { }

  getClientes(): Observable<Cliente[]> {
    return this._http.
      get('https://node12910-env-4599970.br1.saphir.global/rest/cliente').
      map(this.extractData);
  }

  private extractData(res: Response) {
    return res.json();
  }

  addCliente(cliente: Cliente): Observable<string> {
    const json = JSON.stringify(cliente);
    const headers = new Headers({ 'Content-Type': 'application/json' });
    const options = new RequestOptions({ headers: headers });
    return this._http.
      post('https://node12910-env-4599970.br1.saphir.global/rest/cliente',
      json, options).map(res => res.json());
  }
  
  updateCliente(cliente: Cliente): Observable<string> {
	    const json = JSON.stringify(cliente);
	    const headers = new Headers({ 'Content-Type': 'application/json' });
	    const options = new RequestOptions({ headers: headers });
	    return this._http.
	      post('https://node12910-env-4599970.br1.saphir.global/rest/cliente',
	      json, options).map(res => res.json());
	  }
    
    removeCliente(cliente: Cliente): Observable<string> {
      const json = JSON.stringify(cliente);
      const headers = new Headers({ 'Content-Type': 'application/json' });
      const options = new RequestOptions({ headers: headers });
      return this._http.
        post('https://node12910-env-4599970.br1.saphir.global/rest/cliente/excluir',
        json, options).map(res => res.json());
    }
}
