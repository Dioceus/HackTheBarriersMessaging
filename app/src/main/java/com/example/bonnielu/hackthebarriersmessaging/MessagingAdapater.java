package com.example.bonnielu.hackthebarriersmessaging;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.sendbird.android.BaseChannel;
import com.sendbird.android.BaseMessage;
import com.sendbird.android.OpenChannel;
import com.sendbird.android.SendBird;
import com.sendbird.android.SendBirdException;
import com.sendbird.android.UserMessage;

import java.util.ArrayList;
import java.util.List;

public class MessagingAdapater {

    private class SentMessageHolder extends RecyclerView.ViewHolder {

        TextView messageText, timeText;

        SentMessageHolder(View itemView) {
            super(itemView);

            messageText = (TextView) itemView.findViewById(R.id.text_message_body);
            timeText = (TextView) itemView.findViewById(R.id.text_message_time);

        }

        void bind(UserMessage message) {
            messageText.setText(message.getMessage());

            // Format the stored timestamp into a readable String using method.
            timeText.setText(Utils.formatTime(message.getCreatedAt()));


        }
    }


    public class MessagingAdapater1 {

        private class SentMessageHolder extends RecyclerView.ViewHolder {

            TextView messageText, timeText;

            SentMessageHolder(View itemView) {
                super(itemView);

                messageText = (TextView) itemView.findViewById(R.id.text_message_body);
                timeText = (TextView) itemView.findViewById(R.id.text_message_time);

            }

            void bind(UserMessage message) {
                messageText.setText(message.getMessage());

                // Format the stored timestamp into a readable String using method.
                timeText.setText(Utils.formatTime(message.getCreatedAt()));


            }
        }

        // Messages sent by others display a profile image and nickname.
        private class ReceivedMessageHolder extends RecyclerView.ViewHolder {
            TextView messageText, timeText, nameText;
            ImageView profileImage;

            ReceivedMessageHolder(View itemView) {
                super(itemView);

                messageText = (TextView) itemView.findViewById(R.id.text_message_body);
                timeText = (TextView) itemView.findViewById(R.id.text_message_time);
                nameText = (TextView) itemView.findViewById(R.id.text_message_name);
                profileImage = (ImageView) itemView.findViewById(R.id.image_message_profile);
            }

            void bind(UserMessage message) {
                messageText.setText(message.getMessage());
                nameText.setText(message.getSender().getNickname());
                Utils.displayRoundImageFromUrl(MessagingAdapater.this,
                        message.getSender().getProfileUrl(), profileImage);
                timeText.setText(Utils.formatTime(message.getCreatedAt()));

            }
        }
    }


    // Retrieves 30 most recent messages.
    BaseChannel mChannel;
    ArrayList<BaseMessage> mMessageList;

    void refresh() {
        mChannel.getPreviousMessagesByTimestamp(Long.MAX_VALUE, true, 30, true,
                BaseChannel.MessageTypeFilter.USER, null, new BaseChannel.GetMessagesHandler() {
                    @Override
                    public void onResult(List<BaseMessage> list, SendBirdException e) {
                        if (e != null) {
                            e.printStackTrace();
                            return;
                        }
                        mMessageList = (ArrayList<BaseMessage>) list;

                        notifyDataSetChanged();

                    }
                });

    }

    void loadPreviousMessages() {
        final long lastTimestamp = mMessageList.get(mMessageList.size() - 1).getCreatedAt();
        mChannel.getPreviousMessagesByTimestamp(lastTimestamp, false, 30, true,
                BaseChannel.MessageTypeFilter.USER, null, new BaseChannel.GetMessagesHandler() {
                    @Override
                    public void onResult(List<BaseMessage> list, SendBirdException e) {
                        if (e != null) {
                            e.printStackTrace();
                            return;
                        }
                        mMessageList.addAll(list);

                        notifyDataSetChanged();
                    }
                });
    }

    // Appends a new message to the beginning of the message list.
    void appendMessage(UserMessage message) {
        mMessageList.add(0, message);
        notifyDataSetChanged();
    }

    // Sends a new message, and appends the sent message to the beginning of the message list.
    void sendMessage(final String message) {
        mChannel.sendUserMessage(message, new BaseChannel.SendUserMessageHandler() {
            @Override
            public void onSent(UserMessage userMessage, SendBirdException e) {
                if (e != null) {
                    e.printStackTrace();
                    return;
                }

                mMessageList.add(0, userMessage);
                notifyDataSetChanged();
            }
        });
    }
}
