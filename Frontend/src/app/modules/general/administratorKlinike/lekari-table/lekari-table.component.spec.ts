import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LekariTableComponent } from './lekari-table.component';

describe('LekariTableComponent', () => {
  let component: LekariTableComponent;
  let fixture: ComponentFixture<LekariTableComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LekariTableComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LekariTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
