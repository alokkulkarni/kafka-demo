import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
// import { ChartModule } from 'angular2-highcharts';
import { AppComponent } from './app.component';


@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule
    // ChartModule.forRoot(require('highcharts'))
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
