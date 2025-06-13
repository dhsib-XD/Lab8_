/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laboratorio8;

/**
 *
 * @author Nathan
 */
public class UsuarioJugador {

    private String usuario;
    private String contra;
    private int puntos;

    private static String[][] usuarios;
    private static int totalU = 0;

    public UsuarioJugador(String usuario, int numUsuarios) {
        usuarios = new String[numUsuarios][2];
    }

    public UsuarioJugador(String usuario, String contra) {
        this.usuario = usuario;
        this.contra = contra;
        this.puntos = puntos;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContra() {
        return contra;
    }

    public int getPuntos() {
        return puntos;
    }

    public void sumarPuntos() {
        this.puntos++;
    }

    public boolean registrarUsuario() {
        if (totalU < usuarios.length) {
            if (UsernameValido(this.usuario)) {
                usuarios[totalU][0] = this.usuario;
                usuarios[totalU][1] = this.contra;
                totalU++;
                System.out.println("Usuario " + this.usuario + " registrado exitosamente.");
                return true;
            } else {
                System.out.println("Error: El nombre de usuario '" + this.usuario + "' ya existe.");
                return false;
            }
        } else {
            System.out.println("Error: No se pueden registrar más usuarios, el límite ha sido alcanzado.");
            return false;
        }
    }

    public static boolean UsernameValido(String usuario) {
        for (int i = 0; i < totalU; i++) {
            if (usuarios[i][0] != null && usuarios[i][0].equals(usuario)) {
                return false;
            }
        }
        return true;
    }

    public static boolean iniciarSesion(String usuario, String contra) {
        for (int i = 0; i < totalU; i++) {
            if (usuarios[i][0] != null && usuarios[i][0].equals(usuario)) {
                if (usuarios[i][1] != null && usuarios[i][1].equals(contra)) {
                    System.out.println("Inicio de sesión exitoso para " + usuario);
                    return true;
                } else {
                    System.out.println("Contraseña incorrecta para " + usuario);
                    return false;
                }
            }
        }
        System.out.println("Usuario '" + usuario + "' no encontrado.");
        return false;
    }


