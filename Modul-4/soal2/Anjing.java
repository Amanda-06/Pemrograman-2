package Modul4.soal2;

public class Anjing extends HewanPeliharaan{
	private String warnaBulu;
	private String[] kemampuan;
	
    public Anjing(String n, String r, String w, String[] k) {
        super(r, n); 
        setWarnaBulu(w);
        setKemampuan(k);
    }
    
    public String getWarnaBulu() {
		return warnaBulu;
	}

	public void setWarnaBulu(String warnaBulu) {
		this.warnaBulu = warnaBulu;
	}
	
	public String[] getKemampuan() {
		return kemampuan;
	}

	public void setKemampuan(String[] kemampuan) {
		this.kemampuan = kemampuan;
	}
	
    public void displayDetailAnjing() {
        super.display(); 
        System.out.println("Memiliki warna bulu : " + getWarnaBulu());
        System.out.print("Memiliki kemampuan :");
        for (String skill : getKemampuan()) {
            System.out.print(" " + skill);
        }
        System.out.println();
    }
}