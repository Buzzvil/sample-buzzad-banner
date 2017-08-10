Prerequisite: Adding repositories and dependencies to build.gradle

repositories {
    maven { url "https://dl.bintray.com/buzzvil/buzzscreen/" }
    maven { url "http://dl.appnext.com/" }
}
...
dependencies {
    compile("com.buzzvil.buzzad:buzzad-sdk:")
    compile('com.android.support:multidex:1.0.1')
}

Step 1: Adding Buzzad adView
In your layout file (for example: /res/layout/activity_main.xml), add Buzzad adView.

<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout
 ...
 >
   ...
    <com.buzzvil.buzzad.sdk.banner.AdView
        android:id="@+id/adView"
        android:layout_width="match_parent"
        android:layout_height="wrap_content">
    </com.buzzvil.buzzad.sdk.banner.AdView>
   ...
</RelativeLayout>


Step 2: Loading an Ad

private AdView adView;

@Override
public void onCreate(Bundle savedInstanceState) {
 
 ...
     // Find the instantiated AdView view
     adView = (AdView) findViewById(R.id.adView);

     // Add an Ad Listener
    adView.setAdListener(new AdListener() {
        @Override
        public void onError(BuzzAdError error) {
        }

        @Override
        public void onAdLoaded(Ad ad) {
        }

        @Override
        public void onClicked(Ad ad) {
        }
    });

    // Request an ad
    adView.loadAd(121658059380746);
}

Optional: Setting Demo