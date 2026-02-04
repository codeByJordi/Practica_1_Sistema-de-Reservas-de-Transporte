import java.time.LocalDateTime;
import javax.swing.JOptionPane;


public abstract class Reserva implements Confirmable {
    private String origen;
    private String destino;
    private LocalDateTime fechaViaje;
    
    
    
    public Reserva(){ this.origen = ""; this.destino = ""; }
    
    
    public String getOrigen() { return origen; }
    public void setOrigen(String origen) { this.origen = origen; }
    public String getDestino() { return destino; }
    public void setDestino(String destino) { this.destino = destino; }

    public LocalDateTime getFechaViaje() { return fechaViaje; }

    public void setFechaViaje(int hora, int minuto) {
        this.fechaViaje = LocalDateTime.now().withHour(hora).withMinute(minuto);
    }
    
    public abstract void reservar();
    
    

    public String toString() {
        return "Su viaje tiene de origen " + this.origen + " y como destino: " + this.destino + ". A las " + this.fechaViaje.getHour() + ":"+ this.fechaViaje.getMinute();
    }
}
