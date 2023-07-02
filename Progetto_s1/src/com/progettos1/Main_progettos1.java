package com.progettos1;

import java.util.Scanner;

import com.progettos1.classi.Audio;
import com.progettos1.classi.ElementoMultimediale;
import com.progettos1.classi.Immagine;
import com.progettos1.classi.Video;

public class Main_progettos1 {

	public static void main(String[] args) {

		Audio a = new Audio("aaa", 4, 5);
		a.play();

		Immagine i = new Immagine("iii", 2);
		i.show();

		Video vid = new Video("vvv", 3, 3, 5);
		vid.play();

		lettoreMultimediale();
	}

	public static void lettoreMultimediale() {
		ElementoMultimediale[] arrElMult = new ElementoMultimediale[5];
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < 5; i++) {
			System.out.println("Che tipo di elemento multimediale scegli? [1] Immagine [2] Audio [3] Video ");
			int n = sc.nextInt();
			sc.nextLine();

			switch (n) {
			// Immagine
			case 1:
				System.out.println("Che titolo vuoi dare all'immagine? ");
				String titolo1 = sc.nextLine();
				System.out.println("Esprimi in numero la luminosità dell'immagine: ");
				int luminosita1 = sc.nextInt();
				sc.nextLine();
				Immagine imm = new Immagine(titolo1, luminosita1);
				arrElMult[i] = imm;
				break;
			// Audio
			case 2:
				System.out.println("Che titolo vuoi dare all'audio? ");
				String titolo2 = sc.nextLine();
				System.out.println("A che volume vuoi ascoltare l'audio? ");
				int volume2 = sc.nextInt();
				System.out.println("Che durata deve avere questo audio? ");
				int durata2 = sc.nextInt();
				sc.nextLine();
				Audio aud = new Audio(titolo2, volume2, durata2);
				arrElMult[i] = aud;
				break;
			// Video
			case 3:
				System.out.println("Che titolo vuoi dare all'audio? ");
				String titolo3 = sc.nextLine();
				System.out.println("Che luminosità deve evere il video? ");
				int luminosita3 = sc.nextInt();
				System.out.println("Che durata deve avere questo video? ");
				int video3 = sc.nextInt();
				System.out.println("A che volume vuoi ascoltare questo video? ");
				int volume3 = sc.nextInt();
				sc.nextLine();
				Video vid = new Video(titolo3, luminosita3, video3, volume3);
				arrElMult[i] = vid;
				break;
			default:
				System.out.println("Errore");
			}
		}
		for (int i = 0; i < arrElMult.length; i++) {
			System.out.println(arrElMult[i]);
		}
		
		int n = -1;
		while (n != 0) {
			System.out.println("Quale elemento vuoi eseguire? ");
			n = sc.nextInt();
			switch (n) {
			case 1:
				System.out.println("Avvia " + arrElMult[n-1]);
				break;
			case 2:
				System.out.println("Avvia " + arrElMult[n-1]);
				break;
			case 3:
				System.out.println("Avvia " + arrElMult[n-1]);
				break;
			case 4:
				System.out.println("Avvia " + arrElMult[n-1]);
				break;
			case 5:
				System.out.println("Avvia " + arrElMult[n-1]);
				break;
			case 0:
				System.out.println("Fine");
			default:
				System.out.println("Errore");
			}
		}
	}
}
