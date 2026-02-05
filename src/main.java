
import javax.swing.JOptionPane;

public class main {


    public static void main(String[] args) {
            
        int opcion = 0;
        do {
            try {
                opcion = Integer.parseInt(JOptionPane.showInputDialog("*-*-*-*-*-*-*MENU DE RESERVAS*-*-*-*-*-*-*" 
                                                                                                        + "\n1) Reservar Taxi"
                                                                                                        + "\n2) Reservar Vehiculo Privado"
                                                                                                        + "\n3) Reservar Asiento de Bus"
                                                                                                        + "\n4) Salir"));
                
                if(opcion > 4) {  throw new Exception("Debe ser un numero dentro de las opciones"); }
                
            } 
            catch (NumberFormatException e) {JOptionPane.showMessageDialog(null, "Debe ser un numero", "Digito Incorrecto", JOptionPane.ERROR_MESSAGE);}
            catch (Exception x) {JOptionPane.showMessageDialog(null, x.getMessage(), "Fuera del rango de opciones", JOptionPane.ERROR_MESSAGE);}
            finally{
                switch(opcion){
                    case 1: {
                        Reserva taxi = new TaxiTradicional();
                        taxi.reservar();
                        taxi.validarRequisitos(); //Debe tener 7 digitos
                        taxi.enviarConfirmacion();
                        JOptionPane.showMessageDialog(null, taxi.toString());
                        opcion = 4;
                        break;
                    }
                    case 2: {
                        Reserva vehiculo = new VehiculoPrivado();
                        vehiculo.reservar();
                        vehiculo.validarRequisitos(); //Matriculas que si están registradas CR123, CR456, CR789.
                        vehiculo.enviarConfirmacion();
                        JOptionPane.showMessageDialog(null, vehiculo.toString());
                        opcion = 4;
                        break;
                    }
                    case 3: {
                        Reserva bus = new BusInter();
                        bus.reservar();
                        bus.validarRequisitos(); //EMPRESAS REGISTRADAS INTERBUS, TUASA, TRACOPA
                        bus.enviarConfirmacion();
                        JOptionPane.showMessageDialog(null, bus.toString());
                        opcion = 4;
                        break;
                    }
                    default: System.exit(0);
                }
            }
        } while(opcion != 4);
    }
    
}
