// student.component.ts
import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.css']
})
export class StudentComponent {
  studentArray: any[] = [];
  isResultLoaded = false;
  isUpdateFormActive = false;

  studentName: string = "";
  studentEmail: string = "";
  mobile: number = 0;
  currentStudentId = "";

  constructor(private http: HttpClient) {
    this.getAllStud();
  }

  getAllStud() {
    this.http.get("http://localhost:8080/api/v1/student/getAllStud")
      .subscribe(
        (resultData: any) => {
          this.isResultLoaded = true;
          console.log(resultData);
          this.studentArray = resultData;
        },
        (error) => {
          console.error("Error fetching students:", error);
        }
      );
  }

  register() {
    const bodyData = {
      "studentName": this.studentName,
      "studentEmail": this.studentEmail,
      "mobile": this.mobile
    };

    this.http.post("http://localhost:8080/api/v1/student/save", bodyData, { responseType: 'text' })
      .subscribe(
        (resultData: any) => {
          console.log(resultData);
          alert("Student Registered Successfully");
          this.getAllStud();
          this.resetForm();
        },
        (error) => {
          console.error("Error registering student:", error);
        }
      );
  }

  setUpdate(data: any) {
    this.studentName = data.studentName;
    this.studentEmail = data.studentEmail;
    this.mobile = data.mobile;
    this.currentStudentId = data.studentId;
  }

  updateRecords() {
    const bodyData = {
      "studentId": this.currentStudentId,
      "studentName": this.studentName,
      "studentEmail": this.studentEmail,
      "mobile": this.mobile
    };

    this.http.put("http://localhost:8080/api/v1/student/update", bodyData, { responseType: 'text' })
      .subscribe(
        (resultData: any) => {
          console.log(resultData);
          alert("Student Updated Successfully");
          this.getAllStud();
          this.resetForm();
        },
        (error) => {
          console.error("Error updating student:", error);
        }
      );
  }

  save() {
    if (this.currentStudentId === '') {
      this.register();
    } else {
      this.updateRecords();
    }
  }

  setDelete(data: any) {
    this.http.delete("http://localhost:8080/api/v1/student/deletecustomer" + "/" + data.studentId, { responseType: 'text' })
      .subscribe(
        (resultData: any) => {
          console.log(resultData);
          alert("Student Deleted Successfully");
          this.getAllStud();
          this.resetForm();
        },
        (error) => {
          console.error("Error deleting student:", error);
        }
      );
  }

  resetForm() {
    this.studentName = '';
    this.studentEmail = '';
    this.mobile = 0;
    this.currentStudentId = '';
  }
}
