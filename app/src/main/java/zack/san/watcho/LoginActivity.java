package zack.san.watcho;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import io.realm.Realm;
import zack.san.watcho.repository.RealmRepository;


public class LoginActivity extends AppCompatActivity {

    private EditText usernameField;
    private EditText passwordField;
    private Button loginButton;
    private Button registerButton;
    private TextView loginStatus;
    private RealmRepository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        repository = new RealmRepository();
        usernameField = findViewById(R.id.usernameField);
        passwordField = findViewById(R.id.passwordField);
        loginButton = findViewById(R.id.loginButton);
        registerButton = findViewById(R.id.registerButton);
        loginStatus = findViewById(R.id.loginStatus);




        //login button
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String username = usernameField.getText().toString().trim();
                String password = passwordField.getText().toString().trim();

                User user = repository.Login(username,password);

                if(user !=null)
                {
                    loginStatus.setText("Successful");
                    loginStatus.setTextColor(getColor(R.color.teal_700));
                    loginStatus.setVisibility(View.VISIBLE);
                    Intent intent = new Intent(LoginActivity.this,HomeActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("username",username);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
                else{
                    loginStatus.setText("Bruh Unsuccessful");
                    loginStatus.setVisibility(View.VISIBLE);
                }


            }
        });

    }
}