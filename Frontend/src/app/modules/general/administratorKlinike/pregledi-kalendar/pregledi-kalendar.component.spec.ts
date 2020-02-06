import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PreglediKalendarComponent } from './pregledi-kalendar.component';

describe('PreglediKalendarComponent', () => {
  let component: PreglediKalendarComponent;
  let fixture: ComponentFixture<PreglediKalendarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PreglediKalendarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PreglediKalendarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
