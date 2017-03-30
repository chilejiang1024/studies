package chile.design.pattern.state;

/**
 * Title : chile.design.pattern.state
 * Description :
 *  - blue -> red -> green
 *
 * @author chile
 * @version 1.0
 * @date 2017/3/30 13:44
 */
public class RedState implements IState {

    @Override public void lastState(Context c) {
        c.setState(new BlueState());
    }

    @Override public void nextState(Context c) {
        c.setState(new GreenState());
    }

    @Override public String getCurrentState() {
        return "red";
    }
}
