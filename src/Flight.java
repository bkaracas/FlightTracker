
public class Flight {

	Time time;
    private Airline airline;
    private int flightNumber;
    private int status; // 1=cancelled 2=scheduled, 3=on the air, 4=waiting for landing, 5=landed
    private String departureairport;
    private int departurehour;
    private int departuremin;
    private String arrivalairport;
    private int arrivalhour;
    private int arrivalmin;
    
    static public final int SORT_BY_DEPARTURE_TIME = 1;
    static public final int SORT_BY_ARRIVAL_TIME = 2;
    static private int sortBy = SORT_BY_DEPARTURE_TIME;
    
    public Flight() {}

    static public void setSortBy( int sortBy ) {
        Flight.sortBy = sortBy;
    }

    static public int getSortBy() {
        return sortBy;
    }
    // constructors
    public Flight(Airline airline, int status, String departureairport, int departurehour,int departuremin, String arrivalairport, int arrivalhour, int arrivalmin) {
        this.airline = airline;
        this.status = status;
        this.departureairport = departureairport;
        this.departurehour = departurehour;
        this.departuremin = departuremin;
        this.arrivalairport = arrivalairport;
        this.arrivalhour = arrivalhour;
        this.arrivalmin = arrivalmin;
    }

    // operations
    public Airline getAirline() {
        return airline;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public int getStatus() {
        return status;
    }
    public void setStatus(int i) {
         status=i;
    }

    public String getDepartureairport() {
		return departureairport;
	}

	public int getDeparturehour() {
		return departurehour;
	}

	public int getDeparturemin() {
		return departuremin;
	}

	public String getArrivalairport() {
		return arrivalairport;
	}

	public int getArrivalhour() {
		return arrivalhour;
	}

	public int getArrivalmin() {
		return arrivalmin;
	}

	public void setDepartureairport(String departureairport) {
		this.departureairport = departureairport;
	}

	public void setDeparturehour(int departurehour) {
		this.departurehour = departurehour;
	}

	public void setDeparturemin(int departuremin) {
		this.departuremin = departuremin;
	}

	public void setArrivalairport(String arrivalairport) {
		this.arrivalairport = arrivalairport;
	}

	public void setArrivalhour(int arrivalhour) {
		this.arrivalhour = arrivalhour;
	}

	public void setArrivalmin(int arrivalmin) {
		this.arrivalmin = arrivalmin;
	}

	public String getDepartureInfo() {
        return "Airline"+airline.getCode()+"Status"+status+"DepartureInfo"+departureairport;
    }

    public String getArrivalInfo() {
        return "Airline"+airline.getCode()+"Status"+status+"ArrivalInfo"+arrivalairport;
    }

    /*public int compareTo( Flight another ) {
        int myTime = 0;
        int anotherTime = 0;
        if ( Flight.getSortBy() == Flight.SORT_BY_DEPARTURE_TIME ) {
            myTime = this.departureInfo.getTime();
            anotherTime = another.departureInfo.getTime();
        } else {
            myTime = this.arrivalInfo.getTime();
            anotherTime = another.arrivalInfo.getTime();
        }
        if ( myTime < anotherTime ) {
            return -1; // this < another
        } else if ( myTime == anotherTime ) {
            return 0;  // this == another
        } else {
            return 1;  // this > another
        }
    }*/

    @Override
    public String toString() {
        return " Airline Code "+airline.getCode()+"\nStatus "+status+"\nDeparture Airport "+departureairport+"\nArrival Airport "+arrivalairport+"\nDeparture Hour "+departurehour+"\nDeparture Min "+departuremin+"\nArrival Hour "+arrivalhour+"\nArrival Min "+arrivalmin+"\n\n";
    }

	
	/*public void run() {
		try {
			System.out.println("thread calýstý");
       	 while(getStatus()==2) {
       		 int x=time.getHour()*60+time.getmin();
       		 int y=getDeparturehour()*60+getDeparturemin();
	         if(x<=y)
	        	 setStatus(3);
	        	 Thread.sleep(2000);
	           
	         }
	         
       	 while(getStatus()==3) {
       		 int x=time.getHour()*60+time.getmin();
       		 int y=getArrivalhour()*60+getArrivalmin();
	         if(x>=y-10)
	        	 setStatus(4);
	        	 Thread.sleep(2000);
	           
	         }
       	 
       	 while(getStatus()==4) {
       		 int x=time.getHour()*60+time.getmin();
       		 int y=getArrivalhour()*60+getArrivalmin();
       		 System.out.println("On the quee for landing");
       		 if(x>=y)
		        	 setStatus(5);
		        	 Thread.sleep(2000);
	         }
	         if(getStatus()==4) {
	        	 System.out.println(toString()+"  has landed");
	         }
       	 
	      } catch (InterruptedException e) {
	         System.out.println("Thread interrupted.");
	      }}*/

}//class Flight