package App.Services;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import App.Models.PhoneUser;
import App.Services.Interfaces.IGetUsers;


import java.util.logging.Level;
import java.util.logging.Logger;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jafar.j
 */
public class DBService implements IGetUsers{

    private  String URL ;
    
    private Connection connection;
    private PreparedStatement preparedStatement;
    
    public DBService(String dbUrlPath) throws java.sql.SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");

        URL = dbUrlPath;

        connection = DriverManager.getConnection(URL);
    }

    @Override
    public Iterable<PhoneUser> getAllElements() {
        LinkedList<PhoneUser> linkedList = new LinkedList<PhoneUser>();
        try{
            preparedStatement = connection.prepareStatement("select substr(key,10,4) phone_num, value full_name from astdb where key like '%/cidname' and value not like 'Alakbar Nasirov' and value not like 'Test' order by phone_num");
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                String numberM = resultSet.getString(1);
                String nameM = resultSet.getString(2);
                linkedList.add(new PhoneUser(numberM,nameM));
            }
        
        }catch (SQLException ex) {
            Logger.getLogger(DBService.class.getName()).log(Level.SEVERE, null, ex);
            linkedList = null;
        }
        
        return linkedList;
    }

    @Override
    public Iterable<PhoneUser> getElementByName(String name) {
        LinkedList<PhoneUser> linkedList = new LinkedList<PhoneUser>();

        try{
            preparedStatement = connection.prepareStatement("select substr(key,10,4) phone_num, value full_name from astdb where key like '%/cidname' and value not like 'Alakbar Nasirov' and value not like 'Test' and full_name like '%"+name+"%' order by phone_num");
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                String numberM = resultSet.getString(1);
                String nameM = resultSet.getString(2);
                linkedList.add(new PhoneUser(numberM,nameM));
            }
        }        
        catch (SQLException ex) {
            Logger.getLogger(DBService.class.getName()).log(Level.SEVERE, null, ex);
            linkedList = null;
        }
        
        return linkedList;    
    }

    @Override
    public Iterable<PhoneUser> getElementByPhone(String number) {        
        LinkedList<PhoneUser> linkedList = new LinkedList<PhoneUser>(); 
        try{
            preparedStatement = connection.prepareStatement("select substr(key,10,4) phone_num, value full_name from astdb where key like '%/cidname' and value not like 'Alakbar Nasirov' and value not like 'Test' and phone_num like '%"+number+"%' order by phone_num");
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                String numberM = resultSet.getString(1);
                String nameM = resultSet.getString(2);
                linkedList.add(new PhoneUser(numberM,nameM));
            }
        }        
        catch (SQLException ex) {
            Logger.getLogger(DBService.class.getName()).log(Level.SEVERE, null, ex);
            linkedList = null;
        }
        
        return linkedList;
    }
    
}
