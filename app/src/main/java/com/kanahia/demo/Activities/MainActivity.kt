package com.kanahia.demo.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import com.kanahia.demo.R
import com.kanahia.demo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
//    private lateinit var account: Auth0

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

//        account = Auth0(
//            "jcIMdANBfiRN4IeZMwHYksZFQZjPnrgx",
//            "kanahia.us.auth0.com"
//        )
//        account.setLoggingEnabled(true)
//        account.setOIDCConformant(true)


        setContentView(R.layout.activity_main)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        getSupportActionBar()?.hide()
        Handler().postDelayed({
            val i = Intent(
                this@MainActivity,
                GetStartedActivity::class.java
            )
            startActivity(i)
            finish()
        }, 3000)
//        binding.loginBtn.setOnClickListener {
//
//            WebAuthProvider.login(account)
//                .withScheme("demo")
//                .withScope("openid profile email")
//                // Launch the authentication passing the callback where the results will be received
//                .start(this, object : Callback<Credentials, AuthenticationException> {
//                    // Called when there is an authentication failure
//                    override fun onFailure(error: AuthenticationException) {
//                        Toast
//                            .makeText(this@MainActivity, "Login Error: \n${error.message}", Toast.LENGTH_LONG)
//                            .show()
//
//                        Log.e("PRINT",error.toString())
//                        binding.nameTv.text = error.toString()
//                    }
//
//                    // Called when authentication completed successfully
//                    override fun onSuccess(credentials: Credentials) {
//                        // Get the access token from the credentials object.
//                        // This can be used to call APIs
//                        val accessToken = credentials.accessToken
//                        showUserProfile(accessToken)
//                    }
//                })
//
//        }
//        binding.logOut.setOnClickListener {
//            logout()
//        }
    }

//    private fun showUserProfile(accessToken: String) {
//
//        var client = AuthenticationAPIClient(account)
//
//        // With the access token, call `userInfo` and get the profile from Auth0.
//        client.userInfo(accessToken)
//            .start(object : Callback<UserProfile, AuthenticationException> {
//                override fun onFailure(exception: AuthenticationException) {
//                    // Something went wrong!
//                }
//
//                override fun onSuccess(profile: UserProfile) {
//                    // We have the user's profile!
//                    val email = profile.email
//                    val name = profile.name
//
//                    binding.emailTv.text = email
//                    binding.nameTv.text = name
//                }
//            })
//    }
//    private fun logout() {
//        WebAuthProvider.logout(account)
//            .withScheme("demo")
//            .start(
//                this,
//                object : Callback<Void?, AuthenticationException> {
//                    override fun onSuccess(result: Void?) {
//                        // The user has been logged out!
//                        Toast.makeText(
//                            this@MainActivity,
//                            "Successfully logged out!",
//                            Toast.LENGTH_SHORT
//                        ).show()
////                        binding.nameTv.text = "Logged Out"
////                        binding.emailTv.text = "Logged Out"
//                    }
//
//                    override fun onFailure(error: AuthenticationException) {
//                        Toast.makeText(
//                            this@MainActivity,
//                            "Couldn't Logout!",
//                            Toast.LENGTH_SHORT
//                        ).show()
//                    }
//                }
//            )
//    }

}