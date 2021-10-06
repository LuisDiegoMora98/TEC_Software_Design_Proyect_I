/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import Model.Character;
import Model.Weapon;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author Natalia
 */
public class JSONLoader {
    private static JSONLoader instance;
    private String URL;
    private final Gson json;
    private ObjFormat data;

    private JSONLoader() throws IOException{
        this.URL = "src\\resources\\test.json";
        this.json = new Gson();
        data = new ObjFormat();
        this.readJSON();
    }
    
    public static JSONLoader getInstance() throws IOException{
        if(JSONLoader.instance != null){
            return JSONLoader.instance;
        }
        JSONLoader.instance = new JSONLoader();
        return instance;
    }
    
    private class ObjFormat{
        public ArrayList<Character> characters = new ArrayList<>();
        public ArrayList<Weapon> weapons = new ArrayList<>();
    }

    private void readJSON() throws FileNotFoundException, IOException {
        try {
            if(new File(this.URL).exists()){
                InputStream is = new FileInputStream(this.URL);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
                ObjFormat data = json.fromJson(bufferedReader, ObjFormat.class);
                System.out.println(data);
                System.out.println(data !=  null);
                if (data !=  null){
                    this.data = data;
                }
                bufferedReader.close();
            }
        } catch (JsonIOException | JsonSyntaxException | IOException e) {
            System.out.println(e);
        }
    }

    public void writeJSON(Character pObject) throws IOException {
        try {
            BufferedWriter writer = new BufferedWriter(
                    new FileWriter(new File(this.URL)));
            this.data.characters.add(pObject);
            System.out.println(json.toJson(pObject.getAspect()));
            writer.write(json.toJson(this.data));
            writer.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    
    public void writeJSON(Weapon pObject) throws IOException {
        try {
            BufferedWriter writer = new BufferedWriter(
                    new FileWriter(new File(this.URL)));
            this.data.weapons.add(pObject);
            writer.write(json.toJson(this.data));
            writer.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
    
    public ArrayList<Character> getCharacters(){
        return this.data.characters;
    }
    
    public ArrayList<Weapon> getWeapons(){
        return this.data.weapons;
    }
    


}