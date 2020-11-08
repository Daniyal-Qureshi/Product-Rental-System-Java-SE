import java.util.Scanner;
import java.util.Random;
import java.time.LocalDate;
public class ProductRentalManagementSystem {
    static Scanner input;
    static Random Rand;
    static Comic comic;
    static TextBook textbook;
    static DVD dvd;
    static Dictionary dictionary1;
    static Dictionary dictionary2;
    static Product cd;
    static Product novel;
    static Product Products[];
    static int productNumber;
    static  Customer customer;

    
//Stock Variables.
    static String  title,Discap,Language,author,YOB,PB,ED,
	  ReleaseY,Director,genre,Subject,medium,review,type;
	  
	static int ID,DR,qty;
	  
    public ProductRentalManagementSystem(){
	     input=new Scanner(System.in);
	     Rand=new Random();
	     customer=null;
	     novel=new Product();
	     cd=new Product();
	     productNumber=4;
	     comic=new Comic("Avengers Series",200,Rand.nextInt(30),10,
	    		      "Text and Images","Marvel Comics","Stan Lee","2001",
	                      "Third","Best");
	      
	     textbook=new TextBook("Computer Whiz",100,Rand.nextInt(50),90,
	    		            "Text,Colored Images","Oxford University Press",
	    		  				"Sameena M.Haidermota","2008","Second",
	                            "Computer","English");
	              
	     dvd=new DVD("Marvel's Series",500,Rand.nextInt(10),30,
	    		  		    "2048 Megabyte","English,Spanish","Walt Disney");
	    		  
	      
	     dictionary1=new Dictionary("BA Dictionary",400,Rand.nextInt(35),
	    		  	               10,"Text","English");
	    		  				
	     dictionary2=new Dictionary("Kitabistan",300,Rand.nextInt(25),
		               6,"Text","Urdu");
	     Products=new Product[]{dictionary1,dictionary2,comic,textbook,dvd,
					null,null,null,null,null};
			  
    		  
    		 
    }
 //===========================Main Method   
    public static void main(String[] args) {
        new ProductRentalManagementSystem();
       
        System.out.println("\t\t\t Product Rental Management System");
    
        Menu();

    }
//==================================Menu
    static void Menu(){
    	System.out.println();
        System.out.println("\t\t\t\t1. Add Customer");
        System.out.println("\t\t\t\t2. Calculate Amount");
        System.out.println("\t\t\t\t3. Add order");
        System.out.println("\t\t\t\t4. Modify order");
        System.out.println("\t\t\t\t5. View Stock");
        System.out.println("\t\t\t\t6. Add Stock");
        System.out.println("\t\t\t\t7. Exit");
        System.out.println();
        System.out.print("\t\t\t Press Number(1-7) : ");
               input=new Scanner(System.in); 
               String op=input.next();
               switch(op) {
                    case "1":
                        AddCustomer();
                        
                    break;
                    case "2":
                        CalculateAmount(1);
                    break;

                        case "3":
                        Addorder();
                    break;
                        case "4":
                        ModifyOrder();
                    break;    	
                    

                        case "5":
                    	ViewStock();
                    break;
                        case "6":
                        	AddStock();
                    break;    	
                        case "7":{
                        	System.exit(0);
                        }
                        	break;
                        	
                    default:{
                    System.out.println("\t\t\t Invalid Number Try Again");
                    Menu();				
                    }
                    
                }
                

               
    }
        
    
    //============================Amount
    static void CalculateAmount(int showMenu){
        
        if(customer==null){
            System.out.println("\t\t\t Please Add Customer first");
            System.out.println();
            Menu();
        }
        
        else if(customer.orderNumber<0)
            System.out.println("\t\t\t Please Add Order");
    
        for(int i=0;i<=customer.orderNumber&&i<3;i++){ 
        	
        	if(customer.order[i]!=null&&i==1&&customer.order[i].Totalamount==0)
        	{
        		customer.order[i]=customer.order[i+1];
        		customer.order[i+1]=null;
        		customer.orderNumber-=1;
        		continue;
        	}
        	else if(customer.order[i]!=null&&customer.order[i].Totalamount==0) {
        		customer.order[i]=null;
        		customer.orderNumber-=1;		
        		continue;
        	}	
        	
        	System.out.println();
            System.out.println("\t\t\t This is order Number "+(i+1));
            System.out.println();
        if(customer.reductionPerc>10){
            System.out.println("\t\t\t reduction: 10 % ");
            customer.order[i].Totalamount=customer.reductionPerc*customer.order[i].Totalamount;
        }    
        
        else
        	if(customer.order[i]!=null) {
        		System.out.println("\t\t\t Loan Start Date : "+customer.order[i].Orderloan.startDate);
        		if(customer.order[i].Orderloan.endDate!=null)
        		System.out.println("\t\t\t Loan End Date : "+customer.order[i].Orderloan.endDate);       	
        	}
        System.out.println();
	    System.out.println("\t\t\t  Total Amount :  "+customer.order[i].Totalamount);
	            
        }
       
       
        System.out.println();
        if(showMenu==1) 
        Menu();
    }
    //======================================AddCustomer
    static void AddCustomer(){
        input=new Scanner(System.in);
        boolean found=false;
        for(int i=0;i<3;i++){
	        System.out.print("\t\t\t Enter Customer Type(e.g L for Loyal,O for Occasional) ");
            String type=input.next();
	        if(type.equals("L")){
	            customer=new LoyalCustomer();
	            found=true;
                break;
	        }
	        if(type.equals("O")){
	            customer=new OccasionalCustomer();
	            found=true;
                break;
	        } 
	        else{
	            System.out.print("\t\t\t Invalid selection , try again");
	            System.out.println();
	        }
        }    
         if(!found){
		     System.out.print("\t\t\t Incorrect Selection");
			 Menu();           
		 }  
         
        System.out.print("\t\t\t Enter Customer First Name : ");
        customer.FirstName=input.next();
        System.out.print("\t\t\t Enter Customer SurName : ");
        customer.SurName=input.next();
        customer.customerID=Rand.nextInt(20);
        System.out.print("\t\t\t Customer Added Successfully");
        System.out.println();      
        Menu();
    }    
    
    //===========================Modify Order
    
    static void ModifyOrder() {
    	 if(customer==null)
         {
	          System.out.println("\t\t\t Please Add Customer first");  
	          Menu();
	     }
    	 
    	 else if(customer.orderNumber<0) {
	       	   System.out.println("\t\t\t Please Add Order You don't have any order");  
	    	 	Menu();
	     }
    	 
    	 
    	 CalculateAmount(0);
    	 System.out.print("\t\t\t Select Order number ");  
    	 int OrderN=input.nextInt()-1; 	
    	 System.out.println("\t\t\t 1.Delete Order");  
    	 System.out.println("\t\t\t 2.Remove Loan");  
    	 System.out.print("\t\t\t Enter Number ");  
    	 String x=input.next();
    	 
    	 if(x.equals("1")) {
    		 if(OrderN==1) {
    			 customer.order[OrderN]=customer.order[OrderN+1];
   			  	 customer.order[OrderN+1]=null;
   			  	 customer.orderNumber-=1;
   			  	 
    		 }
    		 else {
    			 customer.order[OrderN]=null;
    			 customer.orderNumber-=1;
   			  	 
    		 }
    	 }
  			  
    	  else if(x.equals("2"))
    	    customer.order[OrderN].Orderloan.endDate=LocalDate.now();
    	  else
    	  {
    		  System.out.println("\t\t\t Invalid selection");  
              Menu();
    		  
    	  }
    	  System.out.println("\t\t\t Selected Order has been  Modified");  
          System.out.println();
          
    	  
    }
    //====================Add Order
    static void Addorder(){
    	
        Order order=new Order();
        if(customer==null)
        {
         System.out.print("\t\t\t Please Add Customer first");  
         Menu();
        
        }
       for(int i=0;i<=customer.orderNumber;i++)
    	   if(customer.order[customer.orderNumber].Totalamount==0) {
    			   customer.order[customer.orderNumber]=null;
    			   customer.orderNumber-=1;
    	   }
    		   
        
        customer.orderNumber+=1;
       
        if(customer.orderNumber>2){
             System.out.print("\t\t\t No more order can be placed from your account");  
             Menu();
        }
        customer.order[customer.orderNumber]=order;
        
        order.creationDate=LocalDate.now();
        order.reduction=customer.reductionPerc;
        System.out.println("\t\t\t Loan has been granted for order "+(customer.orderNumber+1));
        
        System.out.println("\t\t\t select Products");  
        order.Orderloan.startDate=order.creationDate;
        
        System.out.println();
        
        ProductSelection();	
        
    }
    
    
   //====================View Stock 
    static void ViewStock(){
    	System.out.println("\t\t\tTitle\t\t\t\tQuantity\t\tAvailability");
    	for(int i=0;i<=productNumber;i++)
    		System.out.println("\t\t\t"+Products[i].title+"\t\t\t"+Products[i].quantity+"\t\t\t"+Products[i].availableProduct());
            
    	
    	
         System.out.println("\t\t\tNovels\t\t\t\t0\t\t\tfalse");
         System.out.println("\t\t\tCD\t\t\t\t0\t\t\tfalse");
        
        System.out.println();
        System.out.println();
        Menu(); 
        
        
    }
  //=====================ProductSelection
    
    static void ProductSelection() {
        System.out.println();       
        boolean found=false;
        for(int i=0;i<3;i++){
            System.out.println();
            System.out.println("\t\t\t 1.Document");
            System.out.println("\t\t\t 2.Digital Media");
            System.out.print("\t\t\t Select Category (1,2) : ");      
            String op=input.next();
            if(op.equals("1")){      
                
                found=true;
                DocumentStock();
                break;
            }
            else if(op.equals("2")){
                found=true;
                DigitalMediaStock();
                break;
            }
            else{
	            System.out.print("\t\t\t Invalid selection , try again");
	            System.out.println();
	    }
        }
        if(!found){
	        System.out.print("\t\t\t Incorrect Selection");
	        Menu();           
	    }  
        
  
    }
    //======================Document Stock
    static void DocumentStock(){
        System.out.println("\t\t\t\t 1.Dictionary");  
        System.out.println("\t\t\t\t 2.Novel");
        System.out.println("\t\t\t\t 3.Comic");
        System.out.println("\t\t\t\t 4.TextBook");
        System.out.println("\t\t\t\t 5.Main Menu");
        
        System.out.print("\t\t\t\t Enter your desired Number(1-5) : ");
        
        
        String x=input.next();
        
        if(x.equals("1")){
            for(int i=0;i<3;i++){
                System.out.println();   
                System.out.println("\t\t\t Series No : 1");
                System.out.println("\t\t\t Title : "+dictionary1.title);
                System.out.println("\t\t\t Daily Rate : "+dictionary1.dailyrate);
                System.out.println("\t\t\t Quantity : "+dictionary1.quantity);
                System.out.println("\t\t\t Language : "+dictionary1.language);
                System.out.println("\t\t\t Type : "+dictionary1.type);
                System.out.println();
                System.out.println("\t\t\t Series No : 2");
                System.out.println("\t\t\t Title : "+dictionary2.title);
                System.out.println("\t\t\t Daily Rate : "+dictionary2.dailyrate);
                System.out.println("\t\t\t Quantity : "+dictionary2.quantity);
                System.out.println("\t\t\t Language : "+dictionary2.language);
                System.out.println("\t\t\t Type : "+dictionary2.type);
                System.out.print("\t\t\t Enter Series Number : ");

                String op=input.next();
                if(op.equals("1")){
                    customer.order[customer.orderNumber].Totalamount+=dictionary1.dailyrate;
                    dictionary1.quantity-=1;
                    System.out.println("\t\t\t "+dictionary1.title+"  has been added in the order");
                    break;
                }
                else if(op.equals("2")){
                	customer.order[customer.orderNumber].Totalamount+=dictionary2.dailyrate;
                    dictionary2.quantity-=1;
                    System.out.println("\t\t\t "+dictionary2.title+"  has been added in the order");
                    break;
                }
                else{
                      System.out.println("\t\t\t Invalid selection , try again");
                      System.out.println();

                }   
            }  
             System.out.println("\t\t\t Add More Products in the order");
                     
            DocumentStock();
            
        }
    
        if(x.equals("2")){  
        	
            if(!novel.availableProduct())
                System.out.println("\t\t\t Sorry ,Product (Novel) is  unavailable at the moment");
                DocumentStock();
            
        }
        if(x.equals("3")){
                System.out.println();   
                System.out.println("\t\t\t Title : "+comic.title);
                System.out.println("\t\t\t Daily Rate : "+comic.dailyrate);
                System.out.println("\t\t\t Quantity : "+comic.quantity);
                System.out.println("\t\t\t Type : "+comic.type);
                System.out.println("\t\t\t Author Name : "+comic.AuthorName);
                System.out.println("\t\t\t Publisher : "+comic.Publisher);
                System.out.println("\t\t\t Year of Publishing : "+comic.YearofPubs);
                System.out.println("\t\t\t Edition : "+comic.Edition);
                System.out.println("\t\t\t Review : "+comic.review);
                
                System.out.print("\t\t\t Enter Y to Accept and any other to reject : ");
                String X=input.next();
                if(X.equals("Y")){
                	customer.order[customer.orderNumber].Totalamount+=comic.dailyrate;
                    comic.quantity-=1;
                    System.out.println("\t\t\t "+comic.title+"  has been added in the order");
                }
                else{
                      System.out.println();
                      System.out.println("\t\t\t Add More products in the order");
                    
                      DocumentStock();
              
                }   
            }  
            
        if(x.equals("4")){
                System.out.println();   
                System.out.println("\t\t\t Series No : 1");
                System.out.println("\t\t\t Title : "+textbook.title);
                System.out.println("\t\t\t Daily Rate : "+textbook.dailyrate);
                System.out.println("\t\t\t Quantity : "+textbook.quantity);
                System.out.println("\t\t\t Type : "+textbook.type);
                System.out.println("\t\t\t Author Name : "+textbook.AuthorName);
                System.out.println("\t\t\t Publisher : "+textbook.Publisher);
                System.out.println("\t\t\t Year of Publishing : "+textbook.YearofPubs);
                System.out.println("\t\t\t Edition : "+textbook.Edition);
                System.out.println("\t\t\t Subject : "+textbook.Subject);
                System.out.println("\t\t\t Medium : "+textbook.Medium);
                    
                System.out.print("\t\t\t Enter Y to Accept and any other to reject : ");
                String X=input.next();
                if(X.equals("Y")){
                	customer.order[customer.orderNumber].Totalamount+=textbook.dailyrate;
                    textbook.quantity-=1;
                    System.out.println("\t\t\t "+textbook.title+"  has been added in the order");
                }
                else{
                      System.out.println();
                      DocumentStock();
              
                }   
            }  
            
        else if(x.equals("5"))
            Menu();
        else
               System.out.println("\t\t\t Invalid Selection Try again");
            
        DocumentStock();
        
    }
    //=====================Digital media Stock
    static void DigitalMediaStock(){
        System.out.println("\t\t\t\t 1.CD");  
        System.out.println("\t\t\t\t 2.DVD");
        System.out.println("\t\t\t\t 3.Main Menu");
        
        
        System.out.print("\t\t\t\t Enter your desired Number(1,2) : ");
        
        
        String x=input.next();
        
        
        if(x.equals("1")){
            if(!cd.availableProduct()){
                System.out.print("\t\t\t Sorry ,Product (CD) is  unavailable at the moment");
                System.out.println();   
                
                DigitalMediaStock();
            }
        }
        else if(x.equals("2")){
                System.out.println();   
                System.out.println("\t\t\t Title : "+dvd.title);
                System.out.println("\t\t\t Daily Rate : "+dvd.dailyrate);
                System.out.println("\t\t\t Quantity : "+dvd.quantity);
                System.out.println("\t\t\t Disc Capacity : "+dvd.DiscCapacity);
                System.out.println("\t\t\t Language : "+dvd.Language);
                System.out.println("\t\t\t Director Name : "+dvd.DirectorName);
                
                System.out.print("\t\t\t Enter Y to Accept and any other to reject : ");
                String X=input.next();
                if(X.equals("Y")){
                	customer.order[customer.orderNumber].Totalamount+=dvd.dailyrate;
                    dvd.quantity-=1;
                    System.out.println("\t\t\t "+dvd.title+"  has been added in the order");
                }
                else{
                      System.out.println();
                      DigitalMediaStock();
              
                }   
        }  
        
        else if(x.equals("3"))
            Menu();
        else 
              System.out.println("\t\t\t Invalid Selection Try again");
        	   
        DigitalMediaStock();
        
    
    }
    
    
    //=======Add Stock
 static void AddStock() {
	  
	  System.out.println();   
      System.out.println("\t\t\t 1.Dictionary");
      System.out.println("\t\t\t 2.TextBook" );
      System.out.println("\t\t\t 3.Comic");
      System.out.println("\t\t\t 4.Novel");
      System.out.println("\t\t\t 5.CD");
      System.out.println("\t\t\t 6.DVD");
      System.out.println("\t\t\t 7.Main Menu");
      
      System.out.print("\t\t\t Enter Number(1-7) : ");
      String x=input.next();
      
      ID=Rand.nextInt(30);
      System.out.print("\t\t\tEnter Title :");
      title=input.next();
      System.out.print("\t\t\tEnter dailyRate :");
      DR=input.nextInt();
      System.out.print("\t\t\tEnter Quantity :");
      qty=input.nextInt();
      
      
      if(x.equals("1")) {
    	  System.out.print("\t\t\tEnter Type:");
          type=input.next(); 
          
          System.out.print("\t\t\tEnter Language :");
          Language=input.next();
          
    	  Dictionary obj=new Dictionary(title,DR,ID,qty,type,Language);
    	  productNumber+=1;
    	  Products[productNumber]=obj;
      }
      	if(x.equals("2")) {
  	  
          System.out.print("\t\t\tEnter Medium:");
          medium=input.next(); 
          System.out.print("\t\t\tEnter Subject :");
          Subject=input.next();
    	  Book();
    	  
    	  TextBook obj=new TextBook( title, DR,ID, qty,type,PB,author, YOB,ED,Subject,medium);  
    	  
    	  productNumber+=1;
    	  Products[productNumber]=obj;
      }
	  
      
      
      if(x.equals("3")) {
    	 
    	  System.out.print("\t\t\tEnter Review :");
          review=input.next();
    	  Book();
    	  
    	  Comic obj=new Comic( title, DR,ID, qty,type,PB,author, YOB,ED,review);
    	  productNumber+=1;
    	  Products[productNumber]=obj;
      }
	  
      if(x.equals("4")) {

          System.out.print("\t\t\tEnter Genre :");
          genre=input.next();
    	  Book();
    	  
    	  Novel obj=new Novel( title, DR,ID, qty,type,PB,author, YOB,ED,genre);
  	  
    	  productNumber+=1;
    	  Products[productNumber]=obj;
      }
      
      if(x.equals("5")) {
    	  System.out.print("\t\t\tEnter Release Year :");
          ReleaseY=input.next();
    	  Doc();
    	  
    	  CD obj=new CD( title, DR,ID, qty,Discap,Language,ReleaseY);

    	  productNumber+=1;
    	  Products[productNumber]=obj;
      }
      
      if(x.equals("6")) {
     	 
          System.out.print("\t\t\tEnter Director Name:");
          Director=input.next();
    	  Doc();  
    	  CD obj=new CD( title, DR,ID, qty,Discap,Language,Director);
    	  	  
    	  productNumber+=1;
    	  Products[productNumber]=obj;
      }
      else if(x.equals("7"))
    	  Menu();
      
      else {
    	  System.out.println("\t\t\tInvalid Selection");
	      Menu();
      }
	  System.out.println("\t\t\t Product has been added to the stock");   
	  System.out.println();
      
	  AddStock();
	  
 }  
    
	 static void Book() {
		  System.out.print("\t\t\tEnter Author Name");
		  author=input.next(); 
	      System.out.print("\t\t\tEnter Year of Publishing");
	      YOB=input.next(); 
	      System.out.print("\t\t\tEnter Publisher");
	      PB=input.next(); 
	      System.out.print("\t\t\tEnter Edition");
	      ED=input.next(); 
	      System.out.print("\t\t\tEnter Type:");
	      type=input.next(); 

		  
	  }
	 static void Doc() {
		 System.out.print("\t\t\tEnter DiscCapacity");
		 Discap=input.next(); 
	     System.out.print("\t\t\tEnter Language");
	     Language=input.next(); 
 
	 }
	 
    
}
