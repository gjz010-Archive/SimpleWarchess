/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tk.gjz010.simplewarchess.gameplay.units;

import tk.gjz010.simplewarchess.gameplay.GameSession;

/**
 *
 * @author gjz010
 */
public class Fighter extends Unit{

    public Fighter(GameSession session, int x, int y) {
        super(session, x, y);
    }

    @Override
    public String getClipPath() {
        return "images/fighter.png";
    }
    
}
