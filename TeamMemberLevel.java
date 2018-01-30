/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;

import com.codename1.messaging.Message;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.table.DefaultTableModel;
import com.codename1.ui.table.Table;
import com.codename1.util.Callback;
import java.util.ArrayList;

/**
 *
 * @author Mawutor
 */
public class TeamMemberLevel 
{
    public TeamMemberLevel()
    {
        Form form = new Form("TEAM MEMBER DASHBOARD", new BoxLayout(BoxLayout.Y_AXIS));
        Button btn13 = new Button (" Create Message");
        FontImage.setMaterialIcon(btn13, FontImage.MATERIAL_MAIL,5);
        Button button = new Button(" Task Records");
        FontImage.setMaterialIcon(button, FontImage.MATERIAL_VISIBILITY,5);
        Button button1 = new Button(" Project Records");
        Button button2=new Button(" Project Assignments");
        FontImage.setMaterialIcon(button2, FontImage.MATERIAL_VISIBILITY,5);
        FontImage.setMaterialIcon(button1, FontImage.MATERIAL_VISIBILITY,5);
        Button btn15 = new Button (" LOGOUT");
        FontImage.setMaterialIcon(btn15, FontImage.MATERIAL_KEYBOARD_BACKSPACE,5);
        Label logo = new Label();
          logo.setUIID("Label1");
        FontImage.setMaterialIcon(logo, FontImage.MATERIAL_ACCOUNT_BOX,15);
        Container contentPane = form.getContentPane();
        contentPane.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        Container container= new Container(new GridLayout(2,2));
        Container contain = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        contain.add(btn15);
        container.add(btn13);
        container.add(button);
        container.add(button1);
        container.add(button2);
        contain.setUIID("contain");
         
        contentPane.addComponent(logo);
        contentPane.addComponent(container);
        contentPane.addComponent(contain);
        form.show();
        
        btn15.addActionListener((ActionListener) new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) 
            
            {
                Home loginForm = new Home(); 
            }
        
        });
         button2.addActionListener((ActionListener) new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) 
            
            {
               getAssigns();
            }
        
        });
        
        btn13.addActionListener((ActionListener) new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                Message m = new Message("Body of message");
                Display.getInstance().sendMessage(new String[] {"recipient@email.com"}, "Subject of message", m);
              
            }
        
        });
        
        button.addActionListener((ActionListener) new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) 
            
            {
                getTasks();
            }
        
        });
        
        button1.addActionListener((ActionListener) new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) 
            
            {
                getTeam();
            }
        
        });
        
        
    }
    
    private static Object[][] convertArrayListToArray(ArrayList<Object[]> arraylist) {
        Object[][] array2D = new Object[arraylist.size()][];
        int i = 0;
        for(Object[] array : arraylist) {
            array2D[i] = array;
            i++;
        }
        return array2D;
    }
    
     public static void getTasks() {
        WebServiceProxy.getTasksAsync(new Callback() {
            @Override
            public void onSucess(Object value) {
                ArrayList arrayList = ((ArrayList_EXTERNALISED) value).getArrayList();
                fillListOfTasks(arrayList);
            }

            @Override
            public void onError(Object sender, Throwable err, int errorCode, String errorMessage) {
                Dialog.show("MSG", "ERROR", "OK",null);
            }

        });
    }

    public static void fillListOfTasks(ArrayList arraylist) {
        Table table = new Table();
        
        DefaultTableModel tablemodel1 = new DefaultTableModel(new String[]{"Name","Description","Start_Date","End_Date","Status"}, convertArrayListToArray(arraylist));
        table.setModel(tablemodel1);
        Form form = new Form("TASK TABLE", new BoxLayout(BoxLayout.Y_AXIS));
        table.setUIID("Table");
        form.add(table);
        Button button = new Button("OK");
        table.setScrollableX(true);
        form.add(button);
        form.show();
         button.addActionListener((ActionListener) new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                ProjectManagerLevel projectManagerLevel = new ProjectManagerLevel();
            }

        });
    }
    
     public static void getTeam() {
        WebServiceProxy.getTeamAsync(new Callback() {
            @Override
            public void onSucess(Object value) {
                ArrayList arrayList = ((ArrayList_EXTERNALISED) value).getArrayList();
                fillListOfTeam(arrayList);
            }

            @Override
            public void onError(Object sender, Throwable err, int errorCode, String errorMessage) {
                Dialog.show("MSG", "ERROR", "OK",null);
            }

        });
    }

    public static void fillListOfTeam(ArrayList arraylist) {
        Table table = new Table();
        
        DefaultTableModel tablemodel1 = new DefaultTableModel(new String[]{"Last_Name","First_Name","Adress","E-mail","Mobile","Password","TM-Type"}, convertArrayListToArray(arraylist));
        table.setModel(tablemodel1);
        Form form = new Form("TEAM MEMBER TABLE", new BoxLayout(BoxLayout.Y_AXIS));
        table.setUIID("Table");
        form.add(table);
        Button button = new Button("OK");
        table.setScrollableX(true);
        form.add(button);
        form.show();
         button.addActionListener((ActionListener) new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                TeamMemberLevel teamMemberLevel = new TeamMemberLevel();
            }

        });
    }
    
    public void getAssigns() {
        WebServiceProxy.getAssignsAsync(new Callback() {
            @Override
            public void onSucess(Object value) {
                ArrayList arrayList = ((ArrayList_EXTERNALISED) value).getArrayList();
                fillListOfAssigns(arrayList);
            }

            @Override
            public void onError(Object sender, Throwable err, int errorCode, String errorMessage) {
                Dialog.show("MSG", "ERROR", "OK",null);
            }

        });
    }

    public void fillListOfAssigns(ArrayList arraylist) {
        Table table = new Table();
        
        DefaultTableModel tablemodel = new DefaultTableModel(new String[]{"Team Member","Project Name","Team MemberType"}, convertArrayListToArray(arraylist));
        table.setModel(tablemodel);
        Form form = new Form("ASSIGNMENT TABLE", new BoxLayout(BoxLayout.Y_AXIS));
        table.setUIID("Table");
        Button button =new Button("OK");
        form.add(table);
        table.setScrollableX(true);
        form.add(button);
        form.show();
        button.addActionListener((ActionListener) new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                TeamMemberLevel teamMemberLevel = new TeamMemberLevel();
            }

        });
    }
    

        
    
}
