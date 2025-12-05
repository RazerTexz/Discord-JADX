package com.discord.widgets.friends;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.C5419R;
import com.discord.databinding.EmptyFriendsStateViewBinding;
import com.discord.widgets.friends.WidgetFriendsAdd;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: EmptyFriendsStateView.kt */
/* loaded from: classes2.dex */
public final class EmptyFriendsStateView extends ConstraintLayout {
    private final EmptyFriendsStateViewBinding binding;

    /* compiled from: EmptyFriendsStateView.kt */
    /* renamed from: com.discord.widgets.friends.EmptyFriendsStateView$updateView$1 */
    public static final class ViewOnClickListenerC83551 implements View.OnClickListener {
        public final /* synthetic */ String $addFriendSource;

        public ViewOnClickListenerC83551(String str) {
            this.$addFriendSource = str;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetFriendsAdd.Companion companion = WidgetFriendsAdd.INSTANCE;
            Context context = EmptyFriendsStateView.this.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "context");
            WidgetFriendsAdd.Companion.show$default(companion, context, null, this.$addFriendSource, 2, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmptyFriendsStateView(Context context) {
        super(context);
        Intrinsics3.checkNotNullParameter(context, "context");
        EmptyFriendsStateViewBinding emptyFriendsStateViewBindingM8383a = EmptyFriendsStateViewBinding.m8383a(LayoutInflater.from(getContext()), this);
        Intrinsics3.checkNotNullExpressionValue(emptyFriendsStateViewBindingM8383a, "EmptyFriendsStateViewBin…ater.from(context), this)");
        this.binding = emptyFriendsStateViewBindingM8383a;
    }

    public final void initialize(AttributeSet attrs) throws Resources.NotFoundException {
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attrs, C5419R.a.EmptyFriendsStateView);
        Intrinsics3.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…le.EmptyFriendsStateView)");
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, C5419R.dimen.uikit_textsize_xlarge);
        typedArrayObtainStyledAttributes.recycle();
        this.binding.f15062c.setTextSize(0, getResources().getDimension(resourceId));
    }

    public final void updateView(String addFriendSource) {
        Intrinsics3.checkNotNullParameter(addFriendSource, "addFriendSource");
        this.binding.f15061b.setOnClickListener(new ViewOnClickListenerC83551(addFriendSource));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmptyFriendsStateView(Context context, AttributeSet attributeSet) throws Resources.NotFoundException {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
        EmptyFriendsStateViewBinding emptyFriendsStateViewBindingM8383a = EmptyFriendsStateViewBinding.m8383a(LayoutInflater.from(getContext()), this);
        Intrinsics3.checkNotNullExpressionValue(emptyFriendsStateViewBindingM8383a, "EmptyFriendsStateViewBin…ater.from(context), this)");
        this.binding = emptyFriendsStateViewBindingM8383a;
        initialize(attributeSet);
    }

    public /* synthetic */ EmptyFriendsStateView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmptyFriendsStateView(Context context, AttributeSet attributeSet, int i) throws Resources.NotFoundException {
        super(context, attributeSet, i);
        Intrinsics3.checkNotNullParameter(context, "context");
        EmptyFriendsStateViewBinding emptyFriendsStateViewBindingM8383a = EmptyFriendsStateViewBinding.m8383a(LayoutInflater.from(getContext()), this);
        Intrinsics3.checkNotNullExpressionValue(emptyFriendsStateViewBindingM8383a, "EmptyFriendsStateViewBin…ater.from(context), this)");
        this.binding = emptyFriendsStateViewBindingM8383a;
        initialize(attributeSet);
    }

    public /* synthetic */ EmptyFriendsStateView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }
}
