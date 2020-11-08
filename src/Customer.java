import java.util.Random;
class Customer{
   int customerID;
   String FirstName;
   String SurName;
   float reductionPerc;
   Order order[];
   int orderNumber;

Customer(){
order=new Order[3];
orderNumber=-1;
}
}
class LoyalCustomer extends Customer{
    LoyalCustomer(){
        super();
    this.reductionPerc=0.01f;
    }
}
class OccasionalCustomer extends Customer{
    OccasionalCustomer(){
    super();
     this.reductionPerc=0;
    }
}
