import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;

public class Usaodb {

	public static void main(String[] args) {
		AccesoFormula1 a=new AccesoFormula1();
		a.actualizarPuntos("manu", "carceles",12312031);
	//	a.insertar("pepe","lopez", 100);
	//	a.insertar("ana", "garcia", 150);
	//	a.insertar("aleksander", "kladova", 50);
	//	a.insertar("alejandre","carceles",200);
	//	a.insertar("ayendi", "Rosario", 300);
	//	a.insertar("agendas", "rositas", 400);
		a.closeDB();
	}

}
