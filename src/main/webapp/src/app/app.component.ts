import { element } from 'protractor';
import { Component, ElementRef,AfterViewInit,OnDestroy,ViewChild } from '@angular/core';

const Highcharts = require('highcharts/highcharts.src');
import 'highcharts/adapters/standalone-framework.src';

import { AppService } from './app.service';
import { Message } from './message';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  providers: [AppService]
})
export class AppComponent implements AfterViewInit, OnDestroy {
 
   transErrorMessage: string;
   transData: any;  
   _message:Message;


  constructor(private appService: AppService) {
    const me = this;
    
    setInterval(function () {
      if (me._chart) {
        me._chart['series'][0].addPoint([(new Date()).getTime(), me.randomValue()], true, true);
      }
    }, 2000);
  }

  @ViewChild('chart') public chartEl: ElementRef;
  
  private _chart: any;
  

  private randomValue() {
    this.appService.getTransactionDetails().subscribe(transInfoData => this._message = transInfoData, resTransError => this.transErrorMessage = resTransError)
  
    // console.log(this._message.amount);
    if (Number.parseInt(this._message.amount) > 0 ) {
        return Number.parseInt(this._message.amount)
    }
    return Math.floor(Math.random() * 0) + 0;
  }
  
  public ngAfterViewInit() {
    let opts: any = {
        xAxis: {
          type: 'datetime',
          tickPixelInterval: 150
        },
        series: [{
          name: 'Transaction Data',
          data: (function () {
              var data = [],
                  time = (new Date()).getTime(),
                  i;

              for (i = -19; i <= 0; i += 1) {
                  data.push({
                      x: time + i * 1000,
                      y: Math.floor(Math.random() * 100) + 0
                  });
              }
              return data;
          }())
        }]
    };
    
    if (this.chartEl && this.chartEl.nativeElement) {
        opts.chart = {
            type: 'spline',
            renderTo: this.chartEl.nativeElement
        };

        this._chart = new Highcharts.Chart(opts);
    }
  }
  
  public ngOnDestroy() {
    this._chart.destroy();
  }
}
