import { LayoutModule } from '@angular/cdk/layout';
import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { NoopAnimationsModule } from '@angular/platform-browser/animations';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatListModule } from '@angular/material/list';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatToolbarModule } from '@angular/material/toolbar';

import { AdministratorKlinickogCentraNavigationComponent } from './administrator-klinickog-centra-navigation.component';
import {AppRoutingModule} from '../../../app-routing.module';
import {KlinikeTableComponent} from '../../general/profilAdministratoraKlinickogCentra/klinike-table/klinike-table.component';

describe('AdministratorKlinickogCentraNavigationComponent', () => {
  let component: AdministratorKlinickogCentraNavigationComponent;
  let fixture: ComponentFixture<AdministratorKlinickogCentraNavigationComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [AdministratorKlinickogCentraNavigationComponent],
      imports: [
        NoopAnimationsModule,
        LayoutModule,
        MatButtonModule,
        MatIconModule,
        MatListModule,
        MatSidenavModule,
        MatToolbarModule,
        AppRoutingModule,
        KlinikeTableComponent
      ]
    }).compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdministratorKlinickogCentraNavigationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should compile', () => {
    expect(component).toBeTruthy();
  });
});
