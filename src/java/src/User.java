/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.io.Serializable;

/**
 *
 * @author coola
 */
public class User  implements Serializable {
    
    private int userID;
    private String userName;
    private String userEmail;
    private String userPassword;
    private int premium;
    private int admin;
    private int profilePic;
    private String passwordQuestion;
    
    public User(){
        userID = 0;
        userName = "";
        userEmail = "";
        userPassword = "";
        premium = 0;
        admin = 0;
        profilePic =1;
        passwordQuestion ="";
    }

    public User(int userID, String userName, String userEmail, String userPassword, int premium, int admin, int profilePic, String passwordQuestion) {
        this.userID = userID;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.premium = premium;
        this.admin = admin;
        this.profilePic = profilePic;
        this.passwordQuestion = passwordQuestion;
    }

    public String getPasswordQuestion() {
        return passwordQuestion;
    }

    public void setPasswordQuestion(String passwordQuestion) {
        this.passwordQuestion = passwordQuestion;
    }
    

    public int getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(int profilePic) {
        this.profilePic = profilePic;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public int getPremium() {
        return premium;
    }

    public void setPremium(int premium) {
        this.premium = premium;
    }

    public int getAdmin() {
        return admin;
    }

    public void setAdmin(int admin) {
        this.admin = admin;
    }

    
}
