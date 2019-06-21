
package com.mvc.bean;

public class User {
       
    private String userName;
    private String userSurname;
    private String dayBirthday;
    private String monthBirthday;
    private Integer yearBirthday;
    private String country;
    private String email;
    private String gender;
    private String password;
    
    //user contacts
    private String userHomeTown;
    private String  userMobilePhone; 
    
    // user interests
    private String userFilms;
    private String userBooks;
    private String userMusic;
    private String userSport;
    
    //user hobies
    private String userHobbies;
    
    private int userId;
    
    

  
    
    public User() {}  
    public User( String name, String surname){        
        this.userName = name;
        this.userSurname = surname;
    }
    
        
    public String getUserName(){return userName;}
    public String getUserSurname(){return userSurname;}
    public String getDayBirthday(){return dayBirthday;}
    public String getMonthBirthday(){return monthBirthday;}
    public Integer getYearBirthday(){return yearBirthday;}
    public String getCountry(){return country;}
    public String getEmail(){return email;}
    public String getGender(){return gender;}
    public String getPassword(){return password;}
        
    //user contscts
    public String getUserHomeTown(){return userHomeTown;}
    public String getUserMobilePhone(){return userMobilePhone;}
    
    //user interests
    public String getUserFilms(){return userFilms;}
    public String getUserBooks(){return userBooks;}
    public String getUserMusic(){return userMusic;}
    public String getUserSport(){return userSport;}
    
    //user hobbies
    public String getUserHobbies(){return userHobbies;}
    
    
    
        
    public void setUserName(String userName){this.userName = userName;}
    public void setUserSurname(String userSurname){this.userSurname = userSurname;}
    public void setDayBirthday(String dayBirthday){this.dayBirthday = dayBirthday;}
    public void setMonthBirthday(String monthBirthday){this.monthBirthday = monthBirthday;}
    public void setYearBirthday(Integer yearBirthday){this.yearBirthday = yearBirthday;}
    public void setCountry(String country){this.country = country;}
    public void setEmail(String email){this.email = email;}
    public void setGender(String gender){this.gender = gender;}
    public void setPassword(String password){this.password = password;}
    
    //user contscts
    public void setUserHomeTown(String userHomeTown){this.userHomeTown = userHomeTown;}
    public void setUserMobilePhone(String userMobilePhone){this.userMobilePhone = userMobilePhone;}
    
    
    //user interests
    public void setUserFilms(String userFilms){this.userFilms = userFilms;}
    public void setUserBooks(String userBooks){this.userBooks = userBooks;}
    public void setUserMusic(String userMusic){this.userMusic = userMusic;}
    public void setUserSport(String userSport){this.userSport = userSport;}
    
    //user hobbies    
    public void setUserHobbies(String userHobbies){this.userHobbies = userHobbies;}
   
    
      public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
    
    
     

    @Override
    public String toString() {
        return  userName+" "+userSurname ;
    }   
}    
  
   
     

