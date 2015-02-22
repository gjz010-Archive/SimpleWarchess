/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tk.gjz010.simplewarchess.ui;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import tk.gjz010.simplewarchess.gameplay.units.Unit;
import static tk.gjz010.simplewarchess.helper.Const.UNIT_LENGTH;
import tk.gjz010.simplewarchess.helper.ImageAnimationBuilder;
import tk.gjz010.simplewarchess.helper.PictureClip;
import tk.gjz010.simplewarchess.helper.Point;

/**
 *
 * @author gjz010
 */
public class UnitView extends ImageView{
    private Unit unit;
    private PictureClip clips;
    private ImageAnimationBuilder chosen;
    public UnitView(Unit unit){
        super();
        this.unit=unit;
        chosen=null;
        render();
    }
    public Unit getUnit(){
        return unit;
    }
    public void render(){
        clips=new PictureClip(new Image(unit.getClipPath()),4,4);
        this.setImage(clips.getClip(getCurrentClip(),unit.getDirection()));
         setSmooth(true);
         setCache(true);
         Point pos=calcCoord();
         this.setX(pos.getX());
         this.setY(pos.getY());
    }
    /**
     * Calculates the position that makes sure the bottom aligns.
     * @return The point
     */
    public Point calcCoord(){
    Point pt=unit.getLocation();
    int xw=(int) (pt.getX()*UNIT_LENGTH);
    int yw=(int) (pt.getY()*UNIT_LENGTH);
    yw=yw+UNIT_LENGTH-clips.getAverageHeight();
    xw=xw+((UNIT_LENGTH-clips.getAverageWidth())/2);
    return new Point(xw,yw);
    }
    public int getCurrentClip(){
        if(unit.subClip==-1) return 0;
        return unit.subClip;
    }
    public PictureClip getPictureClip(){
        return clips;
    }
    public void flipChosen(){
        if(chosen==null){
        chosen=new ImageAnimationBuilder();
        chosen.buildSelectionAnimation();
            this.setEffect(chosen.getEffect());
            chosen.getTimeline().play();
        }else{
            chosen.getTimeline().stop();
            this.setEffect(null);
            chosen=null;
        }
    }
}
