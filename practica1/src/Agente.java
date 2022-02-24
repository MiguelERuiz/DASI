import jade.core.Agent;

public class Agente extends Agent {
    protected void setup() {
        System.out.println("Hola! Soy el AgenteMinimo " + getAID().getName());
    }

    protected void takeDown() {
        System.out.println("Bye Bye cruel world!");
    }
}
