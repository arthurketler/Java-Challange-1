public class Menu {
    private Patty[] p;
    private Topping[] t;
    private Drink[] d;
    private Side[] s;
    
    public static final int NAME_SIZE = 18;
    public static final int PRICE_SIZE = 4;
    
    // Constructor
    
    private Menu(Patty[] p, Topping[] t, Drink[] d, Side[] s) {
        
        // patties
        this.p = p;
        this.t = t;
        this.d = d;
        this.s = s;
    }
    
    // instance return function
    public static Menu getMenu() {
        // return the menu object from the database
        return new Menu(Patty.getPatty(), Topping.getTopping(), Drink.getDrink(), Side.getSide());
    }
    
    // getters
    
    
    public int getP() {
        return p.length;
    }
    
    public int getT() {
        return t.length;
    }
    
    public int getD() {
        return d.length;
    }
    
    public int getS() {
        return s.length;
    }
    
    public Patty getP(int index) {
        return p[index];
    }
    
    public Topping getT(int index) {
        return t[index];
    }
    
    public Drink getD(int index) {
        return d[index];
    }
    
    public Side getS(int index) {
        return s[index];
    }
    
    // print titles
    public static String printTitle(char option) {
        // decide the type of menu
        String name = switch (option) {
            case 'p' -> "meat";
            case 't' -> "toppings";
            case 'd' -> "drinks";
            case 's' -> "sides";
            default -> "";
        };
        String price = "Price";
        
        // ammount of dots and name concat
        String dots = ".".repeat(Menu.NAME_SIZE - name.length());
        name = String.format("%s%s", name, dots);
        
        // ammount of dots and price concat
        dots = ".".repeat(Menu.PRICE_SIZE - price.length() + 5); // +5 cause it need to account for "R$" and ",00"
        price = String.format("%s%s", price, dots);
        
        return String.format("|%s|%s|", name, price);
    }
    
}

// Menu item

class MenuItem {
    private String name;
    private double basePrice;
    
    MenuItem(String name, double basePrice) {
        this.name = name;
        this.basePrice = basePrice;
    }
    
    String getName() {
        return name;
    }
    
    double getBasePrice() {
        return basePrice;
    }
}

// Hamburger structure

class Patty extends MenuItem {
    private boolean isPremium;
    
    public Patty(String name, double basePrice) {
        this(name, basePrice, false);
    }
    
    public Patty(String name, double basePrice, boolean isPremium) {
        super(name, basePrice);
        this.isPremium = isPremium;
    }
    
    @Override
    public String getName() {
        return super.getName();
    }
    
    @Override
    public double getBasePrice() {
        return super.getBasePrice();
    }
    
    public static Patty[] getPatty() {
        int ammount = Database.getP(); // ammount of patties in database
        Patty[] p = new Patty[ammount];
        
        //fill the array with returns
        for (int i = 0; i < ammount; i++) {
            p[i] = getPatty(i);
        }
        
        return p;
    }
    
    public static Patty getPatty(int line) {
        // return the object from the database
        return Database.getP(line);
    }
    
    public boolean isPremium() {
        return this.isPremium;
    }
    
    // printing function
    public String printItem(int index) {
        // ammount of dots and name concat
        String dots = ".".repeat(Menu.NAME_SIZE - this.getName().length() - String.valueOf(index).length());
        String name = String.format("%d%s%s", index + 1, dots, this.getName());
        
        // ammount of dots and price concat
        dots = ".".repeat(Menu.PRICE_SIZE - String.valueOf((int) this.getBasePrice()).length());
        String price = String.format("%.2f", this.getBasePrice()).replace(',', '%').replace('.', ',').replace('%', '.');
        price = String.format("R$%s%s", dots, price);
        
        String premium = isPremium ? "fixed price" : "";
        
        return String.format("|%s|%s|%s", name, price, premium);
    }
    
}

class Topping extends MenuItem {
    public Topping(String name, double basePrice) {
        super(name, basePrice);
    }
    
    @Override
    public String getName() {
        return super.getName();
    }
    
    @Override
    public double getBasePrice() {
        return super.getBasePrice();
    }
    
    public static Topping[] getTopping() {
        int ammount = Database.getT(); // ammount of patties in database
        Topping[] t = new Topping[ammount];
        
        //fill the array with returns
        for (int i = 0; i < ammount; i++) {
            t[i] = getTopping(i);
        }
        
        return t;
    }
    
    public static Topping getTopping(int line) {
        // return the object from the database
        return Database.getT(line);
    }
    
    // printing function
    public String printItem(int index) {
        // ammount of dots and name concat
        String dots = ".".repeat(Menu.NAME_SIZE - this.getName().length() - String.valueOf(index).length());
        String name = String.format("%d%s%s", index + 1, dots, this.getName());
        
        // ammount of dots and price concat
        dots = ".".repeat(Menu.PRICE_SIZE - String.valueOf((int) this.getBasePrice()).length());
        String price = String.format("%.2f", this.getBasePrice()).replace(',', '%').replace('.', ',').replace('%', '.');
        price = String.format("%s%s", dots, price);
        
        return String.format("|%s|%s|", name, price);
    }
}

// Drinks

class Drink extends MenuItem {
    public Drink(String name, double basePrice) {
        super(name, basePrice);
    }
    
    @Override
    public String getName() {
        return super.getName();
    }
    
    @Override
    public double getBasePrice() {
        return super.getBasePrice();
    }
    
    public static Drink[] getDrink() {
        int ammount = Database.getD(); // ammount of patties in database
        Drink[] d = new Drink[ammount];
        
        //fill the array with returns
        for (int i = 0; i < ammount; i++) {
            d[i] = getDrink(i);
        }
        
        return d;
    }
    
    public static Drink getDrink(int line) {
        // return the object from the database
        return Database.getD(line);
    }
    
    // printing function
    public String printItem(int index) {
        // ammount of dots and name concat
        String dots = ".".repeat(Menu.NAME_SIZE - this.getName().length() - String.valueOf(index).length());
        String name = String.format("%d%s%s", index + 1, dots, this.getName());
        
        // ammount of dots and price concat
        dots = ".".repeat(Menu.PRICE_SIZE - String.valueOf((int) this.getBasePrice()).length());
        String price = String.format("%.2f", this.getBasePrice()).replace(',', '%').replace('.', ',').replace('%', '.');
        price = String.format("%s%s", dots, price);
        
        return String.format("|%s|%s|", name, price);
    }
}

// Sides

class Side extends MenuItem {
    public Side(String name, double basePrice) {
        super(name, basePrice);
    }
    
    @Override
    public String getName() {
        return super.getName();
    }
    
    @Override
    public double getBasePrice() {
        return super.getBasePrice();
    }
    
    public static Side[] getSide() {
        int ammount = Database.getS(); // ammount of patties in database
        Side[] s = new Side[ammount];
        
        //fill the array with returns
        for (int i = 0; i < ammount; i++) {
            s[i] = getSide(i);
        }
        
        return s;
    }
    
    public static Side getSide(int line) {
        // return the object from the database
        return Database.getS(line);
    }
    
    // printing function
    public String printItem(int index) {
        // ammount of dots and name concat
        String dots = ".".repeat(Menu.NAME_SIZE - this.getName().length() - String.valueOf(index).length());
        String name = String.format("%d%s%s", index + 1, dots, this.getName());
        
        // ammount of dots and price concat
        dots = ".".repeat(Menu.PRICE_SIZE - String.valueOf((int) this.getBasePrice()).length());
        String price = String.format("%.2f", this.getBasePrice()).replace(',', '%').replace('.', ',').replace('%', '.');
        price = String.format("%s%s", dots, price);
        
        return String.format("|%s|%s|", name, price);
    }
}