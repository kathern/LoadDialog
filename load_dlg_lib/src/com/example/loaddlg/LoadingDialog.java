package com.example.loaddlg;

import com.dialog.loading.R;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.Animator.AnimatorListener;
import com.nineoldandroids.animation.AnimatorSet;
import com.nineoldandroids.animation.ObjectAnimator;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

public class LoadingDialog {
	private static final int ANIMATION_DURATION = 300;
	private Context context;
	private Dialog mDialog;
	private View contentView;
	private LoadingView mLoadingView;
	private TextView promptTv;
	private AnimatorSet mAnimatorSet = null;
	private static float mDistance = 1;

	public LoadingDialog(Context context) {
		super();
		this.context = context;
		init();
	}

	private void init() {
		mDialog = new Dialog(context, R.style.custom_dialog);
		contentView = LayoutInflater.from(context).inflate(R.layout.loading_dialog, null);
		mLoadingView = (LoadingView) contentView.findViewById(R.id.loadingView);
		promptTv = (TextView) contentView.findViewById(R.id.promptTV);
		mLoadingView.setMinimumHeight(40);
		mDialog.setContentView(contentView);
		startLoading();
	}

	private void startLoading() {
		if (mAnimatorSet != null && mAnimatorSet.isRunning()) {
			return;
		}
		contentView.removeCallbacks(rotateRunnable);
		contentView.post(rotateRunnable);
	}

	private Runnable rotateRunnable = new Runnable() {

		@Override
		public void run() {
			System.out.println("run");
			startRotate();
		}
	};

	public void startRotate() {
		ObjectAnimator objectAnimator = new ObjectAnimator();
		objectAnimator.setDuration(ANIMATION_DURATION);
		ObjectAnimator objectAnimator1 = null;
		switch (mLoadingView.getShape()) {
		case SHAPE_ONE:
			objectAnimator1 = ObjectAnimator.ofFloat(mLoadingView, "translationY", 0, mDistance);
			break;
		case SHAPE_TWO:
			objectAnimator1 = ObjectAnimator.ofFloat(mLoadingView, "translationX", mDistance, 0);
			break;
		case SHAPE_THREE:
			objectAnimator1 = ObjectAnimator.ofFloat(mLoadingView, "translationY", mDistance, 0);
			break;
		case SHAPE_FOUR:
			objectAnimator1 = ObjectAnimator.ofFloat(mLoadingView, "translationX", 0, mDistance);
			break;
		case SHAPE_FIVE:
			objectAnimator1 = ObjectAnimator.ofFloat(mLoadingView, "translationX", 0, mDistance);
			break;
		}
		objectAnimator1.setDuration(ANIMATION_DURATION);
		AnimatorSet animatorSet = new AnimatorSet();
		animatorSet.setDuration(ANIMATION_DURATION);
		animatorSet.play(objectAnimator1);
		animatorSet.addListener(new AnimatorListener() {

			@Override
			public void onAnimationStart(Animator animation) {
			}

			@Override
			public void onAnimationRepeat(Animator animation) {
			}

			@Override
			public void onAnimationEnd(Animator animation) {
				mLoadingView.changeShape();
				startRotate();
			}

			@Override
			public void onAnimationCancel(Animator animation) {
			}
		});
		animatorSet.start();
	}

	public void show(String str) {
		if (null != str && str.length() > 0 && !str.trim().equals("") && null != promptTv) {
			promptTv.setText(str);
		}
		mDialog.show();
	}

	public void dismiss() {
		mDialog.dismiss();
	}

	public Dialog getDialog() {
		return mDialog;
	}

	public void setCanceledOnTouchOutside(boolean cancel) {
		mDialog.setCanceledOnTouchOutside(cancel);
	}

}
