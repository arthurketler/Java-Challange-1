public class Database {
    
    // patties
    private static final Patty[] p = new Patty[4];
    static {
        p[0] = new Patty("beef", 2);
        p[1] = new Patty("chicken", 1);
        p[2] = new Patty("vegan", 7);
        p[3] = new Patty("premium", 8, true);
    }
    
    // toppings
    private static final Topping[] t = new Topping[8];
    static {
        t[0] = new Topping("salad", 0.5);
        t[1] = new Topping("cheese", 1);
        t[2] = new Topping("bacon", 2);
        t[3] = new Topping("cheddar", 1);
        t[4] = new Topping("special sauce", 0.5);
        t[5] = new Topping("onion rings", 1);
        t[6] = new Topping("vegan cheese", 3);
        t[7] = new Topping("none", 0);
    }
    
    // drinks
    private static final Drink[] d = new Drink[3];
    static {
        d[0] = new Drink("soda", 1);
        d[1] = new Drink("juice", 2);
        d[2] = new Drink("water", 0.5);
    }
    
    // sides
    private static final Side[] s = new Side[3];
    static {
        s[0] = new Side("fries", 1);
        s[1] = new Side("onion rings", 1);
        s[2] = new Side("ice cream", 2);
    }
    
    // getter
    
    public static int getP() {
        return Database.p.length;
    }
    
    public static Patty getP(int line) {
        return Database.p[line];
    }
    
    public static int getT() {
        return Database.t.length;
    }
    
    public static Topping getT(int line) {
        return Database.t[line];
    }
    
    public static int getD() {
        return Database.d.length;
    }
    
    public static Drink getD(int line) {
        return Database.d[line];
    }
    
    public static int getS() {
        return Database.s.length;
    }
    
    public static Side getS(int line) {
        return Database.s[line];
    }
}