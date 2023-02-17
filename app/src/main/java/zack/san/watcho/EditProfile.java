package zack.san.watcho;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import zack.san.watcho.databinding.ActivityEditProfileBinding;
import zack.san.watcho.repository.RealmRepository;

public class EditProfile extends AppCompatActivity {

    ActivityEditProfileBinding binding;
    MyApplication context;
    User user;
    EditText username;
    EditText password;
    Button save;
    Button cancel;
    RealmRepository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEditProfileBinding.inflate(getLayoutInflater());

        context = (MyApplication) this.getApplicationContext();
        repository = new RealmRepository();
        user = repository.getUser();

        binding.EditUsername.setText(user.getUsername());
        binding.editPassword.setText(user.getPassword());

        save = binding.editUser;
        cancel = binding.cancelEdit;


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



            }
        });














    }
}