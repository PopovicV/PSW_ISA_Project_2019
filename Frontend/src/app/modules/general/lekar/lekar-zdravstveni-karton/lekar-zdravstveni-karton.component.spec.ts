import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LekarZdravstveniKartonComponent } from './lekar-zdravstveni-karton.component';

describe('LekarZdravstveniKartonComponent', () => {
  let component: LekarZdravstveniKartonComponent;
  let fixture: ComponentFixture<LekarZdravstveniKartonComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LekarZdravstveniKartonComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LekarZdravstveniKartonComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
