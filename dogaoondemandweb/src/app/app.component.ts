import { Component , OnInit} from '@angular/core';
import { ClienteService } from './cliente.service';
import { Cliente } from './Cliente';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'app'; 
  clientes: Cliente[];

  constructor(private clienteService: ClienteService) { }

  ngOnInit() {
    this
      .clienteService
      .getClientes()
      .subscribe((data: Cliente[]) => {
        this.clientes = data;
    });
  }
}
