package demo009.misc;

import demo009.model.Warenart;

public class Util {

	public static String convertWarenartToString(Warenart warenart) {
		return switch (warenart) {
		case BIER -> { 
			yield "Bier";
		}
		case WEIN -> {
			yield "Wein";
		}
		case KORN -> {
			yield "Korn";
		}
		case GLAS -> {
			yield "Glas";
		}
		case TUCH -> {
			yield "Tuch";
		}
		case GOLD -> {
			yield "Gold";
		}
		};
	}
	
	public static Warenart convertWarenartToWarenart(String warenartAlsString) {
		return switch(warenartAlsString) {
		case "Bier" -> {
			yield Warenart.BIER;
		}
		case "Wein" -> {
			yield Warenart.WEIN;
		}
		case "Korn" -> {
			yield Warenart.KORN;
		}
		case "Glas" -> {
			yield Warenart.GLAS;
		}
		case "Tuch" -> {
			yield Warenart.TUCH;
		}
		case "Gold" -> {
			yield Warenart.GOLD;
		}
		default -> throw new IllegalArgumentException("Unexpected value: " + warenartAlsString);
		};
	}
	
	public static void clearConsole(){
        try{
            String operatingSystem = System.getProperty("os.name"); //Check the current operating system
              
            if(operatingSystem.contains("Windows")){        
                ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "cls");
                Process startProcess = pb.inheritIO().start();
                startProcess.waitFor();
            } else {
                ProcessBuilder pb = new ProcessBuilder("clear");
                Process startProcess = pb.inheritIO().start();

                startProcess.waitFor();
            } 
        }catch(Exception e){
            System.out.println(e);
        }
    }
}