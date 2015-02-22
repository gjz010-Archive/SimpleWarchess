/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tk.gjz010.simplewarchess.helper;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.Effect;
import javafx.util.Duration;

/**
 *
 * @author gjz010
 */
public class ImageAnimationBuilder {
    private Timeline tl;
    private Effect ef;

    public void buildSelectionAnimation(){
        tl=new Timeline();
        tl.setCycleCount(Timeline.INDEFINITE);
        tl.setAutoReverse(true);
        ef=new ColorAdjust();
        KeyValue v1=new KeyValue(((ColorAdjust)ef).brightnessProperty(),1.0);
        KeyValue v2=new KeyValue(((ColorAdjust)ef).brightnessProperty(),0.0);
        KeyFrame f1=new KeyFrame(Duration.seconds(0.5),v1);
        KeyFrame f2=new KeyFrame(Duration.seconds(0.5),v2);
        tl.getKeyFrames().addAll(f1,f2);
    }
    public Timeline getTimeline(){
        return tl;
    }
    public Effect getEffect(){
        return ef;
    }
}
