import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Headers, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import 'rxjs/Rx';
import { Vendedor } from './vendedor.component';

@Injectable()
export class HttpVendedorService {
  constructor(private _http: Http) { }

  getVendedores(): Observable<Vendedor[]> {
    return this._http.
      get('https://node12910-env-4599970.br1.saphir.global/rest/vendedor').
      map(this.extractData);
  }

  private extractData(res: Response) {
    return res.json();
  }

  addVendedor(vendedor: Vendedor): Observable<string> {
    const json = JSON.stringify(vendedor);
    const headers = new Headers({ 'Content-Type': 'application/json' });
    const options = new RequestOptions({ headers: headers });
    return this._http.
      post('https://node12910-env-4599970.br1.saphir.global/rest/vendedor',
      json, options).map(res => res.json());
  }
  
  updateVendedor(vendedor: Vendedor): Observable<string> {
	    const json = JSON.stringify(vendedor);
	    const headers = new Headers({ 'Content-Type': 'application/json' });
	    const options = new RequestOptions({ headers: headers });
	    return this._http.
	      post('https://node12910-env-4599970.br1.saphir.global/rest/vendedor',
	      json, options).map(res => res.json());
	  }
    
    removeVendedor(vendedor: Vendedor): Observable<string> {
      const json = JSON.stringify(vendedor);
      const headers = new Headers({ 'Content-Type': 'application/json' });
      const options = new RequestOptions({ headers: headers });
      return this._http.
        post('https://node12910-env-4599970.br1.saphir.global/rest/vendedor/excluir',
        json, options).map(res => res.json());
    }
}
