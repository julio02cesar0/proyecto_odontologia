import { Component } from '@angular/core';
import { PacienteListComponent } from './components/paciente-list/paciente-list.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [PacienteListComponent],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  title = 'consultorio-frontend';
}