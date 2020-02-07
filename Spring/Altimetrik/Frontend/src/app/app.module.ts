import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { MainComponent } from './main/main.component';
import {FormsModule } from '@angular/forms'
import {HttpClientModule, HTTP_INTERCEPTORS} from '@angular/common/http';
import { EnterVinComponent } from './enter-vin/enter-vin.component'
import { AgmCoreModule } from '@agm/core'


@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    MainComponent,
    EnterVinComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    AgmCoreModule.forRoot({
      apiKey:'AIzaSyCnMNBNOVwhZQXfMQtrxqe3CAVpG1Jsf3k'
    })

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
