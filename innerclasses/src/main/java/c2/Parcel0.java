package c2;

/**
 * @author xiaoheitalk
 * @type Parcel1
 * @date 2020/12/9 9:28
 */
public class Parcel0 {
    public class Contents2 {
        private int i = 11;

        public int value() {
            return i;
        }
    }

    class Contents {
        private int i = 11;

        public int value() {
            return i;
        }
    }

    class Destination {
        private String label;

        Destination(String whereTo) {
            label = whereTo;
        }

        String readLabel() {
            return label;
        }
    }

    // Using inner classes looks just like
    // using any other class, within Parcel1:
    public void ship(String dest) {
        Contents c = new Contents();
        Destination d = new Destination(dest);
        System.out.println(d.readLabel());
    }

}
