package com.discord.widgets.servers.creator_monetization_eligibility.onboarding;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Space;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewGroup;
import com.discord.C5419R;
import com.discord.databinding.ViewCreatorMonetizationAcceptTermsStepCardBinding;
import java.util.List;
import kotlin.Lazy;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p027k.FormatUtils;
import p507d0.LazyJVM;
import p507d0.p578f0._Sequences2;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: compiled from: AcceptTermsStepCard.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AcceptTermsStepCard extends ConstraintLayout {

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final Lazy binding;

    @StringRes
    private int descriptionStringRes;

    @DrawableRes
    private int imageSrcRes;
    private int stepNumber;
    private String termsUrl;

    @StringRes
    private int titleStringRes;

    public AcceptTermsStepCard(Context context) {
        this(context, null, 2, null);
    }

    public /* synthetic */ AcceptTermsStepCard(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    private final ViewCreatorMonetizationAcceptTermsStepCardBinding getBinding() {
        return (ViewCreatorMonetizationAcceptTermsStepCardBinding) this.binding.getValue();
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        List<View> list = _Sequences2.toList(ViewGroup.getChildren(this));
        TextView textView = getBinding().f15418e;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.stepNumber");
        textView.setText(String.valueOf(this.stepNumber));
        getBinding().f15416c.setImageResource(this.imageSrcRes);
        TextView textView2 = getBinding().f15419f;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.title");
        FormatUtils.m222n(textView2, this.titleStringRes, new Object[0], null, 4);
        if (this.termsUrl != null) {
            TextView textView3 = getBinding().f15415b;
            Intrinsics3.checkNotNullExpressionValue(textView3, "binding.description");
            FormatUtils.m222n(textView3, this.descriptionStringRes, new Object[]{this.termsUrl}, null, 4);
        } else {
            TextView textView4 = getBinding().f15415b;
            Intrinsics3.checkNotNullExpressionValue(textView4, "binding.description");
            FormatUtils.m222n(textView4, this.descriptionStringRes, new Object[0], null, 4);
        }
        TextView textView5 = getBinding().f15415b;
        Intrinsics3.checkNotNullExpressionValue(textView5, "binding.description");
        int id2 = textView5.getId();
        for (View view : list) {
            ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(view.getLayoutParams());
            ((ViewGroup.MarginLayoutParams) layoutParams).width = 0;
            layoutParams.topToBottom = id2;
            Space space = getBinding().f15417d;
            Intrinsics3.checkNotNullExpressionValue(space, "binding.imagePadding");
            layoutParams.startToEnd = space.getId();
            layoutParams.endToEnd = 0;
            view.setLayoutParams(layoutParams);
            id2 = view.getId();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AcceptTermsStepCard(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
        this.binding = LazyJVM.lazy(new AcceptTermsStepCard2(this, context));
        int[] iArr = C5419R.a.AcceptTermsStepCard;
        Intrinsics3.checkNotNullExpressionValue(iArr, "R.styleable.AcceptTermsStepCard");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
        Intrinsics3.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(attrs, styleable)");
        this.stepNumber = androidx.core.content.res.TypedArray.getIntOrThrow(typedArrayObtainStyledAttributes, 2);
        this.imageSrcRes = androidx.core.content.res.TypedArray.getResourceIdOrThrow(typedArrayObtainStyledAttributes, 0);
        this.titleStringRes = androidx.core.content.res.TypedArray.getResourceIdOrThrow(typedArrayObtainStyledAttributes, 3);
        this.descriptionStringRes = androidx.core.content.res.TypedArray.getResourceIdOrThrow(typedArrayObtainStyledAttributes, 1);
        this.termsUrl = typedArrayObtainStyledAttributes.getString(4);
        typedArrayObtainStyledAttributes.recycle();
    }
}
