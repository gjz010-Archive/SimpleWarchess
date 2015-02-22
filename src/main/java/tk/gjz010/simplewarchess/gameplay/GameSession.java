/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tk.gjz010.simplewarchess.gameplay;

import java.util.ArrayList;
import java.util.List;
import tk.gjz010.simplewarchess.gameplay.units.Unit;

/**
 *The session that stands for a "single game".
 * @author gjz010
 */
public class GameSession {
    private int map;
    private List<Unit> units;
    public GameSession(){
        
        units=new ArrayList<>();
    }
}
