package com.sankalp.forestwalk.precambrian.userdata;

import com.sankalp.forestwalk.precambrian.core.GameLogger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserData {

    private List userChoiceList;

    // Class constructor
    public UserData(){
        userChoiceList = new ArrayList();
    }

    public void addChoices(String str_choice) {
        userChoiceList.add(str_choice);
    }

    public void writeUserChoiceFie(String username, String content) {
        // Write the commands in a file
        String filepath = "C:\\Users\\avikd\\IdeaProjects\\forestwalk-precambrian\\precambrian\\src\\com\\sankalp\\forestwalk\\precambrian\\userdata\\";
        File userdataFie = new File(filepath+username+"_data.csv");
        GameLogger gameLogger = new GameLogger();
        if (!userdataFie.exists()) {
            try{
                String fileName = userdataFie.getName();
                gameLogger.logger("[INFO] User data file created > "+fileName);
                FileWriter fileWriter = new FileWriter(userdataFie, true);
                fileWriter.write(content);
                fileWriter.close();

            } catch (Exception e){
                e.printStackTrace();
            }
        }

    }

    public List getUserChoiceList() {
        return userChoiceList;
    }

    public void setUserChoiceList(List userChoiceList) {
        this.userChoiceList = userChoiceList;
    }
}
