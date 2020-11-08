import java.util.Random;
import java.time.LocalDate;
class Order{
    Loan Orderloan;
    int orderID;
    LocalDate creationDate;
    float Totalamount;
    float reduction;

    Order(){
    Orderloan=new Loan();
    }
        
        
            
    float getCreationDate(){
        return reduction;
    }
    void setReductionAmount(int reduction){
       this.reduction=reduction;
    } 
    
}