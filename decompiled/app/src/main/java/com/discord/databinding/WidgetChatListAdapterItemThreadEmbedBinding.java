package com.discord.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.view.text.SimpleDraweeSpanTextView;
import com.discord.widgets.chat.list.ViewReplySpline;
import com.facebook.drawee.view.SimpleDraweeView;

/* loaded from: classes.dex */
public final class WidgetChatListAdapterItemThreadEmbedBinding implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final ConstraintLayout f16336a;

    /* renamed from: b */
    @NonNull
    public final View f16337b;

    /* renamed from: c */
    @NonNull
    public final View f16338c;

    /* renamed from: d */
    @NonNull
    public final ConstraintLayout f16339d;

    /* renamed from: e */
    @NonNull
    public final ImageView f16340e;

    /* renamed from: f */
    @NonNull
    public final TextView f16341f;

    /* renamed from: g */
    @NonNull
    public final ImageView f16342g;

    /* renamed from: h */
    @NonNull
    public final SimpleDraweeView f16343h;

    /* renamed from: i */
    @NonNull
    public final SimpleDraweeSpanTextView f16344i;

    /* renamed from: j */
    @NonNull
    public final ConstraintLayout f16345j;

    /* renamed from: k */
    @NonNull
    public final TextView f16346k;

    /* renamed from: l */
    @NonNull
    public final TextView f16347l;

    public WidgetChatListAdapterItemThreadEmbedBinding(@NonNull ConstraintLayout constraintLayout, @NonNull View view, @NonNull View view2, @NonNull ConstraintLayout constraintLayout2, @NonNull ImageView imageView, @NonNull View view3, @NonNull TextView textView, @NonNull ImageView imageView2, @NonNull SimpleDraweeView simpleDraweeView, @NonNull SimpleDraweeSpanTextView simpleDraweeSpanTextView, @NonNull ConstraintLayout constraintLayout3, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull ConstraintLayout constraintLayout4, @NonNull ViewReplySpline viewReplySpline, @NonNull Guideline guideline) {
        this.f16336a = constraintLayout;
        this.f16337b = view;
        this.f16338c = view2;
        this.f16339d = constraintLayout2;
        this.f16340e = imageView;
        this.f16341f = textView;
        this.f16342g = imageView2;
        this.f16343h = simpleDraweeView;
        this.f16344i = simpleDraweeSpanTextView;
        this.f16345j = constraintLayout3;
        this.f16346k = textView2;
        this.f16347l = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f16336a;
    }
}
