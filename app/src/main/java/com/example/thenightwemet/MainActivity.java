package com.example.thenightwemet;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.speech.tts.TextToSpeech;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private TextToSpeech myTTS;
    private SpeechRecognizer msppechrecog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                intent.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS,1);
                msppechrecog.startListening(intent);
            }
        });

        textotspeech();
        voicerecog();
    }

    private void voicerecog() {
        if(SpeechRecognizer.isRecognitionAvailable(this))
        {
            msppechrecog = SpeechRecognizer.createSpeechRecognizer(this);
            msppechrecog.setRecognitionListener(new RecognitionListener() {
                @Override
                public void onReadyForSpeech(Bundle params) {

                }

                @Override
                public void onBeginningOfSpeech() {

                }

                @Override
                public void onRmsChanged(float rmsdB) {

                }

                @Override
                public void onBufferReceived(byte[] buffer) {

                }

                @Override
                public void onEndOfSpeech() {

                }

                @Override
                public void onError(int error) {

                }

                @Override
                public void onResults(Bundle results) {

                    List<String> res = results.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);
                    processResults(res.get(0));

                }

                @Override
                public void onPartialResults(Bundle partialResults) {

                }

                @Override
                public void onEvent(int eventType, Bundle params) {

                }
            });
        }
    }

    private void processResults(String hannah) {
        hannah = hannah.toLowerCase();

        if(hannah.indexOf("what") != -1)
        {
            if(hannah.indexOf("your name")!= -1)
            {
                speak("Hey its me Hannah\n"+" Hannah Baker");
            }

        }

        else if(hannah.indexOf("sing") != -1)
        {
            if(hannah.indexOf("me a song")!= -1)
            {
                speak("I am not the only traveler\n" +
                        "Who has not repaid his debt\n" +
                        "I've been searching for a trail to follow again\n" +
                        "Take me back to the night we met\n" +
                        "And then I can tell myself\n" +
                        "What the hell I'm supposed to do\n" +
                        "And then I can tell myself\n" +
                        "Not to ride along with you\n" +
                        "I had all and then most of you\n" +
                        "Some and now none of you\n" +
                        "Take me back to the night we met\n" +
                        "I don't know what I'm supposed to do\n" +
                        "Haunted by the ghost of you\n" +
                        "Oh, take me back to the night we met\n" +
                        "When the night was full of terrors\n" +
                        "And your eyes were filled with tears\n" +
                        "When you had not touched me yet\n" +
                        "Oh, take me back to the night we met\n" +
                        "I had all and then most of you\n" +
                        "Some and now none of you\n" +
                        "Take me back to the night we met\n" +
                        "I don't know what I'm supposed to do\n" +
                        "Haunted by the ghost of you\n" +
                        "Take me back to the night we met");
            }

        }

        else if(hannah.indexOf("open") != -1) {
            if (hannah.indexOf("browser") != -1) {

                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://github.com/ankitjadli"));
                startActivity(intent);
            }
        }
        else if(hannah.indexOf("call") != -1) {
            if (hannah.indexOf("atul") != -1) {
                Uri number = Uri.parse("tel:8368427263");
                Intent callIntent = new Intent(Intent.ACTION_DIAL, number);
                startActivity(callIntent);
            }
        }


    }

    private void textotspeech() {
        myTTS = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {

                if(myTTS.getEngines().size() == 0)
                {

                    Toast.makeText(MainActivity.this,"no Engine ",Toast.LENGTH_LONG).show();
                    finish();
                }
                else
                {
                    myTTS.setLanguage(Locale.ENGLISH);
                  /*  speak("I'm not a perfect person\n" +
                            "There's many thing I wish I didn't do\n" +
                            "But I continue learning\n" +
                            "I never meant to do those things to you\n" +
                            "And so I have to say before I go\n" +
                            "That I just want you to know\n" +
                            "I've found a reason for me\n" +
                            "To change who I used to be\n" +
                            "A reason to start over new\n" +
                            "And the reason is you\n" +
                            "I'm sorry that I hurt you\n" +
                            "It's something I must live with everyday\n" +
                            "And all the pain I put you through\n" +
                            "I wish I could take it all away\n" +
                            "And be the one who catches all your tears\n" +
                            "That's why I need you to hear\n" +
                            "I've found a reason for me\n" +
                            "To change who I used to be\n" +
                            "A reason to start over new\n" +
                            "And the reason is you\n" +
                            "And the reason is you\n" +
                            "And the reason is you\n" +
                            "And the reason is you\n" +
                            "I'm not a perfect person\n" +
                            "I never meant to do those things to you\n" +
                            "And so I have to say before I go\n" +
                            "That I just want you to know\n" +
                            "I've found a reason for me\n" +
                            "To change who I used to be\n" +
                            "A reason to start over new\n" +
                            "And the reason is you\n" +
                            "I've found a reason to show\n" +
                            "A side of me you didn't know\n" +
                            "A reason for all that I do\n" +
                            "And the reason is you"); */
                }

            }
        });
    }

    private void speak(String hello_madafaka) {

        if (Build.VERSION.SDK_INT >= 21)
        {
            myTTS.speak(hello_madafaka,TextToSpeech.QUEUE_FLUSH,null,null);

        }
        else
        {
            myTTS.speak(hello_madafaka,TextToSpeech.QUEUE_ADD,null);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
