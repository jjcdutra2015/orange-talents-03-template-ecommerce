package br.com.zupacademy.juliodutra.mercadolivre.usuario;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class NovoUsuarioRequest {

    @NotBlank @Email
    private String login;
    @NotBlank @Size(min = 6, message = "Senha deve ter no mínimo 6 caracteres")
    private String senha;

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public Usuario toModel() {
        return new Usuario(login, hashSenha(senha));
    }

    private String hashSenha(String senha) {
        String hexSenha = "";
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte messaDigests[] = md.digest(senha.getBytes("UTF-8"));

            StringBuilder sb = new StringBuilder();
            for (byte b : messaDigests) {
                sb.append(String.format("%02x", 0xFF & b));
            }

            hexSenha = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return hexSenha;
    }
}
