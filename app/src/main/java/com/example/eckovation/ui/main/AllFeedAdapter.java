package com.example.eckovation.ui.main;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.eckovation.R;

import org.w3c.dom.Text;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

class AllFeedAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public List<AllFeed> allFeedList;
    public AllFeedRepository allFeedRepository;

    public static final int QUESTION_TITLE = 0;
    public static final int QUESTION_IMAGE = 1;
    public static final int QUESTION_IMAGE_ANSWER_IMAGE = 2;
    public static final int QUESTION_TITLE_ANSWER_IMAGE = 3;

    public AllFeedAdapter(List<AllFeed> allFeedList) {
        this.allFeedList = allFeedList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = null;
        RecyclerView.ViewHolder viewHolder = null;
        if (viewType == QUESTION_TITLE) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.question_title_item, viewGroup, false);
            viewHolder = new ViewHolderQuestionTitle(view);
        }
        if (viewType == QUESTION_IMAGE) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.question_image_item, viewGroup, false);
            viewHolder = new ViewHolderQuestionImage(view);
        }
        if (viewType == QUESTION_IMAGE_ANSWER_IMAGE) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.question_image_answer_image_item, viewGroup, false);
            viewHolder = new ViewHolderQuestionimageAnswerimage(view);
        }
        if (viewType == QUESTION_TITLE_ANSWER_IMAGE) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.question_title_answer_image_item, viewGroup, false);
            viewHolder = new ViewHolderQuestiontitleAnswerimage(view);
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        final AllFeed allFeed = allFeedList.get(position);
        if (viewHolder.getItemViewType() == QUESTION_TITLE) {
            final ViewHolderQuestionTitle viewHolderQuestionTitle = (ViewHolderQuestionTitle) viewHolder;
            viewHolderQuestionTitle.usernameTv.setText(allFeed.getName());
          //  viewHolderQuestionTitle.questionTv.setText(allFeed.getQuestion().getQuestionTitle());
            viewHolderQuestionTitle.followBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    allFeedRepository=new AllFeedRepository(v.getContext());
                    allFeedRepository.updateFollowing();
                    Toast.makeText(v.getContext(),"Question Followed",Toast.LENGTH_SHORT).show();
                }
            });
        } else if (viewHolder.getItemViewType() == QUESTION_TITLE_ANSWER_IMAGE) {
            ViewHolderQuestiontitleAnswerimage viewHolderQuestiontitleAnswerimage = (ViewHolderQuestiontitleAnswerimage) viewHolder;
            viewHolderQuestiontitleAnswerimage.questionPosterTv.setText(allFeed.getName());
//            viewHolderQuestiontitleAnswerimage.topAnswerPosterTv.setText(allFeed.getTopAnswer().getName());
            viewHolderQuestiontitleAnswerimage.topAnswerIv.setVisibility(View.VISIBLE);
            viewHolderQuestiontitleAnswerimage.upVoteBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(),"Upvote Success !",Toast.LENGTH_SHORT).show();
                }
            });
        }else if(viewHolder.getItemViewType() == QUESTION_IMAGE){
            ViewHolderQuestionImage viewHolderQuestionImage = (ViewHolderQuestionImage) viewHolder;
            viewHolderQuestionImage.usernameTv.setText(allFeed.getName());
            viewHolderQuestionImage.questionImageView.setVisibility(View.VISIBLE);
        }else if(viewHolder.getItemViewType() == QUESTION_IMAGE_ANSWER_IMAGE){
            ViewHolderQuestionimageAnswerimage viewHolderQuestionimageAnswerimage = (ViewHolderQuestionimageAnswerimage) viewHolder;
//            viewHolderQuestionimageAnswerimage.topAnswerPosterTv.setText(allFeed.getTopAnswer().getName());
            viewHolderQuestionimageAnswerimage.questionTv.setText(allFeed.getName());
            viewHolderQuestionimageAnswerimage.questionIv.setVisibility(View.VISIBLE);
            viewHolderQuestionimageAnswerimage.topAnswerIv.setVisibility(View.VISIBLE);
            viewHolderQuestionimageAnswerimage.upVoteBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(),"Upvote Success !",Toast.LENGTH_SHORT).show();
                }
            });
        }else{
            ViewHolderQuestionTitle viewHolderQuestionTitle = (ViewHolderQuestionTitle) viewHolder;
            viewHolderQuestionTitle.usernameTv.setText(allFeed.getName());
            viewHolderQuestionTitle.questionTv.setText(allFeed.getQuestion().getQuestionTitle());
        }

    }

    @Override
    public int getItemCount() {
        return allFeedList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return QUESTION_TITLE;
        } else if (position == 1) {
            return QUESTION_IMAGE;
        } else if (position == 2) {
            return QUESTION_IMAGE_ANSWER_IMAGE;
        } else if (position == 3) {
            return QUESTION_TITLE_ANSWER_IMAGE;
        }
        return QUESTION_TITLE;
    }

    private class ViewHolderQuestionTitle extends RecyclerView.ViewHolder {
        public CircleImageView circleImageView;
        public TextView usernameTv, questionTv;
        public Button followBtn, answersBtn;

        public ViewHolderQuestionTitle(View view) {
            super(view);
            circleImageView = view.findViewById(R.id.circleImageView2);
            usernameTv = view.findViewById(R.id.textView3);
            questionTv = view.findViewById(R.id.textView6);
            followBtn = view.findViewById(R.id.button3);
            answersBtn = view.findViewById(R.id.button4);
        }
    }

    private class ViewHolderQuestionImage extends RecyclerView.ViewHolder {
        public CircleImageView circleImageView;
        public TextView usernameTv;
        public ImageView questionImageView;
        public Button followButton, answerButton;

        public ViewHolderQuestionImage(View view) {
            super(view);
            circleImageView = view.findViewById(R.id.circleImageView);
            usernameTv = view.findViewById(R.id.usernameTv);
            questionImageView = view.findViewById(R.id.questionimageView);
            followButton = view.findViewById(R.id.followbutton);
            answerButton = view.findViewById(R.id.answerbutton);
        }
    }

    private class ViewHolderQuestionimageAnswerimage extends RecyclerView.ViewHolder {
        public CircleImageView questioncircleImageView, topanswercircleimageview;
        public TextView questionTv, topAnswerTv, topAnswerPosterTv;
        public ImageView questionIv, topAnswerIv;
        public Button followBtn, AnswerBtn, upVoteBtn;

        public ViewHolderQuestionimageAnswerimage(View view) {
            super(view);
            questioncircleImageView = view.findViewById(R.id.circleImageView3);
            topanswercircleimageview = view.findViewById(R.id.circleImageView4);
            questionTv = view.findViewById(R.id.textView);
            topAnswerTv = view.findViewById(R.id.textView7);
            topAnswerPosterTv = view.findViewById(R.id.textView8);
            questionIv = view.findViewById(R.id.imageView);
            topAnswerIv = view.findViewById(R.id.imageView3);
            followBtn = view.findViewById(R.id.button6);
            AnswerBtn = view.findViewById(R.id.button7);
            upVoteBtn = view.findViewById(R.id.button8);

        }
    }

    private class ViewHolderQuestiontitleAnswerimage extends RecyclerView.ViewHolder {
        public CircleImageView questioncircleImageView, topanswercircleimageview;
        public TextView questionTv, topAnswerPosterTv,questionPosterTv;
        public ImageView topAnswerIv;
        public Button followBtn, AnswerBtn, upVoteBtn;
        public ViewHolderQuestiontitleAnswerimage(View view) {
            super(view);
            questioncircleImageView = view.findViewById(R.id.circleImageView33);
            topanswercircleimageview = view.findViewById(R.id.circleImageView7);
            questionTv = view.findViewById(R.id.textView22);
            topAnswerPosterTv = view.findViewById(R.id.textView5);
            questionPosterTv = view.findViewById(R.id.textView11);
            topAnswerIv = view.findViewById(R.id.imageView2);
            followBtn = view.findViewById(R.id.button);
            AnswerBtn = view.findViewById(R.id.button2);
            upVoteBtn = view.findViewById(R.id.button5);
        }
    }
}
