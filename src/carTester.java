import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;


public class carTester {

	public static void main(String[] args) {
		
		Car cars[] = new Car[500];
		
		Scanner scan = new Scanner(System.in);
		
		for(int i = 0 ; i < cars.length; i++)
		{
			cars[i] = new Car();
			
		}
	
		//Selecting by Make
		System.out.println("Select by model: 'Toyota', 'Mazda', 'Audi', 'Chevrolet'");
		
		String MakeSelection = scan.nextLine();
		Car makeSelect[] = MakeSelect(cars, MakeSelection);
		
		for(int i = 0 ; i < makeSelect.length ; i++)
		{
			System.out.println(makeSelect[i]);
		}
		outputFile(makeSelect, "makeSelection");
		
		//Selecting by model and age
		
		System.out.println("Select by make: 'A', 'B', 'C', 'D'(Case Sensitive)");
		
		String ModelSelection = scan.nextLine();
		
		System.out.println("Select by minimum age: (1-13)");
		
		int AgeSelection = scan.nextInt();
		
		Car modelSelect[] = ModelSelect(cars, ModelSelection.trim());		
	
		Car ageNewSelect[] = AgeNewerSelect(modelSelect, AgeSelection);
		
		for(int i = 0 ; i < ageNewSelect.length ; i++)
		{
			System.out.println(ageNewSelect[i]);
		}
		
		outputFile(ageNewSelect, "Model_Age_Select");
		
		//Selecting by the year of manufacturing and price
		
		System.out.println("Select by year of production: (2010-2022)");
		
		int ProductionYearSel = scan.nextInt();
		
		System.out.println("Enter lower price limit: (20000-30000)");
		
		int PriceSelection = scan.nextInt();
		
		Car ageSelect[] = AgeSelect(cars, ProductionYearSel);
		
		Car priceSelect[] = PriceHigherSelect(ageSelect, PriceSelection);
		
		for(int i = 0 ; i < priceSelect.length ; i++)
		{
			System.out.println(priceSelect[i]);
		}
		
		outputFile(priceSelect, "Product_Price_Select");
		
		scan.close();
		
	}
	
	public static Car[] MakeSelect(Car[] carsArray,String Make)
	{
		int listSize = 0;
		for(int i = 0 ; i < carsArray.length ; i++)
		{
			if(carsArray[i].getMake().equalsIgnoreCase(Make) )
			{
				listSize++;
			}
		}
		
		System.out.println(listSize);
		
		Car MakeSplit[] = new Car[listSize];
		int splitCounter = 0;
		
		for(int i = 0 ; i < carsArray.length; i++)
		{
			if(carsArray[i].getMake().equalsIgnoreCase(Make) )
			{
				MakeSplit[splitCounter] = carsArray[i];
				
				splitCounter++;
			}
		}
		
		
		return MakeSplit;
	}
	
	public static Car[] ModelSelect(Car[] carsArray,String Model)
	{
		int listSize = 0;
		for(int i = 0 ; i < carsArray.length ; i++)
		{
			if(carsArray[i].getModel().equalsIgnoreCase(Model) )
			{
				listSize++;
			}
		}
		
		Car ModelSplit[] = new Car[listSize];
		int splitCounter = 0;
		
		for(int i = 0 ; i < carsArray.length; i++)
		{
			if(carsArray[i].getModel().equalsIgnoreCase(Model) )
			{
				ModelSplit[splitCounter] = carsArray[i];
				
				splitCounter++;
			}
		}
		
		
		return Arrays.stream(carsArray).filter( car -> car.getModel().equals(Model) == true).toArray(Car[]::new);
	}
	
	public static Car[] AgeNewerSelect(Car[] carsArray, int age)
	{
		int listSize = 0;
		int currentYear = 2023;
		
		for(int i = 0 ; i < carsArray.length ; i++)
		{
			if(carsArray[i].getYearofManufacture() <= currentYear - age)
			{
				listSize++;
			}
		}
		
		Car AgeSelected[] = new Car[listSize];
		int ageSelectCounter = 0;
		
		for(int i = 0 ; i < carsArray.length ; i++)
		{
			if(carsArray[i].getYearofManufacture() <= currentYear - age)
			{
				AgeSelected[ageSelectCounter] = carsArray[i];
				ageSelectCounter++;
			}
		}
		
		return AgeSelected;
	}
	
	public static Car[] AgeSelect(Car[] carsArray, int makeYear)
	{
		int listSize = 0;
		
		for(int i = 0 ; i < carsArray.length ; i++)
		{
			if(carsArray[i].getYearofManufacture() == makeYear)
			{
				listSize++;
			}
		}
		
		Car AgeSelected[] = new Car[listSize];
		int ageSelectCounter = 0;
		
		for(int i = 0 ; i < carsArray.length ; i++)
		{
			if(carsArray[i].getYearofManufacture() == makeYear)
			{
				AgeSelected[ageSelectCounter] = carsArray[i];
				ageSelectCounter++;
			}
		}
		
		return AgeSelected;
	}
	
	public static Car[] PriceHigherSelect(Car[] carsArray, int price)
	{
		int listSize = 0;
		
		
		for(int i = 0 ; i < carsArray.length ; i++)
		{
			if(carsArray[i].getPrice() >= price)
			{
				listSize++;
			}
		}
		
		Car PriceSelected[] = new Car[listSize];
		int priceSelectCounter = 0;
		
		for(int i = 0 ; i < carsArray.length ; i++)
		{
			if(carsArray[i].getPrice() >= price)
			{
				PriceSelected[priceSelectCounter] = carsArray[i];
				priceSelectCounter++;
			}
		}
		
		
		return PriceSelected;
	}
	
	public static void outputFile(Car[] carsOBJ,String Filename)
	{
		String csvFileName = Filename + ".csv";
		try (FileWriter writer = new FileWriter(csvFileName)) {
		    
		    for (Car c  : carsOBJ) {
		        writer.write(c + "\n");
		    }

		    System.out.println("CSV file '" + csvFileName + "' created successfully.");
		} catch (IOException e) {
		    System.err.println("Error writing to CSV file: " + e.getMessage());
		}
	}

}
