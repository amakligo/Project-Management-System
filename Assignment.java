/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;

import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;

/**
 *
 * @author Mawutor
 */
public class Assignment 

{
    public Assignment ()
    {
        Form form = new Form("Assign Manager",new BoxLayout(BoxLayout.Y_AXIS));
        Label label = new Label("Project Name");
        TextField text = new TextField();
        Label label2 = new Label("Manager Name");
         TextField text1 = new TextField();
         Button button = new Button("OK");
        form.add(label);
        form.add(text);
        form.add(label2);
        form.add(text1);
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
