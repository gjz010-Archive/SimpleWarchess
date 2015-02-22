/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tk.gjz010.simplewarchess.gameplay;

import org.json.JSONObject;

/**
 *The map of the game
 * @author gjz010
 */
public class GameMap {
    public GameMap(String json){
        JSONObject obj=new JSONObject(json);
    }
    public String toJson(){
        JSONObject obj=new JSONObject();
        return obj.toString();
    }
}
