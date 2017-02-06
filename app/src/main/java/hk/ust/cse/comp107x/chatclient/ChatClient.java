package hk.ust.cse.comp107x.chatclient;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Date;

public class ChatClient extends AppCompatActivity {

    Button btnSend;
    EditText editTxtMessage;
    ListView lstViewMessages;
    MyAdapter myAdapter = null;
    ArrayList<Message> arrayLstMessages = null;

    private int in_index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_client);


        //Get the references to the Send Button on the UI
        btnSend = (Button) findViewById(R.id.btnSend);
        //We create the onclick event of the Send Button
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickSendButton(v);
            }
        });

        //We get the references to the EditText which contains the message to send
        editTxtMessage = (EditText) findViewById(R.id.editTxtMEssage);

        // TODO

        //We get a references to the ListView which contain the messages sent
        lstViewMessages = (ListView) findViewById(R.id.lstViewMessges);

        //We initialize the object that contains the messages sent
        arrayLstMessages = new ArrayList<>();

        //We create our custom adapter
        myAdapter = new MyAdapter(this, arrayLstMessages);

        //Set the custom adapter that we construct to the TextView that contain the messages sent
        lstViewMessages.setAdapter(myAdapter);
    }


    private void onClickSendButton(View v){
        String strMessage = editTxtMessage.getText().toString();
        // If the message is not empty string
        if (!strMessage.equals("")) {

            // TODO
            //We create a object that will contain the message that was sent
            Message message = new Message("Ivan", strMessage, true, new Date());
            //We add the new message to the list that contain the messages
            arrayLstMessages.add(message);
            //We notify to the adapter that a new message was sent
            myAdapter.notifyDataSetChanged();

            //We clean the input text
            editTxtMessage.setText("");

            //We send a joke message
            sendMessage();
        }
    }

    private void sendMessage() {

        String[] incoming = {"Hey, How's it going?",
                "Super! Let's do lunch tomorrow",
                "How about Mexican?",
                "Great, I found this new place around the corner",
                "Ok, see you at 12 then!"};

        if (in_index < incoming.length) {
            Message message = new Message("John", incoming[in_index], false,  new Date());
            arrayLstMessages.add(message);
            in_index++;
            myAdapter.notifyDataSetChanged();
        }

    }

}

