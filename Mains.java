package tempevtran;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Mains {

	public static void main(String[] args) {

	
	System.out.println("LocalDateTime.now() > "+LocalDateTime.now());
	System.out.println("Instant.now()       > "+Instant.now());

	System.out.println("System.currentTimeMillis()   > "+System.currentTimeMillis());
	System.out.println("Instant.now().toEpochMilli() > "+Instant.now().toEpochMilli());

	ZonedDateTime zdt = ZonedDateTime.of(LocalDateTime.now(), ZoneId.systemDefault());
	System.out.println("zdt.toEpochSecond() > "+zdt.toEpochSecond());
	System.out.println("zdt.toInstant().toEpochMilli() > "+zdt.toInstant().toEpochMilli());

	
	System.out.println("LocalDateTime.now().getDayOfMonth() > "+LocalDateTime.now().getDayOfMonth());
	System.out.println("LocalDateTime.now().getDayOfYear() > "+LocalDateTime.now().getDayOfYear());
	System.out.println("LocalDateTime.now().getHour() > "+LocalDateTime.now().getHour());
	System.out.println("LocalDateTime.now().getYear() > "+LocalDateTime.now().getYear());
	System.out.println("LocalDateTime.now().getMonthValue() > "+LocalDateTime.now().getMonthValue());
	System.out.println("LocalDateTime.now().getMonth() > "+LocalDateTime.now().getMonth());
	System.out.println("LocalDateTime.now().withDayOfMonth(3) > "+LocalDateTime.now().withDayOfMonth(3));
	System.out.println("LocalDateTime.now().withMonth(3) > "+LocalDateTime.now().withMonth(3));
	System.out.println("LocalDateTime.now().withMonth(12) > "+LocalDateTime.now().withMonth(12));
	System.out.println("LocalDateTime.now().withHour(23) > "+LocalDateTime.now().withHour(23));

	System.out.println("Duration.ofDays(3) > "+Duration.ofDays(3));
	System.out.println("Duration.ofDays(31) > "+Duration.ofDays(31));
	System.out.println("LocalDateTime.now().plus(Duration.ofHours(72) > "+LocalDateTime.now().plus(Duration.ofHours(72)));





	System.out.println("> "+LocalDateTime.now().with(TemporalAdjusters.lastDayOfMonth()).getDayOfMonth());
	System.out.println("> "+LocalDateTime.now().withMonth(2).with(TemporalAdjusters.lastDayOfMonth()).getDayOfMonth());

		LocalDateTime ldt=LocalDateTime.now();
		System.out.println("ldt > "+ldt);
		
		ldt.plusDays(1);
		System.out.println("ldt.plusDays(1) > "+ldt.plusDays(1));
		ldt.plusDays(1);
		System.out.println("ldt.plusDays(1) > "+ldt.plusDays(1));
		
		LocalDateTime ldt2 = ldt.plusDays(1);
		System.out.println("ldt2 > "+ldt2);
		System.out.println("ldt2.plusDays(1) > "+ldt2.plusDays(1));

		System.out.println("ldt2 > "+ldt2);
		System.out.println("ldt > "+ldt);
		
		System.out.println("-----------------------------------------------------11111111111111111------------------------------------------------------");
		ZonedDateTime zdt1 = ZonedDateTime.of(LocalDateTime.of(2021,1,17,7,11), ZoneId.systemDefault());
		System.out.println(zdt1.toEpochSecond());
		
		System.out.println("-------------------------------------------------------2222222222222222----------------------------------------------------");

		
		System.out.println(LocalDateTime.now().getDayOfMonth());
		System.out.println(LocalDateTime.now().with(TemporalAdjusters.next(DayOfWeek.FRIDAY)).getDayOfMonth());
		System.out.println(LocalDateTime.now().with(TemporalAdjusters.previous(DayOfWeek.FRIDAY)).getDayOfMonth());
		
		System.out.println(LocalDateTime.now().with(TemporalAdjusters.next(DayOfWeek.TUESDAY)).getDayOfMonth());
		System.out.println(LocalDateTime.now().with(TemporalAdjusters.previous(DayOfWeek.TUESDAY)).getDayOfMonth());

	}

}
