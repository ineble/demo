package board_main;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class utile {
	public static String getcurrentdate() {
		LocalDate now = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String formatednow = now.format(formatter);
		return formatednow;
	}
}
