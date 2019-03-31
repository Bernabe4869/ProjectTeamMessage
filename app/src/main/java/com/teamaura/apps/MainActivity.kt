package com.teamaura.apps

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.FragmentTransaction
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), LoginFragment.OnFragmentInteractionListener, PrincipalFragment.OnFragmentInteractionListener, RegistroFragment.OnFragmentInteractionListener {
    override fun onFragmentInteraction(uri: Uri) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        FirebaseApp.initializeApp(this)
        if(FirebaseAuth.getInstance().currentUser!= null){
            transicion_principal()
        }else{
            transicion_login()
        }
    }
    fun transicion_login(){
        val loginFragment = LoginFragment.newInstance()
        supportFragmentManager
            .beginTransaction()
            .setCustomAnimations(R.anim.entradaizquierda,
                R.anim.salidaderecha, 0, 0)
            .replace(R.id.contenedor_principal, loginFragment)
            .addToBackStack(null)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE)
            .commit()
    }
    fun transicion_registro(){
        val registroFragment = RegistroFragment.newInstance()
        supportFragmentManager
            .beginTransaction()
            .setCustomAnimations(R.anim.entradaizquierda,
                R.anim.salidaderecha, 0, 0)
            .replace(R.id.contenedor_principal, registroFragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE)
            .addToBackStack(null)
            .commit()
    }
    fun transicion_principal(){
        val PrincipalFragment = PrincipalFragment.newInstance()
        supportFragmentManager
            .beginTransaction()
            .setCustomAnimations(R.anim.entradaizquierda,
                R.anim.salidaderecha, 0, 0)
            .replace(R.id.contenedor_principal, PrincipalFragment)
            .addToBackStack(null)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE)
            .commit()
    }

    override fun onBackPressed() {
        finish()
    }
}
