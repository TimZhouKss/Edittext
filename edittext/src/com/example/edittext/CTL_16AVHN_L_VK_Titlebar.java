package com.example.edittext;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.text.Editable;
import android.text.Spannable;
import android.text.TextWatcher;
import android.text.method.ArrowKeyMovementMethod;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class CTL_16AVHN_L_VK_Titlebar extends ViewGroup {

	private View m_View;
	private ImageView m_Imagebg;
	private ImageView m_et_bg;
	private ImageView m_image_back;
	private Button m_SingleButtonBack;
	private Button m_SingleButtonOK;
	private EditText m_EditText;

	public static final class CTL_16AVHN_L_VK_ButtonId {
		public static final int BACK = 0;
		public static final int OK = 1;
	}

	public CTL_16AVHN_L_VK_Titlebar(Context context, AttributeSet attrs) {
		super(context, attrs);
		LayoutInflater layout = LayoutInflater.from(context);
		m_View = layout.inflate(R.layout.ctl_16avhn_l_vk_titlebar,
				null);
		addView(m_View);

		m_Imagebg = (ImageView) m_View.findViewWithTag("m_bg");
		m_SingleButtonBack = (Button) m_View
				.findViewWithTag("m_back");
		m_SingleButtonOK = (Button) m_View
				.findViewWithTag("m_ok");
		m_et_bg = (ImageView) m_View.findViewWithTag("m_et_bg");
		m_image_back = (ImageView) m_View
				.findViewWithTag("m_image_back");
		m_EditText = (EditText) m_View.findViewWithTag("m_et");
		m_EditText.setLongClickable(false);
//		m_Imagebg.setImageTheme("p10782_vk");
//		LayoutParams m_backlp = (LayoutParams) m_SingleButtonBack
//				.getLayoutParams();
//		m_backlp.leftMargin = 20 - offSetX;
//		m_backlp.topMargin = 0;
//		m_SingleButtonBack.setLayoutParams(m_backlp);
//		m_image_back.setLayoutParams(m_backlp);
//
//		LayoutParams m_oklp = (LayoutParams) m_SingleButtonOK.getLayoutParams();
//		m_oklp.leftMargin = 686 - offSetX;
//		m_oklp.topMargin = 0;
//		m_SingleButtonOK.setLayoutParams(m_oklp);
//
//		LayoutParams m_etlp = (LayoutParams) m_EditText.getLayoutParams();
//		m_etlp.leftMargin = 174 - offSetX;
//		m_etlp.topMargin = -5;
//		m_EditText.setLayoutParams(m_etlp);
//
//		LayoutParams m_etbglp = (LayoutParams) m_et_bg.getLayoutParams();
//		m_etbglp.leftMargin = 154 - offSetX;
//		m_etbglp.topMargin = 0;
//		m_et_bg.setLayoutParams(m_etbglp);

		initRes();
		TextWatcher textWatcher = new TextWatcher() {

			private int charcount = 0;
			private BackgroundColorSpan my_BackColor1 = new BackgroundColorSpan(Color.argb(255, 51,
					153, 255));
			private BackgroundColorSpan my_BackColor2 = new BackgroundColorSpan(Color.TRANSPARENT);
			private ForegroundColorSpan my_foreColor = new ForegroundColorSpan(Color.argb(255, 8,
					8, 8));
			private ForegroundColorSpan my_foreColor1 = new ForegroundColorSpan(Color.argb(255, 224,
					232, 240));
			private ForegroundColorSpan my_foreColor2 = new ForegroundColorSpan(Color.argb(255, 56,
					136, 248));
			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				charcount = count;
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				charcount = start + count;
			}

			@Override
			public void afterTextChanged(Editable s) {
				Object[] spanned = s.getSpans(0, s.length(), Object.class);
				if (charcount == 0) {
					return;
				}
				if (spanned != null) {
					int textstart = -1;
					int textend = -1;
					for (Object obj : spanned) {
						if (obj instanceof android.text.style.UnderlineSpan) {
							s.removeSpan(obj);
						} else if (obj instanceof BackgroundColorSpan) {
							int color = ((BackgroundColorSpan) obj).getBackgroundColor();
//							Log.d("my", "BackgroundColorSpan color="+color+",red="+Color.red(color)+",green="+Color.green(color)+",blue="+Color.blue(color));
//							Log.d("my", "BackgroundColorSpan getSpanStart="+s.getSpanStart(obj)+",getSpanEnd="+s.getSpanEnd(obj));
							switch (color) {
							case -29696: {//255,140,0
								textstart = s.getSpanStart(obj);
								textend = s.getSpanEnd(obj);
								s.setSpan(my_BackColor1, s.getSpanStart(obj), s.getSpanEnd(obj),
										Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
								s.removeSpan(obj);
								break;
							}
							case -983041: {//240,255,255
								s.setSpan(my_BackColor2, s.getSpanStart(obj), s.getSpanEnd(obj),
										Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
								s.removeSpan(obj);
								break;
							}
							default:
								s.removeSpan(obj);//51, 153, 255 0 | 173,255,47 | 0,255,0
								break;
							}
						} else if (obj instanceof ForegroundColorSpan) {
							int color = ((ForegroundColorSpan) obj).getForegroundColor();
//							Log.d("my", "ForegroundColorSpan color="+color+",red="+Color.red(color)+",green="+Color.green(color)+",blue="+Color.blue(color));
//							Log.d("my", "ForegroundColorSpan getSpanStart="+s.getSpanStart(obj)+",getSpanEnd="+s.getSpanEnd(obj));
							if (textstart >= s.getSpanStart(obj)
									&& textend <= s.getSpanEnd(obj) && textend > 0) {
								switch (color) {
								case -16250872://8, 8, 8
								case -13072136://56, 136, 248
								case -2037520://224, 232, 240
									s.removeSpan(obj);
									break;
								case -16777216: {//0,0,0
										s.setSpan(my_foreColor, textstart, textend,
												Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
										s.setSpan(my_foreColor1, s.getSpanStart(obj), textstart,
												Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
										s.setSpan(my_foreColor2, textend, s.getSpanEnd(obj),
												Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
										s.removeSpan(obj);
									break;
								}
								default:
									break;
								}
							}else{
								s.setSpan(my_foreColor2, s.getSpanStart(obj), s.getSpanEnd(obj),
										Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
								s.removeSpan(obj);
							}
						} else {

						}
					}
				}
			}
		};

		m_EditText.addTextChangedListener(textWatcher);
	}

//	public void setButtonListener(int mode,
//			IButtonActionListenerLongRepeat listener, int[] time) {
//
//		if (null != m_SingleButtonBack) {
//			m_SingleButtonBack.setButtonListener(mode, this, time);
//		}
//		if (null != m_SingleButtonOK) {
//			m_SingleButtonOK.setButtonListener(mode, this, time, true);
//		}
//		m_Listener = listener;
//	}

//	public void removeListener() {
//		if (null != m_SingleButtonBack) {
//			m_SingleButtonBack.removeListener();
//		}
//		if (null != m_SingleButtonOK) {
//			m_SingleButtonOK.removeListener();
//		}
//	}

	public void setText(int id) {
		m_SingleButtonOK.setText(id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jp.pioneer.ceam.ctl.Interface.common.IButtonActionListener#OnLongClick
	 * (android.view.View, int)
	 */
//	@Override
//	public boolean OnLongClick(View view, int time) {
//		if (null == m_Listener) {
//			return false;
//		}
//
//		if (null != view && null != m_SingleButtonBack
//				&& view.equals(m_SingleButtonBack)) {
//			return m_Listener.OnLongClick(CTL_16AVHN_L_VK_ButtonId.BACK, time);
//		} else if (null != view && null != m_SingleButtonOK
//				&& view.equals(m_SingleButtonOK)) {
//			return m_Listener.OnLongClick(CTL_16AVHN_L_VK_ButtonId.OK, time);
//		}
//
//		return false;
//	}

//	public CTL_Control_EditTextBase getEditText() {
//		return null == m_EditText ? null : m_EditText;
//	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jp.pioneer.ceam.ctl.Interface.common.IButtonActionListener#OnRepeat(android
	 * .view.View, int[])
	 */
//	@Override
//	public boolean OnRepeat(View view, int... param) {
//		if (null == m_Listener) {
//			return false;
//		}
//
//		if (null != view && null != m_SingleButtonBack
//				&& view.equals(m_SingleButtonBack)) {
//			return m_Listener.OnRepeat(CTL_16AVHN_L_VK_ButtonId.BACK, param);
//		} else if (null != view && null != m_SingleButtonOK
//				&& view.equals(m_SingleButtonOK)) {
//			return m_Listener.OnRepeat(CTL_16AVHN_L_VK_ButtonId.OK, param);
//		} else {
//		}
//
//		return false;
//	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jp.pioneer.ceam.ctl.Interface.common.IButtonActionListener#OnPush(android
	 * .view.View)
	 */
//	@Override
//	public void OnPush(View view) {
//		if (null == m_Listener) {
//			return;
//		}
//		if (null != view && null != m_SingleButtonBack
//				&& view.equals(m_SingleButtonBack)) {
//			m_Listener.OnPush(CTL_16AVHN_L_VK_ButtonId.BACK);
//		} else if (null != view && null != m_SingleButtonOK
//				&& view.equals(m_SingleButtonOK)) {
//			m_Listener.OnPush(CTL_16AVHN_L_VK_ButtonId.OK);
//		}
//	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * jp.pioneer.ceam.ctl.Interface.common.IButtonActionListener#OnRelease(
	 * android.view.View)
	 */
//	@Override
//	public void OnRelease(View view) {
//		// TODO Auto-generated method stub
//		if (null == m_Listener) {
//			return;
//		}
//		if (null != view && null != m_SingleButtonBack
//				&& view.equals(m_SingleButtonBack)) {
//			m_Listener.OnRelease(CTL_16AVHN_L_VK_ButtonId.BACK);
//		} else if (null != view && null != m_SingleButtonOK
//				&& view.equals(m_SingleButtonOK)) {
//			m_Listener.OnRelease(CTL_16AVHN_L_VK_ButtonId.OK);
//
//		}
//	}
	class mArrowKeyMovementMethod extends ArrowKeyMovementMethod {
		@Override
		public boolean canSelectArbitrarily() {
			
			return false;
		}
		
		
	}

	private void initRes() {
//		m_SingleButtonOK.setButtonImageBack("p10781_vk_1nrm", "p10781_vk_2prs",
//				"p10781_vk_3fcs", "p10781_vk_4dis", "p10781_vk_5dsf");
//		m_SingleButtonOK.setOnProhibition();
		m_SingleButtonOK.setSingleLine(true);
//		m_SingleButtonOK.setTextSize(FontSize.FONTSIZE_30);
//		m_SingleButtonOK.setTextFont(TypeFaceId.HG);
//		m_SingleButtonOK.setTextStyle(TextStyleID.TEXT_007);
//		m_SingleButtonOK.setTextPadingPosition(2, 0, 0, 0);
		m_EditText.setSingleLine();
//		m_EditText.setTextSize(FontSize.FONTSIZE_30);
//		m_EditText.setTextFont(TypeFaceId.HG);
//		m_EditText.setTextStyle(TextStyleID.TEXT_088);
		m_EditText.setMovementMethod(new mArrowKeyMovementMethod());
//		m_et_bg.setBackgroundResource(com.android.internal.R.drawable.p10783_vk);
		m_et_bg.setClickable(false);
//		m_SingleButtonBack.setVKTypeButton();
//		SparseArray<String[]> themePic = new SparseArray<String[]>();
//		SparseArray<int[][]> params = new SparseArray<int[][]>();
//		String[] imageNormal = new String[] { "p10785_vk_1nrm" };
//		String[] imagePressed = new String[] { "p10785_vk_2prs" };
//		String[] imageDis = new String[] { "p10785_vk_4dis" };
//
//		imageNormal = new String[] { "p10785_vk_1nrm" };
//		imagePressed = new String[] { "p10785_vk_2prs" };
//		imageDis = new String[] { "p10785_vk_4dis" };
//
//		int ParamNormal[][] = { { 0, 0, 0, 0 } };
//		themePic.put(ControlStatusList.NORMAL, imageNormal);
//		params.put(ControlStatusList.NORMAL, ParamNormal);
//
//		int ParamPressed[][] = { { 0, 0, 0, 0 } };
//		themePic.put(ControlStatusList.PRESS, imagePressed);
//		params.put(ControlStatusList.PRESS, ParamPressed);
//
//		int ParamaDis[][] = { { 0, 0, 0, 0 } };
//		themePic.put(ControlStatusList.DISABLE, imageDis);
//		params.put(ControlStatusList.DISABLE, ParamaDis);
//
//		m_SingleButtonBack.setButtonImage(themePic, params);
	}

	public class KeyBoardWatch {
		public KeyBoardWatch(View contentView) {
			mContentView = contentView;
			mVisible = false;
			mLastVisible = false;
		}

		public void addLayoutObserver() {
			mListener = new ViewTreeObserver.OnGlobalLayoutListener() {
				@Override
				public void onGlobalLayout() {

					Rect r = new Rect();
					mContentView.getWindowVisibleDisplayFrame(r);
					int screenHeight = mContentView.getRootView().getHeight();

					int keypadHeight = screenHeight - r.bottom;

					// keypadHeight: 300, screenHeight:480
					mLastVisible = mVisible;
					if (keypadHeight > screenHeight * 0.15) { // 0.15 ratio is
																// perhaps
																// enough to
																// determine
																// keypad
																// height.
						// keyboard is opened
						mVisible = true;
					} else {
						// keyboard is closed
						mVisible = false;
					}
				}
			};
			mContentView.getViewTreeObserver().addOnGlobalLayoutListener(
					mListener);
		}

//		public void removeLayoutObserver() {
//			mContentView.getViewTreeObserver().removeOnGlobalLayoutListener(
//					mListener);
//		}

		public boolean isVisible() {
			return mVisible;
		}

		public boolean statusChange() {
			return (mVisible == false && (mLastVisible != mVisible));
		}

		public void resetStatus() {
			mLastVisible = mVisible;
		}

		private boolean mVisible;
		private boolean mLastVisible;
		private View mContentView;
		private ViewTreeObserver.OnGlobalLayoutListener mListener;
	}

	@Override
	protected void onLayout(boolean changed, int l, int t, int r, int b) {
		// TODO Auto-generated method stub
		
	}

}
