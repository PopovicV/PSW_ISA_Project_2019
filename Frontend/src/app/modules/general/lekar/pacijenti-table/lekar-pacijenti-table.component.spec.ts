import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LekarPacijentiTableComponent } from './lekar-pacijenti-table.component';

describe('PacijentiTableComponent', () => {
  let component: LekarPacijentiTableComponent;
  let fixture: ComponentFixture<LekarPacijentiTableComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LekarPacijentiTableComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LekarPacijentiTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
