package model;

public class gate {
    private String gate;

    gate(String gate) {
        this.gate = gate;
    }

    public String getGate() {
        return gate;
    }
    public void setGate(String gate) {
        this.gate = gate;
    }

    public String toString() {
        String stringa = "\nil gate è: " + gate;
        return stringa;
    }
}

