package com.buzzvil.banner.sample;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.buzzvil.buzzad.sdk.BuzzAdError;
import com.buzzvil.buzzad.sdk.BuzzSDK;
import com.buzzvil.buzzad.sdk.UserProfile;
import com.buzzvil.buzzad.sdk.banner.Ad;
import com.buzzvil.buzzad.sdk.banner.AdListener;
import com.buzzvil.buzzad.sdk.banner.AdView;

public class SampleActivity extends Activity {
	private AdView adView;
	private View buttonStart, buttonStop;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sample);

		buttonStart = findViewById(R.id.buttonStart);
		buttonStop = findViewById(R.id.buttonStop);

		buttonStart.setOnClickListener(onClickButtonStart);
		buttonStop.setOnClickListener(onClickButtonStop);
	}

	View.OnClickListener onClickButtonStart = new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			// Optional
			BuzzSDK.setUserProfile(new UserProfile.Builder()
					.setBirthday("1990-12-31")
					.setGender(UserProfile.USER_GENDER_FEMALE)
					.build());

			// Optional, for Testing
			// BuzzSDK.setOptions(new BuzzOptions.Builder().setDebugMode(1).build());

			adView = (AdView) findViewById(R.id.adView);
			adView.setAdListener(adListener);
			adView.loadAd("121658059380746");
		}
	};

	View.OnClickListener onClickButtonStop = new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			adView.destroy();
			adView = null;
		}
	};

	AdListener adListener = new AdListener() {
		@Override
		public void onError(BuzzAdError error) {
			Toast.makeText(getApplicationContext(), "Ad Failed:" + error, Toast.LENGTH_SHORT).show();
		}

		@Override
		public void onAdLoaded(Ad ad) {
			Toast.makeText(getApplicationContext(), "Ad loaded", Toast.LENGTH_SHORT).show();
		}

		@Override
		public void onClicked(Ad ad) {
			Toast.makeText(getApplicationContext(), "Ad Clicked", Toast.LENGTH_SHORT).show();
		}
	};
}
