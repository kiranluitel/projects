import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EnterVinComponent } from './enter-vin.component';

describe('EnterVinComponent', () => {
  let component: EnterVinComponent;
  let fixture: ComponentFixture<EnterVinComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EnterVinComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EnterVinComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
