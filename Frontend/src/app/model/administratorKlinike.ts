import {Klinika} from './klinika';

export class AdministratorKlinike {
  id: number;
  email: string;
  lozinka: string;
  uloga: string;
  ime: string;
  prezime: string;
  kontaktTelefon: string;
  klinika: Klinika;
}
