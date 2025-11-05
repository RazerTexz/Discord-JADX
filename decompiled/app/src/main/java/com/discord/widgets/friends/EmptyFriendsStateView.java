package com.discord.widgets.friends;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.R;
import com.discord.databinding.EmptyFriendsStateViewBinding;
import com.discord.widgets.friends.WidgetFriendsAdd;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: EmptyFriendsStateView.kt */
/* loaded from: classes2.dex */
public final class EmptyFriendsStateView extends ConstraintLayout {
    private final EmptyFriendsStateViewBinding binding;

    /* compiled from: EmptyFriendsStateView.kt */
    /* renamed from: com.discord.widgets.friends.EmptyFriendsStateView$updateView$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ String $addFriendSource;

        public AnonymousClass1(String str) {
            this.$addFriendSource = str;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetFriendsAdd.Companion companion = WidgetFriendsAdd.INSTANCE;
            Context context = EmptyFriendsStateView.this.getContext();
            m.checkNotNullExpressionValue(context, "context");
            WidgetFriendsAdd.Companion.show$default(companion, context, null, this.$addFriendSource, 2, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmptyFriendsStateView(Context context) {
        super(context);
        m.checkNotNullParameter(context, "context");
        EmptyFriendsStateViewBinding emptyFriendsStateViewBindingA = EmptyFriendsStateViewBinding.a(LayoutInflater.from(getContext()), this);
        m.checkNotNullExpressionValue(emptyFriendsStateViewBindingA, "EmptyFriendsStateViewBin…ater.from(context), this)");
        this.binding = emptyFriendsStateViewBindingA;
    }

    public final void initialize(AttributeSet attrs) throws Resources.NotFoundException {
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attrs, R.a.EmptyFriendsStateView);
        m.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…le.EmptyFriendsStateView)");
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, R.dimen.uikit_textsize_xlarge);
        typedArrayObtainStyledAttributes.recycle();
        this.binding.c.setTextSize(0, getResources().getDimension(resourceId));
    }

    public final void updateView(String addFriendSource) {
        m.checkNotNullParameter(addFriendSource, "addFriendSource");
        this.binding.f2103b.setOnClickListener(new AnonymousClass1(addFriendSource));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmptyFriendsStateView(Context context, AttributeSet attributeSet) throws Resources.NotFoundException {
        super(context, attributeSet);
        m.checkNotNullParameter(context, "context");
        EmptyFriendsStateViewBinding emptyFriendsStateViewBindingA = EmptyFriendsStateViewBinding.a(LayoutInflater.from(getContext()), this);
        m.checkNotNullExpressionValue(emptyFriendsStateViewBindingA, "EmptyFriendsStateViewBin…ater.from(context), this)");
        this.binding = emptyFriendsStateViewBindingA;
        initialize(attributeSet);
    }

    public /* synthetic */ EmptyFriendsStateView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmptyFriendsStateView(Context context, AttributeSet attributeSet, int i) throws Resources.NotFoundException {
        super(context, attributeSet, i);
        m.checkNotNullParameter(context, "context");
        EmptyFriendsStateViewBinding emptyFriendsStateViewBindingA = EmptyFriendsStateViewBinding.a(LayoutInflater.from(getContext()), this);
        m.checkNotNullExpressionValue(emptyFriendsStateViewBindingA, "EmptyFriendsStateViewBin…ater.from(context), this)");
        this.binding = emptyFriendsStateViewBindingA;
        initialize(attributeSet);
    }

    public /* synthetic */ EmptyFriendsStateView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }
}
