import java.util.Random;
class Product{
    int ProductID;
    String title;
    int dailyrate;
    int quantity;
    
    Product(){}
    Product(String title,int dailyrate,int ProductID,int qty){
    this.title=title;
    this.dailyrate=dailyrate;
    this.ProductID=ProductID;
    this.quantity=qty;
        
    }
    boolean availableProduct(){
       if(this.quantity>0)
           return true;
       else 
           return false;
    }


}
class Document extends Product{
	String type;
        Document(String title,int dailyrate,int ProductID,int qty,String type){
             super(title,dailyrate,ProductID,qty);
             this.type=type;
               
            }
	
	
}

class DigitalMedia extends Product{
	String DiscCapacity;
        String Language;
   
    DigitalMedia(String title,int dailyrate,int ProductID,int qty,
    			 String DiscCapcaity,String Language){
    	
        super(title,dailyrate,ProductID,qty);
        this.DiscCapacity=DiscCapacity;
        this.Language=Language;
    }
}
class Dictionary extends Document{
	
	String language;
	
        Dictionary(String title,int dailyrate,int ProductID,int qty,
        		   String type,String language){
        	
            super(title,dailyrate,ProductID,qty,type);
            this.language=language;

        }
}
class Book extends Document{
	String Publisher;
	String AuthorName;
	String YearofPubs;
	String Edition;
	
        Book(String title,int dailyrate,int ProductID,int qty,
        	 String type,String Publisher,String AuthorName,
             String YearofPubs,String Edition){
        	
         super(title,dailyrate,ProductID,qty,type);
        this.Publisher=Publisher;
        this.YearofPubs=YearofPubs;
        this.AuthorName=AuthorName;
        this.Edition=Edition;
        }
        
	
}
class CD extends DigitalMedia{
	String releaseYear;

       CD(String title,int dailyrate,int ProductID,int qty,
    	  String DiscCapcaity,String Language,String releaseyear){
    	   
        super(title,dailyrate,ProductID,qty,DiscCapcaity,Language);
             
           this.releaseYear=releaseyear;
        }
        
}

class DVD extends DigitalMedia{
	String DirectorName;
	DVD(String title,int dailyrate,int ProductID,int qty,
	    String DiscCapcaity,String Language,String DirectorName){
		
        super(title,dailyrate,ProductID,qty,DiscCapcaity,Language);
        this.DirectorName=DirectorName;
             
        }
       
             
}

class Novel extends Book{
	String Genre;
        
	Novel(String title,int dailyrate,int ProductID,int qty,
		  String type,String Publisher,String AuthorName,
          String YearofPubs,String Edition,String Genre){
		
         super(title,dailyrate,ProductID,qty,type,AuthorName,
        	   YearofPubs,Publisher,Edition);
        this.Genre=Genre;
        }
        
        
        
}
class TextBook extends Book{
	String Subject;
        String Medium;
       TextBook(String title,int dailyrate,int ProductID,int qty,
    		    String type,String Publisher,String AuthorName,
                String YearofPubs,String Edition,String Subject,String Medium){
    	   
         super(title,dailyrate,ProductID,qty,type,
        	   AuthorName,YearofPubs,Publisher,Edition);
         this.Subject=Subject;
        this.Medium=Medium;
        }
        
}
class Comic  extends Book{
    String review;
    Comic(String title,int dailyrate,int ProductID,int qty,
    	  String type,String Publisher,String AuthorName,
          String YearofPubs,String Edition,String review){
    	
         super(title,dailyrate,ProductID,qty,type,AuthorName,
        	YearofPubs,Publisher,Edition);
         this.review="Best";
    }
    
    
}



