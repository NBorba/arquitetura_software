import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ClienteService {

  url = 'https://node12910-env-4599970.br1.saphir.global/rest';
  constructor(private http: HttpClient) { }

  getClientes() {
    return this
            .http
            .get(`${this.url}/cliente`);
        }
}
