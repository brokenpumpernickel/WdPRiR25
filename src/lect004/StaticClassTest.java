package lect004;

public class StaticClassTest {
    private int dcasca;
    public class InnerClass {

    }

    public InnerClass hello() {
        InnerClass ic = new InnerClass();
        return ic;
    }

    static void main() {
        //InnerClass innerClass = new InnerClass();

        StaticClassTest stc = new StaticClassTest();
        InnerClass ic = stc.new InnerClass();
    }
}
