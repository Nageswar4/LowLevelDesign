package com.fitflix;

import java.time.LocalDate;
import java.util.Map;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fitflix.beans.Center;
import com.fitflix.beans.GymStatus;
import com.fitflix.beans.Slot;
import com.fitflix.beans.SlotAvailability;
import com.fitflix.beans.WorkOutType;
import com.fitflix.service.CenterService;

@SpringBootApplication
public class FitflixApplication {

	public static void main(String[] args) {
		SpringApplication.run(FitflixApplication.class, args);
	}

	@Bean
	public CommandLineRunner onRun() {
		return args -> {
			CenterService centerService = CenterService.getInstance();
			Center center = new Center(1 + "", "Bellandur", GymStatus.OPEN, "Bangalore");
			Center center2 = new Center(12 + "", "Koramangala", GymStatus.OPEN, "Bangalore");
			Center center3 = new Center(123 + "", "WhiteField", GymStatus.OPEN, "Bangalore");
			centerService.addCenter(center3);
			centerService.addCenter(center2);
			centerService.addCenter(center);

			Slot slot = new Slot(1 + "", center.getCenterId(), "MORNING", 20, 6, 7, WorkOutType.CARDIO);
			Slot slot2 = new Slot(12 + "", center.getCenterId(), "AFTER", 20, 13, 14, WorkOutType.WEIGHTS);
			Slot slot3 = new Slot(123 + "", center.getCenterId(), "EVENING", 20, 18, 19, WorkOutType.YOGA);

			centerService.addSlot(slot);
			centerService.addSlot(slot2);
			centerService.addSlot(slot3);

			Slot slot4 = new Slot(1234 + "", center2.getCenterId(), "MORNING", 20, 6, 7, WorkOutType.CARDIO);
			Slot slot5 = new Slot(12345 + "", center2.getCenterId(), "AFTER", 20, 13, 14, WorkOutType.WEIGHTS);
			Slot slot6 = new Slot(123456 + "", center2.getCenterId(), "EVENING", 20, 18, 19, WorkOutType.YOGA);
			centerService.addSlot(slot4);
			centerService.addSlot(slot5);
			centerService.addSlot(slot6);

			SlotAvailability slotAva = new SlotAvailability(123456 + "", slot.getSlotId(), LocalDate.of(2025, 6, 18),
					0);
			SlotAvailability slotAva1 = new SlotAvailability(1234567 + "", slot.getSlotId(), LocalDate.of(2025, 6, 19),
					0);
			SlotAvailability slotAva2 = new SlotAvailability(12345678 + "", slot.getSlotId(), LocalDate.of(2025, 6, 20),
					0);

			centerService.addSlotAvailability(slotAva2);
			centerService.addSlotAvailability(slotAva1);
			centerService.addSlotAvailability(slotAva);

			for (int i = 0; i < 25; i++) {
				Map<String, String> res = centerService.slotBooking(123456 + "", i + "", LocalDate.of(2025, 6, 18));
				System.out.println(res.get(123456 + ""));
			}

			for (int i = 0; i < 7; i++) {
				Map<String, String> res = centerService.cancelBooking(123456 + "", i + "", LocalDate.of(2025, 6, 18));
				System.out.println(res.get(123456 + ""));
			}

			for (int i = 0; i < 2; i++) {
				Map<String, String> res = centerService.slotBooking(123456 + "", i + "", LocalDate.of(2025, 6, 18));
				System.out.println(res.get(123456 + ""));
			}

		};
	}

}
