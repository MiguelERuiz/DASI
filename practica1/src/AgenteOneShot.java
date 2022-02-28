import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;

public class AgenteOneShot extends Agent {

  public void setup() {
    // Create a JADE OneShot behaviour
    this.addBehaviour(new OneShotBehaviour(this) {
      public void action() {
        System.out.println("Hola! Soy el AgenteMinimo " + getAID().getName());
      }
    });
  }
}
