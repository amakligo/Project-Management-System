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
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.table.DefaultTableModel;
import com.codename1.ui.table.Table;
import com.codename1.ui.util.UITimer;
import static com.codename1.ui.util.UITimer.timer;
import com.codename1.util.Callback;
import java.util.ArrayList;
import static com.codename1.ui.util.UITimer.timer;

/**
 *
 * @author Mawutor
 */
public class AdminDashboard {

    public Form Adminform;
    private Runnable form;

    public AdminDashboard() {
       
        Adminform = new Form("ADMINISTRATOR DASHBOARD", new BoxLayout(BoxLayout.Y_AXIS));
        
        Label logo = new Label();
        FontImage.setMaterialIcon(logo, FontImage.MATERIAL_SUPERVISOR_ACCOUNT, 15);
        logo.setUIID("Label1");
        Button btn = new Button(" Create Project");
        FontImage.setMaterialIcon(btn, FontImage.MATERIAL_CREATE_NEW_FOLDER, 5);
        Button btn1 = new Button(" Project Manager");
        FontImage.setMaterialIcon(btn1, FontImage.MATERIAL_PERSON_ADD, 5);
        Button btn2 = new Button(" Team Member");
        FontImage.setMaterialIcon(btn2, FontImage.MATERIAL_PERSON_ADD, 5);
        Button btn8 = new Button(" Assign Project");
         FontImage.setMaterialIcon(btn8, FontImage.MATERIAL_ASSIGNMENT, 5);
        Button btn4 = new Button(" Task Table");
        FontImage.setMaterialIcon(btn4, FontImage.MATERIAL_CLOUD, 5);
        Button btn6 = new Button(" Project Table");
        FontImage.setMaterialIcon(btn6, FontImage.MATERIAL_CLOUD_CIRCLE, 5);
        Button btn7 = new Button(" Team Table");
        FontImage.setMaterialIcon(btn7, FontImage.MATERIAL_CLOUD_UPLOAD, 5);
        Button btn10 = new Button(" Create Message");
        FontImage.setMaterialIcon(btn10, FontImage.MATERIAL_MAIL, 5);
        Button btn11 = new Button(" Assign Table");
        FontImage.setMaterialIcon(btn11, FontImage.MATERIAL_VISIBILITY, 5);
        Button btn12 = new Button(" Local Message");
        FontImage.setMaterialIcon(btn12, FontImage.MATERIAL_VISIBILITY, 5);
        Button btn3 = new Button(" LOGOUT");
        FontImage.setMaterialIcon(btn3, FontImage.MATERIAL_KEYBOARD_ARROW_LEFT, 5);
        Container contentPane = Adminform.getContentPane();
        contentPane.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        Container containn = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        Container contain = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        

       // containn.add(logo);
        contain.add(btn);
        contain.add(btn1);
        
        contain.add(btn2);
        contain.add(btn10);
        contain.add(btn8);
        contain.add(btn4);
        contain.add(btn6);
        contain.add(btn7);
        contain.add(btn11);
        contain.add(btn12);
        
        
        containn.add(btn3);
        containn.setUIID("contain");
        contentPane.addComponent(logo);
        contentPane.addComponent(contain);
        contentPane.addComponent(containn);
      
        Adminform.show();
        
   

        btn3.addActionListener((ActionListener) new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {

                Home loginForm = new Home();

            }
        });

        btn.addActionListener((ActionListener) new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                NewPoject newPoject = new NewPoject();
            }
        });

        btn1.addActionListener((ActionListener) new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                ProjectManager projectManager = new ProjectManager();
            }
        });

        btn2.addActionListener((ActionListener) new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                TeamMember teamMember = new TeamMember();
            }
        });

        btn4.addActionListener((ActionListener) new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                getTasks();

            }

        });
        btn6.addActionListener((ActionListener) new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                getProjects();
            }

        });
        
         btn11.addActionListener((ActionListener) new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                getAssigns();
            }

        });

        btn7.addActionListener((ActionListener) new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                getTeam();

            }

        });
        
        btn12.addActionListener((ActionListener) new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                getMsg();

            }

        });

        btn8.addActionListener((ActionListener) new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                
                someProjects();
            }

        });

        btn10.addActionListener((ActionListener) new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                Message m = new Message("");
                Display.getInstance().sendMessage(new String[]{""}, "", m);
            }

        });

    }

    public void show() {
        Adminform.show();
    }

    public void getProjects() {
        WebServiceProxy.getProjectsAsync(new Callback() {
            @Override
            public void onSucess(Object value) {
                ArrayList arrayList = ((ArrayList_EXTERNALISED) value).getArrayList();
                fillListOfProjects(arrayList);
            }

            @Override
            public void onError(Object sender, Throwable err, int errorCode, String errorMessage) {
                Dialog.show("MSG", "ERROR", "OK", null);
            }

        });
    }

    public void fillListOfProjects(ArrayList arraylist) {
        Table table = new Table();

        DefaultTableModel tablemodel = new DefaultTableModel(new String[]{"Name", "Start_Date", "Description", "Status"}, convertArrayListToArray(arraylist));
        table.setModel(tablemodel);
        Form form = new Form("PROJECT TABLE", new BoxLayout(BoxLayout.Y_AXIS));
        table.setUIID("Table");
        Button button = new Button("OK");
        form.add(table);
        table.setScrollableX(true);
        
        
        form.add(button);
        form.show();
        button.addActionListener((ActionListener) new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                AdminDashboard adminDashboard = new AdminDashboard();
            }

        });
    }

    private static Object[][] convertArrayListToArray(ArrayList<Object[]> arraylist) {
        Object[][] array2D = new Object[arraylist.size()][];
        int i = 0;
        for (Object[] array : arraylist) {
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
                Dialog.show("MSG", "ERROR", "OK", null);
            }

        });
    }

    public static void fillListOfTasks(ArrayList arraylist) {
        Table table = new Table();

        DefaultTableModel tablemodel1 = new DefaultTableModel(new String[]{"Name", "Description", "Start_Date", "End_Date", "Status"}, convertArrayListToArray(arraylist));
        table.setModel(tablemodel1);
        Form form = new Form("TASK TABLE", new BoxLayout(BoxLayout.Y_AXIS));
        table.setUIID("Table");
        form.add(table);
        table.setScrollableX(true);
        Button button = new Button("OK");
        form.add(button);
        form.show();
        button.addActionListener((ActionListener) new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                AdminDashboard adminDashboard = new AdminDashboard();
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
                Dialog.show("MSG", "ERROR", "OK", null);
            }

        });
    }

    public static void fillListOfTeam(ArrayList arraylist) {
        Table table = new Table();

        DefaultTableModel tablemodel1 = new DefaultTableModel(new String[]{"Last_Name", "First_Name", "Adress", "E-mail", "Mobile", "Password", "TM-Type"}, convertArrayListToArray(arraylist));
        table.setModel(tablemodel1);
        Form form = new Form("TEAM MEMBER TABLE", new BoxLayout(BoxLayout.Y_AXIS));
        table.setUIID("Table");
        table.setScrollableX(true);
        form.add(table);
        Button button = new Button("OK");
        form.add(button);
        form.show();
        button.addActionListener((ActionListener) new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                AdminDashboard adminDashboard = new AdminDashboard();
            }

        });
    }

     public static void getMsg() {
        WebServiceProxy.getMsgAsync(new Callback() {
            @Override
            public void onSucess(Object value) {
                ArrayList arrayList = ((ArrayList_EXTERNALISED) value).getArrayList();
                fillListOfMsg(arrayList);
            }

            @Override
            public void onError(Object sender, Throwable err, int errorCode, String errorMessage) {
                Dialog.show("MSG", "ERROR", "OK", null);
            }

        });
    }
     public static void fillListOfMsg(ArrayList arraylist) {
        TextField table = new TextField();

        //DefaultTableModel tablemodel1 = new DefaultTableModel(new String[]{"Last_Name", "First_Name", "Adress", "E-mail", "Mobile", "Password", "TM-Type"}, convertArrayListToArray(arraylist));
        //table.setModel(tablemodel1);
        Form form = new Form("MESSAGE", new BorderLayout(BorderLayout.CENTER_BEHAVIOR_SCALE));
        //table.setUIID("Table");
        TextArea text = new TextArea();
        
        //table.setScrollAnimationSpeed(1);
        Container contain = new Container(new GridLayout(1,1));
        contain.addComponent(text);
        Button button = new Button(" ");
        FontImage.setMaterialIcon(button, FontImage.MATERIAL_SEND, 5);
        form.add(BorderLayout.CENTER,contain);
        Container containn = new Container(new GridLayout(1,2));
        containn.addComponent(table);
        containn.addComponent(button);
        form.add(BorderLayout.SOUTH,containn);
        
        form.show();
        button.addActionListener((ActionListener) new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                WebServiceProxy.MsgAsync(table.getText(), new Callback() {
                    @Override
                    public void onSucess(Object value) {
                        text.setEditable(false);
                        text.setText(table.getText()+"\n");
                        table.setText("");
                      //AdminDashboard adminDashboard = new AdminDashboard(); 
                    }

                    @Override
                    public void onError(Object sender, Throwable err, int errorCode, String errorMessage) {
                     
                    }
                });
                
            }

        });
    }

    public void someProjects() {
        WebServiceProxy.someProjectsAsync(new Callback() {
            @Override
            public void onSucess(Object value) {
                ArrayList arrayList = ((ArrayList_EXTERNALISED) value).getArrayList();
                fillListOfsomeProjects(arrayList);
            }

            @Override
            public void onError(Object sender, Throwable err, int errorCode, String errorMessage) {
                Dialog.show("MSG", "ERROR", "OK", null);
            }

        });
    }

    public void fillListOfsomeProjects(ArrayList arraylist) {
        Form form = new Form("PROJECT SKIM TABLE", new BoxLayout(BoxLayout.Y_AXIS));
        Button button=new Button(" Back");
        FontImage.setMaterialIcon(button, FontImage.MATERIAL_KEYBOARD_ARROW_LEFT,5);
        for (Object project : arraylist) {
            Object[] projects = (Object[]) project;
            ProjectsContainer projectsContainer = new ProjectsContainer(projects[1].toString(),projects[0].toString());
            form.add(projectsContainer);
        }


        form.add(button);
        form.show();
        button.addActionListener((ActionListener) new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                AdminDashboard adminDashboard = new AdminDashboard();
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
                AdminDashboard adminDashboard = new AdminDashboard();
            }

        });
    }
    


}
