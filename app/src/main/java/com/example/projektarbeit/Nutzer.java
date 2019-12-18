package com.example.projektarbeit;

public class Nutzer {

    private String name;
    private String email;
    private String passwort;
    private int alter;
    private static int laufnummer=0;
    private int id;

    public void setName(String name) {
        this.name = name;
    }
    public String getName()
    {
        return name;
    }
    public void setAlter(int alter)
    {
        this.alter=alter;
    }
    public int getAlter()
    {
        return alter;
    }
    public void setEmail(String email)
    {
        this.email=email;
    }
    public String getEmail()
    {
        return email;
    }
    protected String getPasswort()
    {
        return passwort;
    }
    protected void setPasswort()
    {
        this.passwort=passwort;
    }
    public void setId(int id)
    {
        this.id=id;
    }
    public int getId()
    {
        return id;
    }
    public Nutzer()
    {
        id=laufnummer+1;
    }
    public Nutzer(String name, int alter,String email, String passwort)
    {
        this.name=name;
        this.alter=alter;
        this.email=email;
        this.passwort=passwort;

        this.id=laufnummer+1;

    }

    public String toString()
    {
        return "User: " + name + "Alter : " + alter;
    }
}


