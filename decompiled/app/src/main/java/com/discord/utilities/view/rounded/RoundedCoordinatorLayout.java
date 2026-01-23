package com.discord.utilities.view.rounded;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.utilities.view.rounded.RoundedCornerViewCoordinator;
import com.discord.utils.C7063R;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: compiled from: RoundedCoordinatorLayout.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RoundedCoordinatorLayout extends CoordinatorLayout {
    private final RoundedCornerViewCoordinator roundedViewCoordinator;

    /* JADX INFO: renamed from: com.discord.utilities.view.rounded.RoundedCoordinatorLayout$draw$1 */
    /* JADX INFO: compiled from: RoundedCoordinatorLayout.kt */
    public static final class C70091 extends Lambda implements Function1<Canvas, Unit> {
        public C70091() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Canvas canvas) {
            invoke2(canvas);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Canvas canvas) {
            Intrinsics3.checkNotNullParameter(canvas, "it");
            RoundedCoordinatorLayout.m11399access$draw$s747643027(RoundedCoordinatorLayout.this, canvas);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoundedCoordinatorLayout(Context context) {
        super(context);
        Intrinsics3.checkNotNullParameter(context, "context");
        this.roundedViewCoordinator = new RoundedCornerViewCoordinator();
    }

    /* JADX INFO: renamed from: access$draw$s-747643027, reason: not valid java name */
    public static final /* synthetic */ void m11399access$draw$s747643027(RoundedCoordinatorLayout roundedCoordinatorLayout, Canvas canvas) {
        super.draw(canvas);
    }

    private final void initialize(AttributeSet attrs) {
        RoundedCornerViewCoordinator roundedCornerViewCoordinator = this.roundedViewCoordinator;
        int[] iArr = C7063R.b.RoundedCoordinatorLayout;
        Intrinsics3.checkNotNullExpressionValue(iArr, "R.styleable.RoundedCoordinatorLayout");
        roundedCornerViewCoordinator.initialize(this, attrs, iArr, C7063R.b.RoundedCoordinatorLayout_topLeftRadius, C7063R.b.RoundedCoordinatorLayout_topRightRadius, C7063R.b.RoundedCoordinatorLayout_bottomLeftRadius, C7063R.b.RoundedCoordinatorLayout_bottomRightRadius);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        Intrinsics3.checkNotNullParameter(canvas, "canvas");
        this.roundedViewCoordinator.draw(canvas, new C70091());
    }

    @Override // android.view.View
    public void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.roundedViewCoordinator.onSizeChanged(w, h);
    }

    public final void updateTopLeftRadius(float radius) {
        this.roundedViewCoordinator.updateRadius(this, radius, RoundedCornerViewCoordinator.Corner.TOP_LEFT);
    }

    public final void updateTopRightRadius(float radius) {
        this.roundedViewCoordinator.updateRadius(this, radius, RoundedCornerViewCoordinator.Corner.TOP_RIGHT);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoundedCoordinatorLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
        this.roundedViewCoordinator = new RoundedCornerViewCoordinator();
        initialize(attributeSet);
    }

    public /* synthetic */ RoundedCoordinatorLayout(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoundedCoordinatorLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics3.checkNotNullParameter(context, "context");
        this.roundedViewCoordinator = new RoundedCornerViewCoordinator();
        initialize(attributeSet);
    }

    public /* synthetic */ RoundedCoordinatorLayout(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }
}
