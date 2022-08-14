package javaBasic;

import java.util.Locale;

import com.github.javafaker.CreditCardType;
import com.github.javafaker.Faker;

public class Topic_19_Faker {

	public static void main(String[] args) {
		Faker faker = new Faker();
		System.out.println(faker.finance().creditCard(CreditCardType.VISA));

		Faker fakervi = new Faker(new Locale("vi"));
		System.out.println(fakervi.name().fullName());

	}

}
