package org.common;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Base64;
import javax.imageio.ImageIO;

public class ImageString {
    /** Converter uma imagem para uma string base64
     * @param image Imagem
     * @param formatName Formato ("png", "jpg", ...)
     * @return Dados da imagem
     * @throws IOException Em caso de não conseguir escrever no outputStream
     */
    public static String imageToBase64(BufferedImage image, String formatName) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ImageIO.write(image, formatName, outputStream);
        byte[] imageBytes = outputStream.toByteArray();
        return Base64.getEncoder().encodeToString(imageBytes);
    }

    /** Converter uma string base64 para uma imagem
     * @param base64String String base64
     * @return Imagem
     * @throws IOException No caso de não conseguir ler no inputStream
     */
    public static BufferedImage base64ToImage(String base64String) throws IOException {
        byte[] imageBytes = Base64.getDecoder().decode(base64String);
        ByteArrayInputStream inputStream = new ByteArrayInputStream(imageBytes);
        return ImageIO.read(inputStream);
    }

    /** Carrega uma imagem de um arquivo e retorna os dados da imagem em formato base64
     * @param filePath Caminho do arquivo da imagem
     * @return Dados da imagem em formato base64
     * @throws IOException Em caso de não conseguir ler o arquivo
     */
    public static String carregaImagem(String filePath) throws IOException {
        BufferedImage image = ImageIO.read(new File(filePath));
        String formatName = filePath.substring(filePath.lastIndexOf('.') + 1);
        return imageToBase64(image, formatName);
    }

    /** Salva uma imagem em um arquivo
     * @param image Imagem
     * @param formatName Formato da imagem
     * @param outputPath Caminho do arquivo de saída
     * @throws IOException Em caso de não conseguir escrever no arquivo de saída
     */
    public static void salvaImagem(BufferedImage image, String formatName, String outputPath) throws IOException {
        ImageIO.write(image, formatName, new File(outputPath));
    }
}