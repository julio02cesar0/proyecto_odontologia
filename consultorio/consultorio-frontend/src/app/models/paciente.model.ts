export interface Paciente {
  id?: number;
  documento: string;
  nombre: string;
  apellido: string;
  fechaNacimiento?: string;
  telefono?: string;
  email?: string;
  alergias?: string;
}