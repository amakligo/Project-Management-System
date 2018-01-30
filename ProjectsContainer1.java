/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;

import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.util.Callback;
import java.util.ArrayList;

/**
 *
 * @author Mawutor
 */
class ProjectsContainer1 extends Container
{
private Object[] projects;
    public Button button;
    private Button button1;
    private  String projectID;
    private  String projectName;

    public void fillListOfsomeTeamMembers(ArrayList arraylist) {
        Form form = new Form("CHOOSE TEAM MEMBER", new BoxLayout(BoxLayout.Y_AXIS));
        button1 = new Button("Back");

        for (Object project : arraylist) {
            Object[] memeber = (Object[]) project;
            MembersContainer1 membersContainer = new MembersContainer1(memeber[0].toString(), memeber[1].toString(), memeber[2].toString(), getProjectID());
            form.add(membersContainer);

        }


        form.add(button1);
        form.show();
        button1.addActionListener((ActionListener) new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                ProjectManagerLevel projectManagerLevel = new ProjectManagerLevel();
            }

        });
    }

    public ProjectsContainer1(String projectID,String projectName) {
        super(new BoxLayout(BoxLayout.Y_AXIS));
        this.projectID =  projectName;
        this.projectName =projectID;
        button = new Button("Assign Team Member");
        FontImage.setMaterialIcon(button, FontImage.MATERIAL_PERSON_ADD, 5);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                WebServiceProxy.someTeamAsync(new Callback() {
                    @Override
                    public void onSucess(Object value) {

                        ArrayList arrayList = ((ArrayList_EXTERNALISED) value).getArrayList();
                        fillListOfsomeTeamMembers(arrayList);
                    }

                    @Override
                    public void onError(Object sender, Throwable err, int errorCode, String errorMessage) {

                    }

                });
            }

        });
        addProjects();
    }

    private void addProjects() {
       
        Label label2 = new Label(this.projectID);
        Container cont = new Container(new BorderLayout(BorderLayout.CENTER_BEHAVIOR_SCALE));
        cont.setUIID("Table");
        label2.setUIID("Label2");
        cont.addComponent(BorderLayout.NORTH, label2);
        cont.addComponent(BorderLayout.SOUTH, button);
        add(cont);
    }

    public String getProjectID() {
        return projectID;
    }
}
