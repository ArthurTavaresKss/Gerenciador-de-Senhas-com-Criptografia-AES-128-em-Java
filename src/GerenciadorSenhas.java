import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.util.*;
import java.util.regex.Pattern;
import javax.crypto.SecretKey;

public class GerenciadorSenhas {

    private static final String SEPARADOR = "pd:*o.aD0_TgJHD4{A+,K&4Hq&j&EligMKKAv/z<J)PL=x,OFz=#M:03+PW0(462aexg(feZZdF1Jg#8p~==\"fTCw2Hp,dR1Q8HY`c3Kb=dSc%+mPrY=VKGqA->T^_18;6Dl22kWkFx*s[5uIt9**x";
    private static final SecretKey key = Criptography.getKey();
    private static final File ARQUIVO = getArquivo("senhas.txt");

    public static ArrayList<String> nomes = new ArrayList<>();
    public static ArrayList<String> senhas = new ArrayList<>();

    public GerenciadorSenhas() throws Exception {
        carregarSenhas();
    }

    // Método para obter caminho absoluto e criar pasta
    private static File getArquivo(String nomeArquivo) {
        try {
            String pastaJar = new File(GerenciadorSenhas.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getParent();
            File pasta = new File(pastaJar + File.separator + "archives");

            if (!pasta.exists()) {
                pasta.mkdirs();
            }

            return new File(pasta, nomeArquivo);
        } catch (URISyntaxException e) {
            throw new RuntimeException("Erro ao localizar diretório do JAR", e);
        }
    }

    // Carregar senhas do arquivo
    public static int carregarSenhas() throws Exception {
        int linhas = 0;
        if (ARQUIVO.exists()) {
            try (BufferedReader leitor = new BufferedReader(new FileReader(ARQUIVO))) {
                String linha;
                while ((linha = leitor.readLine()) != null) {
                    String[] partes = linha.split(Pattern.quote(SEPARADOR));
                    linhas++;
                    if (partes.length == 2) {
                        nomes.add(Criptography.decrypt(partes[0], key));
                        senhas.add(Criptography.decrypt(partes[1], key));
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return linhas;
    }

    // Salvar todas as senhas no arquivo
    private void salvarSenhas() throws Exception {
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(ARQUIVO))) {
            Map<String, String> senhasMap = new HashMap<>();
            for (int i = 0; i < senhas.size(); i++) {
                senhasMap.put(nomes.get(i).toUpperCase(), senhas.get(i));
            }
            for (Map.Entry<String, String> entrada : senhasMap.entrySet()) {
                escritor.write(Criptography.encrypt(entrada.getKey(), key) + SEPARADOR + Criptography.encrypt(entrada.getValue(), key));
                escritor.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //  Remover senha específica
    public boolean removerSenha(String nomeSenhaRemovida) throws Exception {
        String nomeSenhaCriptografada = Criptography.encrypt(nomeSenhaRemovida.toUpperCase(), key);

        List<String> linhas = Files.readAllLines(ARQUIVO.toPath());
        List<String> linhasFiltradas = new ArrayList<>();
        boolean encontrado = false;

        for (String linha : linhas) {
            String[] partes = linha.split(Pattern.quote(SEPARADOR));
            if (partes.length >= 1) {
                String nomeLinha = partes[0];

                if (!nomeSenhaCriptografada.equalsIgnoreCase(nomeLinha)) {
                    linhasFiltradas.add(linha);
                } else {
                    encontrado = true;
                }
            }
        }

        Files.write(ARQUIVO.toPath(), linhasFiltradas);
        return encontrado;
    }

    // Mandar metade dos nomes
    public ArrayList<String> mandarNomes() {
        int metade = nomes.size() / 2;
        for (int i = nomes.size() - 1; i >= metade; i--) {
            nomes.remove(i);
        }
        return nomes;
    }

    // Mandar metade das senhas
    public ArrayList<String> mandarSenhas() {
        int metade = senhas.size() / 2;
        for (int i = senhas.size() - 1; i >= metade; i--) {
            senhas.remove(i);
        }
        return senhas;
    }

    // Adicionar nova senha
    public void adicionarSenha(String nome, String senha) throws Exception {
        nomes.add(nome);
        senhas.add(senha);
        salvarSenhas();
    }
}
