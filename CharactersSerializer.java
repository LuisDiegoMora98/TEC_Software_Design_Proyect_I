/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author lalem
 */

import Model.Character;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;

public class CharactersSerializer implements JsonSerializer<Character>{

    @Override
    public JsonElement serialize(Character t, Type type, JsonSerializationContext jsc) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("name", t.getName());
        jsonObject.addProperty("cost", t.getCost());
        jsonObject.addProperty("fieldsInArmy", t.getFieldsInArmy());
        jsonObject.addProperty("hitsPerTime", t.getHitsPerTime());
        jsonObject.addProperty("level", t.getLevel());
        jsonObject.addProperty("levelRequired", t.getLevelRequired());
        jsonObject.addProperty("life", t.getLife());
        Gson gson = new Gson();
        jsonObject.add("aspect", gson.toJsonTree(t.getAspect()).getAsJsonObject());
        //jsonObject.addProperty("", t.getCurrentWeapon());
        return jsonObject;
        
    }
    
}
