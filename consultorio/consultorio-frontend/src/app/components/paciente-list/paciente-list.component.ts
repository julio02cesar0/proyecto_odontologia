import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Paciente } from '../../models/paciente.model';
import { PacienteService } from '../../services/paciente.service';

@Component({
  selector: 'app-paciente-list',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './paciente-list.component.html'
})
export class PacienteListComponent implements OnInit {
  pacientes: Paciente[] = [];
  nuevoPaciente: Paciente = { documento: '', nombre: '', apellido: '', telefono: '', email: '' };

  constructor(private pacienteService: PacienteService) {}

  ngOnInit(): void {
    this.cargarPacientes();
  }

  cargarPacientes(): void {
    this.pacienteService.listarTodos().subscribe({
      next: (data) => (this.pacientes = data),
      error: (err) => console.error('Error al cargar pacientes:', err)
    });
  }

  guardarPaciente(): void {
    if (!this.nuevoPaciente.documento || !this.nuevoPaciente.nombre) return;

    this.pacienteService.crear(this.nuevoPaciente).subscribe({
      next: () => {
        this.cargarPacientes();
        this.nuevoPaciente = { documento: '', nombre: '', apellido: '', telefono: '', email: '' };
      },
      error: (err) => console.error('Error al guardar paciente:', err)
    });
  }

  eliminarPaciente(id?: number): void {
    if (!id) return;
    if (confirm('¿Deseas eliminar este paciente?')) {
      this.pacienteService.eliminar(id).subscribe({
        next: () => this.cargarPacientes(),
        error: (err) => console.error('Error al eliminar:', err)
      });
    }
  }
}