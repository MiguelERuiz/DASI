import jade.core.Agent;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.core.behaviours.SimpleBehaviour;

public class SimpleBehaviourAgent extends Agent {

  protected void setup() {
    addBehaviour(new SimpleBehaviour(this) {
      int n = 1;
      public void action () {
        System.out.println("Hola! Soy el Agente " + getAID().getName() +
                           " y estoy en el estado " + n);
        n++;
      }

      public boolean done() {
        boolean condition = n > 3;
        if (condition) {
          System.out.println("I'm going to die!!!");
        }
        return condition;
      }
    });
  }

  protected void takeDown() {
    System.out.println("Bye Bye cruel world!");
  }
}
