package com.google.android.material.timepicker;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.view.ViewCompat;
import com.google.android.material.C10817R;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.chip.Chip;
import p007b.p225i.p226a.p341g.p352k.TimePickerView2;
import p007b.p225i.p226a.p341g.p352k.TimePickerView3;
import p007b.p225i.p226a.p341g.p352k.TimePickerView4;

/* loaded from: classes3.dex */
public class TimePickerView extends ConstraintLayout {

    /* renamed from: j */
    public final Chip f21227j;

    /* renamed from: k */
    public final Chip f21228k;

    /* renamed from: l */
    public final ClockHandView f21229l;

    /* renamed from: m */
    public final ClockFaceView f21230m;

    /* renamed from: n */
    public final MaterialButtonToggleGroup f21231n;

    /* renamed from: o */
    public final View.OnClickListener f21232o;

    /* renamed from: p */
    public InterfaceC11030c f21233p;

    /* renamed from: q */
    public InterfaceC11031d f21234q;

    /* renamed from: r */
    public InterfaceC11029b f21235r;

    /* renamed from: com.google.android.material.timepicker.TimePickerView$a */
    public class ViewOnClickListenerC11028a implements View.OnClickListener {
        public ViewOnClickListenerC11028a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            InterfaceC11031d interfaceC11031d = TimePickerView.this.f21234q;
            if (interfaceC11031d != null) {
                interfaceC11031d.mo6172b(((Integer) view.getTag(C10817R.id.selection_type)).intValue());
            }
        }
    }

    /* renamed from: com.google.android.material.timepicker.TimePickerView$b */
    public interface InterfaceC11029b {
    }

    /* renamed from: com.google.android.material.timepicker.TimePickerView$c */
    public interface InterfaceC11030c {
    }

    /* renamed from: com.google.android.material.timepicker.TimePickerView$d */
    public interface InterfaceC11031d {
        /* renamed from: b */
        void mo6172b(int i);
    }

    public TimePickerView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        ViewOnClickListenerC11028a viewOnClickListenerC11028a = new ViewOnClickListenerC11028a();
        this.f21232o = viewOnClickListenerC11028a;
        LayoutInflater.from(context).inflate(C10817R.layout.material_timepicker, this);
        this.f21230m = (ClockFaceView) findViewById(C10817R.id.material_clock_face);
        MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) findViewById(C10817R.id.material_clock_period_toggle);
        this.f21231n = materialButtonToggleGroup;
        materialButtonToggleGroup.addOnButtonCheckedListener(new TimePickerView2(this));
        Chip chip = (Chip) findViewById(C10817R.id.material_minute_tv);
        this.f21227j = chip;
        Chip chip2 = (Chip) findViewById(C10817R.id.material_hour_tv);
        this.f21228k = chip2;
        this.f21229l = (ClockHandView) findViewById(C10817R.id.material_clock_hand);
        TimePickerView4 timePickerView4 = new TimePickerView4(this, new GestureDetector(getContext(), new TimePickerView3(this)));
        chip.setOnTouchListener(timePickerView4);
        chip2.setOnTouchListener(timePickerView4);
        int i = C10817R.id.selection_type;
        chip.setTag(i, 12);
        chip2.setTag(i, 10);
        chip.setOnClickListener(viewOnClickListenerC11028a);
        chip2.setOnClickListener(viewOnClickListenerC11028a);
    }

    /* renamed from: a */
    public final void m9164a() {
        if (this.f21231n.getVisibility() == 0) {
            ConstraintSet constraintSet = new ConstraintSet();
            constraintSet.clone(this);
            constraintSet.clear(C10817R.id.material_clock_display, ViewCompat.getLayoutDirection(this) == 0 ? 2 : 1);
            constraintSet.applyTo(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        m9164a();
    }

    @Override // android.view.View
    public void onVisibilityChanged(@NonNull View view, int i) {
        super.onVisibilityChanged(view, i);
        if (view == this && i == 0) {
            m9164a();
        }
    }
}
