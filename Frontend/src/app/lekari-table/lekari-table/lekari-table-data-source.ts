import { DataSource } from '@angular/cdk/collections';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { map } from 'rxjs/operators';
import { Observable, of as observableOf, merge } from 'rxjs';
import {Lekar} from '../../model/lekar';

// TODO: Replace this with your own data model type
export interface LekariTableItem {
  ime: string;
  prezime: string;
  kontaktTelefon: string;
  klinikaId: number;
  ocena: number;
  specijalizacija: string;
  smena: number;
}

// TODO: replace this with real data from your application

/**
 * Data source for the PacijentiTable view. This class should
 * encapsulate all logic for fetching and manipulating the displayed data
 * (including sorting, pagination, and filtering).
 */
export class LekariTableDataSource extends DataSource<LekariTableItem> {

  data: Lekar[];

  paginator: MatPaginator;
  sort: MatSort;

  constructor(lekari: Array<Lekar>) {
    super();
    this.data = lekari;
  }

  /**
   * Connect this data source to the table. The table will only update when
   * the returned stream emits new items.
   * @returns A stream of the items to be rendered.
   */
  connect(): Observable<Lekar[]> {
    // Combine everything that affects the rendered data into one update
    // stream for the data-table to consume.
    const dataMutations = [
      observableOf(this.data),
      this.paginator.page,
      this.sort.sortChange
    ];

    return merge(...dataMutations).pipe(map(() => {
      return this.getPagedData(this.getSortedData([...this.data]));
    }));
  }

  /**
   *  Called when the table is being destroyed. Use this function, to clean up
   * any open connections or free any held resources that were set up during connect.
   */
  disconnect() {}

  /**
   * Paginate the data (client-side). If you're using server-side pagination,
   * this would be replaced by requesting the appropriate data from the server.
   */
  private getPagedData(data: Lekar[]) {
    const startIndex = this.paginator.pageIndex * this.paginator.pageSize;
    return data.splice(startIndex, this.paginator.pageSize);
  }

  /**
   * Sort the data (client-side). If you're using server-side sorting,
   * this would be replaced by requesting the appropriate data from the server.
   * //case 'id': return compare(+a.id, +b.id, isAsc);
   */
  private getSortedData(data: Lekar[]) {
    if (!this.sort.active || this.sort.direction === '') {
      return data;
    }

    return data.sort((a, b) => {
      const isAsc = this.sort.direction === 'asc';
      switch (this.sort.active) {
        case 'id': return compare(+a.ime, +b.ime, isAsc);
        case 'ime' : return compare (a.prezime, b.prezime, isAsc);
        case 'prezime' : return compare (a.prezime, b.prezime, isAsc);
        case 'action': return 1;
        default: return 0;
      }
    });
  }
}

/** Simple sort comparator for example ID/Name columns (for client-side sorting). */
function compare(a, b, isAsc) {
  return (a < b ? -1 : 1) * (isAsc ? 1 : -1);
}
