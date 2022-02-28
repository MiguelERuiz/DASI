import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import jade.core.behaviours.FSMBehaviour;

public class FSMBehaviourAgent extends Agent {

	private static final String STATE_1 = "1";
  private static final String STATE_2 = "2";
	private static final String STATE_3 = "3";

  protected void setup() {
    FSMBehaviour fsm = new FSMBehaviour(this) {
      public int onEnd() {
				System.out.println("FSM behaviour completado");
				myAgent.doDelete();
				return super.onEnd();
			}
		};

    fsm.registerFirstState(new Comportamiento(), STATE_1);
    fsm.registerState(new Comportamiento(), STATE_2);
    fsm.registerLastState(new Comportamiento(), STATE_3);

    fsm.registerDefaultTransition(STATE_1, STATE_2);
    fsm.registerDefaultTransition(STATE_2, STATE_3);
    addBehaviour(fsm);

  }

  private class Comportamiento extends OneShotBehaviour {
    public void action() {
      System.out.println("Ejecutando comportamiento " + getBehaviourName());
    }
  }
}