import { Message } from './message';
import { Injectable } from '@angular/core';
import {Http, Response} from '@angular/http';
import {Observable} from "rxjs/Observable";
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/Observable/throw';


@Injectable()
export class AppService {

  private resourceUrl: string = "/message";

  constructor(private http:Http) { }
  
  getTransactionDetails():Observable<Message> {
    return this.http.get(`${this.resourceUrl}`)
    .map((res: Response) => <Message>res.json())
      .catch(this.errorHandler);
  }

  errorHandler(error: Response) {
    return Observable.throw(error || "Server Error");
  }
}
