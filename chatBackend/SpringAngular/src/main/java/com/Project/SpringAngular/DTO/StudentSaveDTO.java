package com.Project.SpringAngular.DTO;

public class StudentSaveDTO {

        private String studentName;
        private String studentEmail;
        private String mobile;


        public StudentSaveDTO(String studentName, String studentEmail, String mobile) {

            this.studentName = studentName;
            this.studentEmail = studentEmail;
            this.mobile = mobile;


        }

        public StudentSaveDTO() {

        }


        public String getStudentName() {
            return studentName;
        }

        public void setStudentName(String studentName) {
            this.studentName = studentName;
        }

        public String getStudentEmail() {
            return studentEmail;
        }

        public void setStudentEmail(String studentEmail) {
            this.studentEmail = studentEmail;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        @Override
        public String toString() {
            return "StudentDTO{" +
                    ", studentName='" + studentName + '\'' +
                    ", studentEmail='" + studentEmail + '\'' +
                    ", mobile=" + mobile +
                    '}';
        }
    }


