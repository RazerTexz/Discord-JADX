package com.discord.views.segmentedcontrol;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.core.app.NotificationCompat;
import com.discord.C5419R;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.widgets.chat.input.gifpicker.ViewScalingOnTouchListener;
import p007b.p008a.p025i.CardSegmentViewBinding;
import p007b.p008a.p062y.p067n0.SegmentedControlSegment;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: CardSegment.kt */
/* loaded from: classes2.dex */
public final class CardSegment extends CardView implements SegmentedControlSegment {

    /* renamed from: j, reason: from kotlin metadata */
    public final CardSegmentViewBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardSegment(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
        LayoutInflater.from(getContext()).inflate(C5419R.layout.card_segment_view, this);
        int i = C5419R.id.card_segment_badge;
        TextView textView = (TextView) findViewById(C5419R.id.card_segment_badge);
        if (textView != null) {
            i = C5419R.id.card_segment_text;
            TextView textView2 = (TextView) findViewById(C5419R.id.card_segment_text);
            if (textView2 != null) {
                CardSegmentViewBinding cardSegmentViewBinding = new CardSegmentViewBinding(this, textView, textView2);
                Intrinsics3.checkNotNullExpressionValue(cardSegmentViewBinding, "CardSegmentViewBinding.i…ater.from(context), this)");
                this.binding = cardSegmentViewBinding;
                if (attributeSet != null) {
                    TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C5419R.a.CardSegment, 0, 0);
                    Intrinsics3.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…leable.CardSegment, 0, 0)");
                    try {
                        setText(typedArrayObtainStyledAttributes.getString(0));
                    } finally {
                        typedArrayObtainStyledAttributes.recycle();
                    }
                }
                setOnTouchListener(new ViewScalingOnTouchListener(0.9f));
                return;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(i)));
    }

    @Override // p007b.p008a.p062y.p067n0.SegmentedControlSegment
    /* renamed from: a */
    public void mo388a(boolean selected) {
        int themedColor = selected ? ColorCompat.getThemedColor(this, C5419R.attr.colorBackgroundAccent) : ColorCompat.getColor(this, C5419R.color.transparent);
        int color = selected ? ColorCompat.getColor(this, C5419R.color.white) : ColorCompat.getThemedColor(this, C5419R.attr.colorInteractiveMuted);
        setCardBackgroundColor(themedColor);
        this.binding.f829c.setTextColor(color);
    }

    public final View getCardText() {
        TextView textView = this.binding.f829c;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.cardSegmentText");
        return textView;
    }

    public final void setBadgeText(CharSequence text) {
        TextView textView = this.binding.f828b;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.cardSegmentBadge");
        ViewExtensions.setTextAndVisibilityBy(textView, text);
    }

    public final void setText(CharSequence text) {
        TextView textView = this.binding.f829c;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.cardSegmentText");
        textView.setText(text);
    }
}
