package com.discord.widgets.forums;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.discord.R;
import com.discord.databinding.ForumPostTagViewBinding;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.textprocessing.node.EmojiNode;
import com.discord.utilities.view.text.SimpleDraweeSpanTextView;
import d0.z.d.Intrinsics3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ForumPostTagView.kt */
/* loaded from: classes2.dex */
public final class ForumPostTagView extends LinearLayout {
    private static final int EMOJI_SIZE_PX = DimenUtils.dpToPixels(12);
    private static final int HORIZONTAL_PADDING = DimenUtils.dpToPixels(8);
    private static final int VERTICAL_PADDING = DimenUtils.dpToPixels(2);
    private final ForumPostTagViewBinding binding;

    public ForumPostTagView(Context context) {
        this(context, null, 0, 6, null);
    }

    public ForumPostTagView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ ForumPostTagView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public final void configureTag(PostData2 tag) {
        Intrinsics3.checkNotNullParameter(tag, "tag");
        EmojiNode.Companion companion = EmojiNode.INSTANCE;
        SimpleDraweeSpanTextView simpleDraweeSpanTextView = this.binding.f2110b;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeSpanTextView, "binding.tagEmoji");
        companion.renderEmoji(simpleDraweeSpanTextView, tag.getMessageReactionEmoji(), true, EMOJI_SIZE_PX);
        TextView textView = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.tagName");
        textView.setText(tag.getTagName());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForumPostTagView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics3.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(R.layout.forum_post_tag_view, this);
        int i2 = R.id.tag_emoji;
        SimpleDraweeSpanTextView simpleDraweeSpanTextView = (SimpleDraweeSpanTextView) findViewById(R.id.tag_emoji);
        if (simpleDraweeSpanTextView != null) {
            i2 = R.id.tag_name;
            TextView textView = (TextView) findViewById(R.id.tag_name);
            if (textView != null) {
                ForumPostTagViewBinding forumPostTagViewBinding = new ForumPostTagViewBinding(this, simpleDraweeSpanTextView, textView);
                Intrinsics3.checkNotNullExpressionValue(forumPostTagViewBinding, "ForumPostTagViewBinding.…ater.from(context), this)");
                this.binding = forumPostTagViewBinding;
                int i3 = HORIZONTAL_PADDING;
                int i4 = VERTICAL_PADDING;
                setPadding(i3, i4, i3, i4);
                setBackground(ContextCompat.getDrawable(context, DrawableCompat.getThemedDrawableRes$default(context, R.attr.theme_forum_post_tag_background, 0, 2, (Object) null)));
                return;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(i2)));
    }
}
