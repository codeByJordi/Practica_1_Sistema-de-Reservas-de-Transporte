
import java.time.LocalDateTime;
import javax.swing.JOptionPane;

public class BusInter extends Reserva {
    private int ruta;
    private static final String empresaOperadoras[] = {"INTERBUS", "TUASA", "TRACOPA"};
    private String empresa;
    
    public BusInter() { super(); }
    
    //Abstract y Interface
    public void reservar() { 
        //Validación de ruta
        int numeroRuta = 0;
        boolean existeRuta = false;
        while(!existeRuta) {
            try{
                numeroRuta = Integer.parseInt(JOptionPane.showInputDialog("----------MENU DE RUTAS----------"
                        + "\nRuta" + "                                                 Hora" 
                        + "\n1) Ciudad Quesada - Fortuna" + "         10:30 am"
                        + "\n2) San Jose - Ciudad Quesada" + "       12:30 am"
                        + "\n3) Fortuna - San Jose" + "                       1:00 pm"));
                if(numeroRuta > 3) { throw new Exception("Numero de Ruta No existe."); }
                else existeRuta = true;
            } 
            catch(NumberFormatException e) {JOptionPane.showMessageDialog(null, "Digito no es un numero", "ERROR", JOptionPane.ERROR_MESSAGE);}
            catch (Exception x) {JOptionPane.showMessageDialog(null, x.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);}
            finally {
                    switch(numeroRuta) {
                        case 1 : {
                            this.ruta = numeroRuta;
                            super.setOrigen("Ciudad Quesada");
                            super.setDestino("Fortuna");
                            super.setFechaViaje(10, 30);
                            break; }
                        case 2 : {
                            this.ruta = numeroRuta;
                            super.setOrigen("San Jose");
                            super.setDestino("Ciudad Quesada");
                            super.setFechaViaje(12, 30);
                            break; }
                        case 3 : {
                            this.ruta = numeroRuta;
                            super.setOrigen("Fortuna");
                            super.setDestino("San Jose");
                            super.setFechaViaje(13, 30);
                            break; }
                    } }; 
           
        }    
    }
    public void enviarConfirmacion() {
        boolean val = true;
        while (val) {
            try {
                String conf = JOptionPane.showInputDialog("Ingrese la palabra 'ACEPTAR' para proceder con la confirmación.");
                if(conf.equals("ACEPTAR")) val = false;
                else throw new Exception("Error: No digitó de forma correcta la palabra.");
            } 
            catch (Exception e) { JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE); }    
        } 
        JOptionPane.showMessageDialog(null, "Se ha confirmado de forma existosa la reserva en el bus.", "Confirmación", JOptionPane.INFORMATION_MESSAGE); 
    }
   public void validarRequisitos() {
       String empresa = "";
       boolean validar = true;
       while(validar) {
           
           try {
            empresa = JOptionPane.showInputDialog("Ingrese el nombre de la empresa de bus: ");
            if(buscarElemento(empresa)) validar = false;
            else throw new Exception("El nombre de la empresa es invalido. Intente de nuevo.");
           } catch (Exception x) {JOptionPane.showMessageDialog(null, x.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);}
            
       }
       this.empresa = empresa;
    }
     

    private boolean buscarElemento(String elemento){
           for(int i = 0; i < empresaOperadoras.length - 1; i++) {
               if(empresaOperadoras[i].equalsIgnoreCase(elemento)) return true;
           }
           return false; }
    
    public int getRuta() { return ruta; }
    public void setRuta(int ruta) { this.ruta = ruta; }
    public String getEmpresa() { return empresa; }
    public void setEmpresa(String empresa) { this.empresa = empresa; }
    
    public String toString() {
        return "Su viaje en bus tiene: " + " \nRuta de origen: " + this.getOrigen() + "\nDestino: " + this.getDestino() + "\nHora: " + this.getFechaViaje().getHour() +":" +this.getFechaViaje().getMinute() + "\nEmpresa: " + this.empresa.toUpperCase();
    }
}
