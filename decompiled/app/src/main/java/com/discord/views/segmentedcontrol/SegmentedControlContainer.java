package com.discord.views.segmentedcontrol;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
import androidx.core.view.ViewGroup;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p007b.p008a.p062y.p067n0.SegmentedControlSegment;
import p507d0.p580t.Collections2;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: compiled from: SegmentedControlContainer.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SegmentedControlContainer extends LinearLayout {

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public Function1<? super Integer, Unit> segmentSelectedChangeListener;

    /* JADX INFO: renamed from: com.discord.views.segmentedcontrol.SegmentedControlContainer$a */
    /* JADX INFO: compiled from: SegmentedControlContainer.kt */
    public static final class ViewOnClickListenerC7120a implements View.OnClickListener {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ int f19288j;

        /* JADX INFO: renamed from: k */
        public final /* synthetic */ SegmentedControlContainer f19289k;

        public ViewOnClickListenerC7120a(int i, SegmentedControlContainer segmentedControlContainer) {
            this.f19288j = i;
            this.f19289k = segmentedControlContainer;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Function1<? super Integer, Unit> function1 = this.f19289k.segmentSelectedChangeListener;
            if (function1 != null) {
                function1.invoke(Integer.valueOf(this.f19288j));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SegmentedControlContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: renamed from: b */
    public static /* synthetic */ void m8606b(SegmentedControlContainer segmentedControlContainer, int i, int i2) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        segmentedControlContainer.m8607a(i);
    }

    /* JADX INFO: renamed from: a */
    public final void m8607a(int selectedIndex) {
        int i = 0;
        for (View view : ViewGroup.getChildren(this)) {
            int i2 = i + 1;
            if (i < 0) {
                Collections2.throwIndexOverflow();
            }
            View view2 = view;
            if (!(view2 instanceof SegmentedControlSegment)) {
                throw new IllegalStateException("All children must be SegmentedControlSegments.".toString());
            }
            view2.setOnClickListener(new ViewOnClickListenerC7120a(i, this));
            i = i2;
        }
        setSelectedIndex(selectedIndex);
    }

    public final void setOnSegmentSelectedChangeListener(Function1<? super Integer, Unit> listener) {
        Intrinsics3.checkNotNullParameter(listener, "listener");
        this.segmentSelectedChangeListener = listener;
    }

    public final void setSelectedIndex(int selectedIndex) {
        int i = 0;
        for (KeyEvent.Callback callback : ViewGroup.getChildren(this)) {
            int i2 = i + 1;
            if (i < 0) {
                Collections2.throwIndexOverflow();
            }
            KeyEvent.Callback callback2 = (View) callback;
            if (!(callback2 instanceof SegmentedControlSegment)) {
                throw new IllegalStateException("All children must be SegmentedControlSegments.".toString());
            }
            ((SegmentedControlSegment) callback2).mo388a(i == selectedIndex);
            i = i2;
        }
    }
}
