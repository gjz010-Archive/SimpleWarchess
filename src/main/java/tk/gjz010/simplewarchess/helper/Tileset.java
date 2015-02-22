/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tk.gjz010.simplewarchess.helper;

import javafx.scene.image.Image;
import static tk.gjz010.simplewarchess.helper.Const.TILES_PER_ROW;
import static tk.gjz010.simplewarchess.helper.Const.UNIT_LENGTH;

/**
 *
 * @author gjz010
 */
public class Tileset extends PictureClip{

    public Tileset(Image origin) {
        super(origin, TILES_PER_ROW, (int)(origin.getHeight()/UNIT_LENGTH));
    }
}
