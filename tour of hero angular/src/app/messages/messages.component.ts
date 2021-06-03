import { Component, OnInit } from '@angular/core';
import { MessagesService } from '../messages.service';
@Component({
  selector: 'app-messages',
  templateUrl: './messages.component.html',
  styleUrls: ['./messages.component.css']
})
export class MessagesComponent implements OnInit {

  /**
   * Angular 只会绑定到组件的公共属性。
   * @param messageService 
   */
  constructor(public messageService:MessagesService) { }

  ngOnInit(): void {
  }

}
