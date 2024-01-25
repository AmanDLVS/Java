
public class UsaAccesoOracle {

	public static void main(String[] args) {
		Acceso a = new Acceso();
		a.abrirConexion();
		a.mostrarContactos();
		a.cerrarConexion();
	}

}
