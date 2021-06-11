import { Component,ViewChild} from '@angular/core';
import { ImageCroppedEvent } from 'ngx-image-cropper';
import { FormBuilder, FormGroup } from "@angular/forms";
import { NgForm } from '@angular/forms';
@Component({
  selector: 'app-upload',
  templateUrl: './upload.component.html',
  styleUrls: ['./upload.component.css']
})
export class UploadComponent  {
  // imgChangeEvt: any = '';
  //   cropImgPreview: any = '';

  //   onFileChange(event: any): void {
  //       this.imgChangeEvt = event;
  //   }
  //   cropImg(e: ImageCroppedEvent) {
  //       this.cropImgPreview = e.base64;
  //   }

  //   imgLoad() {
  //       // display cropper tool
  //   }

  //   initCropper() {
  //       // init cropper
  //   }
    
  //   imgFailed() {
  //       // error msg
  //   }


  // dame

  // fileToUpload: any ='';
  // imageUrl: any ='';
  // handleFileInput(file: FileList) {
  //   this.fileToUpload = file.item(0);

  //   //Show image preview
  //   let reader = new FileReader();
  //   reader.onload = (event: any) => {
  //     this.imageUrl = event.target.result;
  //   }
  //   reader.readAsDataURL(this.fileToUpload);
  // }

  @ViewChild('f') 
  data!: NgForm;
  img!: File;


  onFileChanged(event:any) {
    this.img = event.target.files[0];
  }

  onSubmit() {
    const formdata = new FormData();
    formdata.append('img', this.img,this.img.name);
    if(formdata.has('img')){
      console.log(this.img);
      console.log(this.data);
    alert('success');
    } else {
      alert('not success');
    }
  }
}