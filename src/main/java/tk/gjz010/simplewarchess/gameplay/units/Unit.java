/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tk.gjz010.simplewarchess.gameplay.units;

import tk.gjz010.simplewarchess.gameplay.GameSession;
import tk.gjz010.simplewarchess.helper.ImageAnimationBuilder;
import tk.gjz010.simplewarchess.helper.Point;

/**
 * A unit on the map(soldier,city,construction,etc)
 * @author gjz010
 */
public abstract class Unit{
    private final GameSession session;
    private int x,y;

    /**
     * -1:clip As Action
     * 0-3 clip As Image
     */
    public int subClip;
    public boolean isChosen;
    private int direction;
    public Unit(GameSession session,int x,int y){
        super();
        this.session=session;
        this.x=x;
        this.y=y;
        subClip=0;
        //setCurrentClip(0,0);
    }



    public abstract String getClipPath();
    public Point getLocation(){
        return new Point(x,y);
    }
    /*     ^3
    *       |
    * 1<- O ->2
    *       |
    *       V0
    */
    public int getDirection(){
        return direction;
    }
    public void setDirection(int d){
        this.direction=d;
    }
}
