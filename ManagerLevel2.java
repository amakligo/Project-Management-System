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
public class ManagerLevel2 

{
    public String Deadline;
    public String Status;
    public TextField labelt;
    public ComboBox labelt2;
    public Picker labelt4;
    public Picker labelt5;
    public TextField labelt3;
    public ManagerLevel2()
    {
        Toolbar.setGlobalToolbar(true);
        Form ManagerForm2 = new Form("CREATE TASK", new BoxLayout(BoxLayout.Y_AXIS));
        Style s= UIManager.getInstance().getComponentStyle("Title Command");
        Label logo = new Label();
        FontImage.setMaterialIcon(logo, FontImage.MATERIAL_CREATE_NEW_FOLDER,15);
        logo.setUIID("Label1");
        Label label1= new Label("Description");
        labelt= new TextField();
        Label label2 = new Label("Status");
        labelt2 = new ComboBox();
                labelt2.addItem("Active");
               labelt2.addItem("Inactive");
                labelt2.addItem("Completed");
        Label label3= new Label("Name");
        labelt3= new TextField();
        Label label4= new Label("Start-date");    
        labelt4 = new Picker();
        labelt4.setType(Display.PICKER_TYPE_DATE);
        
        Label label5= new Label("End-date");
        labelt5 = new Picker();
        labelt5.setType(Display.PICKER_TYPE_DATE);
        
       
        Button btn2=new Button(" Done");  
        FontImage.setMaterialIcon(btn2, FontImage.MATERIAL_DONE,5);
        Container contentPane = ManagerForm2.getContentPane();
        contentPane.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        Container contain = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        contain.add(logo);
        contain.add(label3);
        contain.add(labelt3);
        contain.add(label1);
        contain.add(labelt);
         contain.add(label2);
        contain.add(labelt2);
        contain.add(label4);
        contain.add(labelt4);
        contain.add(label5);
        contain.add(labelt5);
        Container containn = new Container(new GridLayout(1, 2));
       
        containn.add(btn2);
        contentPane.add(contain);
        contentPane.add(containn);
        ManagerForm2.getToolbar().addCommandToLeftBar("",FontImage.createMaterial(FontImage.MATERIAL_BACKSPACE,s), new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
              ProjectManagerLevel projectManagerLevel = new ProjectManagerLevel();  
            }
        });
        ManagerForm2.show();
        
      
        
        btn2.addActionListener((ActionListener) new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) 
            {
                WebServiceProxy.CreateAsync(labelt3.getText(), labelt.getText(), labelt4.getDate().toString(), labelt5.getDate().toString(), (String) labelt2.getSelectedItem(), new Callback() {
                    @Override
                    public void onSucess(Object value) {
                        if((Boolean) value==true)
                        {
                            ToastBar.Status status;
                            status =ToastBar.getInstance().createStatus();
                        status.setMessage("Details added");
                        status.show();
                           
                       
                
                        ProjectManagerLevel projectManagerLevel = new ProjectManagerLevel();
                
                        }
                        else
                        {
                           ToastBar.Status status;
                            status =ToastBar.getInstance().createStatus();
                        status.setMessage("There is an inconsistency with your entries");
                        status.show();  
                          
                        }
                    }

                    @Override
                    public void onError(Object sender, Throwable err, int errorCode, String errorMessage) 
                    {
                         ToastBar.Status status;
                            status =ToastBar.getInstance().createStatus();
                        status.setMessage("Lost Server Communication");
                        status.show();
                       
                    }
                });
                
            }
        
        });
        
        
    }
    
}
