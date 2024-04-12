import java.util.Scanner;

public class Register_OS {

	public static void main(String[] args){

		ProductFactory pfac = new ProductFactory();

		if(!pfac.Init()){
			System.exit(0);
		}

		System.out.println("Loaded " + pfac.GetProductList().size() + " products");
		Scanner in = new Scanner(System.in);

		while(true){
			System.out.print("Enter Product SKU or Name: ");
			Product p = null;

			if(in.hasNextInt()){
				Integer sku = in.nextInt();
				p = pfac.GetProduct(sku);
			}
			else if (in.hasNext()){
				String name = in.nextLine();
				p = pfac.GetProduct(name);
			}

			if(p != null){			
				if( p instanceof WeighableProduct){
					WeighableProduct wp = (WeighableProduct)p;
					System.out.print("Enter Product Weight: ");
					double weight = in.nextDouble();

// Implement a better way to calculate and add taxes

					System.out.printf("%d %s Price:$%.2f TaxRate:%.2f%% Total: $%.2f\n", 
					wp.getSku(), wp.getName(), wp.getPrice(weight), wp.getTax() * 100.0f , wp.getPrice(weight) +  (wp.getPrice(weight) * wp.getTax()));
				}
				else{
					System.out.printf("%d %s Price:$%.2f TaxRate:%.2f%% Total: $%.2f\n", 
					p.getSku(), p.getName(), p.getPrice(), p.getTax() * 100.0f , p.getPrice() +  (p.getPrice() * p.getTax()));
				}
			}

		}
	}
}
