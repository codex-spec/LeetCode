public class bicycle implements signal {
    private String name;
    private static int  quantity = 0;
    private String ownership;
    private double price = 0;
    private static bicycle[] arr = new bicycle[6];
    
    bicycle(String n, String o, double p) {
        this.name = n;
        this.ownership = o;
        this.price = p;
    }

    public void changeOwnership(String newOwner) {
        this.ownership = newOwner;
    }

    public double getPrice() {return this.price;}
    public String getName() {return this.name;}
    public String getOwnerShip() {return this.ownership;}

    public boolean checkIfQuantityIsFull(bicycle[] array) {
        return (quantity == arr.length);
    }

    public static void addBicycleBasedOnPrice(bicycle obj) {
        if (quantity < arr.length || obj.getPrice() > arr[quantity-1].price) {
            if(quantity <  arr.length) {
                quantity++;
            }

            int h = quantity-1;
            while(h > 0 && arr[h-1].price < obj.getPrice()) {
                arr[h] = arr[h-1];
                h--;
            }
            arr[h] = obj;
        }
    }

    public static bicycle deleteBicycle(int i) throws IllegalArgumentException {
        if(quantity == 0 || i < 0 || i >= quantity) {
            throw new IllegalArgumentException("Cannot remove objects from empty array or index" + i + " is out of bounds");
        }

        bicycle tmp = arr[i];
        for(int j = i; i < quantity - 1; j++) {
            arr[j] = arr[j+1];
        }
            arr[quantity-1] = null;
            quantity--;
        
            return tmp;
    }
    
    public bicycle[] trunicate(bicycle[] arr) throws IllegalArgumentException{
        if(arr.length == 0 || quantity == 0) throw new IllegalArgumentException("can't trunicate empty array");
        int c = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == null) {
                c++;
            }
        }
        arr = new bicycle[arr.length-c];
        return arr;
    }

    public void turnSignalRight() {
        System.out.println("Turn right");
    }
    public void turnSignalLeft() {
        System.out.println("Turn left");
    }
    public boolean containsSignal() {
        return (quantity/2 >= 5);
    }

    public static void tostring(bicycle[] someA) {
        for(int i = 0; i < someA.length; i++) {
            if(someA[i] == null) {
                continue;
            }else {
            System.out.println("this is a list of bicycle " + someA[i].price);
            }
        }
    }

    public static void toUnCareString(bicycle[] someA) {
        for(int i = 0; i < someA.length; i++) {
            System.out.println("this is a list of bicycle " + someA[i].price);
        }
    }

    public static void main(String[] args) {
        
        bicycle b1 = new bicycle("kunstadat", "abdullah", 250);
        bicycle b2 = new bicycle("ccm", "isaac", 400);
        bicycle b3 = new bicycle("supercycle", "kyle", 420);

        
        addBicycleBasedOnPrice(b1);
        addBicycleBasedOnPrice(b2);
        addBicycleBasedOnPrice(b3);
        tostring(arr);
        toUnCareString(arr);
    }

}