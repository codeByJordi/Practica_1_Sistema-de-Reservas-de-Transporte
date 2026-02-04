
import java.util.Date;
import javax.swing.JOptionPane;

public class TaxiTradicional extends Reserva implements Confirmable {
    
    private String licencia; 
    
    public TaxiTradicional() { 
        super(); 
    }
    
    //Abstract y Interface  
    public void reservar() { 
        super.setOrigen(JOptionPane.showInputDialog("Ingrese su ubicacion actual: "));
        super.setDestino(JOptionPane.showInputDialog("Ingrese su destino: "));
        int hora = Integer.parseInt(JOptionPane.showInputDialog("Digite a que hora será su viaje: "));
        int minuto = Integer.parseInt(JOptionPane.showInputDialog("Digite los minutos: "));
        super.setFechaViaje(hora, minuto);
    } 
    public void enviarConfirmacion() {
        JOptionPane.showMessageDialog(null, "Se ha confirmado de forma existosa la reserva del taxi.", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public String getLicencia() { return licencia; }
    
    public void validarRequisitos() {
        String licencia = "";
        boolean valida = true;
        while(valida) {
            try {
                licencia = JOptionPane.showInputDialog("Ingrese la licencia del conductor: ");
                if(licencia.length() == 7) valida = false;
                else throw new Exception("La licencia debe tener 7 caracters.");
            } catch (Exception e) {JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);}
        }
        this.licencia = licencia;
    }


    
}
