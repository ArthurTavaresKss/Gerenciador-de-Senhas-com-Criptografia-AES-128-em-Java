=============================================================================================================================================================================================
================================================================================= PROJECT CRIPTOGRAPHY 1.0 ==================================================================================
=============================================================================================================================================================================================


==== PT/BR ====

Bem-vindo! Este é meu software de armazenamento de senhas pessoal, criado por necessidade de um local seguro para guardar minhas senhas, sem risco de vazamentos.

Ele funciona de uma forma simples, utilizando uma interface Swing para a visualização e manipulação das senhas, e armazena todas as senhas de forma criptografada utilizando AES-128.
É impossível decifrar a senha fora do software.

A senha inicial é "Admin1234", e ela pode ser alterada posteriormente.

O funcionamento é bastante intuitivo, mas, caso precise de uma explicação interna, ele basicamente funciona assim:
ao adicionar uma senha, o software a criptografa e a envia para o objeto TextUsers. Após isso, ele grava a senha no arquivo, e toda vez que é inicializado, carrega novamente todas as senhas.

Se quiser acessar o código-fonte, fique à vontade. Aproveite, e obrigado pela atenção! 😄


==== TUTORIAL DE INSTALAÇÃO ====

⚠️ AVISO ⚠️
Não tenho certeza se este software funciona no Linux ou macOS, foi testado apenas no Windows.


Como instalar:
Primeiramente, exclua o atalho chamado "Criptography", aquele com o ícone branco.
Ele precisa ser configurado novamente, e é mais fácil se for feito do zero.

Após isso, clique com o botão direito na área de arquivos, vá em "Novo", e depois em "Atalho".
Se aparecer uma janela com o título "Criar Atalho", você está no caminho certo.

No campo "Digite o local do arquivo", clique no botão "Procurar" e navegue até a pasta onde está localizada a pasta do Project Criptography.

⚠️ Atenção! Esta é a parte mais importante. Siga exatamente como está descrito:
Quando aparecer o caminho do arquivo na tela, selecione o caminho completo para o arquivo JavaProjectCriptography.jar, que se encontra na pasta lib.

Após selecionar, pressione as teclas CTRL + X ao mesmo tempo. Isso irá copiar e apagar o caminho.

Em seguida, digite no campo exatamente o seguinte:
java -jar (com um espaço no final).

Depois pressione CTRL + V para colar o caminho do arquivo que você acabou de recortar.

Clique em "Avançar", e então nomeie o atalho como desejar, mas é recomendado utilizar "Criptography".

Alterando o ícone:
Após criar o atalho, clique com o botão direito sobre ele e vá em "Propriedades".
Na aba "Atalho", clique em "Alterar Ícone", e em seguida em "Procurar".

Navegue até a pasta lib, que está dentro da pasta do ProjectCriptography, e selecione o arquivo chamado "Icon".

Clique em "Abrir", depois em "OK", e por fim em "Aplicar".

Pronto! Seu software está configurado corretamente.
Se tiver qualquer dúvida, por favor, entre em contato com o desenvolvedor. Muito obrigado!


==== EN/US ====

Welcome! This is my personal password storage software, created out of the need for a secure place to store my passwords without any risk of leaks.

It works in a simple way, using a Swing interface for viewing and managing passwords, and it stores all passwords encrypted with AES-128.
It is impossible to decrypt the passwords from outside the software.

The default password is "Admin1234", and it can be changed later.

The software is very intuitive, but if you need an internal explanation, it basically works like this:
When adding a password, the software encrypts it and sends it to the TextUsers object. After that, it writes the password to the file, and every time the software is started, it loads all passwords again.

If you wish to view the source code, feel free to do so. Enjoy, and thank you for your attention! 😄


==== INSTALLATION TUTORIAL ====

⚠️ WARNING ⚠️
I am not sure if this works on Linux or macOS. It has only been tested on Windows.


How to Install:
First, delete the shortcut called "Criptography", the one with the white icon.
It needs to be configured again, and it’s easier to do it from scratch.

Then, right-click anywhere in the file explorer window, go to "New", and click "Shortcut".
If a window titled "Create Shortcut" appears, you are on the right track.

In the field "Type the location of the item", click the "Browse" button and navigate to the folder where the Project Criptography folder is located.

⚠️ This is the most important part. Follow it EXACTLY as described:
When the file path appears, select the full path to the file JavaProjectCriptography.jar, which is located in the lib folder.

Once selected, press CTRL + X simultaneously. This will copy and remove the path from the field.

Then, type the following exactly:
java -jar (with a space at the end).

Now press CTRL + V to paste the file path you cut earlier.

Click "Next", then name the shortcut as you wish, but it is recommended to name it "Criptography".

Setting the icon:
Once the shortcut is created, right-click it and go to "Properties".
In the "Shortcut" tab, click "Change Icon", then click "Browse".

Navigate to the lib folder inside the ProjectCriptography folder and select the file named "Icon".

Click "Open", then "OK", and finally "Apply".

Done! Your software is ready to use.
If you have any questions, please contact the developer. Thank you very much!
