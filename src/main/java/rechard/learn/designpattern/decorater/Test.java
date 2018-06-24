package rechard.learn.designpattern.decorater;

/**
 * Hello world!
 *
 */
public class Test 
{
    public static void main( String[] args )
    {
        Drink drink = new Coffee();
        System.out.println(drink.description() +" ： " +drink.cost());
        drink = new Milk(drink);
        System.out.println(drink.description() +" ： " +drink.cost());
        drink =new Suggar(drink);
        System.out.println(drink.description() +" ： " +drink.cost());
        drink =new Suggar(drink);
        System.out.println(drink.description() +" ： " +drink.cost());
    }
}
