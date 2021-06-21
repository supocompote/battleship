package info1.game.engine;

import java.util.ArrayList;
import java.util.List;

public class Scene {

    private String name;
    private List<GameObject> listGo;

    public Scene(String name) {
        this.name = name;
        this.listGo = new ArrayList<>();
    }

    public void addGameObject(GameObject gameObject){
        listGo.add(gameObject);
    }

    public List<GameObject> getGameObject(){
        return listGo;
    }
}
