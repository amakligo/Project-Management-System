/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;

import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.util.Callback;

/**
 *
 * @author Mawutor
 */
class MembersContainer extends Container {

    private Object[] member;
    public  Object memberID;
    private  Button button;
    private String projectID;
    private String memberName;
    private String memeberFN;
    private String projectName;

    public MembersContainer(String memberID,String memberName,String  memberFN,String projectID) {
        super(new BoxLayout(BoxLayout.Y_AXIS));
        this.projectID = projectID;
        this.memberID = memberID;
        this.memberName = memberName;
        this.memeberFN = memberFN;
        button = new Button("Assign as Project Manager");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                WebServiceProxy.addManagerAsync(getMemberID(),getProjectID(), "Project Manager ", new Callback() {
                    @Override
                    public void onSucess(Object value) {
                        if ((Boolean) value == true) {

                            Dialog.show("Notification", "Details added.", "OK", null);
                        }
                        else
                        {
                            Dialog.show("Notification","Unable to add details.","OK",null);
                        }
                            
                    }

                    @Override
                    public void onError(Object sender, Throwable err, int errorCode, String errorMessage) {
                        Dialog.show("Notification", "Lost Server Commmunication.", "OK", null);
                    }
                });

            }

        });
        addMemebers();
    }

    private void addMemebers() {
        Container cont = new Container(new BorderLayout(BorderLayout.CENTER_BEHAVIOR_SCALE));
        cont.setUIID("Table");
        Label label2 =new Label(this.memberName);
        cont.addComponent(BorderLayout.NORTH, label2);
        label2.setUIID("Label2");
        Label label3 =new Label(this.memeberFN);
        cont.addComponent(BorderLayout.WEST, label3);
        label3.setUIID("Label2");
        cont.addComponent(BorderLayout.SOUTH, button);
        add(cont);
    }

    public  String getMemberID() {
        return memberName.toString();
    }
    public void setMemberID(Object memberID) {
        this.memberName = memberName ;
    }

    public String getProjectID() {
        return projectID;
    }
    

}
