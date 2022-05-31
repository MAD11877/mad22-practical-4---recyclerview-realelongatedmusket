package sg.edu.np.mad.test1mad;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Random;

public class ListActivity extends AppCompatActivity {

    private String TAG = "List Activity";
    private RecyclerView recyclerView;
    Random rand = new Random();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        ArrayList<User> userList = new ArrayList<User>();
        userList = CreateUserList(20);
        SetAdapter(userList);

//        ImageView profileImage = findViewById(R.id.profileImage);
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setTitle("Profile");
//        builder.setMessage("MADness");
//        builder.setCancelable(true);
//        builder.setPositiveButton("Close", new
//                DialogInterface.OnClickListener(){
//                    public void onClick(DialogInterface dialog, int id){
//
//                    }
//                });
//        builder.setNegativeButton("View", new
//                DialogInterface.OnClickListener(){
//                    public void onClick(DialogInterface dialog, int id){
//                        Random num = new Random();
//                        int rand = num.nextInt();
//                        Intent launchMainActivity = new Intent(ListActivity.this, MainActivity.class);
//                        launchMainActivity.putExtra("Random Number", rand);
//                        startActivity(launchMainActivity);
//                    }
//                });
//
//        profileImage.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Log.v(TAG, "Image Pressed!");
//                AlertDialog alert = builder.create();
//                alert.show();
//            }
//        });
    }

    public ArrayList<User> CreateUserList(int num){
        ArrayList<User> userList = new ArrayList<>();
        for (int i = 0; i < num; i++){
            String randNameDesc = String.valueOf(rand.nextInt(999999));
            boolean randFollowed = rand.nextBoolean();
            User newUser = new User(randNameDesc, randNameDesc, i, randFollowed);
            userList.add(newUser);
        }
        return userList;
    }

    public void SetAdapter(ArrayList<User> userList){
        RecyclerView recyclerView = findViewById(R.id.userRecycler);
        Adapter myAdapter = new Adapter(userList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(myAdapter);
    }
}