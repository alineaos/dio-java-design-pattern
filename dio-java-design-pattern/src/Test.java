import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test {
    public final static Scanner sc = new Scanner(System.in);
    public final static EnviarVideo enviando = new EnviarVideo();

    public static void main(String[] args) {
        Upload youtube = new YoutubeUpload();
        Upload tiktok = new TiktokUpload();
        Upload instagram = new InstagramUpload();
        Upload facebook = new FacebookUpload();

        Map<Integer, Upload> plataformas = new HashMap<>();
        plataformas.put(1, youtube);
        plataformas.put(2, tiktok);
        plataformas.put(3, instagram);
        plataformas.put(4, facebook);

        int opcao;
        do {
            System.out.println("Escolha a plataforma para enviar o vídeo:");
            System.out.println("=========================================");
            System.out.println("[1] Youtube");
            System.out.println("[2] Tiktok");
            System.out.println("[3] Instagram");
            System.out.println("[4] Facebook");
            System.out.println("[0] Sair");
            opcao = sc.nextInt();
            if (opcao >= 1 && opcao <= 4) {
                selecionandoPlataforma(opcao, plataformas);
            } else if (opcao == 0) {
                System.exit(0);
            } else {
                System.out.println("Opção inválida.");
            }
        } while (true);
    }

    public static void selecionandoPlataforma(int opcao, Map<Integer, Upload> plataforma) {
        if (plataforma.isEmpty()){
            System.out.println("O vídeo já foi enviado em todas as plataformas.");
            System.out.println("Encerrando sistema...");
            System.exit(0);
        }
        for (Map.Entry<Integer, Upload> entry : plataforma.entrySet()) {
            if (entry.getKey() == opcao) {
                enviando.setUpload(entry.getValue());
                enviando.upload();
                plataforma.remove(opcao);
                return;
            }
        }
        System.out.println("O vídeo já foi enviado nesta plataforma, selecione outra.");
    }
}


