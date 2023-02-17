package zack.san.watcho;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import zack.san.watcho.databinding.HomeActivityBinding;

public class HomeActivity extends AppCompatActivity {

    HomeActivityBinding binding;
    private String username;


    //fragments
    private ProfileFragment profileFragment;
    private ListFragment listFragment;
    private FavoriteFragment favoriteFragment;

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout,fragment);
        fragmentTransaction.commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = HomeActivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
       // replaceFragment(new ProfileFragment());



        Intent intent = this.getIntent();
        if(intent != null )
        {
            Bundle bundle = intent.getExtras();
            username = bundle.getString("username");
            profileFragment = new ProfileFragment();
            profileFragment.setArguments(bundle);
            replaceFragment(profileFragment);



            binding.bottomNavigationView.setOnItemSelectedListener(item -> {

                switch (item.getItemId()){

                    case  R.id.profile:
                        replaceFragment(profileFragment);
                        break;
                    case R.id.list:
                        replaceFragment(new ListFragment());
                        break;
                    case R.id.favorite:
                        replaceFragment(new FavoriteFragment());
                        break;
                }


                return  true;
            });

        }










    }





}