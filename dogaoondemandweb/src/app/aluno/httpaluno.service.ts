import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Headers, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import 'rxjs/Rx';
import { Aluno } from './aluno.component'

@Injectable()
export class HttpAlunoService {
  constructor(private _http: Http) { }

  getAlunos(): Observable<Aluno[]> {
    return this._http.
      get('http://localhost:8080/sistemaacademico201802/rest/aluno').
      map(this.extractData);
  }

  private extractData(res: Response) {
    return res.json();
  }

  addAluno(aluno: Aluno): Observable<string> {
    const json = JSON.stringify(aluno);
    const headers = new Headers({ 'Content-Type': 'application/json' });
    const options = new RequestOptions({ headers: headers });
    return this._http.
      post('http://localhost:8080/sistemaacademico201802/rest/aluno',
      json, options).map(res => res.json());
  }
  
  updateAluno(aluno: Aluno): Observable<string> {
	    const json = JSON.stringify(aluno);
	    const headers = new Headers({ 'Content-Type': 'application/json' });
	    const options = new RequestOptions({ headers: headers });
	    return this._http.
	      post('http://localhost:8080/sistemaacademico201802/rest/aluno',
	      json, options).map(res => res.json());
	  }
}
