package com.discord.widgets.notice;

import android.text.Layout;
import android.text.SpannableStringBuilder;
import com.discord.databinding.WidgetNoticePopupBinding;
import com.discord.utilities.view.text.SimpleDraweeSpanTextView;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: NoticePopup.kt */
/* renamed from: com.discord.widgets.notice.NoticePopup$enqueue$notice$1$3$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class NoticePopup6 implements Runnable {
    public final /* synthetic */ WidgetNoticePopupBinding $binding;

    public NoticePopup6(WidgetNoticePopupBinding widgetNoticePopupBinding) {
        this.$binding = widgetNoticePopupBinding;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SimpleDraweeSpanTextView simpleDraweeSpanTextView = this.$binding.f17310c;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeSpanTextView, "binding.popupBody");
        Layout layout = simpleDraweeSpanTextView.getLayout();
        int lineCount = layout != null ? layout.getLineCount() : 0;
        SimpleDraweeSpanTextView simpleDraweeSpanTextView2 = this.$binding.f17310c;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeSpanTextView2, "binding.popupBody");
        if (lineCount > simpleDraweeSpanTextView2.getMaxLines()) {
            SimpleDraweeSpanTextView simpleDraweeSpanTextView3 = this.$binding.f17310c;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeSpanTextView3, "binding.popupBody");
            Layout layout2 = simpleDraweeSpanTextView3.getLayout();
            Intrinsics3.checkNotNullExpressionValue(this.$binding.f17310c, "binding.popupBody");
            int lineEnd = layout2.getLineEnd(r3.getMaxLines() - 1);
            SimpleDraweeSpanTextView simpleDraweeSpanTextView4 = this.$binding.f17310c;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeSpanTextView4, "binding.popupBody");
            CharSequence charSequenceSubSequence = simpleDraweeSpanTextView4.getText().subSequence(0, lineEnd - 1);
            SimpleDraweeSpanTextView simpleDraweeSpanTextView5 = this.$binding.f17310c;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeSpanTextView5, "binding.popupBody");
            simpleDraweeSpanTextView5.setText(new SpannableStringBuilder(charSequenceSubSequence).append((CharSequence) "…"));
        }
    }
}
