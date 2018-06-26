import { Component } from '@angular/core';
import { HttpAlunoService } from './httpaluno.service'
import { Aluno } from './aluno.component'

@Component({
  selector: 'app-root',
  templateUrl: './aluno.component.html',
  providers: [HttpAlunoService] 
})
export class HttpAlunoComponent {
  alunos: Aluno[];
  aluno: Aluno;

  constructor(private httpAlunoS: HttpAlunoService) {
    this.aluno = new Aluno();
    this.getAlunos();
  }

  getAlunos() {
    this.httpAlunoS.getAlunos().subscribe(
      alunos => this.alunos = alunos,
      error => alert(error),
      () => console.log('terminou')
    );
  }

  addAluno() {
    this.httpAlunoS.addAluno(this.aluno).subscribe(
      data => data,
      error => alert(error),
      () => this.getAlunos()
    );
  }
  
  loadAluno(aluno: Aluno) {
	  this.aluno = aluno;
  }
  
  updateAluno() {
	    this.httpAlunoS.addAluno(this.aluno).subscribe(
	      data => data,
	      error => alert(error),
	      () => this.getAlunos()
	    );
	  }


}
