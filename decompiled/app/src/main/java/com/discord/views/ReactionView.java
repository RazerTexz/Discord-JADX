package com.discord.views;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextSwitcher;
import android.widget.TextView;
import com.discord.C5419R;
import com.discord.api.message.reaction.MessageReaction;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.textprocessing.node.EmojiNode;
import com.discord.utilities.view.text.SimpleDraweeSpanTextView;
import p007b.p008a.p025i.ReactionViewBinding;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: ReactionView.kt */
/* loaded from: classes2.dex */
public final class ReactionView extends LinearLayout {

    /* renamed from: j, reason: from kotlin metadata */
    public int curCount;

    /* renamed from: k, reason: from kotlin metadata */
    public Long curMessageId;

    /* renamed from: l, reason: from kotlin metadata */
    public MessageReaction reaction;

    /* renamed from: m, reason: from kotlin metadata */
    public ColorStateList textColor;

    /* renamed from: n, reason: from kotlin metadata */
    public ColorStateList meTextColor;

    /* renamed from: o, reason: from kotlin metadata */
    public final ReactionViewBinding binding;

    public ReactionView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public ReactionView(Context context, AttributeSet attributeSet, int i, int i2) {
        attributeSet = (i2 & 2) != 0 ? null : attributeSet;
        i = (i2 & 4) != 0 ? 0 : i;
        Intrinsics3.checkNotNullParameter(context, "context");
        super(context, attributeSet, i);
        LayoutInflater.from(context).inflate(C5419R.layout.reaction_view, this);
        int i3 = C5419R.id.counter_text_1;
        TextView textView = (TextView) findViewById(C5419R.id.counter_text_1);
        if (textView != null) {
            i3 = C5419R.id.counter_text_2;
            TextView textView2 = (TextView) findViewById(C5419R.id.counter_text_2);
            if (textView2 != null) {
                i3 = C5419R.id.counter_text_switcher;
                TextSwitcher textSwitcher = (TextSwitcher) findViewById(C5419R.id.counter_text_switcher);
                if (textSwitcher != null) {
                    i3 = C5419R.id.emoji_text_view;
                    SimpleDraweeSpanTextView simpleDraweeSpanTextView = (SimpleDraweeSpanTextView) findViewById(C5419R.id.emoji_text_view);
                    if (simpleDraweeSpanTextView != null) {
                        ReactionViewBinding reactionViewBinding = new ReactionViewBinding(this, textView, textView2, textSwitcher, simpleDraweeSpanTextView);
                        Intrinsics3.checkNotNullExpressionValue(reactionViewBinding, "ReactionViewBinding.infl…ater.from(context), this)");
                        this.binding = reactionViewBinding;
                        int[] iArr = C5419R.a.ReactionView;
                        Intrinsics3.checkNotNullExpressionValue(iArr, "R.styleable.ReactionView");
                        Context context2 = getContext();
                        Intrinsics3.checkNotNullExpressionValue(context2, "context");
                        TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, iArr);
                        Intrinsics3.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(attrs, styleable)");
                        this.meTextColor = typedArrayObtainStyledAttributes.getColorStateList(0);
                        this.textColor = typedArrayObtainStyledAttributes.getColorStateList(1);
                        typedArrayObtainStyledAttributes.recycle();
                        return;
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(i3)));
    }

    private final void setIsMe(boolean isMe) {
        setActivated(isMe);
        setSelected(isMe);
        TextView textView = this.binding.f942b;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.counterText1");
        textView.setActivated(isMe);
        TextView textView2 = this.binding.f943c;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.counterText2");
        textView2.setActivated(isMe);
    }

    private final void setTextColor(boolean isMe) {
        ColorStateList colorStateList = isMe ? this.meTextColor : this.textColor;
        if (colorStateList != null) {
            this.binding.f942b.setTextColor(colorStateList);
            this.binding.f943c.setTextColor(colorStateList);
        }
    }

    /* renamed from: a */
    public final void m8552a(MessageReaction reaction, long messageId, boolean animateEmojis) {
        Intrinsics3.checkNotNullParameter(reaction, "reaction");
        Long l = this.curMessageId;
        boolean z2 = l == null || l == null || l.longValue() != messageId;
        MessageReaction messageReaction = this.reaction;
        int count = reaction.getCount();
        ReactionViewBinding reactionViewBinding = this.binding;
        int i = this.curCount;
        if (count != i) {
            if (z2) {
                reactionViewBinding.f944d.setCurrentText(String.valueOf(count));
            } else {
                if (count > i) {
                    TextSwitcher textSwitcher = reactionViewBinding.f944d;
                    textSwitcher.setInAnimation(textSwitcher.getContext(), C5419R.anim.anim_slide_in_up);
                    textSwitcher.setOutAnimation(textSwitcher.getContext(), C5419R.anim.anim_slide_out_up);
                } else {
                    TextSwitcher textSwitcher2 = reactionViewBinding.f944d;
                    textSwitcher2.setInAnimation(textSwitcher2.getContext(), C5419R.anim.anim_slide_in_down);
                    textSwitcher2.setOutAnimation(textSwitcher2.getContext(), C5419R.anim.anim_slide_out_down);
                }
                reactionViewBinding.f944d.setText(String.valueOf(count));
            }
            this.curCount = count;
        }
        if (messageReaction == null || (!Intrinsics3.areEqual(reaction.getEmoji(), messageReaction.getEmoji()))) {
            EmojiNode.Companion companion = EmojiNode.INSTANCE;
            SimpleDraweeSpanTextView simpleDraweeSpanTextView = this.binding.f945e;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeSpanTextView, "binding.emojiTextView");
            EmojiNode.Companion.renderEmoji$default(companion, simpleDraweeSpanTextView, reaction.getEmoji(), animateEmojis, 0, 4, null);
        }
        setIsMe(reaction.getMe());
        setTextColor(reaction.getMe());
        this.reaction = reaction;
        this.curMessageId = Long.valueOf(messageId);
    }

    public final MessageReaction getReaction() {
        return this.reaction;
    }

    public final void setMeTextColor(ColorStateList color) {
        Intrinsics3.checkNotNullParameter(color, ModelAuditLogEntry.CHANGE_KEY_COLOR);
        this.meTextColor = color;
    }
}
