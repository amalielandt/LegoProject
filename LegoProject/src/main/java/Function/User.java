/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Function;

/**
 *
 * @author sofieamalielandt
 */
public class User
{
   private int user_id;
   private String password;
   private String email;
   private String role;

    public User(String password, String email, String role)
    {
        this.password = password;
        this.email = email;
        this.role = role;
    }

    public User(int user_id, String password, String email, String role)
    {
        this.user_id = user_id;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    public int getUser_id()
    {
        return user_id;
    }

    public String getPassword()
    {
        return password;
    }

    public String getEmail()
    {
        return email;
    }

    public String getRole()
    {
        return role;
    }

    public void setUser_id(int user_id)
    {
        this.user_id = user_id;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public void setRole(String role)
    {
        this.role = role;
    }
   
   
   
}
