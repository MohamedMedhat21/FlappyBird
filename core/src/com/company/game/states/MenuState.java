package com.company.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.company.game.FlappyDemo;

public class MenuState extends State{
    private Texture background;
    private Texture playBtn;

    public MenuState(GameStateManager gsm) {
        super(gsm);
        background=new Texture("bg.png");
        playBtn=new Texture("playbtn.png");
        cam.setToOrtho(false, FlappyDemo.WIDTH/2,FlappyDemo.Height/2);
    }

    @Override
    public void handleInput() {
        if(Gdx.input.justTouched()){
            gsm.set(new PlayState(gsm));
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
      //  sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(background,0,0, FlappyDemo.WIDTH,FlappyDemo.Height);
        sb.draw(playBtn,FlappyDemo.WIDTH/2-(playBtn.getWidth()/2),FlappyDemo.Height/2);
        sb.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        playBtn.dispose();
    }
}
