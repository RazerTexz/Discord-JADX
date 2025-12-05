package p007b.p225i.p226a.p341g.p352k;

import android.view.GestureDetector;
import android.view.MotionEvent;
import com.google.android.material.timepicker.MaterialTimePicker;
import com.google.android.material.timepicker.TimePickerView;

/* compiled from: TimePickerView.java */
/* renamed from: b.i.a.g.k.l, reason: use source file name */
/* loaded from: classes3.dex */
public class TimePickerView3 extends GestureDetector.SimpleOnGestureListener {

    /* renamed from: j */
    public final /* synthetic */ TimePickerView f11892j;

    public TimePickerView3(TimePickerView timePickerView) {
        this.f11892j = timePickerView;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        boolean zOnDoubleTap = super.onDoubleTap(motionEvent);
        TimePickerView.InterfaceC11029b interfaceC11029b = this.f11892j.f21235r;
        if (interfaceC11029b != null) {
            MaterialTimePicker.C11023a c11023a = (MaterialTimePicker.C11023a) interfaceC11029b;
            MaterialTimePicker.access$402(MaterialTimePicker.this, 1);
            MaterialTimePicker materialTimePicker = MaterialTimePicker.this;
            MaterialTimePicker.access$600(materialTimePicker, MaterialTimePicker.access$500(materialTimePicker));
            TimePickerTextInputPresenter timePickerTextInputPresenterAccess$700 = MaterialTimePicker.access$700(MaterialTimePicker.this);
            timePickerTextInputPresenterAccess$700.f11881n.setChecked(timePickerTextInputPresenterAccess$700.f11878k.f21225o == 12);
            timePickerTextInputPresenterAccess$700.f11882o.setChecked(timePickerTextInputPresenterAccess$700.f11878k.f21225o == 10);
        }
        return zOnDoubleTap;
    }
}
