package modelo;

import libreria.parametrizable;

public interface Validable extends parametrizable<String>{
	public final String ER_NOMBRE = "^[a-zA-Z]+[a-zA-Z ]*$";
	public final String ER_NOMBRES_COMPLETOS = ERNames;
	public final String ER_CORREO = ERCorreo;
	public final String ER_CEDULA = ERDNI;
	public final String ER_CLAVE = "^[a-zA-Z0-9._#@%-]{8,}$";
	public final String ER_TELEFONO = "^[0-9]{7,10}$";
	public final String ER_CODIGO = "^[0-9A-Z]{6}$";
	public final String ER_RAZON_SOCIAL = "^[a-zA-Z]+[a-zA-Z ]*$";
	public final String ER_DIRECCION = "^[a-zA-Z0-9 ]{,100}$";
	public final String ER_DESCRIPCION = "^[a-zA-Z0-9 ]{,200}$";
	
	public static String generarCodigo() {
		String codigo = "";
		for (int i = 0; i < 6; i++) {
            int n = (int) (Math.random() * 36);
            if (n < 10) {
                codigo += n;
            } else {
                codigo += (char) (n + 55);
            }
        }
		return codigo;
	}

}
