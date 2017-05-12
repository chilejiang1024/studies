package chile.design.pattern.state.impl;

import chile.design.pattern.state.logic.Context;
import chile.design.pattern.state.intf.IState;

/**
 * Title : chile.design.pattern.state
 * Description :
 *  - blue -> red -> green
 *
 * @author chile
 * @version 1.0
 * @date 2017/3/30 13:45
 */

public class GreenState implements IState {

    @Override public void lastState(Context c) {
        c.setState(new RedState());
    }

    @Override public void nextState(Context c) {
        c.setState(new BlueState());
    }

    @Override public String getCurrentState() {
        return "green";
    }
}