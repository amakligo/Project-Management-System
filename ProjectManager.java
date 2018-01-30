/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;

import com.codename1.components.ToastBar;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
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
import com.codename1.util.Callback;

/**
 *
 * @author Mawutor
 */
 
public class ProjectManager 
       
{
    public TextField lnamet;
    public TextField fnamet;
    public TextField addresst;
    public TextField emailt;
    public TextField mobilet;
    public TextField passwordt;
    public ComboBox pri; 
    public ProjectManager()
    {
        Toolbar.setGlobalToolbar(true);
        Form Managerform = new Form("PROJECT MANAGER", new BoxLayout(BoxLayout.X_AXIS));
        Style s =UIManager.getInstance().getComponentStyle("Title Command");
                Label logo = new Label();
        FontImage.setMaterialIcon(logo, FontImage.MATERIAL_PERSON_ADD,15);
        logo.setUIID("Label1");
                Label lname = new Label(" Lastname");
                lnamet = new TextField();
                Label fname = new Label(" Firstname");
                fnamet = new TextField();
                Label address = new Label(" Address");
                addresst = new TextField();
                Label email = new Label(" Email");
                emailt = new TextField();
                emailt.setConstraint(TextField.EMAILADDR);
                Label mobile = new Label(" Phone Number");
                mobilet = new TextField();
                mobilet.setConstraint(TextField.PHONENUMBER);
                Label password = new Label(" Password");
                passwordt = new TextField();
                passwordt.setConstraint(TextField.PASSWORD);
                Label priv = new Label(" Priviledges");
                Button btn8 = new Button(" Create");
               
                FontImage.setMaterialIcon(btn8, FontImage.MATERIAL_CREATE,5);
                
                pri = new ComboBox();
                pri.addItem("Project Manager");
                pri.addItem("Administrator");
                pri.addItem("Team Memeber");
                Container contentPane = Managerform.getContentPane();
                contentPane.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
                Container contain = new Container(new GridLayout(1, 2));
                Container containn = new Container(new BoxLayout(BoxLayout.Y_AXIS));
                
                containn.setUIID("form1");
                contain.setUIID("below");
                
                contain.add(btn8);
                containn.add(logo);
                containn.add(lname);
                containn.add(lnamet);
                containn.add(fname);
                containn.add(fnamet);
                containn.add(address);
                containn.add(addresst);
                containn.add(email);
                containn.add(emailt);
                containn.add(mobile);
                containn.add(mobilet);
                containn.add(password);
                containn.add(passwordt);
                containn.add(priv);
                containn.add(pri);
                
                containn.setUIID("Contain");
               
                contentPane.add(containn);
                contentPane.add(contain);
                Managerform.getToolbar().addCommandToLeftBar("",FontImage.createMaterial(FontImage.MATERIAL_BACKSPACE,s), new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                AdminDashboard adminDashboard = new AdminDashboard();
            }
        });
                Managerform.show();
                
                btn8.addActionListener((ActionListener) new ActionListener() {
                    @Override
            public void actionPerformed(ActionEvent evt) {
                 
                        WebServiceProxy.Verify1Async(fnamet.getText(),lnamet.getText(),addresst.getText(),emailt.getText(),mobilet.getText(),passwordt.getText(), (String) pri.getSelectedItem(),new Callback() {
                             @Override
                             public void onSucess(Object value) {
                               if((Boolean)value==true)
                               {
                                  ToastBar.Status status;
                            status =ToastBar.getInstance().createStatus();
                        status.setMessage("Project Manager Created");
                        status.show(); 
                                 //Dialog.show("Notification", "", "OK", null);
                                    AdminDashboard adminDashboard = new AdminDashboard();
                               }
                               else
                               {
                                   ToastBar.Status status;
                            status =ToastBar.getInstance().createStatus();
                        status.setMessage("Could not create new Project Manager");
                        status.show(); 
                                  //Dialog.show("Notification","Could not create new Project Manager","OK",null);
                               }
                             }

                             @Override
                             public void onError(Object sender, Throwable err, int errorCode, String errorMessage) 
                             {
                                ToastBar.Status status;
                            status =ToastBar.getInstance().createStatus();
                        status.setMessage("Lost Server Communication");
                        status.show();  
                            // Dialog.show("Notification","Error: "+errorMessage,"OK",null);    
                             }
                         });
                
            }
                });
                
                
    }
}
