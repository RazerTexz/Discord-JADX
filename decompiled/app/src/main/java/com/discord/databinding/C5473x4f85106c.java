package com.discord.databinding;

import android.view.View;
import android.view.ViewStub;
import android.widget.CheckBox;
import android.widget.ScrollView;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.discord.views.LoadingButton;

/* renamed from: com.discord.databinding.WidgetServerSettingsCreatorMonetizationOnboardingAcceptTermsBinding */
/* loaded from: classes.dex */
public final class C5473x4f85106c implements ViewBinding {

    /* renamed from: a */
    @NonNull
    public final ScrollView f17592a;

    /* renamed from: b */
    @NonNull
    public final LoadingButton f17593b;

    /* renamed from: c */
    @NonNull
    public final CheckBox f17594c;

    /* renamed from: d */
    @NonNull
    public final ScrollView f17595d;

    /* renamed from: e */
    @NonNull
    public final ViewStub f17596e;

    public C5473x4f85106c(@NonNull ScrollView scrollView, @NonNull LoadingButton loadingButton, @NonNull CheckBox checkBox, @NonNull ScrollView scrollView2, @NonNull ViewStub viewStub) {
        this.f17592a = scrollView;
        this.f17593b = loadingButton;
        this.f17594c = checkBox;
        this.f17595d = scrollView2;
        this.f17596e = viewStub;
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f17592a;
    }
}
