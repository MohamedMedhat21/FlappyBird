package com.company.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

public class Tube {
    private static final int RAND_LIMIT=130,TUBE_GAP=120,LOWSET_OPENING=120;
    public static final int TUBE_WIDTH=52;
    private Rectangle boundsTop,boundsBottom;
    private Texture topTube, bottomTube;
    private Vector2 posTopTube,posBottomTube;
    private Random rand;
    public Tube(float x){
        topTube=new Texture("toptube.png");
        bottomTube =new Texture("bottomtube.png");
        rand=new Random();
        posTopTube=new Vector2(x,rand.nextInt(RAND_LIMIT)+TUBE_GAP+LOWSET_OPENING);
        posBottomTube=new Vector2(x,posTopTube.y-TUBE_GAP-bottomTube.getHeight());
        boundsTop=new Rectangle(posTopTube.x,posTopTube.y,topTube.getWidth(),topTube.getHeight());
        boundsBottom=new Rectangle(posBottomTube.x,posBottomTube.y,bottomTube.getWidth(),bottomTube.getHeight());
    }

    public Texture getTopTube() {
        return topTube;
    }

    public Texture getBottomTube() {
        return bottomTube;
    }

    public Vector2 getPosTopTube() {
        return posTopTube;
    }

    public Vector2 getPosBottomTube() {
        return posBottomTube;
    }

    public void reposition(float x){
        posTopTube.set(x,rand.nextInt(RAND_LIMIT)+TUBE_GAP+LOWSET_OPENING);
        posBottomTube.set(x,posTopTube.y-TUBE_GAP-bottomTube.getHeight());
        boundsTop.setPosition(posTopTube.x,posTopTube.y);
        boundsBottom.setPosition(posBottomTube.x,posBottomTube.y);

    }

    public boolean collides(Rectangle player){
        return player.overlaps(boundsTop)||player.overlaps(boundsBottom);
    }

    public void dispose(){
        topTube.dispose();
        bottomTube.dispose();
    }
}