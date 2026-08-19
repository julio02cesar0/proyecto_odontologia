import { TestBed } from '@angular/core/testing';
import { provideHttpClient } from '@angular/common/http';
import { provideHttpClientTesting } from '@angular/common/http/testing';

import { PacienteService } from './paciente.service';

describe('PacienteService', () => {
  let service: PacienteService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [provideHttpClient(), provideHttpClientTesting()],
    });
    service = TestBed.inject(PacienteService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
