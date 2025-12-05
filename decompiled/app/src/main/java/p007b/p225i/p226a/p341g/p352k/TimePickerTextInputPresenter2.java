package p007b.p225i.p226a.p341g.p352k;

import com.google.android.material.C10817R;
import com.google.android.material.button.MaterialButtonToggleGroup;

/* compiled from: TimePickerTextInputPresenter.java */
/* renamed from: b.i.a.g.k.j, reason: use source file name */
/* loaded from: classes3.dex */
public class TimePickerTextInputPresenter2 implements MaterialButtonToggleGroup.OnButtonCheckedListener {

    /* renamed from: a */
    public final /* synthetic */ TimePickerTextInputPresenter f11890a;

    public TimePickerTextInputPresenter2(TimePickerTextInputPresenter timePickerTextInputPresenter) {
        this.f11890a = timePickerTextInputPresenter;
    }

    @Override // com.google.android.material.button.MaterialButtonToggleGroup.OnButtonCheckedListener
    public void onButtonChecked(MaterialButtonToggleGroup materialButtonToggleGroup, int i, boolean z2) {
        this.f11890a.f11878k.m9163d(i == C10817R.id.material_clock_period_pm_button ? 1 : 0);
    }
}
