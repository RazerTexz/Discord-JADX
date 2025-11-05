package b.i.a.g.k;

import android.view.GestureDetector;
import android.view.MotionEvent;
import com.google.android.material.timepicker.MaterialTimePicker;
import com.google.android.material.timepicker.TimePickerView;

/* compiled from: TimePickerView.java */
/* loaded from: classes3.dex */
public class l extends GestureDetector.SimpleOnGestureListener {
    public final /* synthetic */ TimePickerView j;

    public l(TimePickerView timePickerView) {
        this.j = timePickerView;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        boolean zOnDoubleTap = super.onDoubleTap(motionEvent);
        TimePickerView.b bVar = this.j.r;
        if (bVar != null) {
            MaterialTimePicker.a aVar = (MaterialTimePicker.a) bVar;
            MaterialTimePicker.access$402(MaterialTimePicker.this, 1);
            MaterialTimePicker materialTimePicker = MaterialTimePicker.this;
            MaterialTimePicker.access$600(materialTimePicker, MaterialTimePicker.access$500(materialTimePicker));
            i iVarAccess$700 = MaterialTimePicker.access$700(MaterialTimePicker.this);
            iVarAccess$700.n.setChecked(iVarAccess$700.k.o == 12);
            iVarAccess$700.o.setChecked(iVarAccess$700.k.o == 10);
        }
        return zOnDoubleTap;
    }
}
