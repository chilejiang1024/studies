package main.chile.design.pattern.state.intf;

import main.chile.design.pattern.state.logic.Context;

/**
 * Title : main.chile.design.pattern.state.intf.IState
 * Description :
 *  - 状态操作接口，执行上一个下一个的操作,还可以获得当前的状态
 *  - 当然在这可以既执行别的操作，比如开关拨到某个颜色的时候，颜色对应的灯亮
 *
 * @author main.chile
 * @version 1.0
 * @date 2017/3/30 11:38
 */

public interface IState {

    void lastState(Context c);

    void nextState(Context c);

    String getCurrentState();
}
