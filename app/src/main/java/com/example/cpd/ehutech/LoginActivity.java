package com.example.cpd.ehutech;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.cpd.ehutech.model.Login.Post;
import com.example.cpd.ehutech.model.Login.Results_;
import com.example.cpd.ehutech.model.Login.TrangThai;
import com.example.cpd.ehutech.remote.ApiUtils;
import com.example.cpd.ehutech.service.APIService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity {
    /**
     * A dummy authentication store containing known user names and passwords.
     * TODO: remove after connecting to a real authentication system.
     */
    private static final String[] DUMMY_CREDENTIALS = new String[]{
            "foo@example.com:hello", "bar@example.com:world"
    };
    /**
     * Keep track of the login task to ensure we can cancel it if requested.
     */
    private UserLoginTask mAuthTask = null;

    // UI references.
    public Intent intent;
    private EditText mMssvView;
    private EditText mPasswordView;
    String MyPREFERENCES = "ThongTinSV";
    String MSSV = "mMSSV";
    String ID = "mID";
    String Token = "token";
    String Ten = "hoten";
    String Lop = "lop";
    String Khoa = "khoa";
    String ChuKy = "chuky";
    String Email = "email";
    String SDT = "sdt";
    String username;
    String pass;
    Results_ results;
    SharedPreferences sharedPreferences;
    Post post_login = new Post();
    APIService apiService;
    Button mLogin;
    private RelativeLayout relativeLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // Anh xa - Login
        Anhxa();
        KiemtraLogin();
        mLogin.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptLogin();
            }
        });
    }
    private void KiemtraLogin() {
        sharedPreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        if (!sharedPreferences.getString(MSSV, "").equals("")) {
            intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
        }
    }
    private void Anhxa() {
        relativeLayout = findViewById(R.id.rela_loading);
        relativeLayout.setVisibility(View.GONE);
        mMssvView = findViewById(R.id.mssv);
        mPasswordView = findViewById(R.id.password);
        apiService = ApiUtils.getUserService();
        mLogin = findViewById(R.id.mssv_login);
    }

    private void attemptLogin() {
        if (mAuthTask != null) {
            return;
        }
        // Reset errors.
        mMssvView.setError(null);
        mPasswordView.setError(null);
        username = mMssvView.getText().toString();
        pass = mPasswordView.getText().toString();
        post_login.setUsername(username);
        post_login.setPassword(pass);
        boolean cancel = false;
        View focusView = null;

        // Check for a valid password, if the user entered one.
        if (!isPasswordValid(pass)) {
            mPasswordView.setError(getString(R.string.error_invalid_password));
            focusView = mPasswordView;
            cancel = true;
        }
        // Check for a valid email address.
        if (TextUtils.isEmpty(username)) {
            mMssvView.setError(getString(R.string.error_invalid_mssv));
            focusView = mMssvView;
            cancel = true;
        }
        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        } else {
            // Show a progress spinner, and kick off a background task to
            // perform the user login attempt.
            mAuthTask = new UserLoginTask(username, pass);
            mAuthTask.execute((Void) null);
        }
    }

    private boolean isPasswordValid(String password) {
        //TODO: Replace this with your own logic
        return password.length() > 1;
    }

    /**
     * Represents an asynchronous login/registration task used to authenticate
     * the user.
     */
    @SuppressLint("StaticFieldLeak")
    public class UserLoginTask extends AsyncTask<Void, Void, Boolean> {

        private final String mMssv;
        private final String mPassword;

        UserLoginTask(String email, String password) {
            mMssv = email;
            mPassword = password;
        }

        @Override
        protected Boolean doInBackground(Void... params) {
            // TODO: attempt authentication against a network service.
            try {
                // Simulate network access.
                Thread.sleep(500);
            } catch (InterruptedException e) {
                return false;
            }
            for (String credential : DUMMY_CREDENTIALS) {
                String[] pieces = credential.split(":");
                if (pieces[0].equals(mMssv)) {
                    // Account exists, return true if the password matches.
                    return pieces[1].equals(mPassword);
                }
            }
            return true;
        }

        @Override
        protected void onPostExecute(final Boolean success) {
            mAuthTask = null;
            String mssv = mMssvView.getText().toString();

            if (success) {
                relativeLayout.setVisibility(View.VISIBLE);
                doLogin(post_login);
            } else {
                mPasswordView.setError(getString(R.string.error_incorrect_password));
                mPasswordView.requestFocus();
            }
        }

        @Override
        protected void onCancelled() {
            mAuthTask = null;
        }
    }

    public void doLogin(Post post) {
        Call<TrangThai> call = apiService.login_mssv(post);
        call.enqueue(new Callback<TrangThai>() {
            @Override
            public void onResponse(Call<TrangThai> call, Response<TrangThai> response) {
                if (response.isSuccessful()) {
                    results = response.body().getResults().getObject().getResults();
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(MSSV, results.getUsername());
                    editor.putString(Token, results.getToken());
                    editor.putString(Ten, results.getHoten());
                    editor.putString(Lop, results.getTenlop());
                    editor.putString(Khoa, results.getTenkhoa());
                    editor.putString(ChuKy,results.getChuky());
                    editor.putString(ID,results.getId());
                    editor.putString(Email, results.getEmail());
                    editor.putString(SDT, results.getSdt());
                    editor.apply();
                    Toast.makeText(LoginActivity.this, "Xin Chao " + results.getHoten() + "", Toast.LENGTH_LONG).show();
                    intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    relativeLayout.setVisibility(View.GONE);
                    Toast.makeText(LoginActivity.this, "Sai Mật Khẩu Hoặc Mã Sô Sinh Viên", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<TrangThai> call, Throwable t) {
                relativeLayout.setVisibility(View.GONE);
                Toast.makeText(LoginActivity.this, "Ket Noi Loi", Toast.LENGTH_LONG).show();
            }
        });
    }
}
