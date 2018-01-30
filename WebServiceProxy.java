/*
 * This is generated code, copyright free and unrestricted
 */
package com.mycompany.myapp;

import com.codename1.io.WebServiceProxyCall;
import com.codename1.util.Callback;
import java.io.IOException;

public class WebServiceProxy {

    private static final String DESTINATION_URL = "http://localhost:8080/PMServer/cn1proxy";

   

   // private static String DESTINATION_URL5 = "http://192.168.42.104:8080/PMServer/cn1proxy";

    private static final WebServiceProxyCall.WSDefinition def_Verify = WebServiceProxyCall.defineWebService(DESTINATION_URL, "Verify", WebServiceProxyCall.TYPE_STRING, WebServiceProxyCall.TYPE_STRING, WebServiceProxyCall.TYPE_STRING);

    private static final WebServiceProxyCall.WSDefinition def_Verify1 = WebServiceProxyCall.defineWebService(DESTINATION_URL, "Verify1", WebServiceProxyCall.TYPE_BOOLEAN,
            WebServiceProxyCall.TYPE_STRING,
            WebServiceProxyCall.TYPE_STRING,
            WebServiceProxyCall.TYPE_STRING,
            WebServiceProxyCall.TYPE_STRING,
            WebServiceProxyCall.TYPE_STRING,
            WebServiceProxyCall.TYPE_STRING,
            WebServiceProxyCall.TYPE_STRING);
    
    private static final WebServiceProxyCall.WSDefinition def_Msg = WebServiceProxyCall.defineWebService(DESTINATION_URL, "Msg", WebServiceProxyCall.TYPE_BOOLEAN,
            WebServiceProxyCall.TYPE_STRING);

    private static final WebServiceProxyCall.WSDefinition def_Create = WebServiceProxyCall.defineWebService(DESTINATION_URL, "Create", WebServiceProxyCall.TYPE_BOOLEAN,
            WebServiceProxyCall.TYPE_STRING,
            WebServiceProxyCall.TYPE_STRING,
            WebServiceProxyCall.TYPE_STRING,
            WebServiceProxyCall.TYPE_STRING,
            WebServiceProxyCall.TYPE_STRING);

    private static final WebServiceProxyCall.WSDefinition def_addNewProject = WebServiceProxyCall.defineWebService(DESTINATION_URL, "addNewProject", WebServiceProxyCall.TYPE_BOOLEAN, WebServiceProxyCall.TYPE_STRING, WebServiceProxyCall.TYPE_STRING, WebServiceProxyCall.TYPE_STRING, WebServiceProxyCall.TYPE_STRING);
     private static final WebServiceProxyCall.WSDefinition def_addManager = WebServiceProxyCall.defineWebService(DESTINATION_URL, "addManager", WebServiceProxyCall.TYPE_BOOLEAN, WebServiceProxyCall.TYPE_STRING, WebServiceProxyCall.TYPE_STRING, WebServiceProxyCall.TYPE_STRING);
    private static final WebServiceProxyCall.WSDefinition def_addProject = WebServiceProxyCall.defineWebService(DESTINATION_URL, "addProject", WebServiceProxyCall.TYPE_BOOLEAN, WebServiceProxyCall.TYPE_STRING_ARRAY);
    private static final WebServiceProxyCall.WSDefinition def_getProjects = WebServiceProxyCall.defineWebService(DESTINATION_URL, "getProjects", WebServiceProxyCall.TYPE_EXTERNALIABLE);
     private static final WebServiceProxyCall.WSDefinition def_getAssigns = WebServiceProxyCall.defineWebService(DESTINATION_URL, "getAssigns", WebServiceProxyCall.TYPE_EXTERNALIABLE);
    private static final WebServiceProxyCall.WSDefinition def_someProjects = WebServiceProxyCall.defineWebService(DESTINATION_URL, "someProjects", WebServiceProxyCall.TYPE_EXTERNALIABLE);
     private static final WebServiceProxyCall.WSDefinition def_someProject = WebServiceProxyCall.defineWebService(DESTINATION_URL, "someProject", WebServiceProxyCall.TYPE_EXTERNALIABLE,WebServiceProxyCall.TYPE_STRING);
     private static final WebServiceProxyCall.WSDefinition def_someTeam = WebServiceProxyCall.defineWebService(DESTINATION_URL, "someTeam", WebServiceProxyCall.TYPE_EXTERNALIABLE);
     private static final WebServiceProxyCall.WSDefinition def_getTasks = WebServiceProxyCall.defineWebService(DESTINATION_URL, "getTasks", WebServiceProxyCall.TYPE_EXTERNALIABLE);
     private static final WebServiceProxyCall.WSDefinition def_getTeam = WebServiceProxyCall.defineWebService(DESTINATION_URL, "getTeam", WebServiceProxyCall.TYPE_EXTERNALIABLE);
      private static final WebServiceProxyCall.WSDefinition def_getMsg = WebServiceProxyCall.defineWebService(DESTINATION_URL, "getMsg", WebServiceProxyCall.TYPE_EXTERNALIABLE);
      
    
    private static final WebServiceProxyCall.WSDefinition def_addTeamMember = WebServiceProxyCall.defineWebService(DESTINATION_URL, "addTeamMember", WebServiceProxyCall.TYPE_BOOLEAN, WebServiceProxyCall.TYPE_STRING_ARRAY);
    private static final WebServiceProxyCall.WSDefinition def_addNewTeamMember = WebServiceProxyCall.defineWebService(DESTINATION_URL, "addNewTeamMember", WebServiceProxyCall.TYPE_BOOLEAN,
            WebServiceProxyCall.TYPE_STRING,
            WebServiceProxyCall.TYPE_STRING,
            WebServiceProxyCall.TYPE_STRING,
            WebServiceProxyCall.TYPE_STRING,
            WebServiceProxyCall.TYPE_STRING,
            WebServiceProxyCall.TYPE_STRING,
            WebServiceProxyCall.TYPE_STRING);

    public static boolean Verify(String username, String password) throws IOException {
        return ((Boolean) WebServiceProxyCall.invokeWebserviceSync(def_Verify, username, password));
    }

    public static void VerifyAsync(String username, String password, Callback<Boolean> returnValueFromMethod) {
        WebServiceProxyCall.invokeWebserviceASync(def_Verify, returnValueFromMethod, username, password);
    }

    public static void addNewProjectAsync(String username, String password, String username1, String password1, Callback<Boolean> returnValueFromMethod) {
        WebServiceProxyCall.invokeWebserviceASync(def_addNewProject, returnValueFromMethod, username, password, username1, password1);
    }

    public static void addManagerAsync(String username, String password, String username1 ,Callback<Boolean> returnValueFromMethod) {
        WebServiceProxyCall.invokeWebserviceASync(def_addManager, returnValueFromMethod, username, password, username1);
    }
    public static void someProjectAsync(String username,Callback<Boolean> returnValueFromMethod) {
        WebServiceProxyCall.invokeWebserviceASync(def_someProject, returnValueFromMethod, username);
    }
    
    public static void addProjectAsync(String[] data, Callback<Boolean> returnValueFromMethod) {
        WebServiceProxyCall.invokeWebserviceASync(def_addProject, returnValueFromMethod, new Object[]{data});
    }

    public static void Verify1Async(
            String username,
            String password,
            String username1,
            String password1,
            String username2,
            String password2,
            String password3,
            Callback<Boolean> returnValueFromMethod) {
        WebServiceProxyCall.invokeWebserviceASync(def_Verify1, returnValueFromMethod,
                username,
                password,
                username1,
                password1,
                username2,
                password2,
                password3);
    }
    
    public static void MsgAsync(
            String username,
            Callback<Boolean> returnValueFromMethod) {
        WebServiceProxyCall.invokeWebserviceASync(def_Msg, returnValueFromMethod,
                username);
    }

    public static void CreateAsync(
            String username,
            String password,
            String username1,
            String password1,
            String username2,
            Callback<Boolean> returnValueFromMethod) {
        WebServiceProxyCall.invokeWebserviceASync(def_Create, returnValueFromMethod,
                username,
                password,
                username1,
                password1,
                username2);
    }

    public static void addTeamMemberAsync(String[] more, Callback<Boolean> returnValueFromMethod) {
        WebServiceProxyCall.invokeWebserviceASync(def_addTeamMember, returnValueFromMethod, new Object[]{more});
    }
    
        public static void getProjectsAsync(Callback<Boolean> returnValueFromMethod) {
        WebServiceProxyCall.invokeWebserviceASync(def_getProjects, returnValueFromMethod);
    }
        public static void getAssignsAsync(Callback<Boolean> returnValueFromMethod) {
        WebServiceProxyCall.invokeWebserviceASync(def_getAssigns, returnValueFromMethod);
    }
        public static void someProjectsAsync(Callback<Boolean> returnValueFromMethod) {
        WebServiceProxyCall.invokeWebserviceASync(def_someProjects, returnValueFromMethod);
    }
        
        public static void someTeamAsync(Callback<Boolean> returnValueFromMethod) {
        WebServiceProxyCall.invokeWebserviceASync(def_someTeam, returnValueFromMethod);
    }
        
        public static void getTasksAsync(Callback<Boolean> returnValueFromMethod) {
        WebServiceProxyCall.invokeWebserviceASync(def_getTasks, returnValueFromMethod);
    }
        
         public static void getTeamAsync(Callback<Boolean> returnValueFromMethod) {
        WebServiceProxyCall.invokeWebserviceASync(def_getTeam, returnValueFromMethod);
    }
         
          public static void getMsgAsync(Callback<Boolean> returnValueFromMethod) {
        WebServiceProxyCall.invokeWebserviceASync(def_getMsg, returnValueFromMethod);
    }

    

}
