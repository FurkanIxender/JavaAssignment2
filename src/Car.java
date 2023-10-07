
import java.util.Random;

public class Car {
	private int id;
	private String make;
	private String model;
	private int yearofManufacture;
	private String color;
	private int price;
	private int registrationNumber;
	
	public Car()
	{
		id = randomID();
		make = randomMake();
		model = randomModel();
		yearofManufacture = randomYOM();
		color = randomColor();
		price = randomPrice();
		registrationNumber = randomRegNumber();
	}
	
	 public String toString() {
	        return "Car{" +
	                "id=" + id +
	                ", make='" + make + '\'' +
	                ", model='" + model + '\'' +
	                ", yearofManufacture=" + yearofManufacture +
	                ", color='" + color + '\'' +
	                ", price=" + price +
	                ", registrationNumber=" + registrationNumber +
	                '}';
	 }
	
	public int getID()
	{
		return id;
	}
	
	public String getMake()
	{
		return make;
	}
	
	public String getModel()
	{
		return model;
	}
	
	public int getYearofManufacture()
	{
		return yearofManufacture;
	}
	
	public String getColor()
	{
		return color;
	}
	
	public int getPrice()
	{
		return price;
	}
	
	public int getRegistrationNumber()
	{
		return registrationNumber;
	}
	
	public void setID(int ID)
	{
		id = ID; 
	}
	
	public void setMake(String Make)
	{
		make = Make;
	}
	
	public void setModel(String Model)
	{
		model = Model;
	}
	
	public void setYearofManufacture(int YOM)
	{
		yearofManufacture = YOM;
	}
	
	public void setColor(String Color)
	{
		color = Color;
	}
	
	public void setRegistrationNumber(int RegistrationNumber)
	{
		registrationNumber = RegistrationNumber;
	}
	
	public int randomID()
	{
		Random r = new Random();
		return r.nextInt(1000,8999);
	}
	
	public String randomMake()
	{
		Random r = new Random();
		
		String CarCompanies[] = {"Chevrolet","Audi","Mazda","Toyota"};
		
		String randomMake = CarCompanies[r.nextInt(4)];
		
		return randomMake;
	}
	
	public String randomModel()
	{
		Random r = new Random();
		
		String CarModels[] = {"A","B","C","D"};
		
		String randomModels = CarModels[r.nextInt(4)];
		
		return randomModels;
	}
	
	public int randomYOM()
	{
		Random r = new Random();
		
		int randomYOM =  2010 +r.nextInt(13);
		
		return randomYOM;
	}
	
	public String randomColor()
	{
		Random r = new Random();
		
		String colors[] = {"Red","Blue","Black","Grey"};
		
		String randomColors = colors[r.nextInt(4)];
		
		return randomColors;
	}
	
	public int randomPrice()
	{
		Random r = new Random();
		
		int randomPrices =  20000 +r.nextInt(10000);
		
		return randomPrices;
		
	}
	
	public int randomRegNumber()
	{
		Random r = new Random();
		
		int randomReg =  1000000 +r.nextInt(8999999);
		
		return randomReg;
	}
	

	
}
