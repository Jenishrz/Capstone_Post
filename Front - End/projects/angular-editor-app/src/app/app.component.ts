import { Component, OnInit } from '@angular/core';
import { FormArray, FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
//import { AngularEditorConfig } from 'angular-editor';
import { AngularEditorConfig } from '@kolkov/angular-editor';
import { Texteditor } from 'projects/angular-editor-app/Model/text';
import { TextpostService } from 'projects/angular-editor-app/Services/textpost.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],
})
export class AppComponent implements OnInit {
  title = 'app';
  date: Date;

  form: FormGroup;
  htmlContent1 = '';
  htmlContent2 = '';
  flag_insert!: boolean;
  flag_del!: boolean;
  flag_update!: boolean;
  text: Texteditor;

  result: String = "";
  texList: Texteditor[] = [];



  config1: AngularEditorConfig = {
    editable: true,
    spellcheck: true,
    minHeight: '5rem',
    maxHeight: '15rem',
    placeholder: 'what on your mind right now?',
    translate: 'no',
    sanitize: true,
    outline: false,
    toolbarPosition: 'bottom',
    defaultFontName: 'Lato',
    defaultFontSize: '5',
    defaultParagraphSeparator: 'p',
  };


  constructor(private formBuilder: FormBuilder, private tex: TextpostService) {
    // this.form = new FormGroup({
    //   postId: new FormControl('', [Validators.required, Validators.pattern('[0-9]+')]),
    //   postName: new FormControl('', [Validators.required, Validators.pattern('[a-zA-Z]+')])
    // }) 
    // this.text = new Texteditor();
    // this.getAllpost();

  }
  getAllpost() {
    throw new Error('Method not implemented.');
  }

  ngOnInit() {
    this.form = this.formBuilder.group({
      signature: ['', Validators.required],
    });
    console.log(this.htmlContent1);
  }

  onChange(event) {
    console.log('changed');
  }

  onBlur(event) {
    console.log('blur ' + event);
  }

  onChange2(event) {
    console.warn(this.form.value);
  }
  //  InsertText(data: Texteditor) {
  //   this.text.postId=data.postId;
  //   this.text.postName = data.postName;
  //   this.result = this.tex.insertpost(this.text);
  //   this.getAllpost();
  //   alert("Posted");
  // }
}
