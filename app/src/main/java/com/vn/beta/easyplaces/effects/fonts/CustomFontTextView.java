package com.vn.beta.easyplaces.effects.fonts;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;


import com.vn.beta.easyplaces.R;


public class CustomFontTextView extends TextView {

    public static final String ANDROID_SCHEMA = "http://schemas.android.com/apk/res/android";


    public CustomFontTextView(Context context) {
        super(context);
        applyCustomFont(context, null);
    }

    public CustomFontTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        applyCustomFont(context, attrs);
    }

    public CustomFontTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        applyCustomFont(context, attrs);
    }

    private void applyCustomFont(Context context, AttributeSet attrs) {
        TypedArray attributeArray = context.obtainStyledAttributes(attrs, R.styleable.CustomFontApp);

        String fontName = attributeArray.getString(R.styleable.CustomFontApp_font);
        int textStyle = attrs.getAttributeIntValue(ANDROID_SCHEMA, "textStyle", Typeface.NORMAL);

        Typeface customFont = selectType(context, fontName, textStyle);
        setTypeface(customFont);

        attributeArray.recycle();
    }

    private Typeface selectType(Context context, String fontName, int textStyle) {
        if(fontName.contentEquals(context.getString(R.string.font_fontawesome))){
            return FontManager.getTypeface("fonts/fontawesome-webfont.ttf", context);
        }else if(fontName.contentEquals(context.getString(R.string.font_default))){
            switch (textStyle){
                case Typeface.BOLD:
                    return FontManager.getTypeface("fonts/Roboto-Bold.ttf", context);
                case Typeface.ITALIC:
                    return FontManager.getTypeface("fonts/Roboto-Italic.ttf", context);
                case Typeface.BOLD_ITALIC:
                    return FontManager.getTypeface("fonts/Roboto-BoldItalic.ttf", context);
                case Typeface.NORMAL:
                    return FontManager.getTypeface("fonts/Roboto-Regular.ttf", context);
                default:
                    return FontManager.getTypeface("fonts/Roboto-Light.ttf", context);
            }
        }
        return null;
    }
}
