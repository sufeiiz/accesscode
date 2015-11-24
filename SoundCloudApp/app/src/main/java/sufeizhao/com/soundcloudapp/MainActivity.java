package sufeizhao.com.soundcloudapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;

import retrofit.Call;

public class MainActivity extends AppCompatActivity {

    private final String APP_TITLE = "SoundCloudApp";
    private final String CLIENT_ID = "44c3ef50ef4ddcfe6bf438027c39c7d8";
    private final String CLIENT_SECRET = "a90221156df766dc5c73b4a453bd6e66";
    private final String REDIRECT_URI = "sufeizhao://www.hello.com/";
    TextView accesscode, token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        token = (TextView) findViewById(R.id.token);
        accesscode = (TextView)findViewById(R.id.accesscode);

        Button loginButton = (Button) findViewById(R.id.loginbutton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse(ServiceGenerator.API_URL + "?client_id=" + CLIENT_ID + "&redirect_uri=" + REDIRECT_URI + "&response_type=code"));
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        // the intent filter defined in AndroidManifest will handle the return from ACTION_VIEW intent
        Uri uri = getIntent().getData();
        if (uri != null && uri.toString().startsWith(REDIRECT_URI)) {
            // use the parameter your API exposes for the code (mostly it's "code")
            String code = uri.getQueryParameter("code");
            token.setText("hello");
            if (code != null) {
                // get access token

                ServiceGenerator.LoginService loginService =
                        ServiceGenerator.createService(ServiceGenerator.LoginService.class, CLIENT_ID, CLIENT_SECRET);
                Call<AccessToken> call = loginService.getAccessToken(code, "authorization_code");
                try {
                    AccessToken accessToken = call.execute().body();
                    accesscode.setText(accessToken.getAccessToken());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if (uri.getQueryParameter("error") != null) {
                // show an error message here
            }
        }
    }
}
