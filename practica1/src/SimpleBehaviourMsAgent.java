import jade.core.Agent;
import jade.core.behaviours.SimpleBehaviour;
import java.lang.Thread;

public class SimpleBehaviourMsAgent extends Agent {

  protected void setup() {
    addBehaviour(new SimpleBehaviour(this) {
      int n = 1;
      int ms;
      long epoch;
      public void action () {
        System.out.println("Hola! Soy el Agente " + getAID().getName() +
                           " y estoy en el estado " + n);
        if (n == 1){
          ms = 3000;
        } else if (n == 2) {
          ms = 5000;
        } else {
          ms = 1000;
        }
        try
        {
            Thread.sleep(ms);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
        n++;
      }

      public boolean done() {
        boolean transition = false;
        epoch = System.currentTimeMillis();
        boolean condition = n > 3;
        if (condition) {
          System.out.println("I'm going to die!!!");
        }
        if (epoch % 2 != 0){
          System.out.println("Cannot make transition from 1 to 2");
          condition = false;
        }
        return condition;
      }
    });
  }

  protected void takeDown() {
    System.out.println("Bye Bye cruel world!");
  }

}
