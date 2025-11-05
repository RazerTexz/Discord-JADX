package b.i.a.g.k;

import com.google.android.material.R;
import com.google.android.material.button.MaterialButtonToggleGroup;

/* compiled from: TimePickerTextInputPresenter.java */
/* loaded from: classes3.dex */
public class j implements MaterialButtonToggleGroup.OnButtonCheckedListener {
    public final /* synthetic */ i a;

    public j(i iVar) {
        this.a = iVar;
    }

    @Override // com.google.android.material.button.MaterialButtonToggleGroup.OnButtonCheckedListener
    public void onButtonChecked(MaterialButtonToggleGroup materialButtonToggleGroup, int i, boolean z2) {
        this.a.k.d(i == R.id.material_clock_period_pm_button ? 1 : 0);
    }
}
