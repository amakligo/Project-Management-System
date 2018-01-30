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
public class TeamMember 
{

    public TextField lnamet;
    public TextField fnamet;
    public TextField addresst;
    public TextField emailt;
    public TextField mobilet;
    public TextField passwordt;
    public ComboBox pri; 
    public TeamMember()
    {
        Toolbar.setGlobalToolbar(true);
         Form Teamform = new Form("TEAM MEMBER", new BoxLayout(BoxLayout.Y_AXIS));
         Style s = UIManager.getInstance().getComponentStyle("Title Command");
         Label logo = new Label();
        FontImage.setMaterialIcon(logo, FontImage.MATERIAL_PERSON_ADD,15);
        logo.setUIID("Label1");
                Label lname = new Label("Lastname");
                lnamet = new TextField();
                Label fname = new Label("Firstname");
                fnamet = new TextField();
                Label address = new Label("Address");
                addresst = new TextField();
                Label email = new Label("Email");
                emailt = new TextField();
                emailt.setConstraint(TextField.EMAILADDR);
                Label mobile = new Label("Phone Number");
                mobilet = new TextField();
                mobilet.setConstraint(TextField.PHONENUMBER);
                Label password = new Label("Password");
                passwordt = new TextField();
                passwordt.setConstraint(TextField.PASSWORD);
                Label priv = new Label("Priviledges");
                Button btn8 = new Button(" Create");      
                FontImage.setMaterialIcon(btn8, FontImage.MATERIAL_CREATE,5);
                Button btn9 = new Button(" Cancel");
                FontImage.setMaterialIcon(btn9, FontImage.MATERIAL_CANCEL,5);
                Container contentPane = Teamform.getContentPane();
                contentPane.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
                Container containn = new Container(new BoxLayout(BoxLayout.Y_AXIS));
                Container contain = new Container(new GridLayout(1, 2));
                containn.setUIID("form1");
                pri = new ComboBox();
                pri.addItem("Team Member");
                pri.addItem("Administrator");
                pri.addItem("Project Manager");
                contain.add(btn9);
                contain.add(btn8);
                contain.setUIID("below");
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
                contentPane.addComponent(containn);
                contentPane.addComponent(contain);
                Teamform.getToolbar().addCommandToLeftBar("",FontImage.createMaterial(FontImage.MATERIAL_BACKSPACE,s), new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
              ProjectManagerLevel projectManagerLevel = new ProjectManagerLevel();  
            }
        });
                Teamform.show();
                
                btn9.addActionListener((ActionListener) new ActionListener() {
                   @Override
             public void actionPerformed(ActionEvent evt) 
             {
               AdminDashboard adminDashboard = new AdminDashboard();  
             }
                });
                
                
                btn8.addActionListener((ActionListener) new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt)
                    {
                         String[] m = {lnamet.getText(),fnamet.getText(),addresst.getText(),emailt.getText(),passwordt.getText(),pri.getSelectCommandText()};
                        WebServiceProxy.Verify1Async(fnamet.getText(),lnamet.getText(),addresst.getText(),emailt.getText(),mobilet.getText(),passwordt.getText(), (String) pri.getSelectedItem(),new Callback() {
                             @Override
                             public void onSucess(Object value) {
                               if((Boolean)value==true)
                               {
                                    ToastBar.Status status;
                            status =ToastBar.getInstance().createStatus();
                        status.setMessage("Team Member Created");
                        status.show();
                                 //Dialog.show("Notification", "", "OK", null);  
                                   AdminDashboard adminDashboard = new AdminDashboard();
                               }
                               else
                               {
                                  ToastBar.Status status;
                            status =ToastBar.getInstance().createStatus();
                        status.setMessage("Could not create new Team Member");
                        status.show(); 
                                  //Dialog.show("Notification","","OK",null);
                               }
                             }

                             @Override
                             public void onError(Object sender, Throwable err, int errorCode, String errorMessage) 
                             {
                                  ToastBar.Status status;
                            status =ToastBar.getInstance().createStatus();
                        status.setMessage("Lost Server Communication");
                        status.show(); 
                                 
                            //   Dialog.show("Notification","Error: "+errorMessage,"OK",null);
                             }
                         });
                        
                    }
                });
    }
}
