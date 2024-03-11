import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Texteditor } from '../Model/text';

@Injectable({
  providedIn: 'root'
})
export class TextpostService {
  private url: string = "http://localhost:2222";


  constructor(private http: HttpClient) { }
  insertpost(text: Texteditor) {
    this.http.post(this.url + "/Insert", text).subscribe();
     return "Posted";
  }
  // getAllPostDetails() {
  //   return this.http.get<Texteditor[]>(this.url + "/ViewAll");


  // }

}
