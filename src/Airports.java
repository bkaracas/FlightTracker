public class Airports {

	private int sayac;
	private String[] List;
    public static final String ISTANBUL="ISTANBUL";
    public static final String ADANA="ADANA";
    public static final String ANKARA="ANKARA";
    public static final String DIYARBAKIR="DIYABAKIR";
    public static final String ERZURUM="ERZURUM";
    
    
    public Airports() {
    	List=new String[20];
    	sayac=0;
    		List[0]=ISTANBUL;
    		List[1]=ADANA;
    		List[2]=ANKARA;
    		List[3]=DIYARBAKIR;
    		List[4]=ERZURUM;
    }
    
    public void ekleList(String ekle) {
    	List[sayac+5]=ekle;
    	sayac++;
    }
    
	public int getSayac() {
		return sayac;
	}
	public void setSayac(int sayac) {
		this.sayac = sayac;
	}
	public String alListe(int i) {
		return List[i];
	}
	
	public String[] getList() {
		return List;
	}
	public void setList(String list[]) {
		List = list;
	}
    
    
}
