public class Midterm_Q1 {
    abstract static class Human {
        void luvz(){
            System.out.println("... luvz");
        }
        abstract void killz();
    }
    interface Robot {
        void killz();
        default void protects(){
            System.out.println("Come with me if you wanna live!");
        }
    }
    static class Terminator extends Human implements Robot{
        @Override
        void luvz() {
            System.out.println("Terminator kills but human...");
            super.luvz();
        }

        @Override
        public void killz() {
            System.out.println("kill!");
        }
    }
    public static void main(String[] args) {
        Robot r = new Midterm_Q1.Terminator();  //line 1
//        r.luvz();                               //line 2
        r.killz();                              //line 3
        r.protects();                           //line 4
//        Terminator t = new Midterm_Q1.Robot();  //line 5
//        t.killz();                              //line 6
        Terminator schwarz = (Terminator)r;     //line 7
        schwarz.luvz();                         //line 6
    }
}
