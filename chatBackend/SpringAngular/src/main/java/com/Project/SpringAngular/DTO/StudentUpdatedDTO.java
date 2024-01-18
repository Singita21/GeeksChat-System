package com.Project.SpringAngular.DTO;

public class StudentUpdatedDTO {

        private int studentId;
        private String studentName;
        private String studentEmail;
        private String mobile;


        public StudentUpdatedDTO(int studentId, String studentId1, String studentName, String studentEmail, String mobile) {
            this.studentId = studentId;
            this.studentName = studentName;
            this.studentEmail = studentEmail;
            this.mobile = mobile;


        }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
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
                    "studentid=" + studentId +
                    ", studentName='" + studentName + '\'' +
                    ", studentEmail='" + studentEmail + '\'' +
                    ", mobile=" + mobile +
                    '}';
        }

}


