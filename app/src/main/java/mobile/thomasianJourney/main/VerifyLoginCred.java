package mobile.thomasianJourney.main;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

import mobile.thomasianJourney.main.register.utils.IntentExtrasAddresses;
import mobile.thomasianJourney.main.vieweventsfragments.R;

public class VerifyLoginCred extends AppCompatActivity {

    private TextView vtvone ;
    private TextView vtvtwo ;
    private LottieAnimationView LottieLoad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_login_cred);

        //ANIMATION LOTTIE
        LottieLoad = findViewById(R.id.registerFirstLoading_lottieAnimationView);

        LottieLoad.setScale(7f);
        LottieLoad.setVisibility(View.VISIBLE);
        LottieLoad.setAnimation(R.raw.load);
        LottieLoad.playAnimation();


        vtvone = (TextView) findViewById(R.id.vtvone);
        vtvtwo = (TextView) findViewById(R.id.vtvtwo);
        Animation myanim = AnimationUtils.loadAnimation(this,R.anim.mytransition);
        vtvone.startAnimation(myanim);
        vtvtwo.startAnimation(myanim);

        final Intent i = new Intent(this,VerLoginCredSuc.class);
        Intent intent = getIntent();

        String id = intent.getExtras().getString("activityId");
        i.putExtra("activityId", id);


        SharedPreferences sharedPreferences = getSharedPreferences("mobile.thomasianJourney.main" +
                ".register.USER_CREDENTIALS", Context.MODE_PRIVATE);
        String email1 = sharedPreferences.getString(IntentExtrasAddresses.INTENT_EXTRA_EMAIL_ADDRESS, "");


        Thread timer = new Thread() {
            public void run () {
                try {
                    sleep(5000) ;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    startActivity(i);
                    finish();
                }
            }
        };
        timer.start();
    }
}
