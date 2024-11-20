package clasesGenerales;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class ReproducirMusica
{
    private String ubicacionArchivo = "A:\\Dev\\UTN\\carrera\\Programación 2 Java\\tpFinal\\TpFinal\\LOTR.mp3";

    public void main(String[] args) {
        try {
            File audioFile = new File(this.getUbicacionArchivo());
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.loop(Clip.LOOP_CONTINUOUSLY); // Reproduce en bucle
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public String getUbicacionArchivo() {
        return ubicacionArchivo;
    }

    public void setUbicacionArchivo(String ubicacionArchivo) {
        this.ubicacionArchivo = ubicacionArchivo;
    }
}