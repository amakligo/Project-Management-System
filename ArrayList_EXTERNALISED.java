/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;

import com.codename1.io.Externalizable;
import com.codename1.io.Util;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author CHEERY
 */
public class ArrayList_EXTERNALISED implements Externalizable {

    private ArrayList arrayList = null;
    private final int VERSION = 1;

    public ArrayList_EXTERNALISED() {
        this.arrayList = new ArrayList();
    }

    public ArrayList getArrayList() {
        return arrayList;
    }

    public void setArrayList(ArrayList arrayList) {
        this.arrayList = arrayList;
    }

    public void addArrayList(Externalizable arrayList) {
        if (arrayList != null) {
            for (Object object : ((ArrayList_EXTERNALISED) arrayList).getArrayList()) {
                if (object != null) {
                    this.arrayList.add(object);
                }
            }
        }
    }

    @Override
    public int getVersion() {
        return VERSION;
    }

    @Override
    public void externalize(DataOutputStream out) throws IOException {
        Util.writeObject(arrayList, out);
    }

    @Override
    public void internalize(int version, DataInputStream in) throws IOException {
        arrayList = (ArrayList) Util.readObject(in);
    }

    @Override
    public String getObjectId() {
        return "ArrayList_EXTERNALISED";
    }

}
