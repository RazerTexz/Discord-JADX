package com.discord.utilities.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.google.android.material.appbar.AppBarLayout;
import d0.z.d.m;
import d0.z.d.o;
import d0.z.d.q;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ContentResizingCoordinatorLayout.kt */
/* loaded from: classes2.dex */
public final class ContentResizingCoordinatorLayout extends CoordinatorLayout {
    private AppBarLayout appBarLayout;
    private View content;
    private int currentVerticalOffset;

    /* compiled from: ContentResizingCoordinatorLayout.kt */
    /* renamed from: com.discord.utilities.views.ContentResizingCoordinatorLayout$onMeasure$1, reason: invalid class name */
    public final /* synthetic */ class AnonymousClass1 extends q {
        public AnonymousClass1(ContentResizingCoordinatorLayout contentResizingCoordinatorLayout) {
            super(contentResizingCoordinatorLayout, ContentResizingCoordinatorLayout.class, "appBarLayout", "getAppBarLayout()Lcom/google/android/material/appbar/AppBarLayout;", 0);
        }

        @Override // d0.z.d.q, kotlin.reflect.KProperty0
        public Object get() {
            return ContentResizingCoordinatorLayout.access$getAppBarLayout$p((ContentResizingCoordinatorLayout) this.receiver);
        }

        @Override // d0.z.d.q
        public void set(Object obj) {
            ContentResizingCoordinatorLayout.access$setAppBarLayout$p((ContentResizingCoordinatorLayout) this.receiver, (AppBarLayout) obj);
        }
    }

    /* compiled from: ContentResizingCoordinatorLayout.kt */
    /* renamed from: com.discord.utilities.views.ContentResizingCoordinatorLayout$onMeasure$2, reason: invalid class name */
    public static final class AnonymousClass2 implements AppBarLayout.OnOffsetChangedListener {
        public final /* synthetic */ int $heightMeasureSpec;
        public final /* synthetic */ int $widthMeasureSpec;

        public AnonymousClass2(int i, int i2) {
            this.$widthMeasureSpec = i;
            this.$heightMeasureSpec = i2;
        }

        @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
        public final void onOffsetChanged(AppBarLayout appBarLayout, int i) {
            ContentResizingCoordinatorLayout.access$setCurrentVerticalOffset$p(ContentResizingCoordinatorLayout.this, i);
            ContentResizingCoordinatorLayout contentResizingCoordinatorLayout = ContentResizingCoordinatorLayout.this;
            ContentResizingCoordinatorLayout.access$updateContentLayoutParams(contentResizingCoordinatorLayout, i, ContentResizingCoordinatorLayout.access$getAppBarLayout$p(contentResizingCoordinatorLayout).getMeasuredHeight(), ContentResizingCoordinatorLayout.this.getMeasuredHeight(), this.$widthMeasureSpec, this.$heightMeasureSpec);
        }
    }

    /* compiled from: ContentResizingCoordinatorLayout.kt */
    /* renamed from: com.discord.utilities.views.ContentResizingCoordinatorLayout$onMeasure$3, reason: invalid class name */
    public static final class AnonymousClass3 extends o implements Function2<Integer, Integer, Unit> {
        public final /* synthetic */ int $heightMeasureSpec;
        public final /* synthetic */ int $widthMeasureSpec;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(int i, int i2) {
            super(2);
            this.$widthMeasureSpec = i;
            this.$heightMeasureSpec = i2;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Integer num, Integer num2) {
            invoke(num.intValue(), num2.intValue());
            return Unit.a;
        }

        public final void invoke(int i, int i2) {
            ContentResizingCoordinatorLayout contentResizingCoordinatorLayout = ContentResizingCoordinatorLayout.this;
            ContentResizingCoordinatorLayout.access$updateContentLayoutParams(contentResizingCoordinatorLayout, ContentResizingCoordinatorLayout.access$getCurrentVerticalOffset$p(contentResizingCoordinatorLayout), ContentResizingCoordinatorLayout.access$getAppBarLayout$p(ContentResizingCoordinatorLayout.this).getMeasuredHeight(), ContentResizingCoordinatorLayout.this.getMeasuredHeight(), this.$widthMeasureSpec, this.$heightMeasureSpec);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContentResizingCoordinatorLayout(Context context) {
        super(context);
        m.checkNotNullParameter(context, "context");
    }

    public static final /* synthetic */ AppBarLayout access$getAppBarLayout$p(ContentResizingCoordinatorLayout contentResizingCoordinatorLayout) {
        AppBarLayout appBarLayout = contentResizingCoordinatorLayout.appBarLayout;
        if (appBarLayout == null) {
            m.throwUninitializedPropertyAccessException("appBarLayout");
        }
        return appBarLayout;
    }

    public static final /* synthetic */ int access$getCurrentVerticalOffset$p(ContentResizingCoordinatorLayout contentResizingCoordinatorLayout) {
        return contentResizingCoordinatorLayout.currentVerticalOffset;
    }

    public static final /* synthetic */ void access$setAppBarLayout$p(ContentResizingCoordinatorLayout contentResizingCoordinatorLayout, AppBarLayout appBarLayout) {
        contentResizingCoordinatorLayout.appBarLayout = appBarLayout;
    }

    public static final /* synthetic */ void access$setCurrentVerticalOffset$p(ContentResizingCoordinatorLayout contentResizingCoordinatorLayout, int i) {
        contentResizingCoordinatorLayout.currentVerticalOffset = i;
    }

    public static final /* synthetic */ void access$updateContentLayoutParams(ContentResizingCoordinatorLayout contentResizingCoordinatorLayout, int i, int i2, int i3, int i4, int i5) {
        contentResizingCoordinatorLayout.updateContentLayoutParams(i, i2, i3, i4, i5);
    }

    private final void updateContentLayoutParams(int appBarVerticalOffset, int measuredAppBarHeight, int measuredContainerHeight, int widthMeasureSpec, int heightMeasureSpec) {
        int i = measuredAppBarHeight + appBarVerticalOffset;
        View view = this.content;
        if (view == null) {
            m.throwUninitializedPropertyAccessException("content");
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = measuredContainerHeight - i;
        View view2 = this.content;
        if (view2 == null) {
            m.throwUninitializedPropertyAccessException("content");
        }
        view2.setLayoutParams(layoutParams);
        View view3 = this.content;
        if (view3 == null) {
            m.throwUninitializedPropertyAccessException("content");
        }
        measureChild(view3, widthMeasureSpec, heightMeasureSpec);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int size = View.MeasureSpec.getSize(heightMeasureSpec);
        if (this.appBarLayout == null && getChildCount() >= 2) {
            View childAt = getChildAt(0);
            Objects.requireNonNull(childAt, "null cannot be cast to non-null type com.google.android.material.appbar.AppBarLayout");
            this.appBarLayout = (AppBarLayout) childAt;
            View childAt2 = getChildAt(1);
            Objects.requireNonNull(childAt2, "null cannot be cast to non-null type android.view.View");
            this.content = childAt2;
            AppBarLayout appBarLayout = this.appBarLayout;
            if (appBarLayout == null) {
                m.throwUninitializedPropertyAccessException("appBarLayout");
            }
            measureChild(appBarLayout, widthMeasureSpec, heightMeasureSpec);
            AppBarLayout appBarLayout2 = this.appBarLayout;
            if (appBarLayout2 == null) {
                m.throwUninitializedPropertyAccessException("appBarLayout");
            }
            appBarLayout2.offsetTopAndBottom(0);
            AppBarLayout appBarLayout3 = this.appBarLayout;
            if (appBarLayout3 == null) {
                m.throwUninitializedPropertyAccessException("appBarLayout");
            }
            updateContentLayoutParams(0, appBarLayout3.getMeasuredHeight(), size, widthMeasureSpec, heightMeasureSpec);
            AppBarLayout appBarLayout4 = this.appBarLayout;
            if (appBarLayout4 == null) {
                m.throwUninitializedPropertyAccessException("appBarLayout");
            }
            appBarLayout4.addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) new AnonymousClass2(widthMeasureSpec, heightMeasureSpec));
            AppBarLayout appBarLayout5 = this.appBarLayout;
            if (appBarLayout5 == null) {
                m.throwUninitializedPropertyAccessException("appBarLayout");
            }
            ViewExtensions.addOnHeightChangedListener(appBarLayout5, new AnonymousClass3(widthMeasureSpec, heightMeasureSpec));
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContentResizingCoordinatorLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ ContentResizingCoordinatorLayout(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContentResizingCoordinatorLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ ContentResizingCoordinatorLayout(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }
}
