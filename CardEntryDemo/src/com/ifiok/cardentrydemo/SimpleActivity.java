package com.ifiok.cardentrydemo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.ifiok.cardentry.library.CardValidCallback;
import com.ifiok.cardentry.library.CreditCard;
import com.ifiok.cardentry.library.CreditCardForm;

public class SimpleActivity extends Activity {
	private static final String TAG = "SimpleActivity";

	CardValidCallback cardValidCallback = new CardValidCallback() {
		@Override
		public void cardValid(CreditCard card) {
			Log.d(TAG, "valid card: " + card);
			Toast.makeText(SimpleActivity.this, "Card valid and complete", Toast.LENGTH_SHORT).show();
		}
	};

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.simple);

		final CreditCardForm zipForm = (CreditCardForm) findViewById(R.id.form_with_zip);
		zipForm.setOnCardValidCallback(cardValidCallback);
	}

}
