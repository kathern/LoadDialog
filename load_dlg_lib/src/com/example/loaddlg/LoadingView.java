package com.example.loaddlg;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import com.dialog.loading.R;

public class LoadingView extends View {
	private Paint mPaint;
	private Path path;
	private Shape mShape = Shape.SHAPE_ONE;
	private int mTextAppearance;

	private String mLoadText;

	public LoadingView(Context context, AttributeSet attrs) {
		super(context, attrs, 0);
		init(context, attrs);

	}

	private void init(Context context, AttributeSet attrs) {

		TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.LoadingView);
		mLoadText = typedArray.getString(R.styleable.LoadingView_loadingText);
		mTextAppearance = typedArray.getResourceId(R.styleable.LoadingView_loadingTextAppearance, -1);
		typedArray.recycle();
		mPaint = new Paint();
		mPaint.setColor(getResources().getColor(R.color.one));
		mPaint.setAntiAlias(true);
		mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
		mOneColor = getResources().getColor(R.color.one);
		mTwoColor = getResources().getColor(R.color.two);
		mThreeColor = getResources().getColor(R.color.three);
		mFourColor = getResources().getColor(R.color.four);
		path = new Path();
	}

	public LoadingView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		init(context, attrs);
	}

	@TargetApi(Build.VERSION_CODES.LOLLIPOP)
	public LoadingView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
		super(context, attrs, defStyleAttr, defStyleRes);
		init(context, attrs);
	}

	private int mOneColor;
	private int mTwoColor;
	private int mThreeColor;
	private int mFourColor;

	private float relativeXFromView(float percent) {
		return getWidth() * percent;
	}

	private float relativeYFromView(float percent) {
		return getHeight() * percent;
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		Canvas canvas1;
		Canvas canvas2;
		Canvas canvas3;
		System.out.println("aaaaa");
		switch (mShape) {
		case SHAPE_ONE:
			/* 设置paint的颜色 */
			mShape = Shape.SHAPE_TWO;
			mPaint.setColor(mOneColor);
			canvas.drawRect(relativeXFromView(1f) / 2 + relativeXFromView(0.01f),
					relativeYFromView(1f) / 2 - relativeXFromView(0.01f) - relativeXFromView(0.06f),
					relativeXFromView(1f) / 2 + relativeXFromView(0.01f) + relativeXFromView(0.06f),
					relativeYFromView(1f) / 2 - relativeXFromView(0.01f), mPaint);
			System.out.println("getWidth() " + getWidth());
			System.out.println("getHeight() " + getHeight());

			break;
		case SHAPE_TWO:
			mShape = Shape.SHAPE_THREE;
			mPaint.setColor(mOneColor);

			canvas.drawRect(relativeXFromView(1f) / 2 + relativeXFromView(0.01f),
					relativeYFromView(1f) / 2 - relativeXFromView(0.01f) - relativeXFromView(0.06f),
					relativeXFromView(1f) / 2 + relativeXFromView(0.01f) + relativeXFromView(0.06f),
					relativeYFromView(1f) / 2 - relativeXFromView(0.01f), mPaint);
			mPaint.setColor(mTwoColor);
			canvas.drawRect(relativeXFromView(1f) / 2 + relativeXFromView(0.01f),
					relativeYFromView(1f) / 2 + relativeXFromView(0.01f),
					relativeXFromView(1f) / 2 + relativeXFromView(0.01f) + relativeXFromView(0.06f),
					relativeYFromView(1f) / 2 + relativeXFromView(0.01f) + relativeXFromView(0.06f), mPaint);

			break;
		case SHAPE_THREE:
			mShape = Shape.SHAPE_FOUR;
			mPaint.setColor(mOneColor);
			canvas.drawRect(relativeXFromView(1f) / 2 + relativeXFromView(0.01f),
					relativeYFromView(1f) / 2 - relativeXFromView(0.01f) - relativeXFromView(0.06f),
					relativeXFromView(1f) / 2 + relativeXFromView(0.01f) + relativeXFromView(0.06f),
					relativeYFromView(1f) / 2 - relativeXFromView(0.01f), mPaint);
			mPaint.setColor(mTwoColor);
			canvas.drawRect(relativeXFromView(1f) / 2 + relativeXFromView(0.01f),
					relativeYFromView(1f) / 2 + relativeXFromView(0.01f),
					relativeXFromView(1f) / 2 + relativeXFromView(0.01f) + relativeXFromView(0.06f),
					relativeYFromView(1f) / 2 + relativeXFromView(0.01f) + relativeXFromView(0.06f), mPaint);
			mPaint.setColor(mThreeColor);
			canvas.drawRect(relativeXFromView(1f) / 2 - relativeXFromView(0.01f) - relativeXFromView(0.06f),
					relativeYFromView(1f) / 2 + relativeXFromView(0.01f),
					relativeXFromView(1f) / 2 - relativeXFromView(0.01f),
					relativeYFromView(1f) / 2 + relativeXFromView(0.01f) + relativeXFromView(0.06f), mPaint);
			break;
		case SHAPE_FOUR:
			mShape = Shape.SHAPE_FIVE;
			mPaint.setColor(mOneColor);
			canvas.drawRect(relativeXFromView(1f) / 2 + relativeXFromView(0.01f),
					relativeYFromView(1f) / 2 - relativeXFromView(0.01f) - relativeXFromView(0.06f),
					relativeXFromView(1f) / 2 + relativeXFromView(0.01f) + relativeXFromView(0.06f),
					relativeYFromView(1f) / 2 - relativeXFromView(0.01f), mPaint);
			mPaint.setColor(mTwoColor);
			canvas.drawRect(relativeXFromView(1f) / 2 + relativeXFromView(0.01f),
					relativeYFromView(1f) / 2 + relativeXFromView(0.01f),
					relativeXFromView(1f) / 2 + relativeXFromView(0.01f) + relativeXFromView(0.06f),
					relativeYFromView(1f) / 2 + relativeXFromView(0.01f) + relativeXFromView(0.06f), mPaint);
			mPaint.setColor(mThreeColor);
			canvas.drawRect(relativeXFromView(1f) / 2 - relativeXFromView(0.01f) - relativeXFromView(0.06f),
					relativeYFromView(1f) / 2 + relativeXFromView(0.01f),
					relativeXFromView(1f) / 2 - relativeXFromView(0.01f),
					relativeYFromView(1f) / 2 + relativeXFromView(0.01f) + relativeXFromView(0.06f), mPaint);
			mPaint.setColor(mFourColor);
			canvas.drawRect(relativeXFromView(1f) / 2 - relativeXFromView(0.01f) - relativeXFromView(0.06f),
					relativeYFromView(1f) / 2 - relativeXFromView(0.01f) - relativeXFromView(0.06f),
					relativeXFromView(1f) / 2 - relativeXFromView(0.01f),
					relativeYFromView(1f) / 2 - relativeXFromView(0.01f), mPaint);
			break;
		case SHAPE_FIVE:
			mShape = Shape.SHAPE_ONE;
			mPaint.setColor(mFourColor);
			canvas.drawRect(relativeXFromView(1f) / 2 - relativeXFromView(0.01f) - relativeXFromView(0.06f),
					relativeYFromView(1f) / 2 - relativeXFromView(0.01f) - relativeXFromView(0.06f),
					relativeXFromView(1f) / 2 - relativeXFromView(0.01f),
					relativeYFromView(1f) / 2 - relativeXFromView(0.01f), mPaint);
			break;
		}
	}

	public void changeShape() {

		invalidate();
	}

	public enum Shape {
		SHAPE_ONE, SHAPE_TWO, SHAPE_THREE, SHAPE_FOUR, SHAPE_FIVE
	}

	public Shape getShape() {
		return mShape;
	}

}
