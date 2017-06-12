package main.chile.design.pattern.state.logic;

import main.chile.design.pattern.state.intf.IState;

/**
 * Title : main.chile.design.pattern.state
 * Description :
 *  - 状态管理器，设置初始状态，得到当前状态
 *    提供了两个操作:
 *      上一个的操作方法中，调用了当前状态的last方法，将状态管理器的状态更新
 *      下一个的操作方法中，调用了当前状态的next方法，将状态管理器的状态更新
 *
 * @author main.chile
 * @version 1.0
 * @date 2017/3/30 11:45
 */

public class Context {

    private IState state = null;

    public IState getState() {
        return state;
    }

    public void setState(IState state) {
        this.state = state;
    }

    public void push(){
        state.nextState(this);
    }

    public void pull(){
        state.lastState(this);
    }
}
