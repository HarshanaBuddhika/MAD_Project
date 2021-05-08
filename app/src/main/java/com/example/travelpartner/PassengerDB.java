package com.example.travelpartner;

public class PassengerDB {
    private String Fname;
    private String Lname;
    private String Email;
    private String phone;
    private String Password;

    public PassengerDB() {

    }
        public String getFname () {
            return Fname;
        }

        public void setFname (String fname){
            Fname = fname;
        }

        public String getLname () {
            return Lname;
        }

        public void setLname (String lname){
            Lname = lname;
        }

        public String getEmail () {
            return Email;
        }

        public void setEmail (String email){
            Email = email;
        }

        public String getPhone () {
            return phone;
        }

        public void setPhone (String phone){
            this.phone = phone;
        }

        public String getPassword () {
            return Password;
        }

        public void setPassword (String password){
            Password = password;
        }

}
