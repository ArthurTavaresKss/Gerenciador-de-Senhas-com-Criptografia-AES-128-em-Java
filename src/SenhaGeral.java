import java.io.*;

public class SenhaGeral {

    private static final File arquivoSenhaGeral = getArquivo("senhaGeral.txt");

    // Método para obter o caminho absoluto e criar pasta se necessário
    private static File getArquivo(String nomeArquivo) {
        try {
            String pastaJar = new File(SenhaGeral.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getParent();
            File pasta = new File(pastaJar + File.separator + "archives");
            if (!pasta.exists()) {
                pasta.mkdirs();
            }
            return new File(pasta, nomeArquivo);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao localizar diretório do JAR", e);
        }
    }

    // Ler a senha do arquivo de senha
    public static String lerSenhaDoArquivo() {
        try {
            if (!arquivoSenhaGeral.exists()) {
                // Se não existir, cria com uma senha padrão criptografada
                try (FileWriter writer = new FileWriter(arquivoSenhaGeral)) {
                    writer.write(Criptography.encrypt("Admin1234", Criptography.getKey()));
                }
            }

            try (BufferedReader leitor = new BufferedReader(new FileReader(arquivoSenhaGeral))) {
                return leitor.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Salva a senha no arquivo
    public static void salvarSenhaNoArquivo(String novaSenhaCriptografada) {
        try (FileWriter writer = new FileWriter(arquivoSenhaGeral)) {
            writer.write(novaSenhaCriptografada);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
