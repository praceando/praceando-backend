package org.model;


public class Avatar implements Model {
    private int id;
    private String b64_avatar;

    /** Construtor que inicializa o ID do avatar podendo ser null b64_avatar
     * @param id_avatar ID do avatar
     * @param b64_avatar Converte a imagem do avatar para base64
     */
    public Avatar(Integer id_avatar, String b64_avatar) {
        this.b64_avatar = b64_avatar;
        this.id = id_avatar;
    }

    /** Getter do b64_avatar
     * @return b64_avatar
     */

    public String getB64_avatar() {
        return b64_avatar;
    }

    /** Getter do ID do avatar, pode retornar null.
     * @return ID do avatar
     */
    public int getId() {
        return this.id;
    }

    /** Setter do ID do avatar
     */
    public void setId(int id) {
        this.id = id;
    }

    /**Método utilizado para gerar uma linha HTML com os dados do avatar
     * @return Uma linha HTML com os dados do avatar
     */
    @Override
    public String getRawHTMLRow() {
        return String.format(
                "<td>%d/td>" +
                "<td>%s</td>",
                id,
                b64_avatar
        );
    }
}

