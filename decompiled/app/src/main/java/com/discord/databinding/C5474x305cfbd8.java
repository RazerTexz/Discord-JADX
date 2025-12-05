package com.discord.databinding;

import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.views.LoadingButton;
import com.discord.widgets.servers.creator_monetization_eligibility.EligibilityChecklistView;
import com.google.android.material.button.MaterialButton;

/* renamed from: com.discord.databinding.WidgetServerSettingsCreatorMonetizationOnboardingCreateRequestBinding */
/* loaded from: classes.dex */
public final class C5474x305cfbd8 implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final ScrollView f17602a;

    /* renamed from: b */
    @NonNull
    public final MaterialButton f17603b;

    /* renamed from: c */
    @NonNull
    public final LoadingButton f17604c;

    /* renamed from: d */
    @NonNull
    public final EligibilityChecklistView f17605d;

    /* renamed from: e */
    @NonNull
    public final ImageView f17606e;

    /* renamed from: f */
    @NonNull
    public final TextView f17607f;

    /* renamed from: g */
    @NonNull
    public final ViewStub f17608g;

    /* renamed from: h */
    @NonNull
    public final TextView f17609h;

    /* renamed from: i */
    @NonNull
    public final LinkifiedTextView f17610i;

    public C5474x305cfbd8(@NonNull ScrollView scrollView, @NonNull MaterialButton materialButton, @NonNull LoadingButton loadingButton, @NonNull EligibilityChecklistView eligibilityChecklistView, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull ViewStub viewStub, @NonNull TextView textView2, @NonNull LinkifiedTextView linkifiedTextView) {
        this.f17602a = scrollView;
        this.f17603b = materialButton;
        this.f17604c = loadingButton;
        this.f17605d = eligibilityChecklistView;
        this.f17606e = imageView;
        this.f17607f = textView;
        this.f17608g = viewStub;
        this.f17609h = textView2;
        this.f17610i = linkifiedTextView;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17602a;
    }
}
