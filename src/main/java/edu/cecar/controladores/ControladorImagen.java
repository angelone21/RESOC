package edu.cecar.controladores;

import edu.cecar.modelos.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import javax.imageio.ImageIO;

/**
 * Clase: ControladorImagen
 *
 * @version: 0.1
 *
 * @since: 18/09/2019
 *
 * Fecha de Modificación:
 *
 * @author: Vincenzo Angelone
 *
 * Copyrigth: CECAR
 */
public final class ControladorImagen {

    public BufferedImage descargarImagen(Blob blob) throws IOException,SQLException {
        byte[] data = blob.getBytes(1, (int) blob.length());
        BufferedImage img = null;
        try {
            img = ImageIO.read(new ByteArrayInputStream(data));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return img;
    }

}
