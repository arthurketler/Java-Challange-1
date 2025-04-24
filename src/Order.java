public class Order {
    private Patty patty;
    private Topping toppings;
    private Drink drink;
    private Side side;
    
    private double total;
    
    // constructor
    
    public Order(Patty patty, Topping toppings, Drink drink, Side side) {
        this.patty = patty;
        this.toppings = toppings;
        this.drink = drink;
        this.side = side;
        this.total = 0;
    }
    
    // getters
    
    public Patty getPatty() {
        return patty;
    }
    
    public Topping getToppings() {
        return toppings;
    }
    
    public Drink getDrink() {
        return drink;
    }
    
    public Side getSide() {
        return side;
    }
    
    public double getTotal() {
        return this.total;
    }
    
    //
    
    public void calculateTotal() {
        this.total += this.patty.getBasePrice();
        this.total += this.toppings.getBasePrice();
        this.total += this.drink.getBasePrice();
        this.total += this.side.getBasePrice();
    }
    
    
}
