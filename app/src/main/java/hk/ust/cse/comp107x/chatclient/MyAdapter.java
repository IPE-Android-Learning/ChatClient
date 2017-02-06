package hk.ust.cse.comp107x.chatclient;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by muppala on 8/6/16.
 */
class MyAdapter extends ArrayAdapter<Message> {
    private final Context context;
    private final ArrayList<Message> messages;

    MyAdapter(Context context, ArrayList<Message> messages) {
        super(context, R.layout.message, messages);
        this.context = context;
        this.messages = messages;
    }

    // This method constructs the ListItem's view from the data obtained
    // from the Message object. This will be called by ListView while it
    // is being drawn.
    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {

        // TODO

        View viewMessage;

        //We get a references to the layout inflater, this helps to construct the object's view
        //from the layout file
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        TextView txtViewMessage;
        TextView txtViewTimeMessage;

        // Change the layout based on who the message is from
        if (messages.get(position).fromMe()) {

            //We create the message view from me
            viewMessage = inflater.inflate(R.layout.mymessage, parent, false);
            //We get a references to the TextView which contain the message
            txtViewMessage = (TextView) viewMessage.findViewById(R.id.txtViewMyMessage);
            //We get a reference to the TextView that will contain the time the user sent the message
            txtViewTimeMessage = (TextView) viewMessage.findViewById(R.id.txtViewMyTimeMessage);

        } else {

            //We create the message view from another person
            viewMessage = inflater.inflate(R.layout.message, parent, false);
            //We get a references to the TextView which contain the message
            txtViewMessage = (TextView) viewMessage.findViewById(R.id.txtViewMessage);
            //We get a reference to the TextView that will contain the time the user sent the message
            txtViewTimeMessage = (TextView) viewMessage.findViewById(R.id.txtViewTimeMessage);

        }


        //We set to the TextView the message which the user send
        txtViewMessage.setText(messages.get(position).getMessage());

        //We set to the TextView the time of the message was sent
        txtViewTimeMessage.setText(messages.get(position).getTime());

        return viewMessage;

    }
}