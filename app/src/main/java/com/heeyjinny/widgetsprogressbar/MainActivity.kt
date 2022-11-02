package com.heeyjinny.widgetsprogressbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlin.concurrent.thread
import com.heeyjinny.widgetsprogressbar.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    //뷰바인딩
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //뷰바인딩
        setContentView(binding.root)

        //thread(start=true){} : 함수 블록안의 코드가 모두 백그라운드에서 동작함
        thread(start=true) {

            //Thread.sleep()메서드 : 지정된 시간동안 다음 코드가 실행되지 않음
            Thread.sleep(3000) //3000밀리초 = 3초

            //UI와 관련된 모든 코드는 메인 스레드에서 실행 되어야 함
            //showProgress 메서드는 메인 스레드에서 실행 되어야 하기 때문에
            //runOnUiThread{}를 사용해 메인 스레드에서 동작할 수 있게 하기
            runOnUiThread {
                //메인 스레드에서 동작하는 코드
                showProgress(false)
            }
        }

    }//onCreate


    //xml의 리니어 레이아웃을 숨겼다 보였다 할 수 있는 코드를 가지고 있는 메서드 생성
    fun showProgress(show: Boolean) {

        //만약 showProgress가 파라미터로 받은 값이 참 이라면
        if (show){
            //리니어레이아웃(id:progressLayout)보이기
            //VISIBLE : 현재 보이는 상태 (visibility속성 사용)
            binding.progressLayout.visibility = View.VISIBLE
        }else{
            //값이 거짓이라면 안보이게 하기
            //GONE : 현재 안 보이는 상태, 공간도 차지하지 않음 (visibility속성 사용)
            binding.progressLayout.visibility = View.GONE
        }

        //위 코드 축약형
        //binding.progressLayout.visibility = if(show) View.VISIBLE else View.GONE
    }


}//MainActivity
