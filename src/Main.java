import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.SecretKey;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.basic.BasicScrollBarUI;

public class Main {

    static String senhaGeral = SenhaGeral.lerSenhaDoArquivo();

    // Fontes
            static Font fonteTituloGrande = new Font("Arial", Font.BOLD, 48);
            static Font fonteTitulo = new Font("Arial", Font.BOLD, 20);
            static Font fonteTitulo2 = new Font("Arial", Font.PLAIN, 20);
            static Font fonteTitulo3 = new Font("Arial", Font.BOLD, 28);
            static Font fonteButton = new Font("Arial", Font.PLAIN, 16);
            static Font fonteButton2 = new Font("Arial", Font.BOLD, 14);
            static Font fonteCampos = new Font("Arial", Font.PLAIN, 14); 

    public static void main(String[] args) throws Exception {

        GerenciadorSenhas gerenciadorSenhas = new GerenciadorSenhas();

        try {
            SecretKey key = Criptography.getKey();
            char[] senhaGeralChar = Criptography.decrypt(senhaGeral, key).toCharArray();

            // Letter Spacing
            Map<TextAttribute, Object> attributes = new HashMap<TextAttribute, Object>();
                attributes.put(TextAttribute.TRACKING, 0.3);

            //GBC Center
            GridBagConstraints gbcCenter = new GridBagConstraints();
            gbcCenter.gridx = 0;
            gbcCenter.gridy = 0;
            gbcCenter.insets = new Insets(0, 0, 0, 0);

            // ========== LOGIN ==========
            JFrame loginFrame = new JFrame("Login");
            loginFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            loginFrame.setUndecorated(true);
            loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            loginFrame.setLocationRelativeTo(null);

            JPanel loginPanel = new JPanel(new GridBagLayout());
            loginPanel.setBackground(new Color(22, 22, 22));
            loginFrame.add(loginPanel);

            JPanel loginCentro = new JPanel(new GridBagLayout());
            loginCentro.setPreferredSize(new Dimension(500, 300));
            loginCentro.setBackground(new Color(22, 22, 22));

            GridBagConstraints gbcCenterLogin = new GridBagConstraints();
            gbcCenterLogin.gridx = 0;
            gbcCenterLogin.gridy = 0;
            gbcCenterLogin.insets = new Insets(20, 0, 0, 0);
            loginPanel.add(loginCentro, gbcCenterLogin);

            JPasswordField inserirSenha = new JPasswordField();
            inserirSenha.setPreferredSize(new Dimension(300, 40));
            inserirSenha.setBorder(new LineBorder(new Color(30, 30, 30), 2));
            inserirSenha.setFont(fonteCampos);
            inserirSenha.setForeground(Color.WHITE);
            inserirSenha.setCaretColor(Color.WHITE);
            inserirSenha.setHorizontalAlignment(SwingConstants.CENTER);
            inserirSenha.setBackground(new Color(35, 35, 35));
            loginCentro.add(inserirSenha, gbcCenter);

            JButton botaoEntrar = new JButton("Entrar");
            botaoEntrar.setPreferredSize(new Dimension(150, 40));
            botaoEntrar.setFont(fonteButton);
            botaoEntrar.setFocusPainted(false);
            botaoEntrar.setBackground(new Color(62, 62, 116));
            botaoEntrar.setForeground(Color.WHITE);
            botaoEntrar.setBorder(new LineBorder(new Color(30, 30, 30), 2));

            GridBagConstraints gbcBotaoEntrar = new GridBagConstraints();
            gbcBotaoEntrar.gridx = 0;
            gbcBotaoEntrar.gridy = 1;
            gbcBotaoEntrar.insets = new Insets(20, 0, 0, 0);
            loginCentro.add(botaoEntrar, gbcBotaoEntrar);

            JButton botaoSairLogin = new JButton("Sair");
            botaoSairLogin.setPreferredSize(new Dimension(80, 30));
            botaoSairLogin.setFont(fonteButton2);
            botaoSairLogin.setFocusPainted(false);
            botaoSairLogin.setContentAreaFilled(false);
            botaoSairLogin.setBorderPainted(false);
            botaoSairLogin.setOpaque(false);
            botaoSairLogin.setForeground(new Color(178, 16, 6));
            botaoSairLogin.setBorder(new LineBorder(new Color(30, 30, 30), 2));

            GridBagConstraints gbcBotaoSairLogin = new GridBagConstraints();
            gbcBotaoSairLogin.gridx = 0;
            gbcBotaoSairLogin.gridy = 2;
            gbcBotaoSairLogin.insets = new Insets(0, 0, 0, 3);
            loginCentro.add(botaoSairLogin, gbcBotaoSairLogin);

            // ========== PRINCIPAL ==========
            JFrame principalFrame = new JFrame("Criptography");
            principalFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            principalFrame.setUndecorated(true);
            principalFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            principalFrame.setLocationRelativeTo(null);

            JPanel principalPanel = new JPanel(new BorderLayout());
            principalPanel.setBackground(new Color(22, 22, 22));
            principalFrame.add(principalPanel);

            // ===== ÁREA ÚTIL =====
            JPanel utilAreaPanel = new JPanel(new BorderLayout());
            utilAreaPanel.setBackground(new Color(22, 22, 22));
            utilAreaPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(5, 5, 5, 5),
                BorderFactory.createCompoundBorder(
                    new LineBorder(new Color(40, 40, 40), 2),
                    BorderFactory.createEmptyBorder(5, 5, 5, 5))));

            // ===== TOPO (TÍTULO) =====
            JPanel topoPanel = new JPanel(new GridBagLayout());
            topoPanel.setBackground(new Color(22, 22, 22));
            topoPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(5, 5, 5, 5),
                BorderFactory.createCompoundBorder(
                    new LineBorder(Color.WHITE, 1),
                    BorderFactory.createEmptyBorder(10, 20, 10, 20))));

            JLabel titulo = new JLabel("CRIPTO GRAPHY");
            titulo.setForeground(Color.WHITE);
            titulo.setFont(fonteTituloGrande.deriveFont(attributes));
            topoPanel.add(titulo, gbcCenter);

            utilAreaPanel.add(topoPanel, BorderLayout.NORTH);

            // ===== ÚTEIS =====
            JPanel utilPanel = new JPanel(new BorderLayout());
            utilPanel.setBackground(new Color(22, 22, 22));
            utilPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(5, 5, 5, 5),
                BorderFactory.createCompoundBorder(
                    new LineBorder(Color.WHITE, 1),
                    BorderFactory.createEmptyBorder(10, 20, 10, 20))));
            
            // ===== PAINEL DIREITA =====
            JPanel painelDireitaUtil = new JPanel(new FlowLayout(FlowLayout.LEFT));
            painelDireitaUtil.setBorder(new LineBorder(new Color(40, 40, 40),2));
            painelDireitaUtil.setBackground(new Color(22, 22, 22));

            JButton botaoSair = new JButton("Sair");
            botaoSair.setFont(fonteButton);
            botaoSair.setBackground(new Color(150, 50, 50));
            botaoSair.setForeground(Color.WHITE);
            botaoSair.setFocusPainted(false);
            botaoSair.setBorder(new LineBorder(new Color(30, 30, 30), 2));
            botaoSair.setPreferredSize(new Dimension(300, 30));

            painelDireitaUtil.add(botaoSair);

            utilPanel.add(painelDireitaUtil, BorderLayout.EAST);

            // ===== PAINEL CENTRO =====
            JPanel painelCentroUtil = new JPanel(new GridBagLayout());
            painelCentroUtil.setBorder(new LineBorder(new Color(40, 40, 40),2));
            painelCentroUtil.setBackground(new Color(22, 22, 22));

            JButton botaoAdicionar = new JButton("+ Adicionar Nova Senha");
            botaoAdicionar.setPreferredSize(new Dimension(780, 30));
            botaoAdicionar.setFont(fonteButton);
            botaoAdicionar.setBackground(new Color(50, 150, 50));
            botaoAdicionar.setBorder(new LineBorder(new Color(30, 30, 30), 2));
            botaoAdicionar.setForeground(Color.WHITE);
            botaoAdicionar.setFocusPainted(false);

            painelCentroUtil.add(botaoAdicionar, gbcCenter);

            utilPanel.add(painelCentroUtil, BorderLayout.CENTER);

            // ===== PAINEL ESQUERDA =====
            JPanel painelEsquerdaUtil = new JPanel(new FlowLayout(FlowLayout.LEFT));
            painelEsquerdaUtil.setBorder(new LineBorder(new Color(40, 40, 40),2));
            painelEsquerdaUtil.setBackground(new Color(22, 22, 22));

            JTextField campoMudarSenhaGeral = new JTextField(16);
            LimitarCaracteres.limitarCaracteres(campoMudarSenhaGeral, 16);
            campoMudarSenhaGeral.setPreferredSize(new Dimension(150, 25));
            campoMudarSenhaGeral.setBorder(new LineBorder(new Color(30, 30, 30), 2));
            campoMudarSenhaGeral.setFont(fonteCampos);
            campoMudarSenhaGeral.setForeground(Color.WHITE);
            campoMudarSenhaGeral.setCaretColor(Color.WHITE);
            campoMudarSenhaGeral.setHorizontalAlignment(SwingConstants.CENTER);
            campoMudarSenhaGeral.setBackground(new Color(35, 35, 35));

            JButton botaoMudarSenha = new JButton("Alterar Senha");
            botaoMudarSenha.setFont(fonteButton);
            botaoMudarSenha.setFocusPainted(false);
            botaoMudarSenha.setBackground(new Color(62, 62, 116));
            botaoMudarSenha.setForeground(Color.WHITE);
            botaoMudarSenha.setBorder(new LineBorder(new Color(30, 30, 30), 2));
            botaoMudarSenha.setPreferredSize(new Dimension(150, 30));

            painelEsquerdaUtil.add(campoMudarSenhaGeral);
            painelEsquerdaUtil.add(botaoMudarSenha);
            utilPanel.add(painelEsquerdaUtil, BorderLayout.WEST);

            utilAreaPanel.add(utilPanel, BorderLayout.CENTER);

            // ===== CAMPOS INFORMAÇÕES =====
            JPanel infoAreaPanel = new JPanel(new GridLayout(1, 2, 50, 0));
            infoAreaPanel.setBackground(new Color(22, 22, 22));
            infoAreaPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(5, 5, 5, 5),
                BorderFactory.createCompoundBorder(
                    new LineBorder(Color.WHITE, 1),
                    BorderFactory.createEmptyBorder(10, 20, 10, 20))));

            // ===== PAINEL ESQUERDA =====
            JPanel esquerdaLayout = new JPanel(new GridBagLayout());
            esquerdaLayout.setBackground(new Color(22, 22, 22));

            JPanel esquerdaInfo = new JPanel(new FlowLayout(FlowLayout.LEFT));
            esquerdaInfo.setBorder(BorderFactory.createCompoundBorder(new LineBorder(new Color(40, 40, 40),2)
            , BorderFactory.createEmptyBorder(0, 60, 0, 60)));
            esquerdaInfo.setBackground(new Color(22, 22, 22));

            JLabel nomeLabel = new JLabel("Nome:");
            nomeLabel.setForeground(Color.WHITE);
            nomeLabel.setFont(fonteTitulo);
            esquerdaInfo.add(nomeLabel);

            JTextField campoNome = new JTextField(32);
            LimitarCaracteres.limitarCaracteres(campoNome, 30);
            campoNome.setPreferredSize(new Dimension(Integer.MAX_VALUE, 30));
            campoNome.setBorder(new LineBorder(new Color(30, 30, 30), 2));
            campoNome.setFont(fonteCampos);
            campoNome.setForeground(Color.WHITE);
            campoNome.setCaretColor(Color.WHITE);
            campoNome.setHorizontalAlignment(SwingConstants.CENTER);
            campoNome.setBackground(new Color(35, 35, 35));
            esquerdaInfo.add(campoNome);

            esquerdaLayout.add(esquerdaInfo, gbcCenter);
            infoAreaPanel.add(esquerdaLayout);

            // ===== PAINEL DIREITA =====
            JPanel direitaLayout = new JPanel(new GridBagLayout());
            direitaLayout.setBackground(new Color(22, 22, 22));

            JPanel direitaInfo = new JPanel(new FlowLayout(FlowLayout.LEFT));
            direitaInfo.setBorder(BorderFactory.createCompoundBorder(new LineBorder(new Color(40, 40, 40),2)
            , BorderFactory.createEmptyBorder(0, 60, 0, 60)));
            direitaInfo.setBackground(new Color(22, 22, 22));

            JLabel senhaLabel = new JLabel("Senha:");
            senhaLabel.setForeground(Color.WHITE);
            senhaLabel.setFont(fonteTitulo);
            direitaInfo.add(senhaLabel);

            JTextField campoSenha = new JTextField(32);
            LimitarCaracteres.limitarCaracteres(campoSenha, 30);
            campoSenha.setPreferredSize(new Dimension(Integer.MAX_VALUE, 30));
            campoSenha.setBorder(new LineBorder(new Color(30, 30, 30), 2));
            campoSenha.setFont(fonteCampos);
            campoSenha.setForeground(Color.WHITE);
            campoSenha.setCaretColor(Color.WHITE);
            campoSenha.setHorizontalAlignment(SwingConstants.CENTER);
            campoSenha.setBackground(new Color(35, 35, 35));
            direitaInfo.add(campoSenha);
            
            direitaLayout.add(direitaInfo, gbcCenter);
            infoAreaPanel.add(direitaLayout);

            utilAreaPanel.add(infoAreaPanel, BorderLayout.SOUTH);

            principalPanel.add(utilAreaPanel, BorderLayout.NORTH);

            // ===== CENTRO =====
            JPanel centroPanelPrincipal = new JPanel(new BorderLayout());
            centroPanelPrincipal.setBackground(new Color(22, 22, 22));
            centroPanelPrincipal.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
            centroPanelPrincipal.setPreferredSize(new Dimension(Integer.MAX_VALUE, 600));

            JPanel centroPanel = new JPanel();
            centroPanel.setBackground(new Color(22, 22, 22));
            centroPanel.setLayout(new BoxLayout(centroPanel, BoxLayout.Y_AXIS));

            JScrollPane scrollPane = new JScrollPane(centroPanel);
            scrollPane.getVerticalScrollBar().setUnitIncrement(8);
            scrollPane.setBorder(new LineBorder(Color.WHITE, 1));
            centroPanelPrincipal.add(scrollPane, BorderLayout.CENTER);

            JScrollBar verticalBar = scrollPane.getVerticalScrollBar();

            verticalBar.setUI(new BasicScrollBarUI() {
            @Override
                protected void configureScrollBarColors() {
                this.thumbColor = new Color(62, 62, 116); // Cor do "thumb" (bolinha que arrasta)
                this.trackColor = new Color(30, 30, 30);  // Cor do trilho
                }});

            principalPanel.add(centroPanelPrincipal, BorderLayout.CENTER);

            // ===== MÉTODO PARA ADICIONAR CAIXA =====
            ActionListener adicionarCaixa = e -> {

                if((!campoSenha.getText().isBlank()) && (!campoNome.getText().isBlank())) {

                String nomeSenha = campoNome.getText();
                String senhaSenha = campoSenha.getText();

                try {
                    gerenciadorSenhas.adicionarSenha(nomeSenha, senhaSenha);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }

                // Borda
                TitledBorder borda = BorderFactory.createTitledBorder(
                new LineBorder(Color.WHITE, 1),
                " " + nomeSenha.toUpperCase() + " ",  // Título
                TitledBorder.CENTER, // Justificação
                TitledBorder.TOP); // Posição
                borda.setTitleFont(fonteTitulo3);
                borda.setTitleColor(Color.white);

            JPanel caixaMestre = new JPanel();
            caixaMestre.setLayout(new BorderLayout());
            caixaMestre.setBackground(new Color(22, 22, 22));
            caixaMestre.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20),
            BorderFactory.createCompoundBorder(borda,
            BorderFactory.createEmptyBorder(20, 30, 20, 30))));
            caixaMestre.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));

            // Caixa Info
            JPanel caixaInfo = new JPanel(new GridBagLayout());
            caixaInfo.setBackground(new Color(22, 22, 22));

            // Caixa Senha
            JPanel caixaSenha = new JPanel(new FlowLayout(FlowLayout.LEFT));
            caixaSenha.setPreferredSize(new Dimension(1040, 92));
            caixaSenha.setBackground(new Color(22, 22, 22));
            caixaSenha.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20),
            BorderFactory.createCompoundBorder(new LineBorder(new Color(30, 30, 30),2),
            BorderFactory.createEmptyBorder(5, 65, 5, 40))));

            // Label Senha
            JLabel senhaL = new JLabel("Senha: ");
            senhaL.setForeground(Color.WHITE);
            senhaL.setFont(fonteTitulo);
            caixaSenha.add(senhaL);

            // Label Senha da Senha
            JPasswordField senhadaSenha = new JPasswordField();
            char[] senha = senhaSenha.toCharArray();
            senhadaSenha.setText(new String(senha));
            senhadaSenha.setBackground(new Color(35, 35, 35));
            senhadaSenha.setForeground(Color.WHITE);
            senhadaSenha.setHorizontalAlignment(SwingConstants.CENTER);
            senhadaSenha.setFont(fonteTitulo2);
            senhadaSenha.setEditable(false);
            senhadaSenha.setBorder(new LineBorder(new Color(30, 30, 30), 2));
            senhadaSenha.setPreferredSize(new Dimension(700, 26));
            caixaSenha.add(senhadaSenha);

            JButton botaoMostrarSenha = new JButton("Mostrar");
            botaoMostrarSenha.setFont(fonteButton);
            botaoMostrarSenha.setFocusPainted(false);
            botaoMostrarSenha.setBackground(new Color(62, 62, 116));
            botaoMostrarSenha.setForeground(Color.WHITE);
            botaoMostrarSenha.setBorder(new LineBorder(new Color(30, 30, 30), 2));
            botaoMostrarSenha.setPreferredSize(new Dimension(90, 30));

            // Mostrar senha action listener
            botaoMostrarSenha.addActionListener(a -> {
                // Se senha não tiver aparecendo
                if(botaoMostrarSenha.getBackground().equals(new Color(62, 62, 116))) {
                     senhadaSenha.setEchoChar((char) 0);
                     botaoMostrarSenha.setBackground(new Color(150, 50, 50));
                     botaoMostrarSenha.setText("Esconder");
                } else {
                    // Se senha tiver aparecendo
                    senhadaSenha.setEchoChar('•');
                    botaoMostrarSenha.setBackground(new Color(62, 62, 116));
                    botaoMostrarSenha.setText("Mostrar");
                }});
            
            caixaSenha.add(botaoMostrarSenha);
            caixaInfo.add(caixaSenha, gbcCenter);

            GridBagConstraints gbcBotaoExcluir = new GridBagConstraints();
            gbcBotaoExcluir.gridx = 0;
            gbcBotaoExcluir.gridy = 1;
            gbcBotaoExcluir.insets = new Insets(0, 0, 0, 0);

            JButton botaoExcluirSenha = new JButton("Excluir");
            botaoExcluirSenha.setFont(fonteButton);
            botaoExcluirSenha.setFocusPainted(false);
            botaoExcluirSenha.setBackground(new Color(150, 50, 50));
            botaoExcluirSenha.setForeground(Color.WHITE);
            botaoExcluirSenha.setBorder(new LineBorder(new Color(30, 30, 30), 2));
            botaoExcluirSenha.setPreferredSize(new Dimension(90, 30));

            // Action listener excluir
            botaoExcluirSenha.addActionListener(a -> {
                try {
                    gerenciadorSenhas.removerSenha(nomeSenha);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                centroPanel.remove(caixaMestre);
                centroPanel.revalidate();
                centroPanel.repaint();
                JOptionPane.showMessageDialog(null, "Senha Removida com sucesso.", "", JOptionPane.INFORMATION_MESSAGE);
            });

            botaoExcluirSenha.addMouseListener(new java.awt.event.MouseAdapter() {
                // Hover
                @Override
                public void mouseEntered(java.awt.event.MouseEvent evt) {botaoExcluirSenha.setBackground(new Color(92, 31, 31));}

                // Sair do hover
                @Override
                public void mouseExited(java.awt.event.MouseEvent evt) {botaoExcluirSenha.setBackground(new Color(150, 50, 50));}
            });

            caixaInfo.add(botaoExcluirSenha, gbcBotaoExcluir);

            caixaMestre.add(caixaInfo, BorderLayout.CENTER);

                centroPanel.add(Box.createVerticalStrut(0));
                centroPanel.add(caixaMestre);

                centroPanel.revalidate();
                centroPanel.repaint();

                campoNome.setText("");
                campoSenha.setText("");
                JOptionPane.showMessageDialog(null, "Senha Adicionada com sucesso.", "", JOptionPane.INFORMATION_MESSAGE);

            } else {
                JOptionPane.showMessageDialog(null, "Digite um nome e uma senha válidos.", "", JOptionPane.WARNING_MESSAGE);
                }};

            botaoAdicionar.addActionListener(adicionarCaixa);

            // ===== BOTÃO MUDAR SENHA =====
            botaoMudarSenha.addActionListener(e -> {

            String novaSenha = campoMudarSenhaGeral.getText();

            // Se a senha estiver em branco é inválida
            if (novaSenha.isBlank()) {
            JOptionPane.showMessageDialog(null, "Digite uma senha válida.", "", JOptionPane.WARNING_MESSAGE);
            return;
            }

            // Se for menor que 6 caracteres, não tiver alguma maiúscula ou algum número é inválida
            if ((novaSenha.length() < 6) || (!novaSenha.matches(".*[A-Z].*")) || (!novaSenha.matches(".*[0-9].*"))) {
            JOptionPane.showMessageDialog(null, "Digite uma senha com mais de 6 caracteres, com uma letra maiúcula e algum número.", "", JOptionPane.WARNING_MESSAGE);
            return;
            }

            // Muda a senha no arquivo
            try {
                String novaSenhaCriptografada = Criptography.encrypt(novaSenha, key);

                SenhaGeral.salvarSenhaNoArquivo(novaSenhaCriptografada);

                senhaGeral = novaSenhaCriptografada;
                JOptionPane.showMessageDialog(null, "Senha alterada com sucesso!", "", JOptionPane.INFORMATION_MESSAGE);

                campoMudarSenhaGeral.setText("");

                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Erro ao alterar a senha.", "", JOptionPane.ERROR_MESSAGE);
                }});

                // ===== BOTÃO ENTRAR =====

                botaoEntrar.addActionListener(e -> {
                if (Arrays.equals(senhaGeralChar, inserirSenha.getPassword())) {
                    JOptionPane.showMessageDialog(null, "Senha Correta.", "", JOptionPane.INFORMATION_MESSAGE);
                    loginFrame.setVisible(false);
                    principalFrame.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Senha Incorreta.", "", JOptionPane.ERROR_MESSAGE);
                }
                inserirSenha.setText("");

                //Criar todas as senhas já salvas
                try {
                    gerenciadorSenhas.carregarSenhas();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }

                ArrayList<String> nomes = gerenciadorSenhas.mandarNomes();
                ArrayList<String> senhas = gerenciadorSenhas.mandarSenhas();

                Map<String, String> senhasMap = new HashMap<>();

                for(int i = 0; i < senhas.size(); i++) {senhasMap.put(nomes.get(i), senhas.get(i));}

                // Criar novo bloco
                for(Map.Entry<String, String> entrada : senhasMap.entrySet()) {

                String nomeSenha = entrada.getKey();
                String senhaSenha = entrada.getValue();
                System.out.println(nomeSenha);
                System.out.println(senhaSenha);

                // Borda
                TitledBorder borda = BorderFactory.createTitledBorder(
                new LineBorder(Color.WHITE, 1),
                " " + nomeSenha.toUpperCase() + " ",  // Título
                TitledBorder.CENTER, // Justificação
                TitledBorder.TOP); // Posição
                borda.setTitleFont(fonteTitulo3);
                borda.setTitleColor(Color.white);

            JPanel caixaMestre = new JPanel();
            caixaMestre.setLayout(new BorderLayout());
            caixaMestre.setBackground(new Color(22, 22, 22));
            caixaMestre.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20),
            BorderFactory.createCompoundBorder(borda,
            BorderFactory.createEmptyBorder(20, 30, 20, 30))));
            caixaMestre.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));

            // Caixa Info
            JPanel caixaInfo = new JPanel(new GridBagLayout());
            caixaInfo.setBackground(new Color(22, 22, 22));

            // Caixa Senha
            JPanel caixaSenha = new JPanel(new FlowLayout(FlowLayout.LEFT));
            caixaSenha.setPreferredSize(new Dimension(1040, 92));
            caixaSenha.setBackground(new Color(22, 22, 22));
            caixaSenha.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20),
            BorderFactory.createCompoundBorder(new LineBorder(new Color(30, 30, 30),2),
            BorderFactory.createEmptyBorder(5, 65, 5, 40))));

            // Label Senha
            JLabel senhaL = new JLabel("Senha: ");
            senhaL.setForeground(Color.WHITE);
            senhaL.setFont(fonteTitulo);
            caixaSenha.add(senhaL);

            // Label Senha da Senha
            JPasswordField senhadaSenha = new JPasswordField();
            char[] senha = senhaSenha.toCharArray();
            senhadaSenha.setText(new String(senha));
            senhadaSenha.setBackground(new Color(35, 35, 35));
            senhadaSenha.setForeground(Color.WHITE);
            senhadaSenha.setHorizontalAlignment(SwingConstants.CENTER);
            senhadaSenha.setFont(fonteTitulo2);
            senhadaSenha.setEditable(false);
            senhadaSenha.setBorder(new LineBorder(new Color(30, 30, 30), 2));
            senhadaSenha.setPreferredSize(new Dimension(700, 26));
            caixaSenha.add(senhadaSenha);

            JButton botaoMostrarSenha = new JButton("Mostrar");
            botaoMostrarSenha.setFont(fonteButton);
            botaoMostrarSenha.setFocusPainted(false);
            botaoMostrarSenha.setBackground(new Color(62, 62, 116));
            botaoMostrarSenha.setForeground(Color.WHITE);
            botaoMostrarSenha.setBorder(new LineBorder(new Color(30, 30, 30), 2));
            botaoMostrarSenha.setPreferredSize(new Dimension(90, 30));

            // Mostrar senha action listener
            botaoMostrarSenha.addActionListener(a -> {
                // Se senha não tiver aparecendo
                if(botaoMostrarSenha.getBackground().equals(new Color(62, 62, 116))) {
                     senhadaSenha.setEchoChar((char) 0);
                     botaoMostrarSenha.setBackground(new Color(150, 50, 50));
                     botaoMostrarSenha.setText("Esconder");
                } else {
                    // Se senha tiver aparecendo
                    senhadaSenha.setEchoChar('•');
                    botaoMostrarSenha.setBackground(new Color(62, 62, 116));
                    botaoMostrarSenha.setText("Mostrar");
                }});

            
            caixaSenha.add(botaoMostrarSenha);
            caixaInfo.add(caixaSenha, gbcCenter);

            GridBagConstraints gbcBotaoExcluir = new GridBagConstraints();
            gbcBotaoExcluir.gridx = 0;
            gbcBotaoExcluir.gridy = 1;
            gbcBotaoExcluir.insets = new Insets(0, 0, 0, 0);

            JButton botaoExcluirSenha = new JButton("Excluir");
            botaoExcluirSenha.setFont(fonteButton);
            botaoExcluirSenha.setFocusPainted(false);
            botaoExcluirSenha.setBackground(new Color(150, 50, 50));
            botaoExcluirSenha.setForeground(Color.WHITE);
            botaoExcluirSenha.setBorder(new LineBorder(new Color(30, 30, 30), 2));
            botaoExcluirSenha.setPreferredSize(new Dimension(90, 30));

            // Action listener excluir
            botaoExcluirSenha.addActionListener(a -> {
                try {
                    gerenciadorSenhas.removerSenha(nomeSenha);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                centroPanel.remove(caixaMestre);
                centroPanel.revalidate();
                centroPanel.repaint();
                JOptionPane.showMessageDialog(null, "Senha Removida com sucesso.", "", JOptionPane.INFORMATION_MESSAGE);
            });

            botaoExcluirSenha.addMouseListener(new java.awt.event.MouseAdapter() {
                // Hover
                @Override
                public void mouseEntered(java.awt.event.MouseEvent evt) {botaoExcluirSenha.setBackground(new Color(92, 31, 31));}

                // Sair do hover
                @Override
                public void mouseExited(java.awt.event.MouseEvent evt) {botaoExcluirSenha.setBackground(new Color(150, 50, 50));}
            });

            caixaInfo.add(botaoExcluirSenha, gbcBotaoExcluir);

            caixaMestre.add(caixaInfo, BorderLayout.CENTER);

                centroPanel.add(Box.createVerticalStrut(0));
                centroPanel.add(caixaMestre);

                centroPanel.revalidate();
                centroPanel.repaint();

                }

            });

            // ===== BOTÃO SAIR =====
            botaoSair.addActionListener( e -> {System.exit(0);});
            botaoSairLogin.addActionListener(e -> {System.exit(0);});

            // Mudar a cor com hover
            botaoEntrar.addMouseListener(new java.awt.event.MouseAdapter() {
                // Hover
                @Override
                public void mouseEntered(java.awt.event.MouseEvent evt) {botaoEntrar.setBackground(new Color(37, 37, 70));}

                // Sair do hover
                @Override
                public void mouseExited(java.awt.event.MouseEvent evt) {botaoEntrar.setBackground(new Color(62, 62, 116));}
            });

            botaoSairLogin.addMouseListener(new java.awt.event.MouseAdapter() {
                // Hover
                @Override
                public void mouseEntered(java.awt.event.MouseEvent evt) {botaoSairLogin.setForeground(new Color(84, 7, 3));}

                // Sair do hover
                @Override
                public void mouseExited(java.awt.event.MouseEvent evt) {botaoSairLogin.setForeground(new Color(178, 16, 6));}
            });

            botaoAdicionar.addMouseListener(new java.awt.event.MouseAdapter() {
                // Hover
                @Override
                public void mouseEntered(java.awt.event.MouseEvent evt) {botaoAdicionar.setBackground(new Color(27, 80, 27));}

                // Sair do hover
                @Override
                public void mouseExited(java.awt.event.MouseEvent evt) {botaoAdicionar.setBackground(new Color(50, 150, 50));}
            });

            botaoMudarSenha.addMouseListener(new java.awt.event.MouseAdapter() {
                // Hover
                @Override
                public void mouseEntered(java.awt.event.MouseEvent evt) {botaoMudarSenha.setBackground(new Color(37, 37, 70));}

                // Sair do hover
                @Override
                public void mouseExited(java.awt.event.MouseEvent evt) {botaoMudarSenha.setBackground(new Color(62, 62, 116));}
            });

            botaoSair.addMouseListener(new java.awt.event.MouseAdapter() {
                // Hover
                @Override
                public void mouseEntered(java.awt.event.MouseEvent evt) {botaoSair.setBackground(new Color(92, 31, 31));}

                // Sair do hover
                @Override
                public void mouseExited(java.awt.event.MouseEvent evt) {botaoSair.setBackground(new Color(150, 50, 50));}
            });

            // ===== VISIBILIDADE =====
            loginFrame.setVisible(true);
            principalFrame.setVisible(false);

            // Enter de input
            if(loginFrame.isVisible()) {

                botaoEntrar.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("ENTER"), "click");

                    botaoEntrar.getActionMap().put("click", new AbstractAction() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                    botaoEntrar.doClick();}});
                }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}