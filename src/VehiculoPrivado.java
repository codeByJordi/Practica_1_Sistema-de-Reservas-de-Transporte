
import javax.swing.JOptionPane;

public class VehiculoPrivado extends Reserva {
    private TipoAuto tipoAuto;
    private static final String matriculasRegistradas[] = {"CR123", "CR456", "CR789"};
    private String matriculaCarro; 
    
    public VehiculoPrivado() { super(); }
    
    //Abstract y Interface
    public void reservar() { 
        super.setOrigen(JOptionPane.showInputDialog("Ingrese su ubicacion actual: "));
        super.setDestino(JOptionPane.showInputDialog("Ingrese su destino: "));
        int hora = Integer.parseInt(JOptionPane.showInputDialog("Digite a que hora será su viaje: "));
        int minuto = Integer.parseInt(JOptionPane.showInputDialog("Digite los minutos: "));
        super.setFechaViaje(hora, minuto);
        setTipoAuto();
    }
    public void enviarConfirmacion() {
        JOptionPane.showMessageDialog(null, "Se ha confirmado de forma existosa la reserva del vehiculo privado.", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public String getMatriculaCarro() { return matriculaCarro; }
    

    private void setTipoAuto() {
        int op = 0;
        String resultado;
        boolean esNum = false;
        while(!esNum) {
            try {
                op = Integer.parseInt(JOptionPane.showInputDialog("-----------SELECCIONE UNA OPCION-----------" + "\n1) Normal" + "\n2) VIP" + "\n3) Premium"));
                esNum = true; } 
            catch(NumberFormatException e) {JOptionPane.showMessageDialog(null, "DEBE DIGITAR UN DIGITO DE NUMERO", "ERROR", JOptionPane.ERROR_MESSAGE);}
            finally {
                tipoAuto = switch(op) {
                    case 1 -> tipoAuto.NORMAL;
                    case 2 -> tipoAuto.VIP;
                    case 3 -> tipoAuto.PREMIUM;
                    default -> tipoAuto.NORMAL;
                }; }
        }
        
    }
    
   public String toString(){
        return super.toString() + "\nEn un auto de tipo: " + this.tipoAuto + ".";
    }
   
    public void validarRequisitos() {
       String matricula = "";
       boolean validar = true;
       while(validar) {
           
           try {
            matricula = JOptionPane.showInputDialog("Ingrese el numero de la matricula: ");
            if(buscarElemento(matricula)) validar = false;
            else throw new Exception("El numero de la matricula es invalido. Intente de nuevo.");
           } catch (Exception x) {JOptionPane.showMessageDialog(null, x.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);}
            
       }
       this.matriculaCarro = matricula;
    }
     

    private boolean buscarElemento(String elemento){
           for(int i = 0; i < matriculasRegistradas.length - 1; i++) {
               if(matriculasRegistradas[i].equalsIgnoreCase(elemento)) return true;
           }
           return false; }
}
