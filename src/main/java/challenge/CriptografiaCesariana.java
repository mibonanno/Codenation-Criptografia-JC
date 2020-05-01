package challenge;

public class CriptografiaCesariana implements Criptografia {
    public static int chave = 3;
    private static char espaco = 32;//espaco

    @Override
    public String criptografar(String texto) {
        if (texto == null) {
            throw new NullPointerException("Texto invalido para criptografar.");
        }
        if ("".equals(texto)) {
            throw new IllegalArgumentException("Texto invalido para criptografar.");
        }
        texto = texto.toLowerCase();
        StringBuilder textoCifrado = new StringBuilder();
        int tamanhoTexto = texto.length();

        for (int c = 0; c < tamanhoTexto; c++) {
            int letraCifradaASCII = ((int) texto.charAt(c));

            if(isEspaco(letraCifradaASCII)){
                textoCifrado.append((char) letraCifradaASCII);
                continue;
            }
            if(isNumero(letraCifradaASCII)){ //tratando n�meros
                textoCifrado.append((char) letraCifradaASCII);
                continue;
            }
            letraCifradaASCII+=chave;
            while (letraCifradaASCII > 126) {
                letraCifradaASCII -= 94;
            }
            textoCifrado.append((char) letraCifradaASCII);
        }
        return textoCifrado.toString();
    }

    private boolean isEspaco(int letraCifradaASCII) {
        return  letraCifradaASCII == espaco;
    }

    @Override
    public String descriptografar(String texto) {
        if (texto == null) {
            throw new NullPointerException("Texto invalido para criptografar.");
        }
        if ("".equals(texto)) {
            throw new IllegalArgumentException("Texto invalido para criptografar.");
        }

        texto = texto.toLowerCase();
        int tamanhoTexto = texto.length();
        StringBuilder textoDescriptado = new StringBuilder();
        for (int c = 0; c < tamanhoTexto; c++) {
            int letraDecifradaASCII = ((int) texto.charAt(c));

            if(isEspaco(letraDecifradaASCII)){
                textoDescriptado.append(espaco);
                continue;
            }
            if(isNumero(letraDecifradaASCII)){ //tratando n�meros
                textoDescriptado.append((char) letraDecifradaASCII);
                continue;
            }
            letraDecifradaASCII-=chave;
            while (letraDecifradaASCII < 32) {
                letraDecifradaASCII += 94;
            }

            textoDescriptado.append((char) letraDecifradaASCII);
        }
        return textoDescriptado.toString();
    }

    private boolean isNumero(int codeChar) {
        return codeChar>=48 && codeChar<=57;
    }
}