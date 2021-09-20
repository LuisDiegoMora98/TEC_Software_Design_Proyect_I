/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecti.utils;

import java.io.File;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

/**
 *
 * @author aguil
 */
public class JSONLoader {
    //URL where the json file will be located
    private String url;
    private ObjectMapper objMapper;
    
    public JSONLoader(String pUrl){
        this.url = pUrl;
        this.objMapper = new ObjectMapper();
    }
    /*
    Reads a Json and return an object with all the content.
    In: Nothing
    Out: Object with Json Object
    Exceptions: If Url fails or has no permissions
    */
    public Object readJson() throws IOException{
        return objMapper.readValue(new File(this.url), Object.class);

    }
    
    public static void main(String[] args) throws IOException {
        System.out.println("JsonLoader test");
        //Here write the URL on the constructor to read the Json and get an Object
        JSONLoader tester = new JSONLoader("src/test/resources/characters.json");
        var obj = tester.readJson();
        System.out.println("Read Object from Json: " + obj);
    }
}
