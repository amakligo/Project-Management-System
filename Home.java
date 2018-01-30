/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;

import com.codename1.components.InteractionDialog;
import com.codename1.components.ToastBar;
import com.codename1.io.Util;
import com.codename1.notifications.LocalNotification;
import com.codename1.ui.AutoCompleteTextField;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.util.Callback;

/**
 *
 * @author Mawutor
 */
public class Home {

    private final Form loginform;
    private final TextField field1;
    private final TextField field2;

    public Home() {
        loginform = new Form(new BorderLayout(BorderLayout.CENTER_BEHAVIOR_SCALE));
        loginform.setUIID("MainForm");

        Button button = new Button("LOG IN");
       
        FontImage.setMaterialIcon(button, FontImage.MATERIAL_FORWARD, 5);

        Label logo = new Label();
        FontImage.setMaterialIcon(logo, FontImage.MATERIAL_LOCK, 18);
        
        logo.setUIID("LabelLogin");
        Label label = new Label();
        FontImage.setMaterialIcon(label, FontImage.MATERIAL_SUPERVISOR_ACCOUNT, 5);
        Label label1 = new Label();
        FontImage.setMaterialIcon(label1, FontImage.MATERIAL_VPN_KEY, 5);
        field1 = new TextField();
        field1.setConstraint(AutoCompleteTextField.EMAILADDR);
        field2 = new TextField();
        field2.setConstraint(TextField.PASSWORD);

        Container contain = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        contain.add(logo);
        contain.add(label);
        contain.add(field1);
        contain.add(label1);
        contain.add(field2);
        contain.add(button);
        loginform.addComponent(BorderLayout.CENTER,contain);
        loginform.show();

        button.addActionListener((ActionListener) new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                WebServiceProxy.VerifyAsync(field1.getText(), field2.getText(), new Callback() {
                    @Override
                    public void onSucess(Object value) {
                        if (value != null) {

                            String[] split = Util.split((String) value, ";");
                            String results = split[0];
                            //MyApplication.memberID = split[1];
                            ToastBar.Status status;
                            status = ToastBar.getInstance().createStatus();
                            status.setMessage("Valid Credentials");
                            status.show();
                            if (results.equals("Administrator")) {
                                AdminDashboard adminDashboard = new AdminDashboard();
                                LocalNotification n = new LocalNotification();
                                n.setId("Notification");
                                n.setAlertTitle("Break Time");
                                n.setAlertBody("Its Time");
                               // n.setAlertSound("beep-01a.mp3");
                                Display.getInstance().scheduleLocalNotification(n, System.currentTimeMillis(), LocalNotification.REPEAT_MINUTE);
                            } else if (results.equals("Project Manager")) {
                                ProjectManagerLevel projectManager = new ProjectManagerLevel();
                            } else {
                                TeamMemberLevel fred = new TeamMemberLevel();
                            }
                        } else {
                            ToastBar.Status status;
                            status = ToastBar.getInstance().createStatus();
                            status.setMessage("Invalid user name or password");
                            status.show();

                        }
                    }

                    @Override
                    public void onError(Object sender, Throwable err, int errorCode, String errorMessage) {
                        ToastBar.Status status;
                        status = ToastBar.getInstance().createStatus();
                        status.setMessage("Lost Server Communication");
                        status.show();
                    }

                });
            }

        }
        );

    }
}
