package info1.game.components;

import info1.game.engine.GameEngine;
import info1.game.engine.Scene;
import info1.game.engine.Scenes;
import info1.game.engine.gameobjects.Button;
import info1.game.engine.gameobjects.popup.ModalWaiting;
import info1.game.engine.gameobjects.popup.PopupBackground;
import info1.game.network.GameNetwork;
import info1.game.network.GamePlayer;
import info1.game.resources.Images;
import info1.game.scenes.SetupScene;
import info1.game.utils.Vector2D;

import java.awt.*;

public class PopupWaiting {

    private final ModalWaiting modal;
    private final PopupBackground background;
    private final Button button;
    private final Scene menu = Scenes.MENU.getScene();
    private final GameEngine engine;

    public PopupWaiting(GameEngine engine) {
        this.engine = engine;

        background = new PopupBackground(engine, 0);
        button = new Button(190, 49, "Annuler", new Color(0x6A5800));
        modal = new ModalWaiting(engine, button);

        modal.setSize(new Dimension(500, 220));
        modal.setPosition(new Vector2D(1280 / 2d - modal.getSize().width / 2d, 720));

        button.setClassicImg(Images.BUTTON_YELLOW);
        button.setOverImg(Images.BUTTON_YELLOW_OVER);
        button.setPressImg(Images.BUTTON_YELLOW_PRESS);
        button.setPosition(new Vector2D(modal.getPosition().x + modal.getSize().width - 210, modal.getPosition().y + 150));

        button.setListener(() -> {
            background.close();
            modal.close();
        });
    }

    public void open(int code) {
        menu.addGameObject(2000, background);
        menu.addGameObject(2001, modal);
        menu.addGameObject(2002, button);

        background.open();
        modal.open(code);
    }

}
