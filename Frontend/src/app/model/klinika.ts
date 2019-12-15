import { AdministratorKlinike } from './administratorKlinike';

export class Klinika {
  id: string;
  ime: string;
  adresa: string;
  opis: string;
  administratorKlinikeSet: Set<AdministratorKlinike> = new Set<AdministratorKlinike>();
}
