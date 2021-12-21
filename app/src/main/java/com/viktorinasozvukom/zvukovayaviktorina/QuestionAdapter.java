package com.viktorinasozvukom.zvukovayaviktorina;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class QuestionAdapter extends RecyclerView.Adapter<QuestionAdapter.ViewHolder> {

    private LayoutInflater inflater;
    private List<Question_Model> questions;
    Context context;
    private MediaPlayer sound;

    public QuestionAdapter(Context context, List<Question_Model> questions) {
        this.inflater = LayoutInflater.from(context);
        this.questions = questions;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_quiz, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Question_Model current = questions.get(position);
        holder.setQuestion("Вопрос №" + (position+1));
        holder.setOptions(current, position);
        holder.play_music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.radioGroupOptions.setVisibility(View.VISIBLE);
                if (sound!=null)
                {
                    if(sound.isPlaying())
                    {
                        sound.stop();
                        sound.reset();
                        sound.release();
                        sound=null;
                    }
                }
                sound = new MediaPlayer();
                int tyt = context.getResources().getIdentifier(questions.get(position).getMusic() , "raw", context.getPackageName());
                sound = MediaPlayer.create(context,tyt);
                sound.start();
            }
        });
        holder.stop_music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopMusick();
            }
        });
    }
    public void stopMusick(){
        if (sound!=null)
        {
            if(sound.isPlaying())
            {
                sound.stop();
                sound.reset();
                sound.release();
                sound=null;
            }
        }
    }

    @Override
    public int getItemCount() {
        if (questions == null) {
            return 0;
        } else {
            return questions.size();
        }
    }


    class ViewHolder extends RecyclerView.ViewHolder {

        private LinearLayout linearLayoutContainer;
        ImageView image_item;
        private TextView txt_item_vop, play_music, stop_music;
        private RadioGroup radioGroupOptions;
        private RadioButton radioButtonOption1, radioButtonOption2;
        private RadioButton radioButtonOption3;

        public ViewHolder(View itemView) {
            super(itemView);
            linearLayoutContainer = itemView.findViewById(R.id.linear_layout_container);
            image_item = itemView.findViewById(R.id.image_item);
            txt_item_vop = itemView.findViewById(R.id.txt_item_vop);
            play_music = itemView.findViewById(R.id.play_music);
            stop_music = itemView.findViewById(R.id.stop_music);
            radioGroupOptions = itemView.findViewById(R.id.radio_group_options);
            radioButtonOption1 = itemView.findViewById(R.id.radio_button_option_1);
            radioButtonOption2 = itemView.findViewById(R.id.radio_button_option_2);
            radioButtonOption3 = itemView.findViewById(R.id.radio_button_option_3);
        }

        public void setQuestion(String question) {
            txt_item_vop.setText(question);
        }

        public void setOptions(Question_Model question, int position) {
            radioGroupOptions.setTag(position);
            int resID = context.getResources().getIdentifier(question.getSrc_image() , "drawable", context.getPackageName());
            image_item.setImageResource(resID);
            radioButtonOption1.setText(question.getOptionA());
            radioButtonOption2.setText(question.getOptionB());
            radioButtonOption3.setText(question.getOptionC());
            if (question.isAnswered) {
                radioGroupOptions.check(question.getCheckedId());
            } else {
                radioGroupOptions.check(-1);
            }
            radioGroupOptions.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    int pos = (int) group.getTag();
                    Question_Model que = questions.get(pos);
                    que.isAnswered = true;
                    que.checkedId = checkedId;
                    if (question.correctOption==1 && radioButtonOption1.getId()==question.getCheckedId() && !QuizGameActivity.wer[position]) {
                        QuizGameActivity.wer[position] = true;
                        que.isAnsweredImage = true;
                    }
                    else if (question.correctOption==2 && radioButtonOption2.getId()==question.getCheckedId() && !QuizGameActivity.wer[position]) {
                        QuizGameActivity.wer[position] = true;
                        que.isAnsweredImage = true;
                    }
                    else if (question.correctOption==3 && radioButtonOption3.getId()==question.getCheckedId() && !QuizGameActivity.wer[position]) {
                        QuizGameActivity.wer[position] = true;
                        que.isAnsweredImage = true;
                    }
                    if(questions.get(pos).isAnswered)
                        btn_backgruond(que, checkedId);
                }
            });
        }
        public void btn_backgruond (  Question_Model que,int checkedId){
            switch (checkedId) {
                case R.id.radio_button_option_1:
                    radioButtonOption1.setClickable(false);
                    radioButtonOption2.setClickable(false);
                    radioButtonOption3.setClickable(false);
                    image_item.setVisibility(View.VISIBLE);
                    radioGroupOptions.setVisibility(View.VISIBLE);
                    play_music.setVisibility(View.GONE);
                    stop_music.setVisibility(View.GONE);
                    stopMusick();
                    if (que.correctOption == 1) {
                        radioButtonOption1.setBackgroundResource(R.drawable.btn_radio_true);
                        radioButtonOption2.setBackgroundResource(R.drawable.btn);
                        radioButtonOption3.setBackgroundResource(R.drawable.btn);

                    } else if (que.correctOption == 2) {
                        radioButtonOption1.setBackgroundResource(R.drawable.btn_radio_false);
                        radioButtonOption2.setBackgroundResource(R.drawable.btn_radio_true);
                        radioButtonOption3.setBackgroundResource(R.drawable.btn);
                    } else {
                        radioButtonOption1.setBackgroundResource(R.drawable.btn_radio_false);
                        radioButtonOption2.setBackgroundResource(R.drawable.btn);
                        radioButtonOption3.setBackgroundResource(R.drawable.btn_radio_true);
                    }
                    break;
                case R.id.radio_button_option_2:
                    radioButtonOption1.setClickable(false);
                    radioButtonOption2.setClickable(false);
                    radioButtonOption3.setClickable(false);
                    image_item.setVisibility(View.VISIBLE);
                    radioGroupOptions.setVisibility(View.VISIBLE);
                    play_music.setVisibility(View.GONE);
                    stop_music.setVisibility(View.GONE);
                    stopMusick();
                    if (que.correctOption == 1) {
                        radioButtonOption1.setBackgroundResource(R.drawable.btn_radio_true);
                        radioButtonOption2.setBackgroundResource(R.drawable.btn_radio_false);
                        radioButtonOption3.setBackgroundResource(R.drawable.btn);
                    } else if (que.correctOption == 2) {
                        radioButtonOption1.setBackgroundResource(R.drawable.btn);
                        radioButtonOption2.setBackgroundResource(R.drawable.btn_radio_true);
                        radioButtonOption3.setBackgroundResource(R.drawable.btn);
                    } else {
                        radioButtonOption1.setBackgroundResource(R.drawable.btn);
                        radioButtonOption2.setBackgroundResource(R.drawable.btn_radio_false);
                        radioButtonOption3.setBackgroundResource(R.drawable.btn_radio_true);
                    }
                    break;

                case R.id.radio_button_option_3:
                    radioButtonOption1.setClickable(false);
                    radioButtonOption2.setClickable(false);
                    radioButtonOption3.setClickable(false);
                    image_item.setVisibility(View.VISIBLE);
                    radioGroupOptions.setVisibility(View.VISIBLE);
                    play_music.setVisibility(View.GONE);
                    stop_music.setVisibility(View.GONE);
                    stopMusick();
                    if (que.correctOption == 1) {
                        radioButtonOption1.setBackgroundResource(R.drawable.btn_radio_true);
                        radioButtonOption2.setBackgroundResource(R.drawable.btn);
                        radioButtonOption3.setBackgroundResource(R.drawable.btn_radio_false);
                    } else if (que.correctOption == 2) {
                        radioButtonOption1.setBackgroundResource(R.drawable.btn);
                        radioButtonOption2.setBackgroundResource(R.drawable.btn_radio_true);
                        radioButtonOption3.setBackgroundResource(R.drawable.btn_radio_false);
                    } else  {
                        radioButtonOption1.setBackgroundResource(R.drawable.btn);
                        radioButtonOption2.setBackgroundResource(R.drawable.btn);
                        radioButtonOption3.setBackgroundResource(R.drawable.btn_radio_true);
                    }
                    break;

                default:
                    radioButtonOption1.setBackgroundResource(R.drawable.btn);
                    radioButtonOption2.setBackgroundResource(R.drawable.btn);
                    radioButtonOption3.setBackgroundResource(R.drawable.btn);
                    radioButtonOption1.setClickable(true);
                    radioButtonOption2.setClickable(true);
                    radioButtonOption3.setClickable(true);
                    image_item.setVisibility(View.GONE);
                    radioGroupOptions.setVisibility(View.GONE);
                    play_music.setVisibility(View.VISIBLE);
                    stop_music.setVisibility(View.VISIBLE);
                    break;
            }
        }
    }
}