import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ClienteService {

  url = 'http://localhost:8080/sistemaacademico201802/rest';
  constructor(private http: HttpClient) { }

  getClientes() {
    return this
            .http
            .get(`${this.url}/cliente`);
        }
}
