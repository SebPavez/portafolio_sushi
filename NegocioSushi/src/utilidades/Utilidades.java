package utilidades;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Utilidades {
    public static boolean validarRut(String rut) {
        boolean validacion = false;
        try {
            rut = rut.toUpperCase();
            rut = rut.replace(".", "");
            rut = rut.replace("-", "");
            
            int rutAux = Integer.parseInt(rut.substring(0, rut.length() - 1));
            
            char dv = rut.charAt(rut.length() - 1);
            
            int m = 0, s = 1;
            for (; rutAux != 0; rutAux /= 10) {
                s = (s + rutAux % 10 * (9 - m++ % 6)) % 11;
            }
            if (dv == (char) (s != 0 ? s + 47 : 75)) {
                validacion = true;
            }            
        } catch (java.lang.NumberFormatException e) {
            System.out.println("Error en formato");
        } catch (Exception e) {
            System.out.println("Excepción no identificada en validación de rut");
        }
        return validacion;
    }
    
    private static final String PATRON_EMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
 
    /**
     * Validate given email with regular expression.
     * 
     * @param email
     *            email for validation
     * @return true valid email, otherwise false
     */
    public static boolean validarEMail(String email) {
 
        // Compiles the given regular expression into a pattern.
        Pattern pattern = Pattern.compile(PATRON_EMAIL);
 
        // Match the given input against this pattern
        Matcher matcher = pattern.matcher(email);
        return matcher.matches(); 
    }
}
