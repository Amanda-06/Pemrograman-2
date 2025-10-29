package Modul4.soal2;

public class Kucing extends HewanPeliharaan {
	private String warnaBulu;

    public Kucing(String r, String n, String w) {
        super(n, r); 
        setWarnaBulu(w);
    }
    
    public String getWarnaBulu() {
		return warnaBulu;
	}

	public void setWarnaBulu(String warnaBulu) {
		this.warnaBulu = warnaBulu;
	}
	
    public void displayDetailKucing() {
        super.display(); 
        System.out.println("Memiliki warna bulu : " + getWarnaBulu());
    }
}