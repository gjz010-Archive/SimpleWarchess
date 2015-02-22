/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tk.gjz010.simplewarchess.helper;

import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.image.PixelReader;



/**
 * A helper that splits a picture into pieces.(e.g. for characters,tilesets and NinePatch)
 * @author gjz010
 */
public class PictureClip {
    private final Image o;
    private final WritableImage[][] pics; 
    private final int ws;
    private final int hs;
    private final int average_width;
    private final int average_height;
    public PictureClip(Image origin,int w,int h){
        o=origin;
        pics=new WritableImage[w][h];
        ws=w;
        hs=h;
        average_width=(int) (o.getWidth()/ws);
        average_height=(int) (o.getHeight()/hs);
        generateClips();
    }
    private void generateClips(){
        for(int i=0;i<ws;i++){
            for(int j=0;j<hs;j++){
                pics[i][j]=getSubimage(i*getAverageWidth(), j*getAverageHeight(), getAverageWidth(), getAverageHeight());
            }
        }
    }
    public Image getClip(int x,int y){
        return pics[x][y];
    }
    private WritableImage getSubimage(int x,int y,int w,int h){
        PixelReader pr=o.getPixelReader();
        return new WritableImage(pr,x,y,w,h);
    }
    public Image getOrigin(){
        return o;
    }

    /**
     * @return the average_width
     */
    public int getAverageWidth() {
        return average_width;
    }

    /**
     * @return the average_height
     */
    public int getAverageHeight() {
        return average_height;
    }
}
