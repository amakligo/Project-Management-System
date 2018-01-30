/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;

import com.codename1.components.ToastBar;
import com.codename1.messaging.Message;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.spinner.Picker;
import com.codename1.util.Callback;

/**
 *
 * @author Mawutor
 */
public class NewPoject
{

   public TextField namet;
    public Picker datet;
    public ComboBox statust;
    Form Projform;
    private final TextField des;
    public NewPoject()
    {
        Toolbar.setGlobalToolbar(true);
         Projform = new Form("NEW PROJECT", new BoxLayout(BoxLayout.Y_AXIS));
         Style s= UIManager.getInstance().getComponentStyle("Title Command");
         Label logo = new Label();
        FontImage.setMaterialIcon(logo, FontImage.MATERIAL_CREATE_NEW_FOLDER,15);
        logo.setUIID("Label1");
                Label name = new Label("Name");
                namet = new TextField();
            
                Label date = new Label("Date");
                 datet = new Picker();
                 datet.setType(Display.PICKER_TYPE_DATE);
                
                Label status = new Label("Status");
                statust = new ComboBox();
                statust.addItem("Active");
                statust.addItem("Inactive");
                statust.addItem("Completed");
                Button Btn3 = new Button(" Create Message");
                FontImage.setMaterialIcon(Btn3, FontImage.MATERIAL_MAIL,5);
                Button btn5 = new Button(" Project Manager");
                FontImage.setMaterialIcon(btn5, FontImage.MATERIAL_PERSON_ADD,5);
                Button Btn1 = new Button(" Create Project");
                FontImage.setMaterialIcon(Btn1, FontImage.MATERIAL_CREATE,5);
                Label desl= new Label("Brief Description");
                des= new TextField();
               
                
                Container contentPane = Projform.getContentPane();
                contentPane.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
                Container container = new Container(new GridLayout(1, 2));
                Container containn = new Container(new BoxLayout(BoxLayout.Y_AXIS));
                containn.setUIID("Contain"); 
                containn.add(logo);
                containn.add(name);
                containn.add(namet);
                containn.add(desl);
                containn.add(des);
                containn.add(status);
                containn.add(statust);
                containn.add(date);
                containn.add(datet);
                
                container.add(Btn1);
                containn.add(Btn3);
                containn.add(container); 
                container.setUIID("below");
                contentPane.addComponent(containn);
               Projform.getToolbar().addCommandToLeftBar("",FontImage.createMaterial(FontImage.MATERIAL_BACKSPACE,s), new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
              ProjectManagerLevel projectManagerLevel = new ProjectManagerLevel();  
            }
        });
                Projform.show();
                
                
                 btn5.addActionListener((ActionListener) new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt)
                    {
                    
                      WebServiceProxy.addNewProjectAsync(namet.getText(),datet.getDate().toString(),des.getText(), (String) statust.getSelectedItem(), new Callback() {
                            @Override
                            public void onSucess(Object value) 
                            {
                                if((Boolean)value==true)
                                {
                                     ToastBar.Status status;
                            status =ToastBar.getInstance().createStatus();
                        status.setMessage("Project Created");
                        status.show();
                                    ProjectManager adminDashboard = new ProjectManager();
                                }
                                else
                                {
                                     ToastBar.Status status;
                            status =ToastBar.getInstance().createStatus();
                        status.setMessage("There is(are) an inconsistency with your entries");
                        status.show();
                                   //Dialog.show("Notification","Unable to Create New Project.Check Your Entries","OK",null);  
                                }
                            }

                            @Override
                            public void onError(Object sender, Throwable err, int errorCode, String errorMessage) {
                                ToastBar.Status status;
                            status =ToastBar.getInstance().createStatus();
                        status.setMessage("Lost Server Communication");
                        status.show();
                                //Dialog.show("Notification","Error: "+errorMessage,"OK",null);
                            }
                        });  
                               
                
                    
                    }
                });
                 
                  
                Btn1.addActionListener((ActionListener) new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                       
                    WebServiceProxy.addNewProjectAsync(namet.getText(),datet.getDate().toString(),des.getText(), (String) statust.getSelectedItem(), new Callback() {
                            @Override
                            public void onSucess(Object value) 
                            {
                                if((Boolean)value==true)
                                {
                                    ToastBar.Status status;
                            status =ToastBar.getInstance().createStatus();
                        status.setMessage("New Project Created");
                        status.show();
                                   // Dialog.show("Notification","","OK",null);
                                    AdminDashboard adminDashboard = new AdminDashboard();
                                }
                                else
                                {
                                    ToastBar.Status status;
                            status =ToastBar.getInstance().createStatus();
                        status.setMessage("Unable to Create New Project");
                        status.show();
                                   //Dialog.show("Notification","","OK",null); 
                                }
                            }

                            @Override
                            public void onError(Object sender, Throwable err, int errorCode, String errorMessage) {
                                ToastBar.Status status;
                            status =ToastBar.getInstance().createStatus();
                        status.setMessage("Lost Server Communication");
                        status.show();
                                Dialog.show("Notification","Error "+errorMessage,"OK",null);
                                
                            }
                        });
                
                    }
                });
                
                Btn3.addActionListener((ActionListener) new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) 
                    {
                        Message m = new Message("Body of message");
                        Display.getInstance().sendMessage(new String[] {"recipient@email.com"}, "Subject of message", m);
                       
                    }
                });
                
           }
                
public void show(){
    this.Projform.show();
}
    }

