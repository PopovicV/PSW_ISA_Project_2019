import {Klinika} from './klinika';

export class AdministratorKlinickogCentra {
  id: string;
  email: string;
  lozinka: string;
  ime: string;
  prezime: string;
  kontaktTelefon: string;
  klinike: Array<Klinika>;
}
