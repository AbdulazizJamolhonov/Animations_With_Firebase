package developer.abdulaziz.mytestapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import com.google.firebase.database.*
import developer.abdulaziz.mytestapplication.databinding.ActivityMainBinding
import tyrantgit.explosionfield.ExplosionField

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mExplosionField: ExplosionField
    private lateinit var firebaseDatabase: FirebaseDatabase
    private lateinit var databaseReference: DatabaseReference
    private lateinit var list: ArrayList<ImageView>
    private lateinit var list2: ArrayList<ImageView>
    private lateinit var list3: ArrayList<ImageView>
    private lateinit var handler: Handler
    private var count = 0
    private var value = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        binding.apply {
            firebaseDatabase = FirebaseDatabase.getInstance()
            databaseReference = firebaseDatabase.getReference("animation")
            mExplosionField = ExplosionField.attach2Window(this@MainActivity)
            list3 = arrayListOf(image1, image2, image3, image4, image5, image6, image7, image8)
            list2 =
                arrayListOf(
                    image111,
                    image222,
                    image333,
                    image444,
                    image555,
                    image666,
                    image777,
                    image888
                )
            list =
                arrayListOf(image11, image22, image33, image44, image55, image66, image77, image88)
            handler = Handler(mainLooper)

            databaseReference.setValue("else")
            start.setOnClickListener { databaseReference.setValue("start") }

            databaseReference.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    if (snapshot.value.toString() == "start") {
                        value = false
                        val anim = AnimationUtils.loadAnimation(this@MainActivity, R.anim.anim9)
                        binding.start.startAnimation(anim)
                        handler.postDelayed(r1, 100)
                    } else {
                        myAnim1()
                        myAnim2()
                        myAnim3()
                        myAnim4()
                        myAnim5()
                        myAnim6()
                        myAnim7()
                        myAnim8()
                    }
                }

                override fun onCancelled(error: DatabaseError) {}
            })
        }
    }

    private fun myAnim1() {
        if (value) {
            val anim = AnimationUtils.loadAnimation(this, R.anim.anim1)
            binding.image1.startAnimation(anim)
            anim.setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationStart(p0: Animation?) {}
                override fun onAnimationEnd(p0: Animation?) = myAnim1()
                override fun onAnimationRepeat(p0: Animation?) {}
            })
        }
    }

    private fun myAnim2() {
        if (value) {
            val anim = AnimationUtils.loadAnimation(this, R.anim.anim2)
            binding.image2.startAnimation(anim)
            anim.setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationStart(p0: Animation?) {}
                override fun onAnimationEnd(p0: Animation?) = myAnim2()
                override fun onAnimationRepeat(p0: Animation?) {}
            })
        }
    }

    private fun myAnim3() {
        if (value) {
            val anim = AnimationUtils.loadAnimation(this, R.anim.anim3)
            binding.image3.startAnimation(anim)
            anim.setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationStart(p0: Animation?) {}
                override fun onAnimationEnd(p0: Animation?) = myAnim3()
                override fun onAnimationRepeat(p0: Animation?) {}
            })
        }
    }

    private fun myAnim4() {
        if (value) {
            val anim = AnimationUtils.loadAnimation(this, R.anim.anim4)
            binding.image4.startAnimation(anim)
            anim.setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationStart(p0: Animation?) {}
                override fun onAnimationEnd(p0: Animation?) = myAnim4()
                override fun onAnimationRepeat(p0: Animation?) {}
            })
        }
    }

    private fun myAnim5() {
        if (value) {
            val anim = AnimationUtils.loadAnimation(this, R.anim.anim5)
            binding.image5.startAnimation(anim)
            anim.setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationStart(p0: Animation?) {}
                override fun onAnimationEnd(p0: Animation?) = myAnim5()
                override fun onAnimationRepeat(p0: Animation?) {}
            })
        }
    }

    private fun myAnim6() {
        if (value) {
            val anim = AnimationUtils.loadAnimation(this, R.anim.anim6)
            binding.image6.startAnimation(anim)
            anim.setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationStart(p0: Animation?) {}
                override fun onAnimationEnd(p0: Animation?) = myAnim6()
                override fun onAnimationRepeat(p0: Animation?) {}
            })
        }
    }

    private fun myAnim7() {
        if (value) {
            val anim = AnimationUtils.loadAnimation(this, R.anim.anim7)
            binding.image7.startAnimation(anim)
            anim.setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationStart(p0: Animation?) {}
                override fun onAnimationEnd(p0: Animation?) = myAnim7()
                override fun onAnimationRepeat(p0: Animation?) {}
            })
        }
    }

    private fun myAnim8() {
        if (value) {
            val anim = AnimationUtils.loadAnimation(this, R.anim.anim8)
            binding.image8.startAnimation(anim)
            anim.setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationStart(p0: Animation?) {}
                override fun onAnimationEnd(p0: Animation?) = myAnim8()
                override fun onAnimationRepeat(p0: Animation?) {}
            })
        }
    }

    private val r1 = object : Runnable {
        override fun run() {
            binding.start.visibility = View.GONE
            if (count == 8) {
                count = 0
                handler.postDelayed(r2, 1)
                return
            } else {
                list[count].visibility = View.VISIBLE
                ++count
                handler.postDelayed(this, 250)
            }
        }
    }

    private val r2 = object : Runnable {
        override fun run() {
            if (count == 8) {
                count = 0
                for (i in list.indices) {
                    list[i].scaleX = 1f
                    list[i].scaleY = 1f
                    list[i].alpha = 1f
                    list[i].visibility = View.INVISIBLE
                }
                mExplosionField.clear()
                handler.postDelayed(r3, 1)
                return
            } else {
                mExplosionField.explode(list[count])
                ++count
                handler.postDelayed(this, 500)
            }
        }
    }
    private val r3 = object : Runnable {
        override fun run() {
            if (count == 8) {
                count = 0
                handler.postDelayed(r4, 1)
                return
            } else {
                list2[count].visibility = View.VISIBLE
                ++count
                handler.postDelayed(this, 100)
            }
        }
    }

    private val r4 = object : Runnable {
        override fun run() {
            if (count == 8) {
                count = 0
                for (i in list2.indices) {
                    list2[i].scaleX = 1f
                    list2[i].scaleY = 1f
                    list2[i].alpha = 1f
                    list2[i].visibility = View.INVISIBLE
                }
                mExplosionField.clear()
                value = true
                binding.start.visibility = View.VISIBLE
                databaseReference.setValue("else")
                return
            } else {
                mExplosionField.explode(list2[count])
                ++count
                handler.postDelayed(this, 10)
            }
        }
    }
}