import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  template: `
<a href="/aluno">Aluno</a><br>
<a href="/cliente">Cliente</a>
<router-outlet></router-outlet>`
})
export class AppComponent {
}
