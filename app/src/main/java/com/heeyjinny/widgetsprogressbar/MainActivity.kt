package com.heeyjinny.widgetsprogressbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlin.concurrent.thread
import com.heeyjinny.widgetsprogressbar.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    val binding:ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        //앱 실행 후 3초 후 레이아웃 false로 하여 끄기
        //메인 스레드에서 동작을 멈추는 것이기 때문에 모든 것이 멈춤, 서브스레드에서 동작 시켜야함 --thread(start=true)
        thread(start=true){ //서브스레드
            //Thread.sleep() 지정된 시간 동안 다음 코드가 실행되지 않음
            Thread.sleep(3000) //3초

            //메인 스레드에서 동작할수 있도록
            runOnUiThread{
                showProgress(false)

            }
        }


    }//onCreate


    //조건에 따라 레이아웃 숨겼다 보였다 설정하기
    fun showProgress(show: Boolean){
//        if(show){
//            binding.progressLayout.visibility = View.VISIBLE
//        } else{
//            binding.progressLayout.visibility = View.GONE
//        }

        binding.progressLayout.visibility = if (show) View.VISIBLE else View.GONE
    }

}//class