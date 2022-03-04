

public class ID<N, W, A, G, E> {
    N name;
    W weight; 
    A age;
    G gender;
    E ethnicity; 

    private static final String GenderO = "male";
    private static final String GenderT = "female";
    

    ID() {

    }

    ID(N userN, W weight, A age) {
        this.name = userN;
        this.weight = weight;
        this.age = age;
    }

    ID(N userName, W weight, A age, G gender, E ethnicity) throws Exception {
        this(userName, weight, age);
        if(gender != GenderO || gender != GenderT) throw new IllegalArgumentException("invalid input");
        this.gender = gender;
        this.ethnicity = ethnicity;
    }


    public void toString(ID<N, W, A, G, E> obj) {
      for(int i = 0; i < 50; i++) {
        System.out.print("*");
        //System.out.println();
        
      }
      for(int k = 0; k < 20; k++) {
        if(k < 7)
        System.out.println("| \t\t\t\t\t\t  |");
        else {
          
        }
      }
      for(int j = 0; j < 50; j++)
        System.out.print("*");
        System.out.println();
      
    }    
         
         
    

    public static void main(String[] args) {
        for(int i = 0; i < 50; i++) {
        System.out.print("*");
        //System.out.println();
        
      }
      for(int k = 0; k < 20; k++) {
        System.out.println("| \t\t\t\t\t\t  |");
        
      }
      for(int j = 0; j < 50; j++)
        System.out.print("*");
        System.out.println();
    }
  }



