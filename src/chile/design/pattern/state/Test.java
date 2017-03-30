package chile.design.pattern.state;

/**
 * Title : chile.design.pattern.state
 * Description :
 *  - blue -> red -> green
 *
 * @author chile
 * @version 1.0
 * @date 2017/3/30 13:48
 */

public class Test {

    public static void main(String[] args) throws InterruptedException {
        Context c = new Context();
        IState redState = new RedState();
        c.setState(redState);
        System.out.println("current state is " + c.getState().getCurrentState());
        c.push();
        System.out.println("current state is " + c.getState().getCurrentState());
        c.pull();
        System.out.println("current state is " + c.getState().getCurrentState());
    }
}
