package scope.more;

public class StoreDirectory {
	Bookstore bookstore;
	Market market;
	public StoreDirectory(String custId){
		bookstore = new Bookstore(custId);
		market = new Market();
	}
	
	
	
	//books
	public int getNumberOfBooks() {
		return bookstore.getNumBooks();
	}
	
	public int getNumberOfBookstoreEmployees() {
		return bookstore.getNumEmployees();
	}
	
	public boolean addNewEmployee(String employeeId){
		return bookstore.addNewEmployee(employeeId); 
	}
	
	public boolean bookIsInStock(String bookId){
		return bookstore.bookIsInStock(bookId);
	}
	public int getNumCDsInBookstore(){
		//implement 
		return bookstore.getNumCds();
	}
	
	public boolean addNewCD(int cdId){
		//re-implement 
		if(bookstore.addCd(cdId)) {
			System.out.println("Cd "+cdId+" is successfully added. Thank You");
			return true;
		}
		else {
			System.out.println("Adding cd failed.");
			return false;
		}
	}
	public boolean addNewBook(String bookId){
		//re-implement
		return true;
	}
	
	
	//market
	public boolean marketCarriesFoodItem(String foodItem){
	if (market.carriesFoodItem(foodItem))	{
		return true;
	}else {
		return false;
	}
		
	}

}
