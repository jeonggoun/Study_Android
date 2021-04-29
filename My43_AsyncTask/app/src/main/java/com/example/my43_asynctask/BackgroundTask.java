package com.example.my43_asynctask;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.ProgressBar;

public class BackgroundTask extends AsyncTask<Void, Integer, String> {
    private static final String TAG = "main : BackgroundTask";

    BackgroundTask backgroundTask;
    ProgressBar progressBar;
    int value;

    public BackgroundTask(ProgressBar progressBar, int value) {
        this.progressBar = progressBar;
        this.value = value;
    }//BackgroundTask
    
    // 실제 작업을 하기 전에 작업하는 곳
    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        value = 0;
        progressBar.setProgress(0);
    }//onPreExecute

    // 실제 작업하는 곳
    @Override                       // 첫번째 Void
    protected String doInBackground(Void... voids) {
        while (isCancelled() == false){
            value++;
            if(value >= 100){
                break;
            }else{
                // 데이터를 onProgressUpdate에 넘겨줄 수 있다
                publishProgress(value); //계속 업데이트 하며
                //onProgressUpdate(value, value+1, value+2);
            }//if~else
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }//while
        return "100% 완료";
    }//doInBackground()

    // 작업 중에 필요한 데이터 받는 곳
    @Override                       // 두번째 Integer
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);

        progressBar.setProgress(values[0]);

    }

    //작업이 종료한 후 실행하는 곳
    @Override            // 세번째 String : doInBackground 리턴 타입과 맞춰야 함
    protected void onPostExecute(String result) {
        super.onPostExecute(result);

        Log.d(TAG, "onPostExecute: " + result);
    }//onPostExecute()

    // 실행 취소

    @Override
    protected void onCancelled() {
        super.onCancelled();
        Log.d(TAG, "onCancelled: 실행 취소됨");
    }
}//class