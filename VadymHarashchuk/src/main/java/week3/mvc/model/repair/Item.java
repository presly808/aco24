package week3.mvc.model.repair;

public class Item {
    private String model;
    private String type;
    private State state;

    public Item(String model, String type, String state){
        this.model = model;
        this.type = type;
        this.state = State.valueOf(state);
    }


    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

public enum State{
       COSMETIC_DEFECT, BAD, BROKEN, FIXED

}

}
